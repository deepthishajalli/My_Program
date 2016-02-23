import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Sections{
    public static void main(String[] args){
    if(args.length != 1){
    System.out.println("Please Provide the file name as argument");
    }

//Buffere reads is used to read the file.

    BufferedReader read = null;
    //try block is used to avoid abnormal termination of program if the file name is not found.
    try {
          read = new BufferedReader(new FileReader(args[0]));
         } catch (IOException exe) {
            System.out.println("File not found.");
             return;
         }
     
      //Hashmapping is used to track the count value for each item in the section

     HashMap<String, Integer> section_count = new HashMap<String, Integer>();

     //Stringbuilder is used for the output the items in the Section input.
     
      StringBuilder StrBld = new StringBuilder();

     // Hash to track the lis of items in sections that are given in the file.

      section_count.put("PERSON", 0);
      section_count.put("PLACE", 0);
      section_count.put("ANIMAL", 0);
      section_count.put("COMPUTER", 0);
      section_count.put("OTHER", 0);

     //one string variable is assigned to read the item in the file provided.
     //rds is a string variable used for the reading the items in file provided.

     String rds = null;
   
      try {
              // while loop is written to check the and read the file. while is choosen scince no incrmention of varible is reuired when using the readLine() function.

      while((rds = read.readLine()) != null){
          // To eliminate emplty lines in the files if present
          if(rds.isEmpty())
               continue;

          // get the sections values
           int sectionEnd = rds.indexOf(" "); 
           String category = rds.substring(0, sectionEnd).toUpperCase();
  
         // section reading is check for the valid and we may skipped.
         // duplicate values
         
         if(section_count.containsKey(category) && !StrBld.toString().contains(rds)){
               //appending is done
               StrBld.append(rds);
               StrBld.append("\n\n");
                //updation is being done
                section_count.put(category, section_count.get(category) +1); 
     }
}

//Display of output.

System.out.println("CATEGORY \t COUNT\n");
System.out.println("PERSON \t\t" + section_count.get("PERSON"));
System.out.println("PLACE \t\t" + section_count.get("PLACE"));
System.out.println("ANIMAL \t\t" + section_count.get("ANIMAL"));
System.out.println("COMPUTER \t" + section_count.get("COMPUTER"));
System.out.println("OTHER \t\t" + section_count.get("OTHER")+"\n");
System.out.println("Information Present in the file:"+"\n");
System.out.println(StrBld.toString());
} catch (IOException exe){
            System.out.println(exe.getMessage());
} finally {
        // Close the read if it is open
       if(read != null){
                    try{
                           read.close();
                       } catch(IOException exe){
                              System.out.println(exe.getMessage());
                       }
             }

         }
   }

}
                             