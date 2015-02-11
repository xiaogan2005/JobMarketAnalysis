
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class JobTXReducer
  extends Reducer<Text, IntWritable, Text, IntWritable> {
  
  @Override
  public void reduce(Text key, Iterable<IntWritable> values,
      Context context)
      throws IOException, InterruptedException {
    
    int total=0 , num=0;
    for (IntWritable value : values) {
      total = total + value.get();
      num = num + 1;
    }
    int result = (int) total/num;
    context.write(key, new IntWritable(result));
  }
}
