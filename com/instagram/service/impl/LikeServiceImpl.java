package com.instagram.service.impl;

import java.util.Set;

import com.instagram.model.Like;
import com.instagram.model.Post;
import com.instagram.model.User;
import com.instagram.service.LikeService;
import com.instagram.service.StorageService;
import com.instagram.service.UserValidator;

public class LikeServiceImpl implements LikeService {
    
    private StorageService storageService;
    private UserValidator userValidator;

    public LikeServiceImpl(StorageService storageService, UserValidator userValidator) {

        this.storageService = storageService;
        this.userValidator = userValidator;

    }

    @Override
    public void like(final Like like) {

        // validate whether the post user and the liked user existence and check the liked user session
        if (userValidator.isUserExist(like.getUploaderUserID()) && userValidator.isUserExist(like.getLikerUserID())
             && userValidator.getUserSession(like.getLikerUserID())) {

            final User user = storageService.get(like.getUploaderUserID());

            if (user.getPost(like.getPostId()) != null) {

                final Post post = user.getPost(like.getPostId());
                post.setLike(like);
                System.out.println(like.getLikerUserID() + " liked the post by " + like.getUploaderUserID() + ".\nPost ID: " + like.getPostId());
            
            }

            else {

                System.out.println("The specified post does not exist or the uploader's userID is invalid.");
            
            }
        }

        else {

            System.out.println("unable to like this post, possible reason : the user does not exist either not log in..");
        
        }

    }



    @Override    
    public void dislike(final Like like)  {

        if (userValidator.getUserSession(like.getLikerUserID())) {

            final Post post = storageService.get(like.getUploaderUserID()).getPost(like.getPostId());
            post.getLikes().remove(like);
        
        }
        
        else {
            
            System.out.println("Please log in before attempting to dislike a post.");
        
        }
        
    }
    
    @Override    
    public Set<Like> get(final Post post)  {

       return post.getLikes();
    
    }
    
}