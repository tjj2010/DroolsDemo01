package com.drools.controller;

import com.drools.entity.CalculationEntity;
import com.drools.service.CalculationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rule")
/**
 * 计算个人所得税:控制类
 */
public class CalculationController {
    @Autowired
    private CalculationService ruleService;

    @RequestMapping("/calculate")
    public CalculationEntity calculate(double wage){
        CalculationEntity calculation = new CalculationEntity();
        calculation.setWage(wage);
        calculation = ruleService.calculate(calculation);
        System.out.println(calculation);
        return calculation;
    }
}
