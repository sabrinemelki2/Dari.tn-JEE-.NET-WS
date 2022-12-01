package consomi.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import consomi.entities.Annonce;

public class main {

	public static void main(String[] args) {
		
	

		 String endpoint = "http://localhost:9090/Annoce/Indexx_WS";
		   ArrayList<Annonce> requestlist = new ArrayList<Annonce>();
		   HttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet(endpoint);
			try {
				HttpResponse response = client.execute(request);
				String jsonResponse = EntityUtils.toString(response.getEntity());
				System.out.println("Response as String : " + jsonResponse);
				
					
				JSONArray responsearray = new JSONArray(jsonResponse);
				  int n = responsearray.length();
		            for (int i = 0; i < n; i++) {
		                // GET INDIVIDUAL JSON OBJECT FROM JSON ARRAY
		                JSONObject jo = responsearray.getJSONObject(i);

		                // RETRIEVE EACH JSON OBJECT'S FIELDS
		               
	
		                int AnnonceId = jo.getInt("AnnonceId");
		                int chambres = jo.getInt("chambres");
		               
		                int typeAn = jo.getInt("TypeAn");
		                float surface = jo.getFloat("surface");
		                String description = jo.getString("Description");
		                String address = jo.getString("address");
		                float price = jo.getFloat("price");
		 
		               
		                
		                System.out.println("ID  : " + AnnonceId);
		    			System.out.println("Type d'annoce  : " + typeAn);
		    			System.out.println("\n Description : " + description);
		    			System.out.println("\n Adress : " + address);
		    			System.out.println("\n surface : " + surface);

		    			System.out.println("\n chambres : " + chambres);

		    			System.out.println("\n Price  : " + price);
		    			

	
	
		            }
		            
			           } catch (IOException e) {
		    			//e.printStackTrace();
		    		}
		   
	}

}
