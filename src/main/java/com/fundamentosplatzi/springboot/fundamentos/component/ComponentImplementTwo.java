package com.fundamentosplatzi.springboot.fundamentos.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentImplementTwo implements ComponentDependency{

    @Override
    public void saludar() {
        System.out.println("Hola mundo :) desde mi implementación 2");
    }
}
