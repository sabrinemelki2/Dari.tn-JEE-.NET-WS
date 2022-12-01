package consomi.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import consomi.entities.Advertise;

@LocalBean
@Stateless
public class AdvertiseService {
	
	public List<Advertise>getall() {
		List<Advertise> quiiz = new ArrayList<Advertise>();

		System.out.println("***** get all Advertise *****");
    	Client cl = ClientBuilder.newClient();
		WebTarget target = cl.target("http://localhost:60276/api/web"); 
		Invocation.Builder invocationBuilder =  target.request(MediaType.APPLICATION_JSON);

//		WebTarget hello = target.path("Enfant"); 

//    	Response res=(Response) hello.request().get();
		Response response = invocationBuilder.get();
		

		Advertise[] listQuestion =  response.readEntity(Advertise[].class);
		for (Advertise p:listQuestion){
				quiiz.add(p);
		}
	System.out.println("size of list is : "+quiiz.size()+quiiz);

		return quiiz;

    	// mosh ena System.out.println(res.readEntity(String.class));
	//	ArrayList<Enfant> post = res.readEntity(new GenericType<ArrayList<Enfant>>() {});
	
		
		
		
		
		
		
		 
		//return post;
}
	

    public Advertise getById(int id) {
    	System.out.println("***** get condidate *****");
    	Client cl = ClientBuilder.newClient();
		WebTarget target = cl.target("http://localhost:60276/api/web/"+id); 
		Invocation.Builder invocationBuilder =  target.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		Advertise condi = response.readEntity(Advertise.class);
		System.out.println("*** ref ****"+condi);
		return condi;
    }

    
    public void DeleteById(int id) {
    	//System.out.println("***** get condidate *****");
		List<Advertise> quiiz = new ArrayList<Advertise>();

    	Client cl = ClientBuilder.newClient();
		WebTarget target = cl.target("http://localhost:60276/api/web/"+id); 
		//WebTarget t = target.path("Enfant"+id);     	
		
		Invocation.Builder invocationBuilder =  target.request(MediaType.APPLICATION_JSON);

		Response response = invocationBuilder.delete();
		
//    	Response res=(Response) t.request().delete();
		
		Advertise cond = response.readEntity(Advertise.class);

    	

    }
    
   
	
    public Response EditById(int id, Advertise u) {
    	System.out.println("***** update Advertise *****");
    	Client cl = ClientBuilder.newClient();
		WebTarget target = cl.target("http://localhost:60276/api/web/"+id); 
		 Invocation.Builder invocationBuilder =  target.request(MediaType.APPLICATION_JSON);
			Response response = invocationBuilder.put(Entity.json(u));
    	return response;
    }
    
    public void AddAdvertise(Advertise u) {
    	//System.out.println("***** get condidate *****");
    	//Condidate c;
    	Client cl = ClientBuilder.newClient();
		WebTarget target = cl.target("http://localhost:60276/api/web"); 
		 WebTarget hello = target.path("Advertise");     	

    	Response res=(Response) hello.request().post(Entity.json(u));
		//System.out.println(res.readEntity(String.class));

    	// pa moi System.out.println(res.getStatusInfo().getStatusCode());
    	// p moi System.out.println(res.readEntity(String.class));
    	// p moi Condidate cond = res.readEntity(Condidate.class);

    }}
