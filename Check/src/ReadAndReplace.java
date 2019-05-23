import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ReadAndReplace {

	public static void main(String[] args) throws IOException {
		StringBuffer inputBuffer = new StringBuffer();
		Map<String,String> stringOfJapValue = new  HashMap<String,String>();
		String filePath = "C:/Users/00003897/Desktop/Changes_Done(Future)/New_Japanese.csv";
		String propertiesFilePath = "C:/Users/00003897/Desktop/Changes_Done(Future)/application-bundle_ja.properties";
		String newPropertiesFilePath = "C:/Users/00003897/Desktop/Changes_Done(Future)/new_application_bundle_ja.properties";
		BufferedReader file = null;
		try {
			file = new BufferedReader(new InputStreamReader(
                    new FileInputStream(filePath), "UTF8"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String line;
        List<String> list = new ArrayList<String>();

        try {
			while ((line = file.readLine()) != null) {
				list.add(line.toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        try {
			file.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        Object[] listString =  list.toArray();
    	try {
			file = new BufferedReader(new InputStreamReader(
                    new FileInputStream(propertiesFilePath), "UTF8"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	boolean comeOut = false;
        try {
			while ((line = file.readLine()) != null) {
				comeOut = false;
				//System.out.println(line);
				String[] partsList2 =  line.split("=");
				//System.out.println(partsList2[0]+" "+partsList2[1]);
				if(partsList2.length > 1)
				{
					for(int i = 0;i<listString.length;i++)
					{
						if(line.trim() != "")
						{
							String[] partsList = ((String) listString[i]).split("=");
							
							if(partsList[0].trim().equalsIgnoreCase(partsList2[0].trim().toString()))
							{
								inputBuffer.append(partsList[0].trim()+" = "+ partsList[1].trim());
								System.out.println(partsList[0].trim()+" = "+ partsList[1].trim());
								inputBuffer.append("\n");
								comeOut = true;
								break;
							}
							
						}
						
					}
				}
				
				if(comeOut == false)
				{
					//System.out.println(line);
					inputBuffer.append(line);
					inputBuffer.append("\n");
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        try {
			file.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        BufferedWriter writer = null;
        try
        {
            writer = new BufferedWriter( new OutputStreamWriter(
            	    new FileOutputStream(newPropertiesFilePath), "UTF-8"));
            writer.write( inputBuffer.toString());

        }
        catch ( IOException e)
        {
        	e.printStackTrace();
        }
        finally
        {
            try
            {
                if ( writer != null)
                writer.close( );
            }
            catch ( IOException e)
            {
            }
        }
        
	}

}
