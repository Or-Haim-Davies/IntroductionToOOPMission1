package Tests;
import Classes.IntegerScalar;
import Classes.RationalScalar;
import Classes.Scalar;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestScalar {
  @Test
    public void testTwoAddThreeIsFive(){
    Scalar two=new IntegerScalar(2);
    Scalar three=new IntegerScalar(3);
    Assert.assertEquals("2+3 Should be 5",new IntegerScalar(5), three.add(two));
}
@Test
    public void testMinusFourAddMinusSevenIsMinusEleven(){
    Scalar minusFour=new IntegerScalar(-4);
    Scalar minusSeven=new IntegerScalar(-7);
    Assert.assertEquals("(-4)+(-7) Should be (-11)",new IntegerScalar(-11), minusFour.add(minusSeven));
    }
    @Test
    public void testMinusFourAddSevenIsThree(){
        Scalar minusFour=new IntegerScalar(-4);
        Scalar seven=new IntegerScalar(7);
        Assert.assertEquals("(-4)+7 Should be 3",new IntegerScalar(3), minusFour.add(seven));
    }
    @Test
    public void testZeroAddZeroIsZero(){
        Scalar zero=new IntegerScalar(0);

        Assert.assertEquals("0+0 Should be 0",new IntegerScalar(0), zero.add(zero));
    }
    @Test
    public void test2mul3Is6(){
    IntegerScalar two=new IntegerScalar(2);
    IntegerScalar three=new IntegerScalar(3);
    Assert.assertEquals("2*3=6",new IntegerScalar(6),two.mul(three));
    }
    @Test
    public void test0mul5Is0(){
        IntegerScalar zero=new IntegerScalar(0);
        IntegerScalar five=new IntegerScalar(5);
        Assert.assertEquals("0*5=0",new IntegerScalar(0),zero.mul(five));
    }
    @Test
    public void test1mul8Is8(){
        IntegerScalar one=new IntegerScalar(1);
        IntegerScalar eight=new IntegerScalar(8);
        Assert.assertEquals("1*8=8",new IntegerScalar(8),one.mul(eight));
    }

    @Test
    public void testMinus2mul8is16(){
        IntegerScalar minusTwo=new IntegerScalar(-2);
        IntegerScalar eight=new IntegerScalar(8);
        Assert.assertEquals("(-2)*8=(-16)",new IntegerScalar(-16),minusTwo.mul(eight));
    }
    @Test
    public void test6mulMinus9IsMinus54(){
        IntegerScalar six=new IntegerScalar(6);
        IntegerScalar minusNine=new IntegerScalar(-9);
        Assert.assertEquals("6*(-9)=(-54)",new IntegerScalar(-54),six.mul(minusNine));
    }
    @Test
    public void testMinus3mulMinus9Is27(){
        IntegerScalar minusThree=new IntegerScalar(-3);
        IntegerScalar minusNine=new IntegerScalar(-9);
        Assert.assertEquals("(-3)*(-9)=27",new IntegerScalar(27),minusThree.mul(minusNine));
    }
    @Test
    public void test0mul0Is0(){
        IntegerScalar zero1=new IntegerScalar(0);
        IntegerScalar zero2=new IntegerScalar(0);
        Assert.assertEquals("0*0=0",new IntegerScalar(0),zero1.mul(zero2));
    }
    @Test
    public void test1mul0Is0(){
        IntegerScalar one=new IntegerScalar(1);
        IntegerScalar zero=new IntegerScalar(0);
        Assert.assertEquals("1*0=0",new IntegerScalar(0),one.mul(zero));
    }
    @Test
    public void test2mul1over3(){
        IntegerScalar two=new IntegerScalar(2);
        RationalScalar oneOverThree=new RationalScalar(1,3);
        Assert.assertEquals("2*1/3=2/3",new RationalScalar(2,3),
                two.mul(oneOverThree));
    }
    @Test
    public void test7over6mul3Is21over6(){
        RationalScalar sevenOverSix=new RationalScalar(7,6);
        IntegerScalar three=new IntegerScalar(3);
        Assert.assertEquals("7/6*3=21/6",new RationalScalar(21,6),sevenOverSix.mul(three));
    }

    @Test
    public void testNegationof5IsMinus5(){
        IntegerScalar five=new IntegerScalar(5);
        Assert.assertEquals("The negation of 5 is -5",new IntegerScalar(-5),five.neg());
    }
    @Test
    public void testNegationofMinus3Is3() {
        IntegerScalar minusThree = new IntegerScalar(-3);
        Assert.assertEquals("The negation of -3 is 3", new IntegerScalar(3), minusThree.neg());
    }
    @Test
    public void testNegationOf0Is0(){
        IntegerScalar zero=new IntegerScalar(0);
        Assert.assertEquals("The negation of 0 is 0",new IntegerScalar(0),zero.neg());
    }
    @Test
    public void testNegationOfVeryBigNum(){
        IntegerScalar bigNum=new IntegerScalar(9999999);
        Assert.assertEquals("The negation of 9999999 is -9999999",new IntegerScalar(-9999999),bigNum.neg());
    }
    @Test
    public void testNegationofVerySmallNum(){
        IntegerScalar bigNum=new IntegerScalar(-9999999);
        Assert.assertEquals("The negation of -9999999 is 9999999",new IntegerScalar(9999999),bigNum.neg());
    }
    @Test
    public void test2ToThePowerOf3Is8(){
        IntegerScalar two=new IntegerScalar(2);
        Assert.assertEquals("2^3=8",new IntegerScalar(8),two.power(3));
    }
    @Test
    public void test8ToThePowerOf0Is1(){
        IntegerScalar eight=new IntegerScalar(8);
        Assert.assertEquals("8^0=1",new IntegerScalar(1),eight.power(0));
    }
    @Test
    public void test1ToThePowerOf100Is1(){
        IntegerScalar one=new IntegerScalar(1);
        Assert.assertEquals("1^100=1",new IntegerScalar(1),one.power(100));
    }
    @Test
    public void testMinus2ToThePowerOf3IsMinus8(){
        IntegerScalar minusTwo=new IntegerScalar(-2);
        Assert.assertEquals("(-2)^3=(-8)",new IntegerScalar(-8),minusTwo.power(3));
    }
    @Test
    public void testMinus2ToThePowerOf2Is4(){
        IntegerScalar minusTwo=new IntegerScalar(-2);
        Assert.assertEquals("(-2)^2=4",new IntegerScalar(4),minusTwo.power(2));
    }

    @Test
    public void testSignOf7is1(){
        IntegerScalar seven=new IntegerScalar(7);
        Assert.assertEquals("The sign of 7 is 1.",1,seven.sign());
    }
    @Test
    public void testSignOfMinus7isMinus1(){
        IntegerScalar minusSeven=new IntegerScalar(-7);
        Assert.assertEquals("The sign of -7 is -1.",-1,minusSeven.sign());
    }
    @Test
    public void testSignOf0is0(){
        IntegerScalar zero=new IntegerScalar(0);
        Assert.assertEquals("The sign of 0 is 0.",0,zero.sign());
    }
    @Test
    public void test1EqualsTo1(){
        IntegerScalar one1=new IntegerScalar(1);
        IntegerScalar one2=new IntegerScalar(1);
        Assert.assertTrue("1 Equals 1", one1.equals(one2));
    }
    @Test
    public void testMinus1EqualsToMinus1(){
        IntegerScalar minusOne1=new IntegerScalar(-1);
        IntegerScalar minusOne2=new IntegerScalar(-1);
        Assert.assertTrue("-1 Equals -1", minusOne1.equals(minusOne2));
    }
    @Test
    public void testMinus1NotEqualsTo1(){
        IntegerScalar minusOne=new IntegerScalar(-1);
        IntegerScalar one=new IntegerScalar(1);
        Assert.assertFalse("-1 Not Equals 1", minusOne.equals(one));
    }
    @Test
    public void test0EqualsTo0(){
        IntegerScalar zero1=new IntegerScalar(0);
        IntegerScalar zero2=new IntegerScalar(0);
        Assert.assertTrue("0 Equals 0", zero1.equals(zero2));
    }
    @Test
    public void testToStringOf4(){
        IntegerScalar four=new IntegerScalar(4);
        Assert.assertEquals("4",four.toString());
    }
    @Test
    public void testToStringOfMinus6(){
        IntegerScalar minusSix=new IntegerScalar(-6);
        Assert.assertEquals("-6",minusSix.toString());
    }
      @Test
    public void test1over3Add1over6Is1over2(){
        RationalScalar oneOverThree=new RationalScalar(1,3);
        RationalScalar oneOverSix=new RationalScalar(1,6);
        Assertions.assertEquals(new RationalScalar(1,2),oneOverThree.add(oneOverSix),
                "1/3+1/6=1/2");
    }

    @Test
    public void test3over4AddMinus1over2Is1over4(){
        RationalScalar threeOverFour=new RationalScalar(3,4);
        RationalScalar minusOneOverTwo=new RationalScalar(-1,2);
        Assertions.assertEquals(new RationalScalar(1,4),threeOverFour.add(minusOneOverTwo),
                "3/4+(-1/2)=1/4");
    }
    @Test
    public void test3over7AddMinus3over7Is0over1(){
        RationalScalar threeOverSeven=new RationalScalar(3,7);
        RationalScalar minusThreeOverSeven=new RationalScalar(-3,7);
        Assertions.assertEquals(new RationalScalar(0,1),threeOverSeven.add(minusThreeOverSeven),
                "3/7+(-3/7)=0/1");
    }
    @Test
    public void test3over7Add0over12Is0over1(){
        RationalScalar threeOverSeven=new RationalScalar(3,7);
        RationalScalar zeroOverTwelve=new RationalScalar(0,12);
        Assertions.assertEquals(new RationalScalar(3,7),threeOverSeven.add(zeroOverTwelve),
                "3/7+0/12=3/7");
    }
    @Test
    public void testAdd1over2To2Is5Over2(){
        IntegerScalar two=new IntegerScalar(2);
        RationalScalar oneOverTwo=new RationalScalar(1,2);
        Assertions.assertEquals(new RationalScalar(5,2),two.add(oneOverTwo),
                "2+1/2=5/2");
    }@Test
    public void testAdd1over2ToMinus2IsMinus3Over2(){
        IntegerScalar minusTwo=new IntegerScalar(-2);
        RationalScalar oneOverTwo=new RationalScalar(1,2);
        Assertions.assertEquals(new RationalScalar(-3,2),minusTwo.add(oneOverTwo),
                "-2+1/2=-3/2");
    }

    @Test
    public void test1over2mul2over3is1over3(){
        RationalScalar oneOverTwo=new RationalScalar(1,2);
        RationalScalar twoOverThree=new RationalScalar(2,3);
        assertEquals("1/2*2/3=1/3",new RationalScalar(1,3),oneOverTwo.mul(twoOverThree));
    }
    @Test
    public void testMinus1over2mul2over3is1over3(){
        RationalScalar minusOneOverTwo=new RationalScalar(-1,2);
        RationalScalar twoOverThree=new RationalScalar(2,3);
        assertEquals("(-1/2)*2/3=(-1/3)",new RationalScalar(-1,3),minusOneOverTwo.mul(twoOverThree));
    }
    @Test
    public void test1over2mulMinus2over3is1over3(){
        RationalScalar oneOverTwo=new RationalScalar(1,2);
        RationalScalar minusTwoOverThree=new RationalScalar(-2,3);
        assertEquals("1/2*(-2/3)=(-1/3)",new RationalScalar(-1,3),oneOverTwo.mul(minusTwoOverThree));
    }
    @Test
    public void testMinus1over2mulMinus2over3is1over3(){
        RationalScalar minusOneOverTwo=new RationalScalar(-1,2);
        RationalScalar minusTwoOverThree=new RationalScalar(-2,3);
        assertEquals("(-1/2)*(-2/3)=1/3",new RationalScalar(1,3),minusOneOverTwo.mul(minusTwoOverThree));
    }
    @Test
    public void test0over7mul4over5is0over1(){
        RationalScalar zeroOverSeven=new RationalScalar(0,7);
        RationalScalar fourOverFive=new RationalScalar(4,5);
        assertEquals("0/7*4/5=0/1",new RationalScalar(0,1),
                zeroOverSeven.mul(fourOverFive));
    }
    @Test
    public void test5over2mul0over6Is0over1(){
        RationalScalar fiveOverTwo=new RationalScalar(5,2);
        RationalScalar zeroOverSix=new RationalScalar(0,6);
        assertEquals("5/2*0/6=0/1",new RationalScalar(0,1),fiveOverTwo.mul(zeroOverSix));
    }
    @Test
    public void test0over7mul0over3Is0over1(){
        RationalScalar zeroOverSeven=new RationalScalar(0,7);
        RationalScalar zeroOverThree=new RationalScalar(0,3);
        assertEquals("0/0*0/0=0/0",new RationalScalar(0,1),zeroOverSeven.mul(zeroOverThree));
    }
    @Test
    public void test1over1mul5over3(){
        RationalScalar oneOverOne=new RationalScalar(1,1);
        RationalScalar fiveOverThree=new RationalScalar(5,3);
        assertEquals("1/1*5/3=5/3",new RationalScalar(5,3),
                oneOverOne.mul(fiveOverThree));
    }
    @Test
    public void test2over4mul2over6is1over6(){
        RationalScalar twoOverFour=new RationalScalar(2,4);
        RationalScalar twoOverSix=new RationalScalar(2,6);
        assertEquals("2/4*2/6=1/6",new RationalScalar(1,6),twoOverFour.mul(twoOverSix));
    }
    @Test
    public void test3mul2over7Is6over7(){
        IntegerScalar three=new IntegerScalar(3);
        RationalScalar twoOverSeven=new RationalScalar(2,7);
        assertEquals("3*2/7=6/7",new RationalScalar(6,7),three.mul(twoOverSeven));
    }
    @Test
    public void test1over4mul5Is5over4(){
        RationalScalar oneOverFour=new RationalScalar(1,4);
        IntegerScalar five=new IntegerScalar(5);
        assertEquals("1/4*5=5/4",new RationalScalar(5,4),oneOverFour.mul(five));
    }
    @Test
    public void testNegationOfMinus2over3is2over3(){
        RationalScalar minusTwoOverThree=new RationalScalar(-2,3);
        assertEquals("The negation of -2/3 is 2/3",new RationalScalar(2,3),minusTwoOverThree.neg());
    }
    @Test
    public void testNegationOf2over3isMinus2over3(){
        RationalScalar twoOverThree=new RationalScalar(2,3);
        assertEquals("The negation of 2/3 is -2/3",new RationalScalar(-2,3),twoOverThree.neg());
    }
    @Test
    public void testNegationOf0over1is0over1(){
        RationalScalar zeroOverOne=new RationalScalar(0,1);
        assertEquals("The negation of 0/1 is 0/1",new RationalScalar(0,1),zeroOverOne.neg());
    }
    @Test
    public void testNegationOfMinus1over4is1over4(){
        RationalScalar minusOneOverFour=new RationalScalar(-1,4);
        assertEquals("The negation of -1/4 is 1/4",new RationalScalar(1,4),
                minusOneOverFour.neg());
    }
    @Test
    public void testNegationOf1overMinus4is1over4(){
        RationalScalar oneOverMinusFour=new RationalScalar(1,-4);
        assertEquals("The negation of 1/-4 is 1/4",new RationalScalar(1,4),
                oneOverMinusFour.neg());
    }
    @Test
    public void testNegationOfMinus1overMinus4isMinus1over4(){
        RationalScalar minusOneOverMinusFour=new RationalScalar(-1,-4);
        assertEquals("The negation of -1/-4 is -1/4",new RationalScalar(-1,4),
                minusOneOverMinusFour.neg());
    }
    @Test
    public void testNegationOfAVeryLargeFraction(){
        RationalScalar veryLargeFrac=new RationalScalar(116161,66555666);
        assertEquals("The negation of 116161/66555666 is -116161/66555666",new RationalScalar(-116161,66555666),
                veryLargeFrac.neg());
    }
    @Test
    public void testNegationOfAVeryLargeNegativeFraction(){
        RationalScalar veryLargeNegFrac=new RationalScalar(-116161,66555666);
        assertEquals("The negation of -116161/66555666 is 116161/66555666",new RationalScalar(116161,66555666),
                veryLargeNegFrac.neg());
    }

    @Test
        public void test1over2ToThePowerOf3Is1over8(){
        RationalScalar oneOverTwo=new RationalScalar(1,2);
        assertEquals("(1/2)^3=1/8",new RationalScalar(1,8),oneOverTwo.power(3));
    }
    @Test
    public void testMinus1over2ToThePowerOf3IsMinus1over8(){
        RationalScalar minusOneOverTwo=new RationalScalar(-1,2);
        assertEquals("(-1/2)^3=-1/8",new RationalScalar(-1,8),minusOneOverTwo.power(3));
    }
    @Test
    public void test1overMinus2ToThePowerOf3IsMinus1over8(){
        RationalScalar oneOverMinusTwo=new RationalScalar(1,-2);
        assertEquals("(1/-2)^3=-1/8",new RationalScalar(-1,8),oneOverMinusTwo.power(3));
    }
    @Test
    public void testMinus1overMinus2ToThePowerOf3Is1over8(){
        RationalScalar minusOneOverMinusTwo=new RationalScalar(-1,-2);
       // System.out.println((minusOneOverMinusTwo.power(3)).toString());
        assertEquals("(-1/-2)^3=1/8",new RationalScalar(1,8),minusOneOverMinusTwo.power(3));
    }
    @Test
    public void test0over1ToThePowerOf6Is0over1(){
        RationalScalar zeroOverOne=new RationalScalar(0,1);
        assertEquals("(0/1)^6=0/1",new RationalScalar(0,1),zeroOverOne.power(6));
    }
    @Test
    public void testLargeExponent(){
        RationalScalar threeOverFour=new RationalScalar(3,4);
        assertEquals("(3/4)^10=59049/1048576",new RationalScalar(59049,1048576),threeOverFour.power(10));
    }
    @Test
    public void testSignOf1over2Is1(){
        RationalScalar oneOverTwo=new RationalScalar(1,2);
        assertEquals("Sign of 1/2 is 1.",1,oneOverTwo.sign());
    }
    @Test
    public void testSignOfMinus1over2IsMinus1(){
        RationalScalar minusOneOverTwo=new RationalScalar(-1,2);
        assertEquals("Sign of -1/2 is -1.",-1,minusOneOverTwo.sign());
    }
    @Test
    public void testSignOf1overMinus2IsMinus1(){
        RationalScalar oneOverMinusTwo=new RationalScalar(1,-2);
        assertEquals("Sign of 1/-2 is -1.",-1,oneOverMinusTwo.sign());
    }
    @Test
    public void testSignOfMinus1overMinus2Is1(){
        RationalScalar minusOneOverMinusTwo=new RationalScalar(-1,-2);
        assertEquals("Sign of -1/-2 is 1.",1,minusOneOverMinusTwo.sign());
    }
    @Test
    public void testSignOf0over1Is0(){
        RationalScalar zeroOverOne=new RationalScalar(0,1);
        assertEquals("Sign of 0/1 is 0",0,zeroOverOne.sign());
    }
    @Test
    public void testSignOf0overMinus1Is0(){
        RationalScalar zeroOverMinusOne=new RationalScalar(0,-1);
        assertEquals("Sign of 0/-1 is 0",0,zeroOverMinusOne.sign());
    }
    @Test
    public void test1over2Equals1over2(){
        RationalScalar oneOverTwo1=new RationalScalar(1,2);
        RationalScalar oneOverTwo2=new RationalScalar(1,2);
        assertTrue("1/2 Equals 1/2",oneOverTwo1.equals(oneOverTwo2));
    }
    @Test
    public void test1over2Equals2over4(){
        RationalScalar oneOverTwo=new RationalScalar(1,2);
        RationalScalar twoOverFour=new RationalScalar(2,4);
        assertTrue("1/2 Equals 2/4",oneOverTwo.equals(twoOverFour));
    }
    @Test
    public void test1over2EqualsMinus1overMinus2(){
        RationalScalar oneOverTwo=new RationalScalar(1,2);
        RationalScalar minusOneOverMinusTwo2=new RationalScalar(-1,-2);
        assertTrue("1/2 Equals -1/-2",oneOverTwo.equals(minusOneOverMinusTwo2));
    }
    @Test
    public void testMinus1over2Equals1overMinus2(){
        RationalScalar minusOneOveTwo=new RationalScalar(-1,2);
        RationalScalar oneOverMinusTwo=new RationalScalar(1,-2);

        assertTrue("-1/2 Equals 1/-2",minusOneOveTwo.equals(oneOverMinusTwo));
    }
    @Test
    public void test1over2NotEquals1overMinus2(){
        RationalScalar oneOverTwo=new RationalScalar(1,2);
        //System.out.println(oneOverTwo.toString());
        RationalScalar oneOverMinusTwo=new RationalScalar(1,-2);
        //System.out.println(oneOverMinusTwo.toString());
        assertFalse("1/2 Not Equals 1/-2",oneOverTwo.equals(oneOverMinusTwo));
    }
    @Test
    public void test0over2Equals0over1(){
        RationalScalar zeroOverTwo=new RationalScalar(0,2);
        RationalScalar zeroOverOne=new RationalScalar(0,1);
        assertTrue("0/2 Equals 0/1",zeroOverTwo.equals(zeroOverOne));
    }
    @Test
    public void test0overMinus2Equals0over1(){
        RationalScalar zeroOverMinusTwo=new RationalScalar(0,-2);
        RationalScalar zeroOverOne=new RationalScalar(0,1);
        assertTrue("0/-2 Equals 0/1",zeroOverMinusTwo.equals(zeroOverOne));
    }
    @Test
     public void testToStringOf1over2(){
        RationalScalar oneOverTwo=new RationalScalar(1,2);
        assertEquals("1/2",oneOverTwo.toString());
    }
    @Test
    public void testToStringOf1overMinus2(){
        RationalScalar oneOverMinusTwo=new RationalScalar(1,-2);
        assertEquals("-1/2",oneOverMinusTwo.toString());
    }
    @Test
    public void testToStringOf0overMinus2(){
        RationalScalar zeroOverMinusTwo=new RationalScalar(0,-2);
        assertEquals("0",zeroOverMinusTwo.toString());
    }

    @Test
    public void testReduce100over10Is10over1() {
        RationalScalar hundredOverTen=new RationalScalar(100,10);
        Assertions.assertEquals(new RationalScalar(10,1), hundredOverTen.reduce(), "100/10 is 10/1");
    }
    @Test
    public void testReduce4over8Is1over2() {
        RationalScalar fourOverEight=new RationalScalar(4,8);
        Assertions.assertEquals(new RationalScalar(1,2), fourOverEight.reduce(), "4/8 is 1/2");
    }
    @Test
    public void testReduceMinus4over8IsMinus1over2() {
        RationalScalar minusFourOverEight=new RationalScalar(-4,8);
        Assertions.assertEquals(new RationalScalar(-1,2), minusFourOverEight.reduce(), "-4/8 is -1/2");
    }
    @Test
    public void testReduce4overMinus8IsMinus1over2() {
        RationalScalar fourOverMinusEight=new RationalScalar(4,-8);
        Assertions.assertEquals(new RationalScalar(-1,2), fourOverMinusEight.reduce(), "4/-8 is -1/2");
    }
    @Test
    public void testReduceMinus4overMinus8Is1over2() {
        RationalScalar minusFourOverMinusEight=new RationalScalar(-4,-8);
        Assertions.assertEquals(new RationalScalar(1,2), minusFourOverMinusEight.reduce(), "-4/-8 is 1/2");
    }
    @Test
    public void testReduce1over5Is1over5() {
        RationalScalar oneOverFive=new RationalScalar(1,5);
        Assertions.assertEquals(new RationalScalar(1,5), oneOverFive.reduce(), "4/8 is 1/2");
    }
    @Test
    public void testReduce0over5Is0over1() {
        RationalScalar zeroOverFive=new RationalScalar(0,5);
        Assertions.assertEquals(new RationalScalar(0,1), zeroOverFive.reduce(), "0/5 is 0/1");
    }
    @Test
    public void testReduce0overMinus3Is0over1() {
        RationalScalar zeroOverMinusThree=new RationalScalar(0,-3);
        Assertions.assertEquals(new RationalScalar(0,1), zeroOverMinusThree.reduce(), "0/-3 is 0/1");
    }

    @Test
    public void testMinusOneOverTwoEqualsMinusOneOverTwo() {
        RationalScalar minusOneOverTwo1=new RationalScalar(-1,2);
        RationalScalar minusOneOverTwo2=new RationalScalar(-1,2);
        Assertions.assertTrue( minusOneOverTwo1.equals(minusOneOverTwo2), "-1/2 is -1/2");
    }
    @Test
    public void testToStringOfMinusOneOverTwoEqualsIsCorrect() {
        RationalScalar minusOneOverTwo=new RationalScalar(-1,2);
        Assertions.assertEquals("-1/2", minusOneOverTwo.toString(), "toString Of Minus One Over Two Equals: -1/2");
    }



}
