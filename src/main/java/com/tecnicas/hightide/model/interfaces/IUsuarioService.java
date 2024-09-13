/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tecnicas.hightide.model.interfaces;

import com.tecnicas.hightide.model.models.User;

/**
 *
 * @author Victor Moreno
 */
public interface IUsuarioService {
   public User signUp(String nome, String login, String senha);
   public Boolean signIn(String login, String senha);
   public User editUser(String nome, String login, String senha);
   public Boolean deleteUser(String id);
   public User userById(String id);
}
