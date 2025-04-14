package Classes;

public class Monomial {
    private int exponent;
    private Scalar coefficient;
    public int getExponent(){return this.exponent;}
    public Scalar getCoefficient(){return this.coefficient;}
    public Monomial(int exponent, Scalar coefficient){
        this.exponent=exponent;
        this.coefficient=coefficient;
    }
    public Monomial add(Monomial m){
        if(this.exponent==m.exponent){
            return new Monomial(this.exponent,this.coefficient.add(m.getCoefficient()));
        }
        return null;
    }
    public Monomial mul(Monomial m){
        return new Monomial(this.exponent+m.getExponent(),this.coefficient.mul(m.getCoefficient()));
    }
    public Scalar evaluate(Scalar s){
        return  (this.coefficient.mul(s.power(this.exponent)));
    }
    public Monomial derivative(){
        return new Monomial(exponent-1,new IntegerScalar(exponent).mul(coefficient));
    }
    public int sign(){
        return coefficient.sign();
    }
    public boolean equals(Object o){
        if(o instanceof Monomial){
            if(coefficient.equals(new IntegerScalar(0))&&((Monomial)o).getCoefficient().equals(new IntegerScalar(0))){
                return true;
            } else if (exponent==0&&((Monomial)o).getExponent()==0) {
                return true;
            }
            return ((Monomial) o).exponent == this.exponent && ((Monomial) o).coefficient.equals(this.coefficient);
        }
        return false;
    }
    public String toString(){
        if(exponent==0){
            return coefficient.toString();
        }
        else{
            if(coefficient.toString().equals("1")||coefficient.toString().equals("1")){
                if(coefficient.toString().equals("1")){
                    return "x^"+exponent;
                }
                else {
                    return "-x^"+exponent;
                }
            }
            else {
                return coefficient.toString()+"x^"+exponent;
            }
        }
    }
}
