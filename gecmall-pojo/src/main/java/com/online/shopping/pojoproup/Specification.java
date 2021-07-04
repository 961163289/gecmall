package com.online.shopping.pojoproup;

import com.online.shopping.pojo.TbSpecification;
import com.online.shopping.pojo.TbSpecificationOption;

import java.util.List;


/**
 * 规格组合实体类
 * @author 梁梓鹏
 */
public class Specification {

    private TbSpecification specification; // 规格

    private List<TbSpecificationOption> specificationOptionList; // 规格选项

    public TbSpecification getSpecification() {
        return specification;
    }

    public void setSpecification(TbSpecification specification) {
        this.specification = specification;
    }

    public List<TbSpecificationOption> getSpecificationOptionList() {
        return specificationOptionList;
    }

    public void setSpecificationOptionList(List<TbSpecificationOption> specificationOptionList) {
        this.specificationOptionList = specificationOptionList;
    }
}
