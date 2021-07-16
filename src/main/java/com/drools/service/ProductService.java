package com.drools.service;

import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drools.entity.ProductEntity;

/**
 * 计算商品打折:服务类
 */
@Service
public class ProductService {
    @Autowired
    private KieBase kieBase02;

    //调用Drools规则引擎实现个人所得税计算
    public ProductEntity calculate(ProductEntity product){
        KieSession session = kieBase02.newKieSession();
        session.insert(product);
        session.fireAllRules();
        session.dispose();
        return product;
    }
}
