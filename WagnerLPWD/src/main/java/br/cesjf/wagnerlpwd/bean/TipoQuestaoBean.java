/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.wagnerlpwd.bean;

import br.cesjf.wagnerlpwd.dao.CursoDAO;
import br.cesjf.wagnerlpwd.dao.TipoQuestaoDAO;
import br.cesjf.wagnerlpwd.model.Curso;
import br.cesjf.wagnerlpwd.model.TipoQuestao;
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
@ManagedBean(name = "TipoQuestaoBean")
@ViewScoped
public class TipoQuestaoBean {
   
    TipoQuestao tipoQuestao = new TipoQuestao();
   
    List tipoQuestaos = new ArrayList();
   
    private List<Curso> cursos;

    public TipoQuestaoBean() {
        tipoQuestaos = new TipoQuestaoDAO().buscarTodas();
        tipoQuestao = new TipoQuestao();
        cursos = new CursoDAO().buscarTodas();
    }
   
    public void Record(ActionEvent actionEvent)
    {
        new TipoQuestaoDAO().persistir(tipoQuestao);
        tipoQuestaos = new TipoQuestaoDAO().buscarTodas();
        tipoQuestao = new TipoQuestao();
    }
   
    public void Exclude(ActionEvent actionEvent)
    {
        new TipoQuestaoDAO().remover(tipoQuestao);
        tipoQuestaos = new TipoQuestaoDAO().buscarTodas();
        tipoQuestao = new TipoQuestao();
    }
   
    public TipoQuestao getTipoQuestao()
    {
        return tipoQuestao;
    }
   
    public void setTipoQuestao(TipoQuestao tipoQuestao)
    {
        this.tipoQuestao = tipoQuestao;
    }
   
    public List getTipoQuestaos()
    {
        return tipoQuestaos;
    }
   
    public void setTipoQuestaos(List tipoQuestaos) {
        this.tipoQuestaos = tipoQuestaos;
    }

   
    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
   
}