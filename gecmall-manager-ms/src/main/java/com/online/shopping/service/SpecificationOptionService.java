package com.online.shopping.service;

import com.online.shopping.entity.PageResult;
import com.online.shopping.pojo.TbSpecificationOption;

import java.util.List;

/**
 * 规格选项-服务层接口
 * @author 梁梓鹏
 */
public interface SpecificationOptionService {

    /**
     * 返回全部列表
     * @return
     */
    public List<TbSpecificationOption> findAll();

    /**
     * 添加
     * @param specificationOption
     */
    public void add(TbSpecificationOption specificationOption);

    /**
     * 根据Id获取实体
     * @param id
     * @return
     */
    public TbSpecificationOption findOne(Long id);

    /**
     * 修改
     * @param specificationOption
     */
    public void update(TbSpecificationOption specificationOption);

    /**
     * 批量删除
     * @param ids
     */
    public void delete(Long[] ids);

    /**
     * 返回分页列表
     * @param pageNum
     * @param PageSize
     * @return
     */
    public PageResult findPage(int pageNum,int PageSize);



}
