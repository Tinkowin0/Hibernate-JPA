package com.jdc.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(SalePkId.class)
public class SaleIdClass implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String description;
	
	@Id
	private int sequenceNumber;
	@Id
	private int transactionType;
	
	public SaleIdClass() {
		// TODO Auto-generated constructor stub
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public int getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(int transactionType) {
		this.transactionType = transactionType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, sequenceNumber, transactionType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SaleIdClass other = (SaleIdClass) obj;
		return Objects.equals(description, other.description) && sequenceNumber == other.sequenceNumber
				&& transactionType == other.transactionType;
	}
	
	

}
