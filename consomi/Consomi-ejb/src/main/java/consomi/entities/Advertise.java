package consomi.entities;

import java.sql.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Advertise {
	
	@JsonProperty("advertiseId")
    public int advertiseId ;

	@JsonProperty("name")
    public String name ;
	
	@JsonProperty("dateDeb")
    public Date dateDeb;
	
	
	
	@JsonProperty("description")
    public String description;



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



	public Date getDateDeb() {
		return dateDeb;
	}



	public void setDateDeb(Date dateDeb) {
		this.dateDeb = dateDeb;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	@Override
	public String toString() {
		return "Advertise [advertiseId=" + advertiseId + ", name=" + name + ", dateDeb=" + dateDeb + ", description="
				+ description + "]";
	}

	
}
