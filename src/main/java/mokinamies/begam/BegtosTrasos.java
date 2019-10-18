package mokinamies.begam;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class BegtosTrasos {
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable=false)
	private Integer begikas_id;
	
	@Column(nullable=false)
	private Integer trasa_id;
	
	private Integer data;
	private Integer atstumas;
	private Integer laikas;
		    
	@JsonIgnoreProperties("begikai")
	@ManyToOne(optional=false)
    @JoinColumn(name="begikas_id",referencedColumnName="id", insertable=false, updatable=false)
    private Begikai begikai;
	
	@JsonIgnoreProperties("trasos")
	@ManyToOne(optional=false)
    @JoinColumn(name="trasa_id",referencedColumnName="id", insertable=false, updatable=false)
    private Trasos trasos;
	
	public BegtosTrasos() {}

	/**
	 * @return the trasos
	 */
	public Trasos getTrasos() {
		return trasos;
	}

	/**
	 * @param trasos the trasos to set
	 */
	public void setTrasos(Trasos trasos) {
		this.trasos = trasos;
	}

	/**
	 * @return the begikai
	 */
	public Begikai getBegikai() {
		return begikai;
	}

	/**
	 * @param begikai the begikai to set
	 */
	public void setBegikai(Begikai begikai) {
		this.begikai = begikai;
	}
	
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
	 * @return the begikas_id
	 */
	public Integer getBegikas_id() {
		return begikas_id;
	}

	/**
	 * @param begikas_id the begikas_id to set
	 */
	public void setBegikas_id(Integer begikas_id) {
		this.begikas_id = begikas_id;
	}

	/**
	 * @return the trasa_id
	 */
	public Integer getTrasa_id() {
		return trasa_id;
	}

	/**
	 * @param trasa_id the trasa_id to set
	 */
	public void setTrasa_id(Integer trasa_id) {
		this.trasa_id = trasa_id;
	}

	/**
	 * @return the data
	 */
	public Integer getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Integer data) {
		this.data = data;
	}

	/**
	 * @return the atstumas
	 */
	public Integer getAtstumas() {
		return atstumas;
	}

	/**
	 * @param atstumas the atstumas to set
	 */
	public void setAtstumas(Integer atstumas) {
		this.atstumas = atstumas;
	}

	/**
	 * @return the laikas
	 */
	public Integer getLaikas() {
		return laikas;
	}

	/**
	 * @param laikas the laikas to set
	 */
	public void setLaikas(Integer laikas) {
		this.laikas = laikas;
	}

}