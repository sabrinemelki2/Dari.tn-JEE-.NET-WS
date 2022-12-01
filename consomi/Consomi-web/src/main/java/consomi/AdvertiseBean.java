package consomi;

import java.io.File;


import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import consomi.entities.Advertise;
import consomi.services.AdvertiseService;




@ManagedBean(name = "AdvertiseBean", eager = true)
@SessionScoped
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdvertiseBean {
	String txtname;
	String TxtStatus;
	Advertise ad1;
	Advertise ad2;
	Advertise ad3;
	List<Advertise> mstCode;
	List<Advertise> liste2 ;
	int advertiseId;
	String name;
	String dateDeb;
	String description;
	
	@Enumerated(EnumType.ORDINAL)
	String typeAd;
	
	
	public String getTxtname() {
		return txtname;
	}
	public void setTxtname(String txtname) {
		this.txtname = txtname;
	}
	public String getTxtStatus() {
		return TxtStatus;
	}
	public void setTxtStatus(String txtStatus) {
		TxtStatus = txtStatus;
	}
	public Advertise getAd1() {
		return ad1;
	}
	public void setAd1(Advertise ad1) {
		this.ad1 = ad1;
	}
	public Advertise getAd2() {
		return ad2;
	}
	public void setAd2(Advertise ad2) {
		this.ad2 = ad2;
	}
	public Advertise getAd3() {
		return ad3;
	}
	public void setAd3(Advertise ad3) {
		this.ad3 = ad3;
	}
	public List<Advertise> getMstCode() {
		return mstCode;
	}
	public void setMstCode(List<Advertise> mstCode) {
		this.mstCode = mstCode;
	}
	public List<Advertise> getListe2() {
		return liste2;
	}
	public void setListe2(List<Advertise> liste2) {
		this.liste2 = liste2;
	}
	
	
	
	public int getAdvertiseId() {
		return advertiseId;
	}
	public void setAdvertiseId(int advertiseId) {
		this.advertiseId = advertiseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDateDeb() {
		return dateDeb;
	}
	public void setDateDeb(String dateDeb) {
		this.dateDeb = dateDeb;
	}
	
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public AdvertiseService getAd() {
		return ad;
	}
	public void setAd(AdvertiseService ad) {
		this.ad = ad;
	}


	public String getTypeAd() {
		return typeAd;
	}
	public void setTypeAd(String typeAd) {
		this.typeAd = typeAd;
	}


	@EJB
	AdvertiseService ad;
	
	public List<Advertise> doGetAll() {
		System.out.println(ad.getall());

		return ad.getall();
	}

	public String IndexGetAll() {
		return "ListAdvertise.jsf?faces-redirect=true";
	}
	
	 public String AjouterAdvertise(){
		 Advertise ajout = new Advertise();
		   // ajout.setId(id);
		    ajout.setName(name);
		    
		    try {SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date1 = sdf.parse(dateDeb);
			java.sql.Date sqlStartDate = new java.sql.Date(date1.getTime());
			ajout.setDateDeb(sqlStartDate);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		   
		    
		    
		    
		    //ajout.setImage(image);
		    ajout.setDescription(description);
		   
		    
		    ad.AddAdvertise(ajout);
			return "ListAdvertise.jsf?faces-redirect=true";
			}
	
	    public String DeleteAdvertise(int id) {
			System.out.println("delete is here !");
			ad.DeleteById(id);
			return "ListAdvertise.jsf?faces-redirect=true"; 
			}
	    
	    public String redirectUpdate(int id )
		{
			ad1 = ad.getById(id);
	        setAdvertiseId(ad1.getAdvertiseId());		   

	        setName(ad1.getName());		   

			   SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		        String strDate = sdf.format(ad1.getDateDeb());
			setDateDeb(strDate); 
	        setDescription(ad1.getDescription());	   
	        
	      
	        		   


			return "UpdateAdvertise.jsf?faces-redirect=true";
		}
	    
	    public String UpdateAdvertise(int Id) {

	    	Advertise  interv1 = new Advertise();
			 interv1.setAdvertiseId(advertiseId);
			 interv1.setName(name);
			    
			   try {SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date date1 = sdf.parse(dateDeb);
				java.sql.Date sqlStartDate = new java.sql.Date(date1.getTime());
				interv1.setDateDeb(sqlStartDate);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			   

				 interv1.setDescription(description);
				 
				 

			    System.out.println(interv1);
			    System.out.println("aaaaaaaaaa");
			     ad.EditById(Id, interv1);
			return "ListAdvertise.jsf?faces-redirect=true";
}
}