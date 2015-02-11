import java.io.*;


public class ReadLine {

	

	public static void readLine(String s) throws IOException

	{

		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(s))));

		String temp = "";

		String lastTitle = "";

		long count = 0;

		FileWriter fw = new FileWriter("output.jason");

		fw.append("{ \r\n");

		while((temp=br.readLine())!=null)

		{

			temp.replaceAll("[\\n\\t\\s ]", "");

			//String[] line = temp.split(",\\t");
			String[] line = temp.split("\\t");

			if(!line[0].equals(lastTitle))

			{

				if(count!=0)

				{

					fw.append("]");

					fw.append("\r\n");

				}

				fw.append("\""+line[0]+"\":[");

				fw.append("\r\n");

				//fw.append("{\"year\":\""+line[1]+"\",\"salary\":\""+line[2]+"\"},");
				//fw.append("{\""+line[1]+"\",\""+line[2]+"\"},");
				fw.append("["+line[1]+","+line[2]+"],");

				fw.append("\r\n");

				count++;

				lastTitle=line[0];

			}

			else

			{

				fw.append("["+line[1]+","+line[2]+"],");

				fw.append("\r\n");

			}

			

		}

		fw.append("}");

		fw.close();

	}





	public static void main(String[] args) throws Exception {
		
		String filename = "jobTXn.txt";
		ReadLine.readLine(filename);
	
	}

}