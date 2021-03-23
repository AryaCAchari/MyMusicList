package com.music.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "music_list")
public class MusicListBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "singer")
	private String singer;
	
	@Column(name = "active_indicator")
	private Integer activeIndicator = 1;
	
	@Column(name = "created_on")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	
	@Column(name = "udpated_on")
	@Temporal(TemporalType.TIMESTAMP)
	private Date udpatedOn;
	
	@PrePersist
	private void createdOn() {
		udpatedOn = createdOn = new Date();
	}

	@PreUpdate
	private void udpatedOn() {
		udpatedOn = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public Integer getActiveIndicator() {
		return activeIndicator;
	}

	public void setActiveIndicator(Integer activeIndicator) {
		this.activeIndicator = activeIndicator;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUdpatedOn() {
		return udpatedOn;
	}

	public void setUdpatedOn(Date udpatedOn) {
		this.udpatedOn = udpatedOn;
	}
}
