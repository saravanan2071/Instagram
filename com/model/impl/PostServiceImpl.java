package com.model.impl;

import java.util.Map;
import com.model.interfaces.*;
import com.model.models.*;
import com.storage.*;

public class PostServiceImpl implements PostService{

    private User user;
    private Storage db = new StorageImpl();
    private UserService us = new UserServiceImpl();
    
    public void post(Post post) {

        Integer id = post.getPostId();
        Integer key = null;

        // fetching the userID with the help of userName to store the post to a corresponding User.
        for(Map.Entry<Integer, User> e : StorageImpl.users.entrySet()){

            user = e.getValue();

            if(post.getUserName().equals(user.getUserName())){
                key = e.getKey();
                break;
            }
        }

        User user1 = StorageImpl.users.get(key);

        // if getUsersession is false then it means the user is not log in currently, so the user cannot use this method
        if(post != null && key != null && us.getUserSession(user1.getUserName()) == true && user1!= null)
        {
            user1.setPost(id, post);
            System.out.println(user1.getPost(id));
        }

        else
        {
           System.out.println("you are not login or unidentified user....");
        }
    }



    
    public void delete(String userName, Integer postId) {

        // if the does not login then he cannot have the access to delete
        if (us.getUserSession(userName)) 
        {
            Integer key = null;


            // fetching the UserId using user name
            for(Map.Entry<Integer, User> e : StorageImpl.users.entrySet())
            {
                User u1 = e.getValue();

                if(userName.equals(u1.getUserName()))
                {
                    key = e.getKey();
                }
            }   

            User u1 = db.get().get(key);

            if(u1.getPost().containsKey(postId))
            {
                u1.getPost().remove(postId);
            }

            else
            {
                System.out.println("there is no such post");
            }        
            
        }

    }




    
    public void delete(String userName) 
    {
        if (us.getUserSession(userName)) 
        {
            Integer key = null;
        
            for(Map.Entry<Integer, User> e : StorageImpl.users.entrySet())
            {
                User u1 = e.getValue();

                if(userName.equals(u1.getUserName()))
                {
                    key = e.getKey();
                }
            }   

            User u1 = db.get().get(key);

            if (!u1.getPost().isEmpty()) 
            {
                u1.getPost().clear();    
            }
            
        }    
    }

    // public Post get(String userName, int postId) {

    //     return null;
    // }

    public Map<Integer, Post> get(String userName) 
    {
        Integer key = null;
        
        for(Map.Entry<Integer, User> e : StorageImpl.users.entrySet())
        {
            User u1 = e.getValue();

            if(userName.equals(u1.getUserName()))
            {
                key = e.getKey();
            }
        }   

        User u1 = db.get().get(key);

        if(db.get().containsKey(key))
        {
            return u1.getPost();
        }

        else
        {
            return null;
        }

            
            
    }
	
}