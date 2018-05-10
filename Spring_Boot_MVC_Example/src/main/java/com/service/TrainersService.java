package com.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Trainers;
import com.rep.TrainersRep;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainersService{
    @Autowired
    private TrainersRep trainersRep;

    public List<Trainers> getAllTrainers(){
        List<Trainers> trainers = new ArrayList<>();
        trainersRep.findAll().forEach(trainers::add);
        return trainers;
    }

    public ArrayList<Trainers> getAllTrainersRating(){
        ArrayList<Trainers> trainers = new ArrayList<>();
        trainersRep.findByOrderByExpDesc().forEach(trainers::add);
        return trainers;
    }

    public Trainers getTrainersByNameAndPass(String name, String pass){
        return trainersRep.findByNameAndPass(name, pass);
    }

    public Trainers getTrainers(int id){
        return trainersRep.findOne(id);
    }

    public Trainers getTrainersByName(String name){
        return trainersRep.findByName(name);
    }

    public void addTrainers(Trainers trainers){
        trainersRep.save(trainers);
    }

    public void updateTrainers(Trainers trainers){
        trainersRep.save(trainers);
    }


    public void deleteTrainers(int id){
        trainersRep.delete(id);
    }
}
