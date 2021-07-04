package com.online.shopping.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.online.shopping.entity.PageResult;
import com.online.shopping.mapper.TbSpecificationMapper;
import com.online.shopping.mapper.TbSpecificationOptionMapper;
import com.online.shopping.pojo.TbSpecification;
import com.online.shopping.pojo.TbSpecificationExample;
import com.online.shopping.pojo.TbSpecificationOption;
import com.online.shopping.pojo.TbSpecificationOptionExample;
import com.online.shopping.pojoproup.Specification;
import com.online.shopping.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 规格-服务实现层
 *
 * @author 梁梓鹏
 */
@Service
public class SpecificationServiceImpl implements SpecificationService {

    @Autowired
    private TbSpecificationMapper specificationMapper;

    @Autowired
    private TbSpecificationOptionMapper specificationOptionMapper;

    /**
     * 查询全部
     *
     * @return List<TbSpecification>
     */
    @Override
    public List<TbSpecification> findAll() {
        return this.specificationMapper.selectByExample(null);
    }

    /**
     * 添加
     *
     * @param specification
     */
    @Override
    public void add(Specification specification) {
        // 保存规格 一方的数据
        this.specificationMapper.insert(specification.getSpecification());
        // 保存规格选项 多方的数据
        for (TbSpecificationOption specificationOption : specification.getSpecificationOptionList()) {
            specificationOption.setSpecId(specification.getSpecification().getId());
            /**
             * 设置规格的Id: 主键回填
             * 思考: 为何要先取出规格的Id,再设置给规则选项的spec_id呢?
             *     保证插入的规则选项不会插入到其他规则中去
             */
            this.specificationOptionMapper.insert(specificationOption);
        }
    }

    /**
     * 根据Id查询
     *
     * @param id
     * @return
     */
    @Override
    public Specification findOne(Long id) {
        Specification specification = new Specification();

        //根据Id查询规格对象
        TbSpecification tbSpecification = this.specificationMapper.selectByPrimaryKey(id);
        specification.setSpecification(tbSpecification);

        //根据规格的Id查询规格选项
        TbSpecificationOptionExample example = new TbSpecificationOptionExample();
        TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
        criteria.andSpecIdEqualTo(id);

        List<TbSpecificationOption> list = this.specificationOptionMapper.selectByExample(example);
        specification.setSpecificationOptionList(list);

        return specification;
    }

    /**
     * 修改
     *
     * @param specification
     */
    @Override
    public void update(Specification specification) {
        // 修改规格 一方的数据
        this.specificationMapper.updateByPrimaryKey(specification.getSpecification());

        // 先删除规格选项,再添加新的规格选项
        TbSpecificationOptionExample example = new TbSpecificationOptionExample();
        TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
        criteria.andSpecIdEqualTo(specification.getSpecification().getId());

        this.specificationOptionMapper.deleteByExample(example);

        //保存规格选项
        for (TbSpecificationOption specificationOption : specification.getSpecificationOptionList()) {
            specificationOption.setSpecId(specification.getSpecification().getId());
            this.specificationOptionMapper.insert(specificationOption);
        }

    }

    /**
     * 批量删除
     *
     * @param ids
     */
    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            // 删除规格
            this.specificationMapper.deleteByPrimaryKey(id);

            // 删除对应的规格选项
            TbSpecificationOptionExample example = new TbSpecificationOptionExample();
            TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
            criteria.andSpecIdEqualTo(id);
            this.specificationOptionMapper.deleteByExample(example);
        }
    }

    /**
     * 分页
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<TbSpecification> page = (Page<TbSpecification>) this.specificationMapper.selectByExample(null);
        return new PageResult(page.getTotal(),page.getResult());
    }

    /**
     * 查询+分页
     * @param specification
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageResult findPage(TbSpecification specification, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        TbSpecificationExample example=new TbSpecificationExample();
        TbSpecificationExample.Criteria criteria = example.createCriteria();

        if(specification!=null){
            if(specification.getSpecName()!=null && specification.getSpecName().length()>0){
                criteria.andSpecNameLike("%"+specification.getSpecName()+"%");
            }
        }

        Page<TbSpecification> page= (Page<TbSpecification>)specificationMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 下拉列表
     * @return
     */
    @Override
    public List<Map> selectOptionList() {
        return this.specificationMapper.selectOptionList();
    }
}
