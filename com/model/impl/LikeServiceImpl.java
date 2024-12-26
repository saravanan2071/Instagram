package com.model.impl;

import java.util.*;
import com.model.interfaces.LikeService;
import com.model.interfaces.UserService;
import com.model.models.Like;
import com.model.models.Post;
import com.model.models.User;
import com.storage.StorageImpl;

public class LikeServiceImpl implements LikeService{

    // to get the usersession
    UserService us =  new UserServiceImpl();

    public void like(Like like) 
    {

        if(us.getUserSession(like.getUserName()))
        {

            if(like == null || like.getPostUserName() == null || like.getPostId() == null)
            {
                System.out.println("Invalid Like data");
                return;
            }
        
            Integer pid = like.getPostId();
            String pu = like.getPostUserName();

            if(StorageImpl.users!=null)
            {
                // iterating the users map for find the user uing PostId
                for (Map.Entry<Integer, User> e : StorageImpl.users.entrySet()) 
                {
                    User user = e.getValue();

                    if(user.getUserName().equals(pu))
                    {
                        // get the post of the corresponding user's post
                        Map<Integer, Post> m = user.getPost();
                        if(m!=null)
                        {
                            if(m.containsKey(pid)){
                                Post p = m.get(pid);
                                p.setLike(like);
                                System.out.println(like.getUserName() + " likes the post of " + like.getPostUserName() +" \n Post : " + like.getPostId());
                                return; // terminate the method when the job done
                            }
                        }
                        else
                        {
                            System.out.println(like.getPostId() + " Not found");
                        }
                    }
                    
                }
            }
        }
    }


    
    public void dislike(Like like) 
    {

        if(like==null)
        {
            System.out.println("cannot like this post");
            return;
        }
        if(us.getUserSession(like.getUserName()))
        {
            Integer pid = like.getPostId();
            String pu = like.getPostUserName();

            if(StorageImpl.users!=null)
            {
                for (Map.Entry<Integer, User> e : StorageImpl.users.entrySet()) 
                {
                    User user = e.getValue();

                    if(user.getUserName().equals(pu))
                    {
                        Map<Integer, Post> m = user.getPost();
                        if(m!=null)
                        {
                            if(m.containsKey(pid)){
                                Post p = m.get(pid);
                                Set<Like> liked = p.getLikes();
                                if (liked.contains(like)) 
                                {
                                    liked.remove(like);
                                    return;
                                }
                            }
                        }
                        else
                        {
                            System.out.println(like.getPostId() + " Not found");
                        }
                    }
                        
                }
            }
        }
        else
        {
            System.out.println("Try to like the post after login...");
        }
        
    }
    
    public void get(Post post) 
    {
       System.out.println("UserName : "+ post.getUserName()  +", PostID: "+ post.getPostId() + ", Likes : " + post.getLikesCount() + "\n" + post.getLikes());
    }
	
}