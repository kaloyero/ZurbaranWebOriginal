package com.contable.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "")
public class TipoDocumento implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public TipoDocumento() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IDAcceso", unique = true, nullable = false)
	private  int id ;
	
}
