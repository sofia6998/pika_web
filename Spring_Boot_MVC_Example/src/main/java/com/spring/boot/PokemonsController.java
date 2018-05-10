package com.spring.boot;

import com.bean.User;
import com.entity.Pokemons;
import com.service.PokemonsService;

import java.util.ArrayList;
import java.util.List;

public class PokemonsController {
    
    static ArrayList<String[]> setMyCards(PokemonsService pokemonsService){
        int number = 1 + (int) (Math.random()*2);
        List<Pokemons> pokemons = pokemonsService.getAllPokemonsInStorage(number);
        ArrayList<String[]> myCards = new ArrayList<>();
        for (int i=0; i<15; i++){
            int randomcard = (int) (Math.random()*10);
            Pokemons poke = pokemons.get(randomcard);
            String arr[]=new String[5];
            arr[0]=poke.getName()+".png";
            arr[1]=String.valueOf(poke.getHp());
            arr[2]=String.valueOf(poke.getDamage());
            arr[3]=String.valueOf(poke.getSkill());
            arr[4]=String.valueOf(poke.getParam());
            myCards.add(arr);
            for (int j=0;j<5;j++){
                System.out.print(arr[j]);
            }
            System.out.println();
            
        }
        return myCards;
    }

    static ArrayList<String[]> setCards(PokemonsService pokemonsService){
        int number = 1 + (int) (Math.random()*2);
        List<Pokemons> pokemons = pokemonsService.getAllPokemonsInStorage(number);
        ArrayList<String[]> cards = new ArrayList<>();
        for (int i=0; i<15; i++){
            int randomcard = (int) (Math.random()*10);
            Pokemons poke = pokemons.get(randomcard);
            String arr[]=new String[5];
            arr[0]=poke.getName()+".png";
            arr[1]=String.valueOf(poke.getHp());
            arr[2]=String.valueOf(poke.getDamage());
            arr[3]=String.valueOf(poke.getSkill());
            arr[4]=String.valueOf(poke.getParam());
            cards.add(arr);
            for (int j=0;j<5;j++){
                System.out.print(arr[j]);
            }
            System.out.println();
        }
        return cards;   
    }
    
    static void makeMyHod(User user){
    	int myDamage = 0;
        ArrayList<String[]> myCards = user.getMyCards();
        ArrayList<String[]> cards = user.getCards();
        int myCard=Integer.parseInt(user.getMyCard());
        int hisCard=Integer.parseInt(user.getHisCard());
        myDamage = Integer.parseInt(myCards.get(myCard)[2]);
        int hisHp = Integer.parseInt(cards.get(hisCard)[1])-myDamage;
        
        switch (myCards.get(myCard)[3]) {
        case "2":
        	int param = 0;
            int chance = 0;
        	param = Integer.parseInt(myCards.get(myCard)[4]);
        	chance = 1+(int)(Math.random()*100);
        	if (chance<=param) {
        		myDamage = myDamage + Integer.parseInt(cards.get(hisCard)[1]);
        		hisHp = 0;
        	}
        	break;
        case "3":
        	param =0;
        	param = Integer.parseInt(myCards.get(myCard)[4]);
        	int reducedDamage = Integer.parseInt(cards.get(hisCard)[2])-param;
        	cards.get(hisCard)[2]=""+reducedDamage;
        	//System.out.println(reducedDamage);
        	//System.out.println(param);
        	break;
        case "4":
        	param =0;
        	param = Integer.parseInt(myCards.get(myCard)[4]);
            for (int i=4;i>=0;i--){
            	int newhp = Integer.parseInt(cards.get(i)[1])-param;
            	cards.get(i)[1]=""+newhp;
            	myDamage = myDamage + param;
            }
        	break;
        }
        
        cards.get(hisCard)[1]="" + hisHp;
        user.setOpponentHP(user.getOpponentHP()-myDamage);
        for (int i=4;i>=0;i--){
            if (Integer.parseInt(cards.get(i)[1])<=0) {
            	user.setOpponentHP(user.getOpponentHP()-Integer.parseInt(cards.get(i)[1]));
            	cards.remove(i);
            }
        }
        user.setCards(cards);
        //return user.getCards();
    }
    
    static void makeOpponentHod(User user){
    	int hisDamage = 0;
        ArrayList<String[]> myCards = user.getMyCards();
        ArrayList<String[]> cards = user.getCards();
        int myCard = (int) (Math.random()*4);
        int hisCard = (int) (Math.random()*4);
        user.setHisCard("1"+hisCard);
        user.setMyCard("1"+myCard);
        hisDamage = Integer.parseInt(cards.get(hisCard)[2]);
        int myHp = Integer.parseInt(myCards.get(myCard)[1])-hisDamage;
        
        switch (cards.get(hisCard)[3]) {
        case "2":
            int chance = 0;
        	int param = 0;
        	param = Integer.parseInt(cards.get(hisCard)[4]);
        	chance = 1+(int)(Math.random()*100);
        	if (chance<=param) {
        		hisDamage = hisDamage + Integer.parseInt(myCards.get(myCard)[1]);
        		myHp = 0;
        	}
        	break;
        case "3":
        	param =0;
        	param = Integer.parseInt(cards.get(hisCard)[4]);
        	int reducedDamage = Integer.parseInt(myCards.get(myCard)[2])-param;
        	cards.get(myCard)[2]=""+reducedDamage;
        	//System.out.println(reducedDamage);
        	//System.out.println(param);
        	break;
        case "4":
        	param =0;
        	param = Integer.parseInt(cards.get(hisCard)[4]);
            for (int i=4;i>=0;i--){
            	int newhp = Integer.parseInt(myCards.get(i)[1])-param;
            	myCards.get(i)[1]=""+newhp;
            	hisDamage = hisDamage + param;
            }
        	break;
        }
        
        myCards.get(myCard)[1]="" + myHp;
        user.setMyHP(user.getMyHP()-hisDamage);
        for (int i=4;i>=0;i--){
            if (Integer.parseInt(myCards.get(i)[1])<=0){
            	user.setMyHP(user.getMyHP()-Integer.parseInt(myCards.get(i)[1]));
            	myCards.remove(i);
            }
        }
        user.setMyCards(myCards);
    }

}
