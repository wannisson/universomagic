package br.com.universomagic.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.universomagic.pojo.Cards;


@Entity
public class Carts {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String manaCost;
	private String power;
	private String toughness;
	private String imageUrl;


	public Carts() {
		
	}
	
	public Carts(Cards cards) {
		this.manaCost = cards.getManaCost();
		this.power = cards.getPower();
		this.toughness = cards.getToughness();
		this.name = cards.getName();		
		this.imageUrl = cards.getImageUrl();
		
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getManaCost() {
		return manaCost;
	}

	public void setManaCost(String manaCost) {
		this.manaCost = manaCost;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public String getToughness() {
		return toughness;
	}

	public void setToughness(String toughness) {
		this.toughness = toughness;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	

	
}
