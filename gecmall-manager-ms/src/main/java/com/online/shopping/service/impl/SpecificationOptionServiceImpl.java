package com.online.shopping.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.online.shopping.entity.PageResult;
import com.online.shopping.mapper.TbSpecificationOptionMapper;
import com.online.shopping.pojo.TbSpecificationOption;
import com.online.shopping.service.SpecificationOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 规格选项-服务实现层
 * @author 梁梓鹏
 */
@Service
public class SpecificationOptionServiceImpl implements SpecificationOptionService {

    @Autowired
    private TbSpecificationOptionMapper tbSpecificationOptionMapper;

    /**
     * 查询全部
     * @return
     */
    @Override
    public List<TbSpecificationOption> findAll() {
        return this.tbSpecificationOptionMapper.selectByExample(null);
    }

    /**
     * 添加
     * @param specificationOption
     */
    @Override
    public void add(TbSpecificationOption specificationOption) {
        this.tbSpecificationOptionMapper.insert(specificationOption);
    }

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    @Override
    public TbSpecificationOption findOne(Long id) {
        return this.tbSpecificationOptionMapper.selectByPrimaryKey(id);
    }

    /**
     * 修改
     * @param specificationOption
     */
    @Override
    public void update(TbSpecificationOption specificationOption) {
        this.tbSpecificationOptionMapper.updateByPrimaryKey(specificationOption);
    }

    /**
     * 批量删除
     * @param ids
     */
    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            this.tbSpecificationOptionMapper.deleteByPrimaryKey(id);
        }
    }

    /**
     * 按分页查询
     * @param pageNum
     * @param PageSize
     * @return
     */
    @Override
    public PageResult findPage(int pageNum, int PageSize) {
        PageHelper.startPage(pageNum, PageSize);
        Page<TbSpecificationOption> page = (Page<TbSpecificationOption>) this.tbSpecificationOptionMapper.selectByExample(null);
        return new PageResult(page.getTotal(),page.getResult());
    }
}
