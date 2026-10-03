package edu.cs.utexas.HadoopEx;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class IntTuple implements Writable {
    public int a;
    public int b;

    public IntTuple() {
        a = 0;
        b = 0;
    }

    public IntTuple(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void readFields(DataInput arg0) throws IOException {
        a = arg0.readInt();
        b = arg0.readInt();
    }

    @Override
    public void write(DataOutput arg0) throws IOException {
        arg0.writeInt(a);
        arg0.writeInt(b);
    }

}