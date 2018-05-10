package com.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class User implements Serializable{
    private final int N = 10; //количество капчей
    private boolean tryToReg;
    private int myHP;
    private int opponentHP;
    private int curCaptcha;
    private boolean loged;
    private boolean active;
    private String loginEr;
    private String errorMsg;
    public final String NONE = "none";
    private String hisCard; //выбранная своя карта
    private String myCard; //выбранная карта противника
    private String name;
    private String password;
    private int hod; //номер хода
    //private int userGameXP;
    private ArrayList<String[]> myCards; //мои карты
    private ArrayList<String[]> cards; //карты противника
    private final List<String[]> captcha;
    private String captchaImg;
    private String myCaptcha;
    
    private String oldPass;
    private String newName;
    private String newPass;
    private String newPass2;


    public User(){
    	myHP=100;
    	opponentHP=100;
    	active = false;
    	tryToReg=false;
    	loged = false;
        captcha = Arrays.asList(new String[]{"cap0","brr"}, new String[]{"cap1","pip"}, new String[]{"cap2","lab"}, new String[]{"cap3","hey"}, new String[]{"cap4","wow"}, new String[]{"cap5","sos"}, new String[]{"cap6","piu"}, new String[]{"cap7","viu"}, new String[]{"cap8","pop"}, new String[]{"cap9","trr"});
        randomCap(N);
        clearErrorMsg();
        hisCard=NONE;
        myCard=NONE;
        cards = new ArrayList<>();
        myCards = new ArrayList<>();
        cards.add(new String[] {"pika.jpg","100"});
        cards.add(new String[] {"metapod.jpg","100"});
    }

    private void randomCap(int i) {
        Random r = new Random();
        curCaptcha=r.nextInt(i);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = "pipka"+password.hashCode();
    }
    
    
    public String getHisCard() {
        return hisCard;
    }

    public void setHisCard(String hisCard) {
    	if(hisCard.length()>1) {
            this.hisCard = hisCard.substring(1,2);
       	}else {
       		this.hisCard = hisCard;
       	}
    }

    public String getMyCard() {
        return myCard;
    }

    public void setMyCard(String myCard) {
    	if(myCard.length()>1) {
         this.myCard = myCard.substring(1,2);
    	}else {
    		this.myCard = myCard;
    	}
    }

    public ArrayList<String[]> getCards() {
        return cards;
    }

    public void setCards(ArrayList<String[]> cards) {
        this.cards = cards;
    }

    public int getHod() {
        return hod;
    }

    public void setHod(int hod) {
        this.hod = hod;
    }

    public void decHod() {
        hod--;
    }

    public void resetHod() {
        hod=3;
        resetAfterHod();
        clearErrorMsg();
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
    public void clearErrorMsg(){
        this.errorMsg = "";
    }

    public void resetAfterHod() {
        this.hisCard = this.NONE;
        this.myCard = this.NONE;
    }

    public String getLoginEr() {
        return loginEr;
    }

    public void setLoginEr(String loginEr) {
        this.loginEr = loginEr;
    }
    public void resetLoginEr(){
        this.loginEr="";
    }

    public boolean isLoged() {
        return loged;
    }

    public void setLoged(boolean loged) {
        this.loged = loged;
    }



    public void clearOnExit() {
        //myCards.clear();
        //cards.clear();
        randomCap(N);
        loged = false;
        loginEr="";
        errorMsg="";
        hisCard="";
        myCard="";
        name="";
        password="";
    }

    public void clearGameState(){
            //myCards.clear();
            //cards.clear();
            loginEr="";
            errorMsg="";
            hisCard="";
            myCard="";
            myHP=100;
        	opponentHP=100;
    }


    public List<String[]> getCaptcha() {
        return captcha;
    }

    private int getCurCaptcha() {
        return curCaptcha;
    }
    public String getCaptchaImg(){
        captchaImg =  captcha.get(curCaptcha)[0]+".png";
        return captchaImg;
    }

    public boolean checkCaptcha(){
        return captcha.get(curCaptcha)[1].equals(myCaptcha);
    }

    public String getMyCaptcha() {
        return myCaptcha;
    }

    public void setMyCaptcha(String myCaptcha) {
        this.myCaptcha = myCaptcha;
    }

	public boolean isTryToReg() {
		return tryToReg;
	}

	public void setTryToReg(boolean tryToReg) {
		this.tryToReg = tryToReg;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	public int getMyHP() {
		return myHP;
	}

	public void setMyHP(int myHP) {
		this.myHP = myHP;
	}

	public int getOpponentHP() {
		return opponentHP;
	}

	public void setOpponentHP(int opponentHP) {
		this.opponentHP = opponentHP;
	}

	public ArrayList<String[]> getMyCards() {
		return myCards;
	}

	public void setMyCards(ArrayList<String[]> myCards) {
		this.myCards = myCards;
	}

	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	public String getNewPass() {
		return newPass;
	}

	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}

	public String getNewPass2() {
		return newPass2;
	}

	public void setNewPass2(String newPass2) {
		this.newPass2 = newPass2;
	}

	public String getOldPass() {
		return oldPass;
	}

	public void setOldPass(String oldPass) {
		this.oldPass = "pipka"+oldPass.hashCode();
	}

}
