/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.wagnerlpwd.dao;
import br.cesjf.wagnerlpwd.util.PersistenceUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
/**
 *
 * @author alunoces
 */
public class QuestaoDAO {
    public static QuestaoDAO questaoDao;
    
    public static QuestaoDAO getInstace(){
        if(questaoDao == null){
            questaoDao = new QuestaoDAO();
        }
        return questaoDao;
    }
    
    
    public Questao buscar()
}
