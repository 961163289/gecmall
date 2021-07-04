package com.online.shopping.controller;

import com.online.shopping.entity.PageResult;
import com.online.shopping.entity.Result;
import com.online.shopping.pojo.TbTypeTemplate;
import com.online.shopping.service.TypeTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller
 * @author 梁梓鹏
 */
@RestController
@RequestMapping("/typeTemplate-Ms")
public class TypeTemplateController {

    @Autowired
    private TypeTemplateService typeTemplateService;

    /**
     * 返回全部列表
     * @return
     */
    @RequestMapping("/findAll")
    public List<TbTypeTemplate> findAll(){
        return this.typeTemplateService.findAll();
    }

    /**
     * 分页
     * @return
     */
    @RequestMapping("/findPage")
    public PageResult  findPage(int page,int rows){
        return typeTemplateService.findPage(page, rows);
    }

    /**
     * 添加
     * @param typeTemplate
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody TbTypeTemplate typeTemplate){
        try {
            this.typeTemplateService.add(typeTemplate);
            return new Result(true,"增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"增加失败");
        }
    }

    /**
     * 根据Id进行查询
     * @param id
     * @return
     */
    @RequestMapping("/findOne")
    public TbTypeTemplate findOne(Long id){
        return this.typeTemplateService.findOne(id);
    }

    /**
     * 修改
     * @param typeTemplate
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody TbTypeTemplate typeTemplate){
        try {
            this.typeTemplateService.update(typeTemplate);
            return new Result(true,"修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"修改失败");
        }
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(Long[] ids){
        try {
            this.typeTemplateService.delete(ids);
            return new Result(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除失败");
        }
    }

    /**
     * 查询+分页
     * @param typeTemplate
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/search")
    public PageResult search(@RequestBody TbTypeTemplate typeTemplate,int page,int rows){
        return typeTemplateService.findPage(typeTemplate,page,rows);
    }



}
