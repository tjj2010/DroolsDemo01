package com.drools.controller;

import com.drools.entity.ProductEntity;
import com.drools.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rule")
/**
 * 计算商品打折率:控制类
 */
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/product")
    public ProductEntity calculate(String type){
    	ProductEntity product = new ProductEntity();
    	product.setType(type);
    	product = productService.calculate(product);
        System.out.println(product);
        return product;
    }
}
