package com.jdc.shop.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.OrderBy;
import javax.persistence.OrderColumn;

@Entity
public class Product implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String category;
	
	@CollectionTable(name = "PRODUCT_PRICE", joinColumns = @JoinColumn(name = "product", referencedColumnName = "id"))
	@ElementCollection
	@MapKeyColumn(name = "price_type")
	@MapKeyEnumerated(EnumType.STRING)
	private Map<PriceType, Integer> price;
	
	@CollectionTable(name = "PRODUT_TAGS")
	@ElementCollection
	@OrderBy("tags desc")
	private List<String> tags;
	
	@ElementCollection
	@OrderColumn(name = "Event")
	private List<Features> feature;
	 
	public enum PriceType{
		Customer, Agent, Purchase
	}
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Map<PriceType, Integer> getPrice() {
		return price;
	}

	public void setPrice(Map<PriceType, Integer> price) {
		this.price = price;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, feature, id, name, price, tags);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(category, other.category) && Objects.equals(feature, other.feature) && id == other.id
				&& Objects.equals(name, other.name) && Objects.equals(price, other.price)
				&& Objects.equals(tags, other.tags);
	}

	public List<Features> getFeature() {
		return feature;
	}

	public void setFeature(List<Features> feature) {
		this.feature = feature;
	}
	
}
