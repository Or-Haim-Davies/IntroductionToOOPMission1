package Classes;

public class RationalScalar implements Scalar {
    private int numerator;
    private int dominator;

    public RationalScalar(int numerator,int dominator){

        this.numerator=numerator;
        this.dominator=dominator;
    }

    public String toString(){
        IntegerScalar numerator=new IntegerScalar(getNumerator());
        IntegerScalar dominator=new IntegerScalar(getDominator());
        if(getNumerator()%getDominator()==0)
            return Integer.toString(getNumerator()/getDominator());
        else if (numerator.sign()*dominator.sign()>0){
            RationalScalar result=new RationalScalar(getNumerator(),getDominator());
            result=result.reduce();
            return Math.abs(result.getNumerator())+"/"+ Math.abs(result.getDominator());
        }
        else {
            RationalScalar result=new RationalScalar(getNumerator(),
                    getDominator());
            if(getNumerator()<0){
                result=result.reduce();
                return result.getNumerator()+"/"+ result.getDominator();
            }

            result=result.reduce();
            return "-"+result.getNumerator()+"/"+ Math.abs(result.getDominator());
        }


    }
    public Scalar add(Scalar s){
        return s.addRational(this);
    }

    public Scalar addRational(RationalScalar s){
        int numerator1=this.numerator;
        int dominator1=this.dominator;
        int numerator2=s.getNumerator();
        int dominator2=s.getDominator();
        return new RationalScalar(numerator1*dominator2+numerator2*dominator1,dominator1*dominator2);
    }
    public Scalar addInteger(IntegerScalar s){
        int numerator1=this.numerator;
        int dominator1=this.dominator;
        int number2=s.getNumber();

        return new RationalScalar(numerator1+number2*dominator1,dominator1);
    }


    public Scalar mul(Scalar s){
        return s.mulRational((this));
    }
    public Scalar mulRational(RationalScalar s){
        int numerator1=this.numerator;
        int dominator1=this.dominator;
        int numerator2=s.getNumerator();
        int dominator2=s.getDominator();
        return new RationalScalar(numerator1*numerator2,dominator1*dominator2);
    }
    public Scalar mulInteger(IntegerScalar s){
        int numerator1=this.numerator;
        int dominator1=this.dominator;
        int number2=s.getNumber();
        return new RationalScalar(numerator1*number2,dominator1);
    }
    public Scalar neg(){
        return new RationalScalar(-this.numerator,this.dominator);
    }
    public Scalar power(int exponent){
        int newNumerator=1;
        int newDominator=1;
        for (int i=0;i<exponent;i++){
            newNumerator*=getNumerator();
            newDominator*=getDominator();
        }

        return new RationalScalar(newNumerator,newDominator);
    }
    public int sign(){
        if(getNumerator()==0)
            return 0;
        int signNumerator=0;
        int signDominator=0;
        if(getNumerator()>0)
            signNumerator=1;
        else
            signNumerator=-1;
        if (getDominator()>0)
            signDominator=1;
        else
            signDominator=-1;
        return signNumerator*signDominator;
    }
    public boolean equals(Object o){
        if(o instanceof Scalar){
           return  ((Scalar)o).equalsRational(this);
        }
        return false;
    }
    public boolean equalsRational(RationalScalar o){
       RationalScalar thisRationalScalar=this.reduce();
       RationalScalar oRationalScalar=o.reduce();
        if(this.sign()!=o.sign())
            return false;
        else {
            //System.out.println(getNumerator() / getDominator() == o.getNumerator() / o.getDominator());
            //return getNumerator() / getDominator() == o.getNumerator() / o.getDominator();
           /* int a1=thisRationalScalar.getNumerator();
            int a2=thisRationalScalar.getDominator();
            int b1=oRationalScalar.getNumerator();
            int b2=oRationalScalar.getDominator();
            boolean equals=thisRationalScalar.getNumerator()==oRationalScalar.getNumerator()&&thisRationalScalar.getDominator()==oRationalScalar.getDominator();*/
            return Math.abs(thisRationalScalar.getNumerator())==Math.abs(oRationalScalar.getNumerator())&&
                    Math.abs(thisRationalScalar.getDominator())==Math.abs(oRationalScalar.getDominator());
        }
        //return this.getNumerator()==o.getNumerator()&&this.getDominator()==o.getDominator();

        //return (o.getNumerator()/o.getDominator()+o.getNumerator()%o.getDominator()==this.numerator/this.dominator+this.numerator%this.dominator);
    }
    public boolean equalsInteger(IntegerScalar o){

        return (this.numerator/this.dominator+this.numerator%this.dominator==o.getNumber());
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
        if(this.numerator<0&&this.dominator<0){
            this.numerator*=-1;
            this.dominator*=-1;
        }


        return new RationalScalar(this.numerator/Math.abs(numerator),this.dominator/Math.abs(numerator));
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
