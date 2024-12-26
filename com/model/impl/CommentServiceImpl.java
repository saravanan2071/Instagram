package com.model.impl;

import java.util.*;

import com.model.interfaces.CommentService;
import com.model.interfaces.UserService;
import com.model.models.Comment;
import com.model.models.Post;
import com.model.models.User;
import com.storage.StorageImpl;

public class CommentServiceImpl implements CommentService{

    // to get the usersession
    private UserService us = new UserServiceImpl();
    
    public void add(Comment comment)
    {

        // to check the commented user and the posted user are exist in the DB or not
        boolean existU1 = false;
        boolean existU2 = false;

        if(comment==null)
        {
            System.out.println("Invalid Comment");
            return;
        }

        // iterating the DB to find the first user
        for(Map.Entry<Integer, User> e : StorageImpl.users.entrySet())
        {
            User user1 = e.getValue();
            if(user1.getUserName().equals(comment.getCmntUserName()))
            {
                if(us.getUserSession(user1.getUserName()))
                {
                    existU1 = true;
                    break;
                }
                        
            }
        }
        if(existU1)
        {
            // iterating the DB to find the second user if only the first user exist
            Map<Integer, Post> m =new HashMap<>();
            for(Map.Entry<Integer, User> e1 : StorageImpl.users.entrySet())
            {
                User user2 = e1.getValue();
                if(user2.getUserName().equals(comment.getpostedUserName()))
                {
                    existU2 = true;
                    m = user2.getPost();
                }
            }
            if (existU2) 
            {
                // check the Post is exist or not only when the two users are exist.
                if (m.containsKey(comment.getPostId()))
                {
                    Post post = m.get(comment.getPostId());
                    post.setComments(comment.getCommentId(), comment);   
                    System.out.println(comment.getCmntUserName() +  " comment on "+ comment.getPostId() + "\n " + comment.getComment()); 
                }   
                else{
                    System.out.println("The specified post does not exist.");
                } 
                }
                else{
                    System.out.println("The user who owns the post does not exist.");
                }
            }
            else{
                System.out.println("The specified user does not exist");
            }
    }


    public void delete(Comment comment) 
    {
        boolean existU1 = false;
        boolean existU2 = false;
        if(comment==null)
        {
            System.out.println("Invalid Comment");
            return;
        }

        for(Map.Entry<Integer, User> e : StorageImpl.users.entrySet())
        {
            User user1 = e.getValue();
            if(user1.getUserName().equals(comment.getCmntUserName()))
            {
                if(us.getUserSession(user1.getUserName()))
                {
                    existU1 = true;
                    break;
                }
                        
            }
        }
        if(existU1)
        {
            Map<Integer, Post> m =new HashMap<>();
            for(Map.Entry<Integer, User> e1 : StorageImpl.users.entrySet())
            {
                User user2 = e1.getValue();
                if(user2.getUserName().equals(comment.getpostedUserName()))
                {
                    existU2 = true;
                    m = user2.getPost();
                }
            }
            if (existU2) 
            {
                if (m.containsKey(comment.getPostId()))
                {
                    Post post = m.get(comment.getPostId());
                    Map<Integer, Comment> mc = post.getComments();

                    if (mc.containsKey(comment.getCommentId())) 
                    {
                        mc.remove(comment.getCommentId());
                        System.out.println("comment deleted");
                    }
                }   
                else{
                    System.out.println("The specified post does not exist.");
                } 
                }
                else{
                    System.out.println("The user who owns the post does not exist.");
                }
            }
            else{
                System.out.println("The specified user does not exist");
            }

    }

    public void get(Post post)
    {
       System.out.println(post.getComments());
    }
	
}