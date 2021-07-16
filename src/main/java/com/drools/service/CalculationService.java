package com.drools.service;

import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drools.entity.CalculationEntity;

/**
 * 计算个人所得税:服务类
 */
@Service
public class CalculationService {
    @Autowired
    private KieBase kieBase;

    //调用Drools规则引擎实现个人所得税计算
    public CalculationEntity calculate(CalculationEntity calculation){
        KieSession session = kieBase.newKieSession();
        session.insert(calculation);
        session.fireAllRules();
        session.dispose();
        return calculation;
    }
}
