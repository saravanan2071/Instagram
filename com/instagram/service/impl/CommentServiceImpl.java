package com.instagram.service.impl;

import java.util.Map;

import com.instagram.model.Comment;
import com.instagram.model.Post;
import com.instagram.model.User;
import com.instagram.service.CommentService;
import com.instagram.service.StorageService;
import com.instagram.service.UserService;

public class CommentServiceImpl implements CommentService{

    private UserService userService;
    private StorageService storageService;

    public CommentServiceImpl(UserService userService, StorageService storageService)
    {
        this.userService = userService;
        this.storageService = storageService;
    }
    
    @Override    
    public void add(Comment comment)
    {
        if(comment == null)
        {
            System.out.println("Invalid comment. Please provide a valid comment.");
            return;
        }

        if(isUserExist(comment.getpostedUserName()) && isUserExist(comment.getCmntUserName())
         && getPost(comment.getpostedUserName(), comment.getPostId()) != null)
        {
            if(userService.getUserSession(comment.getCmntUserName()))
            {
                Post post = getPost(comment.getpostedUserName(), comment.getPostId());
                post.setComments(comment.getCommentId(), comment);
                System.out.println(comment.getCmntUserName() + " commented: \"" + comment.getComment() + "\" on the post by " 
                + comment.getpostedUserName() + " (Post ID: " + comment.getPostId() + ").");
            }
        }
        else
        {
            System.out.println("Failed to add the comment. Possible reasons: the user or post does not exist, or the user is not logged in.");
        }
        
    }


    @Override    
    public void delete(Comment comment) 
    {
        if(comment==null)
        {
            System.out.println("Invalid comment. Unable to proceed with deletion.");
            return;
        }

        if (userService.getUserSession(comment.getCmntUserName())) 
        {
            for(Map.Entry<Integer, User> entry : storageService.get())
            {
                User user = entry.getValue();
                if(comment.getpostedUserName().equals(user.getUserName()))
                {
                    Post post = user.getPost(comment.getPostId());
                    Map<Integer,Comment> commentStorage = post.getComments();
                    commentStorage.remove(comment.getCommentId());
                    System.out.println("Comment ID " + comment.getCommentId() + " by " + comment.getCmntUserName() 
                    + " has been successfully deleted from the post (Post ID: " + comment.getPostId() + ").");
                    break;
                }
            }

        }
        else{
            System.out.println(comment.getCmntUserName() + ", you need to log in to delete this comment.");
        }

    }

    @Override    
    public void get(Post post)
    {
       System.out.println(post.getComments());
    }

    
    // to get the post using the username and postID    
    public Post getPost(final String userName, final Integer postId)
    {
        Post post = null;
        for(Map.Entry<Integer, User> entry : storageService.get())
        { 
            User user = entry.getValue();
            if(userName.equals(user.getUserName()))
            {
                post = user.getPost(postId);
            }
        }
        return post;

    }


    // for check the existence of an user
    public boolean isUserExist(final String userName)
    {
        boolean isExist = false;
        for(Map.Entry<Integer, User> entry : storageService.get())
        { 
            User user = entry.getValue();
            if(userName.equals(user.getUserName()))
            {
                isExist = true;
            }
        }

        return isExist;
    }
	
}