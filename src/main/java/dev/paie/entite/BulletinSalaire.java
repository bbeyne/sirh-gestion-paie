package dev.paie.entite;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class BulletinSalaire {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;	
	@ManyToOne
	private RemunerationEmploye remunerationEmploye;
	@ManyToOne
	private Periode periode;
	private BigDecimal primeExceptionnelle;
	private ZonedDateTime dateCreation;
	
	public BulletinSalaire() {
		super();
	}
	public BulletinSalaire(ZonedDateTime date, RemunerationEmploye remunerationEmploye, Periode periode, BigDecimal primeExceptionnelle) {
		super();
		this.remunerationEmploye = remunerationEmploye;
		this.periode = periode;
		this.primeExceptionnelle = primeExceptionnelle;
		this.dateCreation=date;
	}
	public RemunerationEmploye getRemunerationEmploye() {
		return remunerationEmploye;
	}
	public void setRemunerationEmploye(RemunerationEmploye remunerationEmploye) {
		this.remunerationEmploye = remunerationEmploye;
	}
	public Periode getPeriode() {
		return periode;
	}
	public void setPeriode(Periode periode) {
		this.periode = periode;
	}
	public BigDecimal getPrimeExceptionnelle() {
		return primeExceptionnelle;
	}
	public void setPrimeExceptionnelle(BigDecimal primeExceptionnelle) {
		this.primeExceptionnelle = primeExceptionnelle;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	

	public ZonedDateTime getDatecreation() {
		
		return dateCreation;
	}
	public void setDatecreation(ZonedDateTime datecreation) {
		this.dateCreation = datecreation;
	}
	
	public String dateform(){
		return dateCreation.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"));
	}
	
}
