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

public class JobNYCParser {

     public static void main(String[] args) throws ParserConfigurationException,
          SAXException, IOException {
    	  StopWords sw = new StopWords();
          if(args.length != 1)
               throw new RuntimeException("The name of the XML file is required!");

          DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
          DocumentBuilder builder = factory.newDocumentBuilder();
          
          File file=new File("job.txt");

          // Load the input XML document, parse it and return an instance of the
          // Document class.
          Document document = builder.parse(new File(args[0]));

          List<JobNew> jobs = new ArrayList<JobNew>();
          NodeList nodeList = document.getDocumentElement().getFirstChild().getChildNodes();
//          System.out.println(nodeList.getLength());
          for (int i = 0; i < nodeList.getLength(); i++) {
               Node node = nodeList.item(i);

               if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) node;

                    // Get the value of the ID attribute.
                    String id = node.getAttributes().getNamedItem("_id").getNodeValue();
                    // Get the value of all sub-elements.
                    String agency = elem.getElementsByTagName("agency")
                                        .item(0).getChildNodes().item(0).getNodeValue();

                    Integer no_of_positions = Integer.parseInt(elem.getElementsByTagName("__of_positions")
                            .item(0).getChildNodes().item(0).getNodeValue());

                    Double salary_range_from = Double.parseDouble(elem.getElementsByTagName("salary_range_from")
                                        .item(0).getChildNodes().item(0).getNodeValue());
                    Double salary_range_to = Double.parseDouble(elem.getElementsByTagName("salary_range_to")
                            .item(0).getChildNodes().item(0).getNodeValue());
                    String posting_date = elem.getElementsByTagName("posting_date")
                            .item(0).getChildNodes().item(0).getNodeValue();
                
                    int salary_avg = (int) ((salary_range_from + salary_range_to)/2);

                    jobs.add(new JobNew(id, agency, no_of_positions, salary_avg, posting_date));

//                    int x = elem.getElementsByTagName("preferred_skills")
//                            .item(0).getChildNodes().getLength();
                    
/*                    if (elem.getElementsByTagName("preferred_skills")
                    .item(0).getChildNodes().getLength()!=0){
                    String preferred_skills = elem.getElementsByTagName("preferred_skills")
                            .item(0).getChildNodes().item(0).getNodeValue();
//                    System.out.println(x);
                    String skills = sw.stopWords(preferred_skills);
                    jobs.add(new JobNew(skills));}*/
                    
               }
          }
              FileWriter fw=new FileWriter(file);
              BufferedWriter bfw=new BufferedWriter(fw);
              
          // Print all jobs.
          for (JobNew jobn : jobs){
//               System.out.println(jobn.toString());
        	  bfw.write(jobn.toString()+"\n");
          }
          bfw.flush();
     }
}