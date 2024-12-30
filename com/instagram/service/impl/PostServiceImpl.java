package com.instagram.service.impl;

import java.util.Map;

import com.instagram.model.Post;
import com.instagram.model.User;
import com.instagram.service.PostService;
import com.instagram.service.StorageService;
import com.instagram.service.UserService;

public class PostServiceImpl implements PostService{

    private UserService userService;
    private StorageService storageService;

    public PostServiceImpl(UserService userService, StorageService storageService)
    {
        this.userService = userService;
        this.storageService = storageService;
    }
    
    @Override
    public void post(final Post post) {

        final Integer postID = post.getPostId();
        final Integer userID = getUserId(post.getUserName());
        final User user = storageService.get(userID);

        // if getUsersession is false then it means the user is not log in currently, so the user cannot use this method
        if(post != null && userID != null && user!= null && userService.getUserSession(user.getUserName()))
        {
            user.setPost(postID, post);
            System.out.println(user.getPost(postID));
        }

        else
        {
            System.out.println("Unable to post: User is either not logged in or does not exist.");
        }
    }



    @Override
    public void delete(final Post post) {

        // if the does not login then he cannot have the access to delete
        if (userService.getUserSession(post.getUserName())) 
        {
            final Integer userID = getUserId(post.getUserName());
            
            final User user = storageService.get(userID);

            if(user.getPost().containsKey(post.getPostId()))
            {
                user.getPost().remove(post.getPostId());
            }

            else
            {
                System.out.println("Deletion failed: The specified post does not exist.");
            }        
            
        }   

        else
        {
            System.out.println("Deletion failed: User is not logged in.");
        }

    }
    
    @Override
    public void delete(final String userName) 
    {
        if (userService.getUserSession(userName)) 
        {
            final Integer userID = getUserId(userName);

            final User user = storageService.get(userID);

            if (!user.getPost().isEmpty()) 
            {
                user.getPost().clear();    
            }
            
        }    

        else
        {
            System.out.println("Unable to delete posts: User is not logged in.");
        }
    }

    @Override
    public Map<Integer, Post> get(String userName) 
    {
        Integer userID = getUserId(userName);

        User user = storageService.get(userID);

        if(user!=null)
        {
            return user.getPost();
        }

        else
        {
            return null;
        }
        
    }

    // to fetch the userID using username
    public Integer getUserId(final String userName)
    {
        Integer userID = null;
        for(final Map.Entry<Integer, User> e : storageService.get())
        {
            User user = e.getValue();

            if(userName.equals(user.getUserName()))
            {
                userID = e.getKey();
            }
        }   

        return userID;
    }
	
}