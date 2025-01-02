package com.instagram.main;

import java.time.LocalDate;

import com.instagram.model.Comment;
import com.instagram.model.Gender;
import com.instagram.model.Like;
import com.instagram.model.Post;
import com.instagram.model.User;
import com.instagram.service.AccountService;
import com.instagram.service.AuthService;
import com.instagram.service.CommentService;
import com.instagram.service.LikeService;
import com.instagram.service.PostService;
import com.instagram.service.StorageService;
import com.instagram.service.UserValidator;
import com.instagram.service.impl.UserValidatorImpl;
import com.instagram.service.impl.AccountServiceImpl;
import com.instagram.service.impl.AuthServiceImpl;
import com.instagram.service.impl.CommentServiceImpl;
import com.instagram.service.impl.LikeServiceImpl;
import com.instagram.service.impl.PostServiceImpl;
import com.instagram.service.impl.StorageServiceImpl;

public class InstagramApplication {

	public static void main(String[] args) {

		StorageService storageService = new StorageServiceImpl();

		UserValidator userValidator = new UserValidatorImpl(storageService);

		AccountService accountService = new AccountServiceImpl(storageService, userValidator);

		AuthService authService = new AuthServiceImpl(userValidator, storageService);

		PostService postService = new PostServiceImpl(storageService, userValidator);

		LikeService likeService = new LikeServiceImpl(storageService, userValidator);

		CommentService commentService = new CommentServiceImpl(storageService, userValidator);
		
		User u1 = new User("Zoro", "+91 7846352748", "piratehunter@gmail.com",
		 LocalDate.of(2001, 04, 24), "roronoa_zoro", "zoro@piratehunter", Gender.MALE);
		accountService.createAccount(u1);
		
		User u2 = new User("Luffy", "+91 7846352749", "mokeydluffy@gmail.com",
		 LocalDate.of(2003, 06, 4), "monkey.D.luffy", "luffy@34", Gender.MALE);
		accountService.createAccount(u2);
		
		User u3 = new User("sanji", "+91 9788466355", "vinsmokesanji@gmail.com",
		 LocalDate.of(2001, 07, 16), "black_leg_sanji", "sanji#cook", Gender.MALE);
		accountService.createAccount(u3);
		
		User u4 = new User("usopp", "+91 9986566355", "usopp@gmail.com",
		 LocalDate.of(2003, 10, 23), "god_D_usopp", "longnose@gmail.com", Gender.MALE);
		accountService.createAccount(u4);
		
		User u5 = new User("sanji", "+91 9788466355", "sanji@gmail.com",
		 LocalDate.of(2001, 07, 16), "sanji", "cook@gmail.com", Gender.MALE);
		accountService.createAccount(u5);
		System.out.println();


		authService.login(202503, "sanji#cook");
		
		authService.login(202502, "luffy@34");
		
		authService.login(202501, "zoro@piratehunter");
		
		System.out.println();
		
		accountService.deletUser(202500, "zoro@piratehunter");
		
		Post p1 = new Post("roronoa_zoro", 202501, "zoro.img", "Pirate Hunter Zoro");
		postService.post(p1);

		Post p2 = new Post("roronoa_zoro",202501,  "roronoa.img", "Kaizoku hantazoro.....");
		postService.post(p2);

		Post p3 = new Post("black_leg_sanji",202503,  "sanji.img", "cheff");
		postService.post(p3);


		
		Like like1 = new Like(202503, 202502, 102);
		likeService.like(like1);

		System.out.println();
		Comment c1 = new Comment(102, 202503, 202502, "SANJI...........");
		commentService.add(c1);

		System.out.println();

		//authService.logout(202502, "luffy@34");
		
		Like like2 = new Like(202501, 202502, 100);
		likeService.like(like2);

		// commentService.delete(c1);
		// likeService.dislike(like2);

		System.out.println(likeService.get(p1));
		System.out.println(commentService.get(p3));

		//accountService.deletUser(202501, "zoro@piratehunter");
		authService.login(202501, "zoro@piratehunter");
		System.out.println(storageService.get(202501));


		System.out.println(storageService.get(202501).hashCode());
		System.out.println(storageService.get(202502).hashCode());
		System.out.println(storageService.get(202503).hashCode());
		System.out.println(storageService.get(202504).hashCode());
	}

}
