package com.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="trainers")
public class Trainers implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="pass")
    private String pass;
    @Column(name="exp")
    private int exp;

    public Trainers(){}

    public Trainers(String name, String pass){
        this.exp=0;
        this.name=name;
        this.pass=pass;
    }

    public int getId() {return id;}
    //public void setId(int id) {this.id=id;}

    public String getName() {return name;}
    public void setName(String name) {this.name=name;}

    public String getPass() {return pass;}
    public void setPass(String pass) {this.pass=pass;}

    public int getExp() {return exp;}
    public void setExp(int exp) {this.exp=exp;}

    @Override
    public String toString() {
        return String.format("Trainer[name='%s', id=%d, pass='%s', exp=%d]", name, id, pass, exp);
    }
}
