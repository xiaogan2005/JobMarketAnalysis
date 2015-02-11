
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class JobTXMapper
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
    int salary = (int) Double.parseDouble(elements[2]);
    String date = elements[0];
    String ndate = FunctionTX.returnDate(date);
    if(ndate.length() == 4 && Integer.parseInt(ndate) > 1960)
    {
    String title = elements[1];

    if (salary != MISSING && title!=null && !title.equals("")) {
      context.write(new Text(title+"\t"+ndate), new IntWritable(salary));
    }
    }
  }
}
