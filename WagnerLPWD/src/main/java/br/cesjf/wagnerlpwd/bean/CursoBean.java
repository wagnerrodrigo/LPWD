/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.wagnerlpwd.bean;

import br.cesjf.wagnerlpwd.dao.CursoDAO;
import br.cesjf.wagnerlpwd.model.Curso;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author wagner
 */
@ManagedBean(name = "cursoBean")
@ViewScoped
public class CursoBean {
    Curso curso = new Curso();
  
    List<Curso> cursos;

    public CursoBean() {
        cursos = new CursoDAO().buscarTodas();
        curso = new Curso();
    }
    
   public void persistir(ActionEvent actionEvent)
    {
        new CursoDAO().persistir(curso);
        cursos = new CursoDAO().buscarTodas();
        curso = new Curso();
    }
   
    public void excluir(ActionEvent actionEvent)
    {
        new CursoDAO().remover(curso);
        cursos = new CursoDAO().buscarTodas();
        curso = new Curso();
    }
   
    public Curso getCurso()
    {
        return curso;
    }
   
    public void setCurso(Curso curso)
    {
        this.curso = curso;
    }
   
    public List getCursos()
    {
        return cursos;
    }
   
    public void setCursos(List cursos) {
        this.cursos = cursos;
    }
    
}
