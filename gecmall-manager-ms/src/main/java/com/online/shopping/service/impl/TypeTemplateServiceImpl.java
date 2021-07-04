package com.online.shopping.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.online.shopping.entity.PageResult;
import com.online.shopping.mapper.TbTypeTemplateMapper;
import com.online.shopping.pojo.TbTypeTemplate;
import com.online.shopping.pojo.TbTypeTemplateExample;
import com.online.shopping.service.TypeTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品类型-服务实现层
 * @author 梁梓鹏
 */
@Service
public class TypeTemplateServiceImpl implements TypeTemplateService {

    @Autowired
    private TbTypeTemplateMapper typeTemplateMapper;

    @Override
    public List<TbTypeTemplate> findAll() {
        return this.typeTemplateMapper.selectByExample(null);
    }

    @Override
    public PageResult findPage(int pageNum, int PageSize) {
        PageHelper.startPage(pageNum, PageSize);
        Page<TbTypeTemplate> page = (Page<TbTypeTemplate>) this.typeTemplateMapper.selectByExample(null);
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public void add(TbTypeTemplate typeTemplate) {
        this.typeTemplateMapper.insert(typeTemplate);

    }

    @Override
    public void update(TbTypeTemplate typeTemplate) {
        this.typeTemplateMapper.updateByPrimaryKey(typeTemplate);
    }

    @Override
    public TbTypeTemplate findOne(Long id) {
        return this.typeTemplateMapper.selectByPrimaryKey(id);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            this.typeTemplateMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public PageResult findPage(TbTypeTemplate typeTemplate, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        TbTypeTemplateExample example = new TbTypeTemplateExample();
        TbTypeTemplateExample.Criteria criteria = example.createCriteria();

        if (typeTemplate.getName()!=null&&typeTemplate.getName().length()>0){
            criteria.andNameLike("%"+typeTemplate.getName()+"%");
        }

        Page<TbTypeTemplate> page = (Page<TbTypeTemplate>) this.typeTemplateMapper.selectByExample(null);
        return new PageResult(page.getTotal(),page.getResult());
    }
}
