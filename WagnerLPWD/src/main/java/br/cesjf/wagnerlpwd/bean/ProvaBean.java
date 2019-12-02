/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.wagnerlpwd.bean;

import br.cesjf.wagnerlpwd.dao.ProvaDao;
import br.cesjf.wagnerlpwd.model.Prova;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author wagner
 */
@ManagedBean(name = "provaBean")
@ViewScoped
public class ProvaBean {
    Prova prova = new Prova();
 
     List provas = new ArrayList();
    
     public ProvaBean(){
         provas = new ProvaDao().buscarTodasProva();
         prova = new Prova();
     }
     
     public void persistir(ActionEvent actionEvent){
         new ProvaDao().persistir(prova);
         provas = new ProvaDao().buscarTodasProva();
         prova = new Prova();
     }
     
      public void excluir(ActionEvent actionEvent)
    {
        provas = new ProvaDao().buscarTodasProva();
        new ProvaDao().remover(prova);
        prova = new Prova();
    } 

    public Prova getProva() {
        return prova;
    }

    public void setProva(Prova prova) {
        this.prova = prova;
    }

    public List getProvas() {
        return provas;
    }

    public void setProvas(List provas) {
        this.provas = provas;
    }
      
      
}
