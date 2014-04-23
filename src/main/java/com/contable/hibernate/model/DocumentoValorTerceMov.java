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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
@Table(name = "documentovalortermovs")
public class DocumentoValorTerceMov implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public DocumentoValorTerceMov() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private  int id ;
	
	@Column(name = "TipoMovimiento")
	private  String tipoMovimiento;
	
	@Column(name = "IdMovimiento")
	private  int idMovimiento;
	
	@OneToOne(fetch=FetchType.EAGER )
	@Cascade(value={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="IdDocumentoValorTer")		
	private DocumentoValorTerce valorTerce;
	
	public DocumentoValorTerce getValorTerce() {
		return valorTerce;
	}

	public void setValorTerce(DocumentoValorTerce valorTerce) {
		this.valorTerce = valorTerce;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public int getIdMovimiento() {
		return idMovimiento;
	}

	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}
	
}
