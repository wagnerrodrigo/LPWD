/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.wagnerlpwd.bean;

import br.cesjf.wagnerlpwd.dao.QuestaoDAO;
import br.cesjf.wagnerlpwd.model.Questao;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author wagner
 */
@ManagedBean
@ViewScoped
public class questoesBean {
    Questao questao = new Questao();
    
    List questoes = new ArrayList();

        
    public questoesBean() {
        questoes = new QuestaoDAO().buscarTodas();
        questao = new Questao();
    }
    
    //Métodos dos botões 
    public void persistir(ActionEvent actionEvent) {
        new QuestaoDAO().persistir(questao);
        questoes = new QuestaoDAO().buscarTodas();
        questao = new Questao();
    }
    public void excluir(ActionEvent actionEvent){
        new QuestaoDAO().remover(questao);
        questoes = new QuestaoDAO().buscarTodas();
        questao = new Questao();
    }
            
    //getters and setters

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    public List getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List questoes) {
        this.questoes = questoes;
    }
    
            
}
