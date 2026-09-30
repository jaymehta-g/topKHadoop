package edu.cs.utexas.HadoopEx;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WordCountReducer extends  Reducer<Text, AirlineTuple, Text, AirlineTuple> {

   public void reduce(Text text, Iterable<AirlineTuple> values, Context context)
           throws IOException, InterruptedException {
	   
       int countSum = 0;
       int delaySum = 0;
       
       for (AirlineTuple value : values) {
           countSum += value.count;
           delaySum += value.delay;
       }
       
       context.write(text, new AirlineTuple(delaySum, countSum));
   }
}