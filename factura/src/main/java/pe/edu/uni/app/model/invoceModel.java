package pe.edu.uni.app.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="invoice_beans")
public class invoceModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	private String numeroOtorgante;
	private int cve_netsuite;
	private int  consultas;
	private Double precio;
	private int cve_descuento;
	private String cve_region;
	private LocalDateTime fec_creacion;
	
	public invoceModel() {
		
	}


}
