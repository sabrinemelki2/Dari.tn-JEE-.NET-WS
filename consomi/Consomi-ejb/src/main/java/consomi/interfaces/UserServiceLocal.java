package consomi.interfaces;

import javax.ejb.Local;

import consomi.entities.ApplicationUser;

@Local
public interface UserServiceLocal {
	public ApplicationUser login(String email, String password);
}
