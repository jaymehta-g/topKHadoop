package edu.cs.utexas.HadoopEx;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class WordCountMapper extends Mapper<Object, Text, Text, AirlineTuple> {

	// Create a counter and initialize with 1
	private final IntWritable counter = new IntWritable(1);
	// Create a hadoop text object to store words
	private Text word = new Text();

	public void map(Object key, Text value, Context context) 
			throws IOException, InterruptedException {
		String[] line = value.toString().split(",");
		String airline = line[4];
		int delay;
		try {
			delay = Integer.parseInt(line[11]);
		} catch (Exception e) {
			return;
		}

		context.write(new Text(airline), new AirlineTuple(delay,1));
	}
}