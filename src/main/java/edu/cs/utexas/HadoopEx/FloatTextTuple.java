package edu.cs.utexas.HadoopEx;

public class FloatTextTuple implements Comparable<FloatTextTuple> {
    public float f;
    public String s;
    public FloatTextTuple(float f, String s) {
        this.f = f;
        this.s = s;
    }
    @Override
    public int compareTo(FloatTextTuple o) {
        return Float.compare(f, o.f);
    }
}