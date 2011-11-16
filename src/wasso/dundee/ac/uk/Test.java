package wasso.dundee.ac.uk;

import java.net.*;
import java.io.*;
import java.util.*;

public class Test {

	
public Float getPrice(String symbol){
	
	//CODE TO GET SHARE PRICES
			String priceline = new String();
			Float price = 0f;
			
			
			try {
			    //SEND HTTP REQUEST
			    String data = URLEncoder.encode("key1", "UTF-8") + "=" + URLEncoder.encode("value1", "UTF-8");
			    data += "&" + URLEncoder.encode("key2", "UTF-8") + "=" + URLEncoder.encode("value2", "UTF-8");

			    
			    URL url = new URL("http://finance.google.com/finance/info?client=ig&q=" + symbol);
			    URLConnection connect = url.openConnection();
			    connect.setDoOutput(true);
			    OutputStreamWriter write = new OutputStreamWriter(connect.getOutputStream());
			    write.write(data);
			    write.flush();

			    // READ TEXT INTO BUFFER
			    BufferedReader read = new BufferedReader(new InputStreamReader(connect.getInputStream()));
			    String textin;
			    int i = 0;
			    while ((textin = read.readLine()) != null) {
			    	// GET LINE 6
			    	if(i==6){
			    		priceline = textin;}
			    	i++;
			    	
			    }
			    write.close();
			    read.close();
			    
			    // EXTRACT NUMBER FROM STRING
			    Float value = new Float(priceline.substring(8,13));
			    price = value;
			    
			   
		    	
			
			} catch (Exception e) {
			}
			return price;
	}
}


