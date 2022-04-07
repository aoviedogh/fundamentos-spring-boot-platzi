package com.fundamentosplatzi.springboot.fundamentos.bean;

public class MyBeanImplement implements MyBean{
    @Override
    public void imprimir() {
        System.out.println("Hola desde MyBeanImplement");
    }
}
