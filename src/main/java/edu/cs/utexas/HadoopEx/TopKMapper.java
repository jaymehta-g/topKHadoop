package edu.cs.utexas.HadoopEx;

import java.io.IOException;
import java.util.PriorityQueue;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.log4j.Logger;


public class TopKMapper extends Mapper<Object, Text, Text, FloatWritable> {

	private Logger logger = Logger.getLogger(TopKMapper.class);


	private PriorityQueue<FloatTextTuple> pq;

	public void setup(Context context) {
		pq = new PriorityQueue<>();

	}

	/**
	 * Reads in results from the first job and filters the topk results
	 *
	 * @param key
	 * @param value a float value stored as a string
	 */
	public void map(Object key, Text value, Context context)
			throws IOException, InterruptedException {


		String[] fields = value.toString().split("\t");

		pq.add(new FloatTextTuple(
			((float)Integer.parseInt(fields[1])) / Integer.parseInt(fields[2]),
			fields[0]
		));

		if (pq.size() > 10) {
			pq.poll();
		}
	}

	public void cleanup(Context context) throws IOException, InterruptedException {


		while (pq.size() > 0) {
			FloatTextTuple wordAndCount = pq.poll();
			context.write(new Text(wordAndCount.s), new FloatWritable(wordAndCount.f));
			logger.info("TopKMapper PQ Status: " + pq.toString());
		}
	}

}