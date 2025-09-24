package com.spe.calc;

public interface calculator {
    public double sqrt(double a) throws ArithmeticException;
    public long factorial(int a) throws ArithmeticException;
    public double log(double a) throws ArithmeticException;
    public double power(double base,double expo);
}
