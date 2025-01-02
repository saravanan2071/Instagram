package com.instagram.service.impl;

import java.util.Map;

import com.instagram.model.Comment;
import com.instagram.model.Post;
import com.instagram.service.CommentService;
import com.instagram.service.StorageService;
import com.instagram.service.UserValidator;

public class CommentServiceImpl implements CommentService {
    
    private StorageService storageService;
    private UserValidator userValidator;

    public CommentServiceImpl(StorageService storageService, UserValidator userValidator) {

        this.storageService = storageService;
        this.userValidator = userValidator;

    }
    
    @Override    
    public void add(final Comment comment) {

        if (comment == null) {

            System.out.println("Invalid comment. Please provide a valid comment.");
            return;
            
        }

        // validate the existence of both the posted user and commented user and the commented user login session
        if (userValidator.isUserExist(comment.getPostedUserID()) && userValidator.isUserExist(comment.getCmntUserID()) && userValidator.getUserSession(comment.getCmntUserID())){

            final Post post = storageService.get(comment.getPostedUserID()).getPost(comment.getPostId());

            if (post != null){

                post.setComments(comment.getCommentId(), comment);

                System.out.println(comment.getCmntUserID() + " commented: \"" + comment.getComment() + "\" on the post by " 
                                + comment.getPostedUserID() + " (Post ID: " + comment.getPostId() + ").");

            }

            else {

                System.out.println("The specified post does not exist");
            
            }
        }

        else {

            System.out.println("Failed to add the comment. Possible reasons: the user does not exist, or the user is not logged in.");
        
        }
        
    }


    @Override    
    public void delete(final Comment comment) {

        if (comment==null) {

            System.out.println("Invalid comment. Unable to proceed with deletion.");
            return;
        
        }

        if (userValidator.getUserSession(comment.getCmntUserID())) {

            // to get the comments of the post
            final Map<Integer, Comment> mapStorage = storageService.getUsers().get(comment.getPostedUserID()).getPost(comment.getPostId()).getComments();  
            
            mapStorage.remove(comment.getCommentId());
            
            System.out.println("Comment ID " + comment.getCommentId() + " by " + comment.getCmntUserID() 
                    + " has been successfully deleted from the post (Post ID: " + comment.getPostId() + ").");

        }

        else {

            System.out.println(comment.getCmntUserID() + ", you need to log in to delete this comment.");
        
        }

    }

    @Override    
    public Map<Integer, Comment> get(Post post) {
       
        return post.getComments();
    
    }
}