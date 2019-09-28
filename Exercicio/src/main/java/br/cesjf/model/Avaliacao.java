/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.model;

/**
 *
 * @author alunoces
 */
public class Avaliacao {
    public int curso;
    public int instrutor;
    public int dia;
    public boolean b1;
    public boolean b2;
    public boolean b3;
    public boolean b4;
    public boolean b5;
    public boolean b6;

    public Avaliacao() {
    }

    public Avaliacao(int curso, int instrutor, int dia, boolean b1, boolean b2, boolean b3, boolean b4, boolean b5, boolean b6) {
        this.curso = curso;
        this.instrutor = instrutor;
        this.dia = dia;
        this.b1 = b1;
        this.b2 = b2;
        this.b3 = b3;
        this.b4 = b4;
        this.b5 = b5;
        this.b6 = b6;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public int getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(int instrutor) {
        this.instrutor = instrutor;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public boolean isB1() {
        return b1;
    }

    public void setB1(boolean b1) {
        this.b1 = b1;
    }

    public boolean isB2() {
        return b2;
    }

    public void setB2(boolean b2) {
        this.b2 = b2;
    }

    public boolean isB3() {
        return b3;
    }

    public void setB3(boolean b3) {
        this.b3 = b3;
    }

    public boolean isB4() {
        return b4;
    }

    public void setB4(boolean b4) {
        this.b4 = b4;
    }

    public boolean isB5() {
        return b5;
    }

    public void setB5(boolean b5) {
        this.b5 = b5;
    }

    public boolean isB6() {
        return b6;
    }

    public void setB6(boolean b6) {
        this.b6 = b6;
    }

    @Override
    public String toString() {
        return "Avaliacao{" + "curso=" + curso + 
               ", instrutor=" + instrutor +
               ", dia=" + dia +
               ", b1=" + b1 + 
               ", b2=" + b2 + 
               ", b3=" + b3 + 
               ", b4=" + b4 +
               ", b5=" + b5 + 
               ", b6=" + b6 +  '}';
    }
    
    
}
