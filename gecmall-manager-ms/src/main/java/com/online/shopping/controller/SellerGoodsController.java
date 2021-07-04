package com.online.shopping.controller;

import com.online.shopping.entity.PageResult;
import com.online.shopping.entity.Result;
import com.online.shopping.pojo.TbBrand;
import com.online.shopping.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/brand-Ms")
public class SellerGoodsController {

    @Autowired
    private BrandService brandService;

    //查询所有
    @RequestMapping("/findAllBrands")
    public List<TbBrand> findAllBrands(){
        return this.brandService.findAllBrands();
    }

    //添加
    @RequestMapping("/add")
    public Result add(@RequestBody TbBrand brand){
        try {
            this.brandService.add(brand);
            return new Result(true,"成功添加品牌信息");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"添加品牌信息失败");
        }
    }

    //根据id查询
    @RequestMapping("/findBrandDetail")
    public TbBrand findBrandDetail(Long id){
        return this.brandService.findOne(id);
    }

    //更新数据
    @RequestMapping("/updateBrand")
    public Result updateBrand(@RequestBody TbBrand brand){
        try {
            this.brandService.update(brand);
            return new Result(true,"修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"修改失败");
        }
    }

    //批量删除
    @RequestMapping("/delete")
    public Result delete(Long[] ids){
        try {
            this.brandService.delete(ids);
            return new Result(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除失败");
        }
    }

    //分页
    @RequestMapping("/findPage")
    public PageResult findPage(int pageNum,int pageSize){
        return this.brandService.findPage(pageNum,pageSize);
    }

    //下拉列表
    @RequestMapping("/selectOptionList")
    public List<Map> selectOptionList() {
        return brandService.selectOptionList();
    }



}
