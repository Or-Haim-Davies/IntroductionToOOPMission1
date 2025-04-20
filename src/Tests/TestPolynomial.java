package Tests;

import Classes.IntegerScalar;
import Classes.Polynomial;
import Classes.RationalScalar;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class TestPolynomial {
    @Test
     void testBuild(){
        Polynomial polynom0204 = Polynomial.build("0 2 0 4");
        Polynomial polynom0Minus204 = Polynomial.build("0 -2 0 4");
        Polynomial polynom0Minus20=Polynomial.build("0 -2 0");
        Polynomial polynom0=Polynomial.build("0");
        Polynomial polynom0Minus1=Polynomial.build("0 -1");
        Polynomial polynom35Minus81=Polynomial.build("3 5 -8 1");
        Assert.assertEquals("2x+4x^3",polynom0204.toString());
        Assert.assertEquals("-2x+4x^3",polynom0Minus204.toString());
        Assert.assertEquals("-2x",polynom0Minus20.toString());
        Assert.assertTrue(polynom0.toString().isEmpty());
        Assert.assertEquals("-x",polynom0Minus1.toString());
        Assert.assertEquals("3+5x-8x^2+x^3",polynom35Minus81.toString());
    }
    @Test
        void testEquals(){
        Polynomial polynom031=Polynomial.build("0 3");
        Polynomial polynom032=Polynomial.build("0 3");
        Polynomial polynom02=Polynomial.build("0 2");
        Assert.assertTrue("3x Equals 3x",polynom031.equals(polynom032));
        Assert.assertFalse("3x Not Equals 2x",polynom031.equals(polynom02));
    }
    @Test
    void testToString(){
        Polynomial polynom01over3=Polynomial.build("0 1/3");
        Polynomial polynom0Minus1over2=Polynomial.build("0 -1/2");
        Assert.assertTrue("toString of polynom01over3 is 1/3x","1/3x".equals(polynom01over3.toString()));
        Assert.assertFalse("toString of polynom0Minus1over2 is not 1/4x","1/4x".equals(polynom0Minus1over2.toString()));
    }

    @Test
     void testAdd(){
        Polynomial polynom2=Polynomial.build("2");
        Polynomial polynom3=Polynomial.build("3");
        Polynomial polynom23=Polynomial.build("2 3");
        Polynomial polynom31=Polynomial.build("3 1");
        Polynomial polynom203=Polynomial.build("2 0 3");
        Polynomial polynom310=Polynomial.build("3 1 0");
        Assert.assertEquals("2+3=5","5",polynom2.add(polynom3).toString());
        Assert.assertEquals("(2+3x)+(3+x)=5+4x","5+4x",polynom23.add(polynom31).toString());
        Assert.assertEquals("(2+3x^2)+(3+x)=5+x+3x^2","5+x+3x^2",polynom203.add(polynom310).toString());
    }
    @Test
    void testMul(){
        Polynomial polynom0=Polynomial.build("0");
        Polynomial polynom2=Polynomial.build("2");
        Polynomial polynom3=Polynomial.build("3");
        Polynomial polynom23=Polynomial.build("2 3");
        Polynomial polynom31=Polynomial.build("3 1");
        Polynomial polynomMinus12=Polynomial.build("-1 2");
        Polynomial polynom203=Polynomial.build("2 0 3");
        Polynomial polynom310=Polynomial.build("3 1 0");

        Assert.assertEquals("2*3=6","6",polynom2.mul(polynom3).toString());
        Assert.assertEquals("(2+3x)*(3+x)=6+11x+3x^2",
                "6+11x+3x^2",polynom23.mul(polynom31).toString());
        Assert.assertEquals("(2+3x^2)*(3+x)=6+2x+9x^2+3x^3",
                "6+2x+9x^2+3x^3",polynom203.mul(polynom310).toString());
        Assert.assertEquals("(3+x)*(-1+2x)=-3+5x+2x^2",
                "-3+5x+2x^2",polynom31.mul(polynomMinus12).toString());
        Assert.assertTrue(polynom0.mul(polynom203).toString().isEmpty());
    }
    @Test
    void testEvaluate(){
        Polynomial polynom2=Polynomial.build("2");
        Polynomial polynom11=Polynomial.build("1 1");
        Polynomial polynom2Minus11=Polynomial.build("2 -1 1");
        Assert.assertEquals("there is no x to evaluate so it remains 2"
                ,new IntegerScalar(2),polynom2.evaluate(new IntegerScalar(1)));
       Assert.assertEquals("1+(1/3)=4/3"
                ,new RationalScalar(4,3),polynom11.evaluate(new RationalScalar(1,3)));
        Assert.assertEquals("2-(1)+(1)^2=2",
                new IntegerScalar(2),polynom2Minus11.evaluate(new IntegerScalar(1)));
    }
    @Test
    void testDerivative(){
        Polynomial polynom1=Polynomial.build("1");
        Polynomial polynom0500Minus307=Polynomial.build("0 5 0 0 -3 0 7");
       Polynomial polynom12Minus1over3=Polynomial.build("1 2 1/3");


        Assert.assertEquals("d/dx(1)=0","",polynom1.derivative().toString());
        Assert.assertEquals("5-12x^3+42x^5",polynom0500Minus307.derivative().toString());
        Assert.assertEquals("d/dx(1+2x+(1/3)x^2)=2-2/3x",
                "2+2/3x",polynom12Minus1over3.derivative().toString());
    }
}
