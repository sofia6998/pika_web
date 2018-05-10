package com.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.entity.Trainers;

import java.util.List;

@Repository
public interface TrainersRep extends JpaRepository<Trainers, Integer> {

    Trainers findByName(String name);

    List<Trainers> findByOrderByExpDesc();

    Trainers findByNameAndPass(String name, String pass);
}