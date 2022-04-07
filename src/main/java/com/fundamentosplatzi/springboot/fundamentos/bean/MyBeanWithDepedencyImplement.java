package com.fundamentosplatzi.springboot.fundamentos.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWithDepedencyImplement implements MyBeanWithDepedency{
    private final Log LOGGER = LogFactory.getLog(this.getClass());

    private MyOperation myOperation;

    public MyBeanWithDepedencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void imprimirWithDependency() {
        LOGGER.info("Inicia el método imprimirWithDependency");

        int numero = 6;
        LOGGER.debug("Debug: " + numero);
        System.out.println(myOperation.suma(numero));

        System.out.println("Imprimiendo desde MyBeanWithDepedency");
        LOGGER.info("Finaliza el método imprimirWithDependency");
    }
}
