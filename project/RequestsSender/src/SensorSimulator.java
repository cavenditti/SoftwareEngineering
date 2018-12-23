import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

import javax.net.ssl.HttpsURLConnection;

import org.omg.CORBA.portable.OutputStream;

public class SensorSimulator implements Runnable{

	private int id;
    private int value;
    private int frequency;
    private static Semaphore s= new Semaphore(1);
    
    SensorSimulator(int id){
    	this.id=id;
    	frequency=5000;
    }
    
    
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		GenerateThreads http = new GenerateThreads();
		
		for(int i=0; i<50; i++)
			try {
				value=ThreadLocalRandom.current().nextInt(0, 10 + 1);
				s.acquire();
				sendGet();
				s.release();
				Thread.sleep(frequency);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	public void setFrequency(int frequency){
		this.frequency=frequency;
	};
	
	// HTTP GET request
	private void sendGet() throws Exception {

        URL oracle = new URL("http://localhost:8080/Dashboard/RequestHandler?id="+id+"&value="+value);
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                                    yc.getInputStream()));
        String inputLine;
        String newFrequency="5000";
        while ((inputLine = in.readLine()) != null) 
            newFrequency=inputLine;
        
        frequency=Integer.parseInt(newFrequency);
        
        System.out.println("Sensor id="+id+"  value="+value);
        
        in.close();
        HttpURLConnection huc=(HttpURLConnection)yc;
        huc.disconnect();
	}
	/*
	private void sendPost() throws Exception {
		   
			String urlParameters = "id=1&value=2";
			
			// Send post request
				      String url = "http://localhost:8080/Dashboard/RequestHandler";
	
	        byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);

	        try {

	            URL myurl = new URL(url);
	            con = (HttpURLConnection) myurl.openConnection();

	            con.setDoOutput(true);
	            con.setRequestMethod("POST");
	            con.setRequestProperty("User-Agent", "Java client");
	            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
	                wr.write(postData);
	            }

	            StringBuilder content;

	            try (BufferedReader in = new BufferedReader(
	                    new InputStreamReader(con.getInputStream()))) {
	                String line;
	                content = new StringBuilder();

	                while ((line = in.readLine()) != null) {
	                    content.append(line);
	                    content.append(System.lineSeparator());
	                }
	            }

	            System.out.println(content.toString());

	        } finally {
	            
	            con.disconnect();
	        }
	
	}*/
}

