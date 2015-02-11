import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class MergeTX {
 // fileNames TargetFileName
 public static void merge(String[] fileNames, String TargetFileName)
   throws Exception {
  File fin = null;
  // 
  File fout = new File(TargetFileName);
  FileOutputStream out = new FileOutputStream(fout);
  for (int i = 0; i < fileNames.length; i++) {
   // 
   fin = new File(fileNames[i]);
   FileInputStream in = new FileInputStream(fin);
   // 
   int c;
   while ((c = in.read()) != -1) {
    out.write(c);
   }
   in.close();
  }
  out.close();
  //System.out.println("" + TargetFileName + "");
 }
 public static void readFileMessage(String fileName) {// 
  File file = new File(fileName);
  BufferedReader reader = null;
  try {
   reader = new BufferedReader(new FileReader(file));
   String string = null;
   // null
   while ((string = reader.readLine()) != null) {
    //System.out.println(string);
   }
   reader.close();
  } catch (IOException e) {
   e.printStackTrace();
  } finally {
   if (reader != null) {
    try {
     reader.close();
    } catch (IOException e1) {
    }
   }
  }
 }
 public static void main(final String[] args) throws Exception {
  // 
  String[] fileNames = { "job1.txt", "job2.txt",
    "job3.txt", "job4.txt", "job5.txt", "job6.txt" };
  String newFileName = "jobTX.txt";
  MergeTX.merge(fileNames, newFileName);
  MergeTX.readFileMessage(newFileName);
 }
}