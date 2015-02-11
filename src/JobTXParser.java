import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileWriter;

public class JobTXParser {

     public static void main(String[] args) throws ParserConfigurationException,
          SAXException, IOException {
/*
          if(args.length != 1)
               throw new RuntimeException("The name of the XML file is required!");
*/
          DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
          DocumentBuilder builder = factory.newDocumentBuilder();
          
          File file=new File("job.txt");

          // Load the input XML document, parse it and return an instance of the
          // Document class.
          Document document = builder.parse(new File("rows6575.xml"));

          List<JobTXNew> jobs = new ArrayList<JobTXNew>();
          NodeList nodeList = document.getDocumentElement().getFirstChild().getChildNodes();
          for (int i = 0; i < nodeList.getLength(); i++) {
              Node node = nodeList.item(i);

              if (node.getNodeType() == Node.ELEMENT_NODE) {
                   Element elem = (Element) node;
                   String id ="";
                   String hire_date ="";
                   String title ="";
                   Double salary =0.00;
                   // Get the value of the ID attribute.
                   if(node.getAttributes().getNamedItem("_id")!=null){
                	   if(node.getAttributes().getNamedItem("_id").getNodeValue()!=null){
                 
                		   id = node.getAttributes().getNamedItem("_id").getNodeValue();
	                   }
	                   // Get the value of all sub-elements.
	/*                    String name = elem.getElementsByTagName("name")
	                                       .item(0).getChildNodes().item(0).getNodeValue();
	*/		
	                   if(elem.getElementsByTagName("title").item(0)!=null){
	                   String title1 = elem.getElementsByTagName("title")
	                           .item(0).getChildNodes().item(0).getNodeValue();
	                   title = title1.replaceAll(",", " ");
	                   }

	                   if(elem.getElementsByTagName("annual_salary").item(0)!=null){
	                    salary = Double.parseDouble(elem.getElementsByTagName("annual_salary")
	                           .item(0).getChildNodes().item(0).getNodeValue());
	                   }
	                   
	                   if(elem.getElementsByTagName("hire_date").item(0)!=null){
	                    hire_date = elem.getElementsByTagName("hire_date")
	                           .item(0).getChildNodes().item(0).getNodeValue();
	                   }

	                   }
	                   jobs.add(new JobTXNew(id, title, salary, hire_date));
	              }
	         }

              FileWriter fw=new FileWriter(file);
              BufferedWriter bfw=new BufferedWriter(fw);
              
          // Print all jobs.
          for (JobTXNew jobn : jobs){
//               System.out.println(jobn.toString());
        	  bfw.write(jobn.toString()+"\n");
          }
          bfw.flush();
     }
}