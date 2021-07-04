package com.online.shopping.service;

import com.online.shopping.entity.PageResult;
import com.online.shopping.pojo.TbTypeTemplate;

import java.util.List;

/**
 * 商品类型-服务层接口
 * @author 梁梓鹏
 */
public interface TypeTemplateService {

    /**
     * 返回全部列表
     * @return
     */
    public List<TbTypeTemplate> findAll();

    /**
     * 返回分页列表
     * @param pageNum
     * @param PageSize
     * @return
     */
    public PageResult findPage(int pageNum,int PageSize);

    /**
     * 添加
     * @param typeTemplate
     */
    public void add(TbTypeTemplate typeTemplate);

    /**
     * 更新
     * @param typeTemplate
     */
    public void update(TbTypeTemplate typeTemplate);

    /**
     * 根据Id进行查询
     * @param id
     * @return
     */
    public TbTypeTemplate findOne(Long id);

    /**
     * 批量删除
     * @param ids
     */
    public void delete(Long[] ids);

    /**
     * 查询+分页
     * @param typeTemplate
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageResult findPage(TbTypeTemplate typeTemplate,int pageNum,int pageSize);

}
