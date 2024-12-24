package com.model.models;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


public  class User{
	
	private String name;
	
	private String phoneNumber;
	
	private String email;
	
	private Date dateOfBirth;
	
	private String userName;
	
	private String password;
	
	private Gender gender;
	
	private Map<Integer, Post> post;
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name
	}
	
	public String getPhoneNumber(){
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public Date getDateOfBirth(){
		return dateOfBirth;
	}
	
	public void setDateofBirth(Date dateOfBirth){
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getUserName(){
		return userName;
	}
	
	public void setUserName(){
		this.userName = userName;
	}
	
	public Post getPost(int postId){
		return post.getEntry(postId);
	}
	
	public void setPost(int postId, Post p){
		post.put(postId, p);
	}
	
}