package br.com.universomagic.pojo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cards {

	@JsonProperty("foreignNames")
	private List<ForeignNames> foreignNames = new ArrayList<ForeignNames>();
	private String name;
	private String manaCost;
	private String power;
	private String toughness;
	private String imageUrl;
	
	
	public List<ForeignNames> getForeignNames() {
		return foreignNames;
	}
	public void setForeignNames(List<ForeignNames> foreignNames) {
		this.foreignNames = foreignNames;
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
