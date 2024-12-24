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

        int id = post.getPostId();
        Integer key = null;

        // fetching the userID with the help of userName to store the post to a corresponding User.
        for(Map.Entry<Integer, User> e : db.get().entrySet()){

            user = e.getValue();

            if(post.getUserName().equals(user.getUserName())){
                key = e.getKey();
                break;
            }
        }

        User user1 = Storage.users.get(key);


        // if getUsersession is false then it means the user is not log in currently, so the user cannot use this method
        if(post != null && key != null && us.getUserSession(user1.getUserName()) == true && user1!= null)
        {
            user1.setPost(id, post);
            System.out.println(user1.getPost(id));
        }

        else
        {
           System.out.println("Unidentified user...");
        }
    }
    
    public boolean delete(int userId, int postId) {
        return false;
    }
    
    public boolean delete(int userId) {
        return false;
    }

    public Post get(int userId, int postId) {
        return null;
    }

    public void get(String userName) 
    {

    }
	
}