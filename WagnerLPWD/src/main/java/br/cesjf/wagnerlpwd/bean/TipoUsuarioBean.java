/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.wagnerlpwd.bean;


import br.cesjf.wagnerlpwd.dao.TipoUsuarioDAO;
import br.cesjf.wagnerlpwd.model.TipoUsuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author alunoces
 */
@ManagedBean(name = "TipoUsuarioBean")
@ViewScoped
public class TipoUsuarioBean {
   
    TipoUsuario tipoUsuario = new TipoUsuario();
  
    private List<TipoUsuario> tipoUsuarios;

    public TipoUsuarioBean() {
        tipoUsuarios = new TipoUsuarioDAO().buscarTodas();
        tipoUsuario = new TipoUsuario();
        tipoUsuarios = new TipoUsuarioDAO().buscarTodas();
    }
   
    public void Record(ActionEvent actionEvent)
    {
        new TipoUsuarioDAO().persistir(tipoUsuario);
        tipoUsuarios = new TipoUsuarioDAO().buscarTodas();
        tipoUsuario = new TipoUsuario();
    }
   
    public void Exclude(ActionEvent actionEvent)
    {
        new TipoUsuarioDAO().remover(tipoUsuario);
        tipoUsuarios = new TipoUsuarioDAO().buscarTodas();
        tipoUsuario = new TipoUsuario();
    }
   
    public TipoUsuario getTipoUsuario()
    {
        return tipoUsuario;
    }
   
    public void setTipoUsuario(TipoUsuario tipoUsuario)
    {
        this.tipoUsuario = tipoUsuario;
    }
   
    public List getTipoUsuarios()
    {
        return tipoUsuarios;
    }
   
    public void setTipoUsuarios(List tipoUsuarios) {
        this.tipoUsuarios = tipoUsuarios;
    }
}