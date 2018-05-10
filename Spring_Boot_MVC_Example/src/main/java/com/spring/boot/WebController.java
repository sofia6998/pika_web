package com.spring.boot;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;

        import com.entity.Trainers;
        import com.rep.TrainersRep;

@RestController
public class WebController {
    @Autowired
    TrainersRep repository;


    @RequestMapping("/findall")
    public String findAll(){
        String result = "";

        for(Trainers train : repository.findAll()){
            result += train.toString() + "<br>";
        }

        return result;
    }

    @RequestMapping("/findbyid")
    public String findById(@RequestParam("id") int id){
        String result = "";
        result = repository.findOne(id).toString();
        return result;
    }

}