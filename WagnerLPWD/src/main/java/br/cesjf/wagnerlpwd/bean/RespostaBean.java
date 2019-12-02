/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.wagnerlpwd.bean;

import br.cesjf.wagnerlpwd.dao.RespostaDAO;
import br.cesjf.wagnerlpwd.model.Resposta;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author wagner
 */
@ManagedBean(name = "respostaBean")
@ViewScoped
public class RespostaBean {
    Resposta resposta = new Resposta();
    
    List respostas = new ArrayList();
    
     public RespostaBean() {
        respostas = new RespostaDAO().buscarTodas();
        resposta = new Resposta();
        respostas = new RespostaDAO().buscarTodas();
    }
     
    public void persistir(ActionEvent actionEvent){
        new RespostaDAO().persistir(resposta);
//        respostas = new RespostaDAO().bu(resposta);
        resposta = new Resposta();
        
    }
    public void excluir(ActionEvent actionEvent)
    {
        new RespostaDAO().remover(resposta);
        respostas = new RespostaDAO().buscarTodas();
        resposta = new Resposta();
    }
   
    public Resposta getResposta()
    {
        return resposta;
    }
   
    public void setResposta(Resposta resposta)
    {
        this.resposta = resposta;
    }
   
    public List getRespostas()
    {
        return respostas;
    }
   
    public void setRespostas(List respostas) {
        this.respostas = respostas;
    }
}
