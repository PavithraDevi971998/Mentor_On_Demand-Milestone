package com.mod.model;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name= "mentor")
public class Mentor {
	@Id
	@Column(name="mentorId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	 private int mentorId;
	@Column(name="name")
	 private String name;
	@Column(name="email")
	 private String email;
	@Column(name="password")
	 private String password;
	@Column(name="linkedinurl")
	 private String linkedinUrl;
	 @Column(name="technology")
	 private String technology;
	 @Column(name="experience")
	 private int experience;
	 @Column(name="contactnumber")
	 private String contactNumber;
	 @Column(name="trainingCompleted")
	 private int trainingCompleted;
	 @Column(name="fromDate")
	 private Date fromDate;
	 @Column(name="toDate")
	 private Date toDate;
	 @Column(name="fromTime")
	 private String fromTime;
	 @Column(name="toTime")
	 private String toTime;
	 @Column(name="statusmentor")
	 private String statusMentor;
	 @Column(name="active")
	 private boolean active;
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getStatusMentor() {
		return statusMentor;
	}
	public void setStatusMentor(String statusMentor) {
		this.statusMentor = statusMentor;
	}
	public int getMentorId() {
		return mentorId;
	}
	public void setMentorId(int mentorId) {
		this.mentorId = mentorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getLinkedinUrl() {
		return linkedinUrl;
	}
	public void setLinkedinUrl(String linkedinUrl) {
		this.linkedinUrl = linkedinUrl;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public int getTrainingCompleted() {
		return trainingCompleted;
	}
	public void setTrainingCompleted(int trainingCompleted) {
		this.trainingCompleted = trainingCompleted;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public String getFromTime() {
		return fromTime;
	}
	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}
	public String getToTime() {
		return toTime;
	}
	public void setToTime(String toTime) {
		this.toTime = toTime;
	}
	@Override
	public String toString() {
		return "Mentor [mentorId=" + mentorId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", linkedinUrl=" + linkedinUrl + ", technology=" + technology + ", experience=" + experience
				+ ", contactNumber=" + contactNumber + ", trainingCompleted=" + trainingCompleted + ", fromDate="
				+ fromDate + ", toDate=" + toDate + ", fromTime=" + fromTime + ", toTime=" + toTime + "]";
	}
	
}
