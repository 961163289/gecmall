package com.online.shopping.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.online.shopping.entity.PageResult;
import com.online.shopping.mapper.TbBrandMapper;
import com.online.shopping.pojo.TbBrand;
import com.online.shopping.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private TbBrandMapper brandMapper;

    @Override
    public List<TbBrand> findAllBrands() {
        return this.brandMapper.selectByExample(null);
    }

    @Override
    public void add(TbBrand brand) {
        this.brandMapper.insert(brand);
    }

    @Override
    public TbBrand findOne(Long id) {
        return this.brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(TbBrand brand) {
        this.brandMapper.updateByPrimaryKey(brand);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            this.brandMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<TbBrand> page = (Page<TbBrand>) brandMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public List<Map> selectOptionList() {
        return brandMapper.selectOptionList();
    }


}
