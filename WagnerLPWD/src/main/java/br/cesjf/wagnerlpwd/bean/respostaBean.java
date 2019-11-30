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
import javax.faces.event.ActionEvent;

/**
 *
 * @author wagner
 */
public class respostaBean {
    Resposta resposta = new Resposta();
    
    List respostas = new ArrayList();
    
    public void persistir(ActionEvent actionEvent){
        new RespostaDAO().persistir(resposta);
//        respostas = new RespostaDAO().bu(resposta);
        resposta = new Resposta();
        
    }
}
