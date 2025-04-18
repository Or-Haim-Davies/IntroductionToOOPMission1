package Classes;

import java.util.TreeMap;

public class Polynomial {
    private TreeMap<Integer,Monomial> monomials;
    private Polynomial(){
        monomials=new TreeMap<>();
    }
    public static Polynomial build(String input){
        Polynomial result = new Polynomial();
        int levelCounter=0;
        String[] parts = input.split(" ");
        for(int i=0;i<parts.length;i++){
            if(parts[i].charAt(0)!=0){
                if(parts[i].contains("/")){
                    StringBuilder numerator= new StringBuilder();
                    StringBuilder dominator= new StringBuilder();
                    boolean divider=true;
                    for(int j=0;j< parts.length;j++){
                        if(parts[i].charAt(j)=='/'){
                            divider=false;
                        }
                        if(divider){
                            numerator.append(parts[i].charAt(j));
                        }
                        else {
                            dominator.append(parts[i].charAt(j));
                        }
                    }
                    result.monomials.put(i, new Monomial(i, new RationalScalar(Integer.parseInt(numerator.toString()), Integer.parseInt(dominator.toString()))));

                }
                else{
                    String number="";
                    for(int j=0;j< parts[i].length();j++){
                         number=number+parts[i].charAt(j);
                    }
                    result.monomials.put(i, new Monomial(i, new IntegerScalar(Integer.parseInt(number))));
                }
            }

        }
        return result;
    }
    public TreeMap<Integer,Monomial> getMonomials(){return monomials;}
    public Polynomial add(Polynomial p){
        Polynomial result = new Polynomial();
        for (int i=0;i<Math.max(this.monomials.size(),p.monomials.size());i++){
            if(p.getMonomials().containsKey(i)&&this.getMonomials().containsKey(i)){
                result.monomials.put(i, this.monomials.get(i).add(p.monomials.get(i)));
            } else if (p.getMonomials().containsKey(i)) {
                result.monomials.put(i, p.monomials.get(i));
            }
            else if (this.getMonomials().containsKey(i)) {
                result.monomials.put(i, this.monomials.get(i));
            }

        }
        return result;
    }
    public Polynomial mul(Polynomial p){
        Polynomial result = new Polynomial();
        for(int j =0;j<this.monomials.size();j++){
            for (int i=0;i<p.monomials.size();i++){
                if(p.getMonomials().containsKey(i)&&this.getMonomials().containsKey(j)){
                    if(result.monomials.containsKey(i+j)){
                        result.monomials.put(i+j,result.monomials.get(j+i).add(this.monomials.get(j).mul(p.monomials.get(i))));
                    }
                    else {
                        result.monomials.put(j+i,this.monomials.get(j).mul(p.monomials.get(i)));

                    }
                }
            }
        }
        return result;
    }
    public Scalar evaluate(Scalar s){
        Scalar result=new IntegerScalar(0);
        for(int i=0;i<this.monomials.size();i++){
            if(this.monomials.containsKey(i)){
                result.add(this.monomials.get(i).evaluate(s));
            }
        }
        return result;
    }
    public Polynomial derivative(){
        Polynomial result = new Polynomial();
        for(int i=0;i<this.monomials.size();i++){
            if(this.monomials.containsKey(i)){
                result.monomials.put(i,this.monomials.get(i).derivative());
            }
        }
        return result;
    }
    public boolean equals(Object o){
        if(o instanceof Polynomial){
            if(((Polynomial) o).monomials.size()==this.monomials.size()){
                for (int i=0;i<this.monomials.size();i++){
                    if(((Polynomial)(o)).getMonomials().containsKey(i)&&this.getMonomials().containsKey(i)){
                        if(!((Polynomial)(o)).getMonomials().get(i).equals(this.getMonomials().get(i))){
                           return false;
                        }
                    } else if (((Polynomial)(o)).getMonomials().containsKey(i)) {
                        return false;
                    }
                    else if (this.getMonomials().containsKey(i)) {
                        return false;
                    }

                }
                return true;
            }
        }
        return false;
    }
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(int i=0; i<monomials.size();i++){
            if(monomials.containsKey(i)){
                if(monomials.get(i).toString().charAt(0)=='-'){
                    if(result.length()==0){
                        result.append(monomials.get(i).toString());
                    }
                    else {
                        result.append(" "+monomials.get(i).toString());

                    }
                } else if (i==0&&monomials.get(i).toString().charAt(0)!='0') {
                    result.append(monomials.get(i).toString());
                }
                else if(monomials.get(i).toString().charAt(0)!='0'){
                    if(result.length()==0){
                        result.append(monomials.get(i).toString());
                    }
                    else {
                        result.append(" +"+monomials.get(i).toString());

                    }
                }
            }
        }
        return result.toString();
    }
}
