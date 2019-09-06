package org.springframework.samples.petclinic.owner;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.visit.Visit;

@Entity
@Table(name="facturas")
public class Bill extends BaseEntity {
	
	@Digits(integer=10, fraction=0)
	private long idNumber;
	
	@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date paymentDate;
	
	@Digits(integer=5, fraction=2)
	@DecimalMin("0.0")
	private double money;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "bill", cascade = CascadeType.ALL)
	private Visit visit;
	
	//@ManyToOne
	//@JoinColumn (name="owner")
	//private Owner owner;
	
	@OneToMany( cascade = CascadeType.ALL, mappedBy = "bill")
	private List<LineasdeFacturas> lineasdefactura;
	
	

	public Bill () { }

	public long getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(long idNumber) {
		this.idNumber = idNumber;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public Visit getVisit() {
		return visit;
	}

	public void setVisit(Visit visit) {
		this.visit = visit;
	}
	public List<LineasdeFacturas> getLineasdefactura() {
		return lineasdefactura;
	}

	public void setLineasdefactura(List<LineasdeFacturas> lineasdefactura) {
		this.lineasdefactura = lineasdefactura;

/*	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}*/
	
	}

	@Override
	public String toString() {
		return "Bill [idNumber=" + idNumber + ", paymentDate=" + paymentDate + ", money=" + money + ", visit=" + visit
				+ ", lineasdefactura=" + lineasdefactura + "]";
	}	
}
