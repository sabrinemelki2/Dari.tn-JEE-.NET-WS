package consomi;

import java.io.Serializable;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


import consomi.entities.Annonce;

import consomi.services.AnnonceService;

import Enumerates.*;


@ManagedBean(name = "AnnonceBean") 
@SessionScoped
public class AnnonceBean implements Serializable {

	private int AnnonceId;
	private int TypeAn;
	private String description;
	private String address;
	private float price;
	private float surface;
	private int chambres ;
	private Annonce annonce;
	private String filtres;
	private String types;
	private String mins;
	private String maxs;
	private TypeAn TypeA;
	

	


	public TypeAn getTypeA() {
		return TypeA;
	}




	public void setTypeA(TypeAn typeA) {
		TypeA = typeA;
	}




	public String getFiltres() {
		return filtres;
	}




	public void setFiltres(String filtres) {
		this.filtres = filtres;
	}




	public String getTypes() {
		return types;
	}




	public void setTypes(String types) {
		this.types = types;
	}




	public String getMins() {
		return mins;
	}




	public void setMins(String mins) {
		this.mins = mins;
	}




	public String getMaxs() {
		return maxs;
	}




	public void setMaxs(String maxs) {
		this.maxs = maxs;
	}








	private ArrayList<Annonce> requestslist;
	private ArrayList<Annonce> requestslist2;
	
	
	
	
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
		this.description = description;
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




	public Annonce getAnnonce() {
		return annonce;
	}




	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}




	public ArrayList<Annonce> getRequestslist2() {
		requestslist2=ds.indx( filtres,  mins,  maxs,  types);
		return requestslist2;
	}




	public void setRequestslist2(ArrayList<Annonce> requestslist2) {
		this.requestslist2 = requestslist2;
	}




	public ArrayList<Annonce> getRequestslist() {
		requestslist=ds.indxx();
		return requestslist;
	}




	public void setRequestslist(ArrayList<Annonce> requestslist) {
		this.requestslist = requestslist;
	}




	@EJB
	AnnonceService ds = new 	AnnonceService();
	
	
	
	public String editAnnoce()
 {
    	int a=0;
    	if(TypeA.toString().equals("Vente"))
    	{
    		a=0;
    	}	if(TypeA.toString().equals("Location"))
    	{
    		a=1;
    	}
    	
    	String navigateTo = "null";
    	
    	ds.editservice(AnnonceId, a, description, address, surface, price,chambres );
    	FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Annonce edit!"));
	
	navigateTo = "Indexx?faces-redirect=true";

	return navigateTo;

}
	
public String addRequest()  {
    	
    	

    	String navigateTo = "null";
    	
    	ds.createservice(0 ,description,address ,surface,price,chambres);
    	FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Annonce Added!"));
	
	navigateTo = "/Annonce/Indexx?faces-redirect=true";

	return navigateTo;

}
public String  displayRequests(Annonce Annonce) {
	this.description=Annonce.getDescription();
	this.TypeAn=Annonce.getTypeAn();
	this.address=Annonce.getAddress();
	this.price=Annonce.getPrice();
	this.surface=Annonce.getSurface();
	this.chambres=Annonce.getChambres();
	this.AnnonceId=Annonce.getAnnonceId();
	
	
	


	

	
	
	String navigateTo = "null"; 
	navigateTo = "/Annonce/Details?faces-redirect=true";
	
	
	
	
	
	
	return navigateTo;
	

}
public String  deleteRequest(int idd) {
		
	ds.deleteservice(idd);
	FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Annonce Deleted!"));
	String navigateTo = "null"; 
	navigateTo = "/Annonce/Indexx?faces-redirect=true";
	
	return navigateTo;
	

}

}

