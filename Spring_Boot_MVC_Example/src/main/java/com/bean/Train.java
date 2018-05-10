package com.bean;

import org.springframework.stereotype.Component;

import com.entity.Trainers;
import com.service.TrainersService;

import java.io.Serializable;
import java.util.ArrayList;

@Component
public class Train implements Serializable{
	
	private ArrayList<Trainers> trainlist;
	private int size;
	public Train(TrainersService trainersService) {
		setTrainlist(trainersService);
	}
	
	void setTrainlist(TrainersService trainersService) {
		this.trainlist = trainersService.getAllTrainersRating();
		this.size=trainlist.size();
	}
	
	public ArrayList<Trainers> getTrainlist() {
		return this.trainlist;
	}

	public int getSize() {
		return size;
	}
}