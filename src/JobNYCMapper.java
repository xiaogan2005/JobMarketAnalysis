
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class JobNYCMapper
  extends Mapper<LongWritable, Text, Text, IntWritable> {

  private static final int MISSING = 0;
  
  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {  
	
    String line = value.toString();
    String[] elements = line.split(",");
    /*
    int l = elements.length;
    for(int i=0;i<l;i++)
    {
    	System.out.println(elements[i]);
    }
    */ 
    int salary = (int) Double.parseDouble(elements[3]);
    String date = elements[4];
    String ndate = Function.returnDate(date);

    if (salary != MISSING) {
      context.write(new Text(ndate), new IntWritable(salary));
    }
  }
}
