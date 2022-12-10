package com.jason.algs4ex;

public class Rational {
    /**
     * 分子
     */
    private final long numerator;
    /**
     * 分母
     */
    private final long denominator;

    public Rational(long numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    public Rational(long numerator, long denominator) {
        //判断分母是不是0
        if (denominator == 0) {
            throw new IllegalArgumentException("denominator can not be 0");
        }
        long gcdValue = gcd(Math.abs(numerator), Math.abs(denominator));
        if (gcdValue != 1) {
            numerator /= gcdValue;
            denominator /= gcdValue;
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    private static long gcd(long p, long q) {
        if (q == 0) return p;
        long r = p % q;
        return gcd(q, r);
    }

    public Rational plus(Rational b) {
        return new Rational(this.numerator * b.denominator + b.numerator * this.denominator,
                this.denominator * b.denominator);
    }

    public Rational minus(Rational b) {
        return new Rational(this.numerator * b.denominator - b.numerator * this.denominator,
                this.denominator * b.denominator);
    }

    public Rational times(Rational b) {
        return new Rational(this.numerator * b.numerator, this.denominator * b.denominator);
    }

    public Rational divides(Rational b) {
        return new Rational(this.numerator * b.denominator, this.denominator * b.numerator);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rational rational = (Rational) o;

        if (numerator != rational.numerator) return false;
        return denominator == rational.denominator;
    }

    @Override
    public int hashCode() {
        int result = (int) (numerator ^ (numerator >>> 32));
        result = 31 * result + (int) (denominator ^ (denominator >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
