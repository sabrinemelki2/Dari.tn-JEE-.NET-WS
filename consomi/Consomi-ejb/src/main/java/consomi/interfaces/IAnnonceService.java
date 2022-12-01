package consomi.interfaces;
import java.util.ArrayList;

import javax.ejb.Remote;

import consomi.entities.Annonce;
import Enumerates.TypeAn;


@Remote
public interface IAnnonceService {
	
	public ArrayList<Annonce> indxx();
	public ArrayList<Annonce> indx(String filtre, String min, String max, String type);
	public void  deleteservice(int idd);
	public void  createservice(int TypeAn , String description, String address , float surface, float price, int chambres);
	public void  editservice(int id, int TypeAn, String Description, String address, float surface, float price, int chambres);
}
