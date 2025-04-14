package Classes;

import jdk.jshell.spi.ExecutionControl;

public class IntegerScalar implements Scalar {
    private int number;
    public String toString(){
        return number+"";
    }
    public int getNumber(){
        return number;
    }
    public IntegerScalar(int number){this.number=number;}

    public Scalar add(Scalar s){
        return s.addInteger(this);
    }
    public Scalar addInteger(IntegerScalar s) {
         return   (new IntegerScalar(s.number+this.number));
    }
    public Scalar addRational(RationalScalar s) {
        int nominator= s.getNumerator()+this.number*s.getDominator();
        return   (new RationalScalar(nominator,s.getDominator()));
    }
    public Scalar mul(Scalar s){
        return s.mulInteger(this);
    }
    public Scalar mulInteger(IntegerScalar s) {
        return   (new IntegerScalar(s.number*this.number));
    }
    public Scalar mulRational(RationalScalar s) {
        int nominator= s.getNumerator()*this.number;
        return   (new RationalScalar(nominator,s.getDominator()));
    }
    public Scalar neg(){
        return new IntegerScalar(-this.number);
    }
    public Scalar power(int exponent){
        int keeper=1;
        for(int i=0;i<exponent;i++){
            keeper=this.number*keeper;
        }
        return new IntegerScalar(keeper);
    }
    public int sign(){
        if(this.number>0){
            return 1;
        }
        else if (this.number<0) {
            return -1;
        }
        else {
            return 0;}

    }
    public boolean equals(Object o){
        if(o instanceof Scalar){
            return (((Scalar)o).equalsInteger(this));
        }
        return false;
    }
    public boolean equalsInteger(IntegerScalar o){
        return o.getNumber()==this.number;
    }
    public boolean equalsRational(RationalScalar o){
        return o.getNumerator()/o.getDominator()+o.getNumerator()%o.getDominator()==this.number;
    }
}
