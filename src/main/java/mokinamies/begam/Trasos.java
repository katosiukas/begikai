package mokinamies.begam;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Trasos {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String pav;
	private Integer ilgis;
	
	@OneToMany(mappedBy = "trasos",cascade = CascadeType.ALL)
	private List<BegtosTrasos> begtostrasos;
	
	public Trasos() {}
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the pav
	 */
	public String getPav() {
		return pav;
	}
	/**
	 * @param pav the pav to set
	 */
	public void setPav(String pav) {
		this.pav = pav;
	}
	/**
	 * @return the ilgis
	 */
	public Integer getIlgis() {
		return ilgis;
	}
	/**
	 * @param ilgis the ilgis to set
	 */
	public void setIlgis(Integer ilgis) {
		this.ilgis = ilgis;
	}

}