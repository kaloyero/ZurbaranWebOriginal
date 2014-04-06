package com.contable.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tipodocumentoconceptos")
public class TipoDocumentoConcepto implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public TipoDocumentoConcepto() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private  int id ;
	
	@Column(name = "IdTipoDocumento")
	private int idTipoDocumento;
	
	@OneToOne(fetch=FetchType.EAGER )
    @JoinColumn(name="IdConcepto")
	private Concepto concepto;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(int idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public Concepto getConcepto() {
		return concepto;
	}

	public void setConcepto(Concepto concepto) {
		this.concepto = concepto;
	}
	
}
