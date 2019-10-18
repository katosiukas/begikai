package mokinamies.begam;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Begikai {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String pav;
	private Integer metai;
	
	@JsonIgnoreProperties("begikai")
	@OneToMany(mappedBy = "begikai",cascade = CascadeType.ALL)
	private List<BegtosTrasos> begtostrasos;
	/**
	 * @return the id
	 */
	
	public Begikai() {}
	
	public Begikai(Integer id, String pav, Integer metai) {
		
		this.id = id;
		this.pav = pav;
		this.metai = metai;
		
	}
	
	/**
	 * @return the begtostrasos
	 */
	public List<BegtosTrasos> getBegtostrasos() {
		return begtostrasos;
	}

	/**
	 * @param begtostrasos the begtostrasos to set
	 */
	public void setBegtostrasos(List<BegtosTrasos> begtostrasos) {
		this.begtostrasos = begtostrasos;
	}

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
	 * @return the metai
	 */
	public Integer getMetai() {
		return metai;
	}
	/**
	 * @param metai the metai to set
	 */
	public void setMetai(Integer metai) {
		this.metai = metai;
	}

}
