package com.contable.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "documentoaplicaciones")
public class DocumentoAplicacion implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public DocumentoAplicacion() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private  int id ;
	
	@Column(name = "IdDocumento")
	private  int idDocumento;
	@Column(name = "IdDocumentoAplica")
	private  int idDocumentoAplica;
	@Column(name = "Importe")
	private  double importe;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdDocumento() {
		return idDocumento;
	}
	public void setIdDocumento(int idDocumento) {
		this.idDocumento = idDocumento;
	}
	public int getIdDocumentoAplica() {
		return idDocumentoAplica;
	}
	public void setIdDocumentoAplica(int idDocumentoAplica) {
		this.idDocumentoAplica = idDocumentoAplica;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}

	
}
