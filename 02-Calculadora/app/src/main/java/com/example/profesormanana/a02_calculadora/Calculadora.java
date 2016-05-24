package com.example.profesormanana.a02_calculadora;

/**
 * Created by profesormanana on 24/5/16.
 */
public class Calculadora {

    private float op1 = 0;
    private float op2 = 0;

    //Inyeccion por construccion
    public Calculadora(float op1, float op2){
        this.op1 = op1;
        this.op2 = op2;
    }

    //Inyeccion por setter
    public void setOp1(float op1){
        this.op1 = op1;
    }

    public void setOp2(float op2){
        this.op2 = op2;
    }

    //Operaciones
    public float sumar(){
        return op1 + op2;
    }

    public float restar(){
        return op1 - op2;
    }

    public float multiplicar(){
        return op1 * op2;
    }

    public float dividir(){
        return op1 / op2;
    }

}
