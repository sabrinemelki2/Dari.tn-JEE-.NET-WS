package consomi.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import consomi.interfaces.*;
import com.jayway.jsonpath.JsonPath;

import consomi.entities.ApplicationUser;


/**
 * Session Bean implementation class UserService
 */
@Stateless
@LocalBean
public class UserService implements UserServiceRemote, UserServiceLocal {

	
	
	/**
     * Default constructor. 
     */
    public UserService() {
        
    }

	@Override
	public ApplicationUser login(String email, String password) {
    	Client client = ClientBuilder.newClient();
    	
    	WebTarget web = client.target("http://localhost:6587/api/user/"); 
    	
    	WebTarget user = web.path(email + "/" + password);
    	
    	Response response = user.request().get();
    	
    	String result = response.readEntity(String.class); 

    	int id = JsonPath.read(result, "$.Result.Id");
    	String username = JsonPath.read(result, "$.Result.UserName");
    	
    	ApplicationUser appUser = new ApplicationUser(id, email, username);
    
		System.out.println("JSON Id " + id);
    
    	response.close(); 

    	return appUser;    	
	
	}

}
