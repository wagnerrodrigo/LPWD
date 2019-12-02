/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.wagnerlpwd.bean;

import br.cesjf.wagnerlpwd.dao.CursoDAO;
import br.cesjf.wagnerlpwd.dao.UsuarioDAO;
import br.cesjf.wagnerlpwd.model.Curso;
import br.cesjf.wagnerlpwd.model.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author wagner
 */
public class UsuarioBean {
     Usuario usuario = new Usuario();
   
    List usuarios = new ArrayList();
   
    private List<Curso> cursos;
    
    public UsuarioBean(){
        usuarios = new UsuarioDAO().buscarTodas();
        usuario = new Usuario();
        cursos = new CursoDAO().buscarTodas();
    }
     public void Record(ActionEvent actionEvent)
    {
        new UsuarioDAO().persistir(usuario);
        usuarios = new UsuarioDAO().buscarTodas();
        usuario = new Usuario();
    }
   
    public void Exclude(ActionEvent actionEvent)
    {
        new UsuarioDAO().remover(usuario);
        usuarios = new UsuarioDAO().buscarTodas();
        usuario = new Usuario();
    }
   
    public Usuario getUsuario()
    {
        return usuario;
    }
   
    public void setUsuario(Usuario usuario)
    {
        this.usuario = usuario;
    }
   
    public List getUsuarios()
    {
        return usuarios;
    }
   
    public void setUsuarios(List usuarios) {
        this.usuarios = usuarios;
    }

    public void login() throws IOException {
        Usuario usuarioLogado = new UsuarioDAO().getLogin(this.usuario);
       
        if (usuarioLogado != null)
        {
            HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            HttpServletResponse response = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
            session.setAttribute("usuario", usuarioLogado);
           
            response.sendRedirect("index.xhtml");
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(
                    null,new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Login ou senha incorretos!",
                    "Favor inserir usuário e senha novamente!"));
        }
    }
   
    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

}
