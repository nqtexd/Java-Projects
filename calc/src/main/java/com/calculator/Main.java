package com.calculator;

import java.util.Scanner;

record DivisionResult(int quotient, int remainder) {
}

class operations{
    public int add(int a, int b){
        return a+b;
    }
    public int sub(int a, int b){
        return a-b;
    }
    public int mul(int a, int b){
        return a*b;
    }

    public DivisionResult div(int a, int b){
        if(b == 0){
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return new DivisionResult(a/b, a%b);
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        operations op = new operations();

        while(true){
            System.out.print("Enter first number: ");
            int a = sc.nextInt();
            System.out.print("Enter second number: ");
            int b = sc.nextInt();
            System.out.print("Select operation: 1.Add 2.Subtract 3.Multiply 4.Divide");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Addition: "+op.add(a,b));
                    break;
                case 2:
                    System.out.println("Subtraction: "+op.sub(a,b));
                    break;
                case 3:
                    System.out.println("Multiplication: "+op.mul(a,b));
                    break;
                case 4:
                    DivisionResult res = op.div(a,b);
                    System.out.println("Division: "+res.quotient()+" Remainder: "+res.remainder());
                    break;
                case 5:
                    sc.close();
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}