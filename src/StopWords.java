import java.io.*;
import java.util.*;


public class StopWords {

	String add = "/home/cloudera/workspace/HW7_N18397245/stopwords.txt";
	
	public String stopWords(String s) throws IOException
	{  
		BufferedReader srcFileBr = new BufferedReader(new InputStreamReader(new FileInputStream(new File(add))));
		
		Set<String> stopWordsSet = new HashSet<String>();
		String stopWord = "";
		for(; (stopWord = srcFileBr.readLine()) != null;)
		{
			stopWordsSet.add(stopWord);    
		} 
		String output="";
		
		StringTokenizer tokenizer = new StringTokenizer(s," ,;.?!:");
		while (tokenizer.hasMoreTokens()) {
			String temp = tokenizer.nextToken().toLowerCase();
			if(!stopWordsSet.contains(temp))
			{
				output=output+temp+" ";
			}
		 }
		return output;
	}
	
}
