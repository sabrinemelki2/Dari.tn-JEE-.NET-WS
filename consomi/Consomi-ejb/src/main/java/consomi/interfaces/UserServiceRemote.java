package consomi.interfaces;

import javax.ejb.Remote;

import consomi.entities.ApplicationUser;

@Remote
public interface UserServiceRemote {
	public ApplicationUser login(String email, String password);
}
