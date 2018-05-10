package com.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="pokemons")
public class Pokemons implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="name")
    private String name;
    @Column(name="hp")
    private int hp;
    @Column(name="damage")
    private int damage;
    @Column(name="skill")
    private int skill;
    @Column(name="param")
    private int param;
    @Column(name="storage")
    private int storage;

    public Pokemons(){}

    public Pokemons(String name,int hp,int damage,int skill,int param, int storage){
        this.name=name;
        this.hp=hp;
        this.damage=damage;
        this.param=param;
        this.skill=skill;
        this.storage=storage;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id=id;}

    public String getName() {return name;}
    public void setName(String name) {this.name=name;}

    public int getHp() {return hp;}
    public void setHp(int hp) {this.hp=hp;}

    public int getDamage() {return damage;}
    public void setDamage(int damage) {this.damage=damage;}

    public int getSkill() {return skill;}
    public void setSkill(int skill) {this.skill=skill;}

    public int getParam() {return param;}
    public void setParam(int param) {this.param=param;}

    public int getStorage() {return storage;}
    public void setStorage(int storage) {this.storage=storage;}

}
