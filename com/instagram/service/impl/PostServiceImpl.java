package com.instagram.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.instagram.model.Post;
import com.instagram.model.User;
import com.instagram.service.PostService;
import com.instagram.service.StorageService;
import com.instagram.service.UserService;

public class PostServiceImpl implements PostService {

    private UserService userService;
    private StorageService storageService;

    public PostServiceImpl(UserService userService, StorageService storageService) {

        this.userService = userService;
        this.storageService = storageService;

    }
    
    @Override
    public void post(final Post post) {

        if (post == null) {

            System.out.println("Invalid Post");
            return;

        }

        if (userService.isUserExist(post.getUserID()) && userService.getUserSession(post.getUserID())) {

            final User user = storageService.get(post.getUserID());
            user.setPost(post.getPostId(), post);
            System.out.println(user.getPost(post.getPostId()));

        }

        else {
            System.out.println("Unable to post: User is either not logged in or does not exist.");

        }
    }


    @Override
    public void delete(final Post post) {

        if (userService.isUserExist(post.getUserID()) && userService.getUserSession(post.getUserID())) {

            final User user = storageService.get(post.getUserID());
            
            if (user.getPost().containsKey(post.getPostId())) {

                user.getPost().remove(post.getPostId());
            
            }

            else {
                System.out.println("Deletion failed: The specified post does not exist.");
            
            }        
        }

        else {
            System.out.println("Deletion failed: User is not logged in.");
        
        }
    }
    
    @Override
    public void delete(final int userID) {

        if (userService.isUserExist(userID) && userService.getUserSession(userID)) {

            final User user = storageService.get(userID);

            if (!user.getPost().isEmpty()) {

                user.getPost().clear();    
            
            }
            
        }    

        else {
            System.out.println("Unable to delete posts: User is not logged in.");
        
        }
    }

    @Override
    public Map<Integer, Post> get(final int userID) {

        if (userService.isUserExist(userID)) {

            final User user = storageService.get(userID);
            return user.getPost();

        }

        else {
            return new HashMap<>();
        
        }
        
    }
}