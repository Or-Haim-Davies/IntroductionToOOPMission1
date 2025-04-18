package Tests;

import Classes.Polynomial;

public class TestPolynomial {
    public  static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
        test9();
        test10();
        test11();
        test12();
        test13();
    }
    public static void  test1(){
        Polynomial poly = Polynomial.build("0 2 0 4");
        if(poly.toString().equals("2x +4x^3")){
            System.out.println("succeed 1");
        }
        else{
            System.out.println(poly);
        }
    }
    public static void  test2(){
        Polynomial poly = Polynomial.build("0 -2 0 4");
        if(poly.toString().equals("-2x +4x^3")){
            System.out.println("succeed 2");
        }
        else{
            System.out.println(poly);
        }
    }
    public static void  test3(){
        Polynomial poly = Polynomial.build("0 -2 0");
        if(poly.toString().equals("-2x")){
            System.out.println("succeed 3");
        }
        else{
            System.out.println(poly);
        }
    }
    public static void  test4(){
        Polynomial poly = Polynomial.build("0");
        if(poly.toString().isEmpty()){
            System.out.println("succeed 4");
        }
        else{
            System.out.println(poly);
        }
    }
    public static void  test5(){
        Polynomial poly = Polynomial.build("0 -1");
        if(poly.toString().equals("-x")){
            System.out.println("succeed 5");
        }
        else{
            System.out.println(poly);
        }
    }
    public static void  test6(){
        Polynomial poly = Polynomial.build("3 5 -8 1");
        if(poly.toString().equals("3 +5x -8x^2 +x^3")){
            System.out.println("succeed 6");
        }
        else{
            System.out.println(poly);
        }
    }
    public static void  test7(){
        Polynomial poly1 = Polynomial.build("2");
        Polynomial poly2= Polynomial.build("3");

        if(poly1.add(poly2).toString().equals("5")){
            System.out.println("succeed 7");
        }
        else{
            System.out.println(poly1.add(poly2));
        }
    }
    public static void  test8(){
        Polynomial poly1 = Polynomial.build("2 3");
        Polynomial poly2= Polynomial.build("3 1");

        if(poly1.add(poly2).toString().equals("5 +4x")){
            System.out.println("succeed 8");
        }
        else{
            System.out.println(poly1.add(poly2));
        }
    }
    public static void  test9(){
        Polynomial poly1 = Polynomial.build("2 0 3");
        Polynomial poly2= Polynomial.build("3 1 0");

        if(poly1.add(poly2).toString().equals("5 +x +3x^2")){
            System.out.println("succeed 9");
        }
        else{
            System.out.println(poly1.add(poly2));
        }
    }
    public static void  test10(){
        Polynomial poly1 = Polynomial.build("2");
        Polynomial poly2= Polynomial.build("3");

        if(poly1.mul(poly2).toString().equals("6")){
            System.out.println("succeed 10");
        }
        else{
            System.out.println(poly1.mul(poly2));
        }
    }
    public static void  test11(){
        Polynomial poly1 = Polynomial.build("2 3");
        Polynomial poly2= Polynomial.build("3 1");

        if(poly1.mul(poly2).toString().equals("6 +11x +3x^2")){
            System.out.println("succeed 11");
        }
        else{
            System.out.println(poly1.mul(poly2));
        }
    }
    public static void  test12(){
        Polynomial poly1 = Polynomial.build("2 0 3");
        Polynomial poly2= Polynomial.build("3 1 0");

        if(poly1.mul(poly2).toString().equals("6 +2x +9x^2 +3x^3")){
            System.out.println("succeed 12");
        }
        else{
            System.out.println(poly1.mul(poly2));
        }
    }
    public static void  test13(){
        Polynomial poly1 = Polynomial.build("-2 1");
        Polynomial poly2= Polynomial.build("3 1");

        if(poly1.mul(poly2).toString().equals("-6 +x +x^2")){
            System.out.println("succeed 13");
        }
        else{
            System.out.println(poly1.mul(poly2));
        }
    }
}
