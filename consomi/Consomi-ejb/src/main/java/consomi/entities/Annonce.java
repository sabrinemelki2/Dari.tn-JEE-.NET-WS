package consomi.entities;
import java.io.Serializable;

public class Annonce implements Serializable {
	public int AnnonceId;
	private int TypeAn;
	private String description;
	private String address;
	private float price;
	private float surface;
	private int chambres ;
	
	
	public int getAnnonceId() {
		return AnnonceId;
	}
	public void setAnnonceId(int annonceId) {
		AnnonceId = annonceId;
	}
	public int getTypeAn() {
		return TypeAn;
	}
	public void setTypeAn(int typeAn) {
		TypeAn = typeAn;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		description = description;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getSurface() {
		return surface;
	}
	public void setSurface(float surface) {
		this.surface = surface;
	}
	public int getChambres() {
		return chambres;
	}
	public void setChambres(int chambres) {
		this.chambres = chambres;
	}
	public Annonce(int AnnonceId, int typeAn, String description, String address, float price, float surface,
			int chambres) {
		super();
		this.AnnonceId = AnnonceId;
		this.TypeAn = typeAn;
		this.description = description;
		this.address = address;
		this.price = price;
		this.surface = surface;
		this.chambres = chambres;
	}

}
