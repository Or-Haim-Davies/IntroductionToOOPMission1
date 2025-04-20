package Tests;

import Classes.IntegerScalar;
import Classes.Monomial;
import Classes.RationalScalar;
import Classes.Scalar;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestMonomial {
    private Monomial monomial0;
    private Monomial monomial1;
    private Monomial monomial2;
    private Monomial monomial3;
    private Monomial monomial4;
    private Monomial monomial5;
    private Monomial monomial6;
    private Monomial monomial7;
    @BeforeEach
    void initiation() {
        monomial0=new Monomial(1,new IntegerScalar(0));
        monomial1 = new Monomial(2, new IntegerScalar(2));
        monomial2= new Monomial(2,new RationalScalar(1,3));
        monomial3=new Monomial(3, new IntegerScalar(2));
        monomial4=new Monomial(5,new RationalScalar(-6,5));
        monomial5=new Monomial(7,new RationalScalar(1,5));
        monomial6=new Monomial(6,new IntegerScalar(-6));
        monomial7=new Monomial(7,new RationalScalar(1,-7));
    }

    @Test
    void testAdd() {
            Assert.assertEquals("2X^2+(1/3)X^2=(7/3)X^2 !=Null because we are adding two monomials with the same exponent."
                    ,new Monomial(2,new RationalScalar(7,3)),monomial1.add(monomial2));
            Assert.assertNull("Should return Null because wer'e adding two monomials with two different exponents.",
                    monomial2.add(monomial3));
    }
    @Test
    void testMul(){
        Assert.assertEquals("2X^2*(1/3)X^2=(2/3)X^4",
                new Monomial(4,new RationalScalar(2,3)),monomial1.mul(monomial2));
        Assert.assertEquals("(-6/5)X^5*2X^3=(-12/5)X^8",
                new Monomial(8,new RationalScalar(-12,5)),monomial4.mul(monomial3));
        Assert.assertEquals("0X*2X^2=0X^3",new Monomial(3,new IntegerScalar(0)),monomial0.mul(monomial1));
    }
    @Test
    void testEvaluate(){
        Assert.assertEquals("2*(1/5)^2=(2/25)",
                new RationalScalar(2,25),
                monomial1.evaluate(new RationalScalar(1,5)));
        Assert.assertEquals("2*(-1/2)^3=(-1/4)",
                new RationalScalar(-1,4),
                monomial3.evaluate(new RationalScalar(-1,2)) );
        Assert.assertEquals("2*(2)^2=8",
                new IntegerScalar(8),monomial1.evaluate(new IntegerScalar(2)));
        Assert.assertEquals("2*(0)^2=0",new IntegerScalar(0),monomial1.evaluate(new IntegerScalar(0)));
    }
    @Test
    void testDerivative(){
        Assert.assertEquals("d/dx(2X^2)=4X"
                ,new Monomial(1,new IntegerScalar(4)),
                monomial1.derivative());
        Assert.assertEquals("d/dx((1/5)X^7)=(7/5)X^6",
                new Monomial(6,new RationalScalar(7,5))
                ,monomial5.derivative());
        Assert.assertEquals("d/dx(0X^1)=0X^0",
                new Monomial(0,new IntegerScalar(0)),monomial0.derivative());
        Assert.assertEquals("d/dx(-6X^6)=-36X^5"
                ,new Monomial(5,new IntegerScalar(-36))
                ,monomial6.derivative());

    }

    @Test
        void testSign(){
        Assert.assertEquals("The sign of (1/-7)X^7 is -1",-1,monomial7.sign());
        Assert.assertEquals("The sign of 0X^1 is 0",0,monomial0.sign());
        Assert.assertEquals("The sign of 2X^2 is 1",1,monomial1.sign());
    }
    @Test
        void testEquals(){
        Monomial mono11=new Monomial(2,new IntegerScalar(1));
        Monomial mono12=new Monomial(2,new IntegerScalar(1));
        Monomial mono3=new Monomial(3,new IntegerScalar(1));
        Assert.assertEquals("X^2 Equals X^2",mono11,mono12);
        Assert.assertNotEquals("X^3 Not Equals X^2",mono3,mono12);
    }
    @Test
        void testToString(){
        Monomial monoMinus7=new Monomial(3,new IntegerScalar(-7));
        Monomial mono0=new Monomial(0,new IntegerScalar(2));
        Monomial mono1=new Monomial(2,new IntegerScalar(1));

        Assert.assertEquals("x^2",mono1.toString());
        Assert.assertEquals("2",mono0.toString());
        Assert.assertEquals("-7x^3",monoMinus7.toString());
        Assert.assertEquals("1/3x^2",monomial2.toString());
    }



}
