package com.jdc.entity;

import java.io.Serializable;
import java.util.Objects;

public class SalePkId implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private int sequenceNumber;
	private int transactionType;
	
	public SalePkId() {
		// TODO Auto-generated constructor stub
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
		return Objects.hash(sequenceNumber, transactionType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalePkId other = (SalePkId) obj;
		return sequenceNumber == other.sequenceNumber && transactionType == other.transactionType;
	}
}
