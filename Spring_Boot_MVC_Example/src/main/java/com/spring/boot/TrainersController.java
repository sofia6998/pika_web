package com.spring.boot;

import org.springframework.web.bind.annotation.*;
import com.entity.Trainers;
import com.service.TrainersService;


import java.util.List;


public class TrainersController {
    

    //authorize
    static boolean authorize(TrainersService trainersService, String name, String pass){
        return trainersService.getTrainersByNameAndPass(name, pass)==null?false:true;
    }
    
    
    //register
    static String register(TrainersService trainersService, String name, String pass){
        Trainers trainer=trainersService.getTrainersByName(name);
        if (trainer==null){
            try{
                trainersService.addTrainers(new Trainers(name,pass));
                return "1"; //ура!!!!
            }
            catch (Exception e){return "-1";} //что-то пошло не так
        }
        else{
            return "0"; // пользователь уже существует
        }
    }
    
    
    static void changeTrainersRating(TrainersService trainersService, String name, int rating){
        Trainers trainer=trainersService.getTrainersByName(name);
        int prev = trainer.getExp();
        rating = rating + prev;
        trainer.setExp(rating);
        try {
            trainersService.updateTrainers(trainer);
        }catch (Exception e){System.out.println("Что-то пошло не так");}
    }
    

    //trainers/name/{name}")
    public Trainers getTrainersByName(TrainersService trainersService, @PathVariable String name){
        return trainersService.getTrainersByName(name);
    }

    //trainers")
    public List<Trainers> getAllTrainers(TrainersService trainersService){
        return trainersService.getAllTrainers();
    }

    //trainers/rating")
    public List<Trainers> getAllTrainersRating(TrainersService trainersService){
        return trainersService.getAllTrainersRating();
    }

    //trainers/namepass/{name}/{pass}")
    public Trainers getTrainersByNameAndPass(TrainersService trainersService, @PathVariable String name, @PathVariable String pass){
        return trainersService.getTrainersByNameAndPass(name, pass);
    }

    //trainers/id/{id}")
    public Trainers getTrainers(TrainersService trainersService, @PathVariable int id){
        return trainersService.getTrainers(id);
    }

    //@RequestMapping(method = RequestMethod.POST, value = "/trainers")
    public void addTrainers(TrainersService trainersService, @RequestBody Trainers trainers){
        trainersService.addTrainers(trainers);
    }

  //@RequestMapping(method = RequestMethod.PUT, value = "/trainers/{id}")
    public void updateTrainers(TrainersService trainersService, @RequestBody Trainers trainers){
        trainersService.updateTrainers(trainers);
    }


    //@RequestMapping(method = RequestMethod.DELETE, value = "trainers/{id}")
    public Trainers deleteTrainers(TrainersService trainersService, @PathVariable int id){
        return trainersService.getTrainers(id);
    }

}
