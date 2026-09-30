package edu.cs.utexas.HadoopEx;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class AirlineTuple implements Writable {

	public int delay;
	public int count;

	public AirlineTuple(int delay, int count) {
		this.delay = delay;
		this.count = count;
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		delay = in.readInt();
		count = in.readInt();
	}

	@Override
	public void write(DataOutput out) throws IOException {
		out.writeInt(delay);
		out.writeInt(count);
	}
	
}
