package com.contable.form;

import com.contable.common.beans.Form;

public class DocumentoAplicacionForm implements Form {

	private static final long serialVersionUID = 1L;

	private  int id ;
	private  Integer idDocumento;
	private  DocumentoForm idDocumentoAplica;
	private  Double importe;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getIdDocumento() {
		return idDocumento;
	}
	public void setIdDocumento(Integer idDocumento) {
		this.idDocumento = idDocumento;
	}
	public DocumentoForm getIdDocumentoAplica() {
		return idDocumentoAplica;
	}
	public void setIdDocumentoAplica(DocumentoForm idDocumentoAplica) {
		this.idDocumentoAplica = idDocumentoAplica;
	}
	public Double getImporte() {
		return importe;
	}
	public void setImporte(Double importe) {
		this.importe = importe;
	}

}
