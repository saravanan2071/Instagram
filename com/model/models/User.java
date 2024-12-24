package com.model.models;
import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

import com.enums.Gender;


public  class User{
	
	private String name;
	
	private String phoneNumber;
	
	private String email;
	
	private LocalDate dateofBirth;
	
	private String userName;

	private String password;
	
	private Gender gender;
	
	private Map<Integer, Post> post;
	
	
	public int hashCode() {
		return Objects.hash(email, phoneNumber, userName);
	}

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(phoneNumber, other.phoneNumber)
				&& Objects.equals(userName, other.userName);
	}
	
	
	public User(String name, String phoneNumber, String email, LocalDate dateOfBirth, String userName, String password, Gender gender) {
					
        this.name = name;
		
        this.phoneNumber = phoneNumber;
		
        this.email = email;
		
        this.dateofBirth = dateOfBirth;
		
        this.userName = userName;
		
        this.password = password;
		
        this.gender = gender;
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
	
	public Post getPost(int postId){
		return post.get(postId);
	}
	
	public void setPost(int postId, Post p){
		post.put(postId, p);
	}

	public Map<Integer, Post> getPost() {
		return post;
	}

	public void setPost(Map<Integer, Post> post) {
		this.post = post;
	}
	
	public String toString() {
		
		return "UserName : " + this.userName + "\n" + "Post : " + post;
		
	}

	
}