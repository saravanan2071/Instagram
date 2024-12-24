package com.main;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.enums.Gender;
import com.model.models.Post;
import com.model.models.User;
import com.model.interfaces.*;
import com.model.impl.*;

public class Main {

	public static void main(String[] args) {
		
		UserService us = new UserServiceImpl();

		PostService ps = new PostServiceImpl();
		
		User u1 = new User("Zoro", "+91 7846352748", "piratehunter@gamail.com", LocalDate.of(2001, 04, 24), "roronoa_zoro", "zoro@piratehunter", Gender.MALE);
		us.createAccount(u1);
		
		User u2 = new User("Luffy", "+91 7846352749", "mokeydluffy@gamail.com", LocalDate.of(2003, 06, 4), "mokey.D.luffy", "luffy@34", Gender.MALE);
		us.createAccount(u2);
		
		User u3 = new User("sanji", "+91 9788466355", "vinsmokesanji@gamail.com", LocalDate.of(2001, 07, 16), "black_leg_sanji", "sanji#cook", Gender.MALE);
		us.createAccount(u3);
		
//		User u4 = new User("usopp", "+91 9986566355", "usopp@gamail.com", LocalDate.of(2003, 10, 23), "god_D_usopp", "longnose@gmail.com", Gender.MALE);
//		us.createAccount(u4);

		User u5 = new User("sanji", "+91 9788466355", "vinsmokesanji@gamail.com", LocalDate.of(2001, 07, 16), "black_leg_sanji", "cook@gmail.com", Gender.MALE);
		us.createAccount(u5);


		us.login("black_leg_sanji", "sanji#cook");
		
		us.login("mokey.D.luffy", "luffy@34");
		
		us.login("roronoa_zoro", "zoro@piratehunter");
		
		//us.deletUser("roronoa_zoro", "zoro@piratehunter");

		Post p1 = new Post("roronoa_zoro", "zoro.img", "PIRATE HUNTER ZORO.....", LocalDateTime.now());
		ps.post(p1);

		Post p2 = new Post("roronoa_zro", "roronoa.img", "Kaizoku hantāzoro.....", LocalDateTime.now());
		ps.post(p2);

		Post p3 = new Post("black_leg_sanji", "sanji.img", "cheff", LocalDateTime.now());
		ps.post(p3);
		
		// System.out.println();
		// System.out.println(u1);
		// System.out.println();
		// System.out.println(u3);

		

		
		
		// System.out.println();
		// System.out.println();
		// User u6 = new User("choper", null, null, LocalDate.of(2005, 8, 10), "racoon", "chope@racoon", null);
		// us.createAccount(u6);
	}

}
