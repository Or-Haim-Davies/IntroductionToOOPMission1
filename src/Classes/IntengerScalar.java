package Classes;

import jdk.jshell.spi.ExecutionControl;

public class IntengerScalar implements Scalar {
    private int number;
    public String toString(){
        return number+"";
    }
    public int getNumber(){
        return number;
    }
    public IntengerScalar(int number){this.number=number;}
    public Scalar add(Scalar s){
        return s.add(this);
    }
    public Scalar add(IntengerScalar s) {
         return   (new IntengerScalar(s.number+this.number));
    }
    public Scalar add(RationalScalar s) {
        int nominator= s.getNumerator()+this.number*s.getDominator();
        return   (new RationalScalar(nominator,s.getDominator()));
    }
    public Scalar mul(Scalar s){
        return s.mul(this);
    }
    public Scalar mul(IntengerScalar s) {
        return   (new IntengerScalar(s.number*this.number));
    }
    public Scalar mul(RationalScalar s) {
        int nominator= s.getNumerator()*this.number;
        return   (new RationalScalar(nominator,s.getDominator()));
    }
    public Scalar neg(){
        return new IntengerScalar(-this.number);
    }
    public Scalar power(int exponent){
        int keeper=1;
        for(int i=0;i<exponent;i++){
            keeper=this.number*keeper;
        }
        return new IntengerScalar(keeper);
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
            return (o.equals(this));
        }
        return false;
    }
    public boolean equals(IntengerScalar o){
        return o.getNumber()==this.number;
    }
    public boolean equals(RationalScalar o){
        return o.getNumerator()/o.getDominator()+o.getNumerator()%o.getDominator()==this.number;
    }
}
