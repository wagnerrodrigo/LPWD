/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlte;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alunoces
 */
public class Servico {
      protected void service(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        
        HttpSession sessao = request.getSession(true);
        if(sessao.isNew()){
            sessao.get;
        }
        
    }
}