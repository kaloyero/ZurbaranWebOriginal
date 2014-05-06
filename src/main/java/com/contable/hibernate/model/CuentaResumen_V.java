package com.contable.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "valorespropios_v")
public class CuentaResumen_V implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public CuentaResumen_V() {
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private  int id ;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
}
