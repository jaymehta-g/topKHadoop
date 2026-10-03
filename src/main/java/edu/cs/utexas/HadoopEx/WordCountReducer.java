package edu.cs.utexas.HadoopEx;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WordCountReducer extends  Reducer<Text, IntTuple, Text, IntTuple> {

   public void reduce(Text text, Iterable<IntTuple> values, Context context)
           throws IOException, InterruptedException {
	   
       int sum = 0;
       int sum2 = 0;
       
       for (IntTuple value : values) {
           sum += value.a;
           sum2 += value.b;
       }
       
       context.write(text, new IntTuple(sum, sum2));
   }
}