package com.infosys.barni.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="usr_id")
	private Long id;

	@Column(name="usr_username")
	private String userUsername;
	
	@Column(name="usr_password")
	private String userPassword;	
	
	@Column(name="usr_email")
	private String userEmail;		
	
	@Column(name="usr_is_active")
	private boolean userIsActive;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserUsername() {
		return userUsername;
	}

	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public boolean isUserIsActive() {
		return userIsActive;
	}

	public void setUserIsActive(boolean userIsActive) {
		this.userIsActive = userIsActive;
	}

	@Override
	public String toString() {
		return "TraditionalProduct [id=" + id + ", userUsername=" + userUsername + ", userPassword=" + userPassword
				+ ", userEmail=" + userEmail + ", userIsActive=" + userIsActive + "]";
	}			

}