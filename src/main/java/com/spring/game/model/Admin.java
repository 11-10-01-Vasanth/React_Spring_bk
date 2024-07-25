package com.spring.game.model;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "admin_game")

public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "gameid", updatable = false, nullable = false)
	private UUID gameid;

	@Column(name = "gametitle")
	private String gametitle;

	@Column(name = "gamedescription")
	private String gamedescription;

	@Column(name = "gameprice")
	private Double gameprice;

	@Column(name = "gamediscount")
	private Double gamediscount;

	@Column(name = "gameimage")
	private String gameimage;

	@Column(name = "gamecategory")
	private String gamecategory;

	@Column(name = "createdAt")
	private Date createdAt;

	@Column(name = "updatedAt")
	private Date updatedAt;

	public UUID getGameid() {
		return gameid;
	}

	public void setGameid(UUID gameid) {
		this.gameid = gameid;
	}

	public String getGametitle() {
		return gametitle;
	}

	public void setGametitle(String gametitle) {
		this.gametitle = gametitle;
	}

	public String getGamedescription() {
		return gamedescription;
	}

	public void setGamedescription(String gamedescription) {
		this.gamedescription = gamedescription;
	}

	public Double getGameprice() {
		return gameprice;
	}

	public void setGameprice(Double gameprice) {
		this.gameprice = gameprice;
	}

	public Double getGamediscount() {
		return gamediscount;
	}

	public void setGamediscount(Double gamediscount) {
		this.gamediscount = gamediscount;
	}

	public String getGameimage() {
		return gameimage;
	}

	public void setGameimage(String gameimage) {
		this.gameimage = gameimage;
	}

	public String getGamecategory() {
		return gamecategory;
	}

	public void setGamecategory(String gamecategory) {
		this.gamecategory = gamecategory;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
