package com.example.amar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.amar.model.User;
import com.example.amar.repository.UserRepo;

@Service
public class UserService {
    
    @Autowired
    UserRepo ur;
    
    @SuppressWarnings("null")
    public User create(User uu)
    {
        return ur.save(uu);
    }

    public List <User> getAlldetails()
    {
        return ur.findAll();
    }
    public User getUserById(int id)
    {
        return ur.findById(id).orElse(null);
    }

    @SuppressWarnings("null")
    public boolean updateDetails(int id,User u)
        {
            if(this.getUserById(id)==null)
            {
                return false;
            }
            try{
                ur.save(u);
            }
            catch(Exception e)
            {
                return false;
            }
            return true;
        }

        public boolean deleteUser(int id)
        {
            if(this.getUserById(id) == null)
            {
                return false;
            }
            ur.deleteById(id);
            return true;
        }
    }
