import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.net.ssl.HttpsURLConnection;

public class GenerateThreads {

	
	public static void main(String[] args) throws Exception {
		for(int i=0; i<150000; i++) {
			  SensorSimulator r = new SensorSimulator(i);
			  Thread t = new Thread(r);
			  t.start();	
		}

		/*RequestHandler http = new RequestHandler();

		System.out.println("Testing 1 - Send Http GET request");
		http.sendGet();
		
		System.out.println("\nTesting 2 - Send Http POST request");
		for(int i=0; i<1000; i++)
			http.sendPost();
	*/
	}
/*
	// HTTP GET request
	private void sendGet() throws Exception {

		String url = "http://localhost:8080/Dashboard/RequestCounter";
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());

	}
	
	// HTTP POST request
	private void sendPost() throws Exception {

	      String url = "http://localhost:8080/Dashboard/RequestCounter";
	        String urlParameters = "";
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
	}
*/
}



