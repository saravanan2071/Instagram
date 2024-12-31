package com.instagram.model;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


public  class User{

	private static int userID = 202501;
	
	private String name;
	
	private String phoneNumber;
	
	private String email;
	
	private LocalDate dateofBirth;
	
	private String userName;

	private String password;
	
	private Gender gender;
	
	private Map<Integer, Post> post;


	public User(String name, String phoneNumber, String email, LocalDate dateOfBirth, String userName, String password, Gender gender) {
					
		this.name = name;
		
		this.phoneNumber = phoneNumber;
		
		this.email = email;
		
		this.dateofBirth = dateOfBirth;
		
		this.userName = userName;
		
		this.password = password;
		
		this.gender = gender;

		post = new HashMap<>();
		
	}

	public int getUserID(){
		return userID;
	}

	public void setUserID(){
		userID++;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
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
	
	public LocalDate getDateOfBirth(){
		return dateofBirth;
	}
	
	public void setDateofBirth(LocalDate dateofBirth){
		this.dateofBirth = dateofBirth;
	}
	
	public String getUserName(){
		return userName;
	}
	
	public void setUserName(String userName){
		this.userName = userName;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public Gender getGender(){
		return gender;
	}
	
	public void setGender(Gender gender){
		this.gender  = gender;
	}
	
	public Post getPost(Integer postId){
		return post.get(postId);
	}

	public Map<Integer, Post> getPost(){
		return post;
	}

	public void setPost(Integer postId, Post p){
		post.put(postId, p);
	}

	public boolean equals(Object obj)
	{
		if(obj == null){
			return false;
		}
		if(obj.getClass() != this.getClass()){
			return false;
		}
		User user = (User)obj;
		
		return user.userName.equals(this.userName) || user.email.equals(this.email) || user.phoneNumber.equals(this.phoneNumber);
	}

	public int hashCode(){
		return userName.hashCode() + email.hashCode() + phoneNumber.hashCode();
	}
	
	
	public String toString() {
		
		return "UserName : " + this.userName + "\n" + "Post : " + post;
		
	}
	
}