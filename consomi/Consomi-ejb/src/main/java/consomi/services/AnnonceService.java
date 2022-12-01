package consomi.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.ws.Response;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import consomi.entities.Annonce;
import consomi.interfaces.IAnnonceService;


@Stateless
@LocalBean

public class AnnonceService implements IAnnonceService {

	public ArrayList<Annonce> indxx()
	{
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
		    			

	Annonce c=new Annonce(AnnonceId,  typeAn,  description,  address,  price,  surface, chambres);
	   
	requestlist.add(c);
		            }
		            
			           } catch (IOException e) {
		    			//e.printStackTrace();
		    		}
		     return    requestlist;

	}

	public ArrayList<Annonce> indx(String filtre, String min, String max, String type)
	{
		  String endpoint = "http://localhost:9090/Annoce/Index_WS?filtre="+filtre+"&min="+min+"&max="+max+"&type="+type;
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
		               
	
		                int annonceId = jo.getInt("AnnonceId");
		                int chambres = jo.getInt("chambres");
		               
		                int typeAn = jo.getInt("TypeAn");
		                float surface = jo.getFloat("surface");
		                String description = jo.getString("description");
		                String address = jo.getString("address");
		                float price = jo.getFloat("price");
		 
		               
		                
		                System.out.println("ID  : " + annonceId);
		    			System.out.println("Type d'annoce  : " + typeAn);
		    			System.out.println("\n Description : " + description);
		    			System.out.println("\n Adress : " + address);
		    			System.out.println("\n surface : " + surface);

		    			System.out.println("\n chambres : " + chambres);

		    			System.out.println("\n Price  : " + price);
		    			

	Annonce c=new Annonce(annonceId,  typeAn,  description,  address,  price,  surface, chambres);
	   
	requestlist.add(c);
		            }
		            
			           } catch (IOException e) {
		    			//e.printStackTrace();
		    		}
		     return    requestlist;
		
	}
	public void  deleteservice(int idd)
	{
		
		
		   String endpoint = "http://localhost:9090/Annoce/Delete_WS?id="+idd;
		
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(endpoint);
		
		try {
			HttpResponse response = client.execute(request);
			 System.out.println("ID  : " + idd);
			
	            }
	            
		            catch (IOException e) {
	    			//e.printStackTrace();
	    		}
	   

		
		
		}
////////////////////////////////////////////////////////////////////////////
	
	
public void  createservice(int TypeAn , String description, String address , float surface, float price, int chambres)
{


String endpoint = "http://localhost:9090/Annoce/Create_WS?TypeAn="+TypeAn+"&Description="+description+"&address="+address+"&surface="+surface+"&price="+price+"&chambres="+chambres;

HttpClient client = new DefaultHttpClient();
HttpGet request = new HttpGet(endpoint);

try {
HttpResponse response = client.execute(request);

}

catch (IOException e) {
//e.printStackTrace();
}




}	

public void  editservice(int id, int TypeAn, String Description, String address, float surface, float price, int chambres)
{


String endpoint = "http://localhost:9090/Annoce/Edit_WS?id="+id+"&TypeAn="+TypeAn+"&Description="+Description+"&address="+address+"&surface="+surface+"&price="+price+"&chambres="+chambres;

HttpClient client = new DefaultHttpClient();
HttpGet request = new HttpGet(endpoint);

try {
HttpResponse response = client.execute(request);

    }
    
        catch (IOException e) {
		//e.printStackTrace();
	}




}
}
