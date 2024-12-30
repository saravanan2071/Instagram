package com.instagram.service.impl;

import java.util.Map;
import java.util.Set;

import com.instagram.model.Like;
import com.instagram.model.Post;
import com.instagram.model.User;
import com.instagram.service.LikeService;
import com.instagram.service.StorageService;
import com.instagram.service.UserService;

public class LikeServiceImpl implements LikeService{
    
    private UserService userService;
    private StorageService storageService;

    public LikeServiceImpl(UserService userService, StorageService storageService)
    {
        this.userService = userService; 
        this.storageService = storageService;
    }

    @Override
    public void like(Like like) 
    {

        boolean isUploaderExist = false;
        boolean isLikerExist = false;
        User user = null;
        Post post = null;

        for(Map.Entry<Integer, User> entry : storageService.get())
        {
            user = entry.getValue();
            if(user.getUserName().equals(like.getPostUserName()))
            {
                isUploaderExist = true;
                post = user.getPost(like.getPostId());
                break;
            }
        }

        if(isUploaderExist && post != null)
        {
            for(Map.Entry<Integer, User> entry1 : storageService.get())
            {
                user = entry1.getValue();
                if(user.getUserName().equals(like.getUserName()))
                {
                    isLikerExist = true;
                    break;
                }
            }
        }
        else
        {
            System.out.println("The specified post does not exist or the uploader's username is invalid.");
        }

        if (isLikerExist && userService.getUserSession(like.getUserName())) 
        {
            post.setLike(like);    
            System.out.println(like.getUserName() + " successfully liked the post by " + like.getPostUserName() + ".\nPost ID: " + like.getPostId());        
        }
        else{
            System.out.println("The user attempting to like the post does not exist or is not logged in.");

        }
    }



    @Override    
    public void dislike(Like like) 
    {

        if(like==null)
        {
            System.out.println("Cannot dislike the post as the like data is invalid.");
            return;
        }
        if(userService.getUserSession(like.getUserName()))
        {
            Integer postId = like.getPostId();
            String userName = like.getPostUserName();

            if(storageService.get()!=null)
            {
                for (Map.Entry<Integer, User> e : storageService.get()) 
                {
                    User user = e.getValue();

                    if(user.getUserName().equals(userName))
                    {
                        Map<Integer, Post> postStorage = user.getPost();
                        if(postStorage!=null)
                        {
                            if(postStorage.containsKey(postId)){
                                Post p = postStorage.get(postId);
                                Set<Like> liked = p.getLikes();
                                if (liked.contains(like)) 
                                {
                                    liked.remove(like);
                                    System.out.println("The like was successfully removed from post ID " + like.getPostId() + ".");
                                    return;
                                }
                                else{
                                    System.out.println("The specified like does not exist on the post.");
                                }
                            }
                        }
                        else
                        {
                            System.out.println("The specified post with ID " + like.getPostId() + " was not found for the user " + like.getPostUserName() + ".");
                        }
                    }
                        
                }
            }
        }
        else
        {
            System.out.println("Please log in before attempting to dislike a post.");
        }
        
    }
    
    @Override    
    public Set<Like> get(Post post) 
    {
       return post.getLikes();
    }
    
}