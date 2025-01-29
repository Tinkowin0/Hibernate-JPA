package com.jdc.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Transient;

@Entity
public class Sale implements Serializable{

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private SalePk salePk;
	
	@Lob
	private String description;
	
	@Transient
	private boolean deleted;
	
	public Sale() {
		// TODO Auto-generated constructor stub
	}

	public SalePk getSalePk() {
		return salePk;
	}

	public void setSalePk(SalePk salePk) {
		this.salePk = salePk;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(deleted, description, salePk);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sale other = (Sale) obj;
		return deleted == other.deleted && Objects.equals(description, other.description)
				&& Objects.equals(salePk, other.salePk);
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	
}
