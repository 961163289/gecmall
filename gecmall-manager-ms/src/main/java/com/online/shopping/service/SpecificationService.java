package com.online.shopping.service;

import com.online.shopping.entity.PageResult;
import com.online.shopping.pojo.TbSpecification;
import com.online.shopping.pojoproup.Specification;

import java.util.List;
import java.util.Map;

/**
 * 规格-服务层接口
 * @author 梁梓鹏
 */
public interface SpecificationService {

    /**
     * 返回全部列表
     * @return
     */
    public List<TbSpecification> findAll();

    /**
     * 增加
     * @param specification
     */
    public void add(Specification specification);

    /**
     * 根据Id获取实体
     * @param id
     * @return
     */
    public Specification findOne(Long id);

    /**
     * 修改
     * @param specification
     */
    public void update(Specification specification);

    /**
     * 批量删除
     * @param ids
     */
    public void delete(Long[] ids);

    /**
     * 返回分页列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageResult findPage(int pageNum,int pageSize);

    /**
     * 查询+分页
     * @param specification
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageResult findPage(TbSpecification specification, int pageNum, int pageSize);


    /**
     * 下拉列表
     * @return
     */
    public List<Map> selectOptionList();
}
