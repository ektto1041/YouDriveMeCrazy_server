package com.freaky_guys.youdrivemecrazy_server.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class gameuser {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nickname;
	private String password;
	public gameuser() {
	}
	public gameuser(Long id, String nickname, String password) {
		this.id = id;
		this.nickname = nickname;
		this.password = password;
	}
	public gameuser(String nickname, String password) {
		this.nickname = nickname;
		this.password = password;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setEmail(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
