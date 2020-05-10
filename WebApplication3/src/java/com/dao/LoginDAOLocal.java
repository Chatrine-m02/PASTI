/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

/**
 *
 * @author ITD
 */
import com.model.Login;
import javax.ejb.Local;

/**
 *
 * @author Vedang Rane
 */
@Local
public interface LoginDAOLocal {
    
      public boolean checkUser(String username, String password);
      
}
