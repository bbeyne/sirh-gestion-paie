package dev.paie.entite;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class ProfilRemuneration {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String code;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="CotisationNonImposable",joinColumns=	@JoinColumn(name="Profilremnonimp_id", referencedColumnName="id"),inverseJoinColumns=@JoinColumn(name="cotisation_id", referencedColumnName="id")
	)
	private List<Cotisation> cotisationsNonImposables;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="CotisationImposable",joinColumns=	@JoinColumn(name="Profilremimp_id", referencedColumnName="id"),inverseJoinColumns=	@JoinColumn(name="cotisation_id", referencedColumnName="id")
	)
	private List<Cotisation> cotisationsImposables;
	@ManyToMany(fetch=FetchType.EAGER)
	private List<Avantage> avantages;
	
	public ProfilRemuneration() {
		super();
	}

	public ProfilRemuneration(String code, List<Cotisation> cotisationsNonImposables,
			List<Cotisation> cotisationsImposables, List<Avantage> avantages) {
		super();
		this.code = code;
		this.cotisationsNonImposables = cotisationsNonImposables;
		this.cotisationsImposables = cotisationsImposables;
		this.avantages = avantages;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Cotisation> getCotisationsNonImposables() {
		return cotisationsNonImposables;
	}

	public void setCotisationsNonImposables(List<Cotisation> cotisationsNonImposables) {
		this.cotisationsNonImposables = cotisationsNonImposables;
	}

	public List<Cotisation> getCotisationsImposables() {
		return cotisationsImposables;
	}

	public void setCotisationsImposables(List<Cotisation> cotisationsImposables) {
		this.cotisationsImposables = cotisationsImposables;
	}

	public List<Avantage> getAvantages() {
		return avantages;
	}

	public void setAvantages(List<Avantage> avantages) {
		this.avantages = avantages;
	}

}
