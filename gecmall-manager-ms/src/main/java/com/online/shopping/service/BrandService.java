package com.online.shopping.service;

import com.online.shopping.entity.PageResult;
import com.online.shopping.pojo.TbBrand;

import java.util.List;
import java.util.Map;

public interface BrandService {

    /**
     * 查询所有品牌
     * @return
     */
    public List<TbBrand> findAllBrands();

    /**
     * 增加
     * @param brand
     */
    public void add(TbBrand brand);

    /**
     * 根据Id查询品牌
     * @param id
     * @return
     */
    public TbBrand findOne(Long id);

    /**
     * 更新
     * @param brand
     */
    public void update(TbBrand brand);

    /**
     * 批量删除
     * @param ids
     */
    public void delete(Long[] ids);

    /**
     * 品牌分页
     * @param pageNum   当前页数
     * @param pageSize  每页总记录数
     * @return
     */
    public PageResult findPage(int pageNum,int pageSize);

    /**
     * 返回下拉列表数据
     * @return
     */
    public List<Map> selectOptionList();
}
