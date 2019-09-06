/**
 * 
 */
package org.springframework.samples.petclinic.owner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.samples.petclinic.model.BaseEntity;

/**
 * @author admin
 *
 */

@Entity
@Table(name = "lineasdefatura")
public class LineasdeFacturas extends BaseEntity {
	
	
	
	@Column(name = "detalhes")
	private String detalhes;

	@ManyToOne
    @JoinColumn(name = "id_bill")
	public Bill bill;

	
	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}
	
	 public String toString() {
	    	String mensaje = "";
	    	
	    	mensaje += " detalhe id: " + this.getId() + "\n";
	    	mensaje += "==================\n";
	    	mensaje += 	mensaje += "Descripcion: " + this.getDetalhes() +"\n";
	    	mensaje += "Id de factura: " + ((this.getBill() == null || (this.getBill() != null && this.getBill().getId() == null)) ? "No existe" : this.getBill().getId()) +"\n";
	    		
	    	return mensaje;

	 }
}
