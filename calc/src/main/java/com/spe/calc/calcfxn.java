package com.spe.calc;
import java.lang.Math;

public class calcfxn implements calculator{
    public calcfxn(){};

    @Override
    public double sqrt(double a) throws ArithmeticException {
        if(a < 0){
            throw new ArithmeticException("square root of negative number is imaginary");
        }

        return Math.sqrt(a);
    }

    @Override
    public long factorial(int a) throws ArithmeticException {
        if(a < 0){
            throw new ArithmeticException("factorial of negative number is not defined");
        }
        if(a == 0){
            return 1;
        }
        long res = 1;
        for(int i = 1;i<=a;i++){
            res = Math.multiplyExact(res, i);
        }
        return res;
    }

    @Override
    public double log(double a) throws ArithmeticException {
        if(a < 0){
            throw new ArithmeticException("log of negative number is not defined");
        }
        return Math.log(a);
    }

    @Override
    public double power(double base, double expo){
        return Math.pow(base, expo);
    }
}
