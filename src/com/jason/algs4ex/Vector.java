package com.jason.algs4ex;

import edu.princeton.cs.algs4.StdOut;

public class Vector {
    private final int d;
    private final double[] data;

    public Vector(int d) {
        this.d = d;
        data = new double[d];
    }

    public Vector(double... a) {
        d = a.length;

        data = new double[d];
        System.arraycopy(a, 0, data, 0, d);
    }

    /**
     * Unit tests the {@code Vector} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        double[] xData = {1.0, 2.0, 3.0, 4.0};
        double[] yData = {5.0, 2.0, 4.0, 1.0};
        Vector x = new Vector(xData);
        Vector y = new Vector(yData);

        StdOut.println("   x       = " + x);
        StdOut.println("   y       = " + y);

        Vector z = x.plus(y);
        StdOut.println("   z       = " + z);

        z = z.scale(10.0);
        StdOut.println(" 10z       = " + z);

        StdOut.println("  |x|      = " + x.magnitude());
        StdOut.println(" <x, y>    = " + x.dot(y));
        StdOut.println("dist(x, y) = " + x.distanceTo(y));
        StdOut.println("dir(x)     = " + x.direction());

    }

    /**
     * Returns the dimension of this vector.
     *
     * @return the dimension of this vector
     */
    public int dimension() {
        return d;
    }

    /**
     * Returns the dot product of this vector with the specified vector.
     *
     * @param that the other vector
     * @return the dot product of this vector and that vector
     * @throws IllegalArgumentException if the dimensions of the two vectors are not equal
     */
    public double dot(Vector that) {
        if (this.d != that.dimension()) throw new IllegalArgumentException("Dimensions don't agree");
        double sum = 0.0;
        for (int i = 0; i < d; i++)
            sum = sum + (this.data[i] * that.cartesian(i));
        return sum;
    }

    /**
     * Returns the magnitude of this vector.
     * This is also known as the L2 norm or the Euclidean norm.
     *
     * @return the magnitude of this vector
     */
    public double magnitude() {
        return Math.sqrt(this.dot(this));
    }

    /**
     * Returns the Euclidean distance between this vector and the specified vector.
     *
     * @param that the other vector
     * @return the Euclidean distance between this vector and that vector
     * @throws IllegalArgumentException if the dimensions of the two vectors are not equal
     */
    public double distanceTo(Vector that) {
        if (this.d != that.d) throw new IllegalArgumentException("Dimensions don't agree");
        return this.minus(that).magnitude();
    }

    /**
     * Returns the sum of this vector and the specified vector.
     *
     * @param that the vector to add to this vector
     * @return the vector whose value is {@code (this + that)}
     * @throws IllegalArgumentException if the dimensions of the two vectors are not equal
     */
    public Vector plus(Vector that) {
        if (this.d != that.d) throw new IllegalArgumentException("Dimensions don't agree");
        Vector c = new Vector(d);
        for (int i = 0; i < d; i++)
            c.data[i] = this.data[i] + that.cartesian(i);
        return c;
    }

    /**
     * Returns the difference between this vector and the specified vector.
     *
     * @param that the vector to subtract from this vector
     * @return the vector whose value is {@code (this - that)}
     * @throws IllegalArgumentException if the dimensions of the two vectors are not equal
     */
    public Vector minus(Vector that) {
        if (this.d != that.d) throw new IllegalArgumentException("Dimensions don't agree");
        Vector c = new Vector(d);
        for (int i = 0; i < d; i++)
            c.data[i] = this.data[i] - that.cartesian(i);
        return c;
    }

    /**
     * Returns the ith cartesian coordinate.
     *
     * @param i the coordinate index
     * @return the ith cartesian coordinate
     */
    public double cartesian(int i) {
        return data[i];
    }

    /**
     * Returns the scalar-vector product of this vector and the specified scalar
     *
     * @param alpha the scalar
     * @return the vector whose value is {@code (alpha * this)}
     */
    public Vector scale(double alpha) {
        Vector c = new Vector(d);
        for (int i = 0; i < d; i++)
            c.data[i] = alpha * data[i];
        return c;
    }

    /**
     * Returns a unit vector in the direction of this vector.
     *
     * @return a unit vector in the direction of this vector
     * @throws ArithmeticException if this vector is the zero vector
     */
    public Vector direction() {
        if (this.magnitude() == 0.0) throw new ArithmeticException("Zero-vector has no direction");
        return this.scale(1.0 / this.magnitude());
    }

    /**
     * Returns a string representation of this vector.
     *
     * @return a string representation of this vector, which consists of
     * the vector entries, separates by single spaces
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < d; i++)
            s.append(data[i]).append(" ");
        return s.toString();
    }
}
