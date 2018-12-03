package assignment4;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
 import assignment4.FileSelecter;
public class ReadFileToString
{
    public static String readingFile(String Path)
    {
    	//String filePath = "E:/Concordia/Fall/data/The_State_of_Data_Final.txt";
        System.out.println( readFile( Path ) );
        String s=readFile( Path );
        return s;
    }
    //Read file content into string with - Files.lines(Path path, Charset cs)
    public static String readFile(String filePath)
    {	String a=null;
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8)){
            stream.forEach(s -> contentBuilder.append(s));
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(contentBuilder.toString());
        
        a=contentBuilder.toString();
        preprocessString(a);
        return a;
    }
    public static String preprocessString(String a) {
    	// removes space
    	String s="0";
    	
    	a=a.replaceAll("(\\s+)","");
    	// removes all leaving A-Z a-z 0-9 @
        a= a.replaceAll("[^A-Za-z0-9 @]", "");
       //System.out.println(a);
        a=a.toUpperCase();
        s=s.concat(a);
		return s;
		
	}


	
    
}