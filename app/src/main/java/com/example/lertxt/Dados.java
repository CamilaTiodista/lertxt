package com.example.lertxt;

import java.io.Serializable;

public class Dados implements Serializable {
    private Integer id;
    private String dado1, dado2, dado3;

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getDado1() {
        return dado1;
    }

    public void setDado1(String dado1) {
        this.dado1 = dado1;
    }

    public String getDado2() {
        return dado2;
    }

    public void setDado2(String dado2) {
        this.dado2 = dado2;
    }

    public String getDado3() {
        return dado3;
    }

    public void setDado3(String dado3) {
        this.dado3 = dado3;
    }

}
