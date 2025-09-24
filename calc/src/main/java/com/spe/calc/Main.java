package com.spe.calc;

import java.util.Scanner;

public class Main {
    private static boolean takeInputAndCalculate(Scanner stdin,calcfxn calc){
        String menu = "choose one of the following options:\n" + 
        "[1] square root\n" + 
        "[2] factorial\n" + 
        "[3] log\n" +
        "[4] power\n" +
        "[5] exit";
        System.out.println(menu);
        int operation = stdin.nextInt();
        try{
            switch (operation) {
                case 1:
                    System.out.print("x = ");
                    System.out.println(calc.sqrt(stdin.nextDouble()));
                    break;
                case 2:
                    System.out.print("x = ");
                    System.out.println(calc.factorial(stdin.nextInt()));
                    break;
                case 3:
                    System.out.print("x = ");
                    System.out.println(calc.log(stdin.nextDouble()));
                    break;
                case 4:
                    System.out.print("x = ");
                    double x = stdin.nextDouble();
                    System.out.print("exponent = ");
                    double exp = stdin.nextDouble();
                    System.out.println(calc.power(x, exp));
                    break;
                case 5:
                    return false;
                default:
                    System.out.println("invalid input choose from 1 to 5");
            }
        }catch(ArithmeticException e){
            System.err.println(e.toString());
        }catch(Exception e){
            System.err.println(e.toString());
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        calcfxn calc = new calcfxn();
        boolean toContinue = true;
        while(toContinue){
            toContinue = takeInputAndCalculate(stdin, calc);
        }
    }
}