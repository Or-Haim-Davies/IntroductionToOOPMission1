package Classes;

public class RationalScalar implements Scalar {
    private int numerator;
    private int dominator;

    public RationalScalar(int numerator,int dominator){

         this.numerator=numerator;
         this.dominator=dominator;
    }

    public String toString(){
    }
    public Scalar add(Scalar s){
        return s.add(this);
    }

    public Scalar add(RationalScalar s){
        int numerator1=this.numerator;
        int dominator1=this.dominator;
        int numerator2=s.getNumerator();
        int dominator2=s.getDominator();
        return new RationalScalar(numerator1*dominator2+numerator2*dominator1,dominator1*dominator2);
    }
    public Scalar add(IntengerScalar s){

    }



    public Scalar mul(Scalar s){

    }
    public Scalar neg(){

    }
    public Scalar power(int exponent){

    }
    public int sign(){

    }
    public boolean equals(Object o){

    }
    public RationalScalar reduce() {
        int gcd = 0;
        int remainder = 0;
        int dominator = this.dominator;
        int numerator = this.numerator;
        while (dominator != 0) {
            remainder = numerator % dominator;
            numerator = dominator;
            dominator = remainder;
        }
        return new RationalScalar(this.numerator/numerator,this.dominator/numerator);
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDominator() {
        return dominator;
    }

    public void setDominator(int dominator) {
        this.dominator = dominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }
}

