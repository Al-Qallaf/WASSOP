package wasso.dundee.ac.uk;

import java.net.*;
import java.io.*;

public class ShareFeed {

	
public Float getPrice(String symbol){
			String priceline = new String();
			Float price = 0f;
			
			try {
			    String data = URLEncoder.encode("key1", "UTF-8") + "=" + URLEncoder.encode("value1", "UTF-8");
			    data += "&" + URLEncoder.encode("key2", "UTF-8") + "=" + URLEncoder.encode("value2", "UTF-8");

			    
			    URL url = new URL("http://finance.google.com/finance/info?client=ig&q=" + symbol);
			    URLConnection connect = url.openConnection();
			    connect.setDoOutput(true);
			    OutputStreamWriter write = new OutputStreamWriter(connect.getOutputStream());
			    write.write(data);
			    write.flush();

			    BufferedReader read = new BufferedReader(new InputStreamReader(connect.getInputStream()));
			    String textin;
			    int i = 0;
			    while ((textin = read.readLine()) != null) {
			    	if(i==6){
			    		priceline = textin;}
			    	i++;
			    	
			    }
			    write.close();
			    read.close();
			    
			    Float value = new Float(priceline.substring(8,13));
			    price = value;
			    
			   
			} catch (Exception e) {
			}
			return price;
	}
}
