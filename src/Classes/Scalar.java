package Classes;

public interface Scalar {
    public Scalar add(Scalar s);
    public Scalar add(RationalScalar s);
    public Scalar add(IntengerScalar s);
    public Scalar mul(Scalar s);
    public Scalar neg();
    public Scalar power(int exponent);
    public int sign();
    boolean equals(Object o);
}
