package com.spring.boot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Train;
import com.bean.User;
import com.service.PokemonsService;
import com.service.TrainersService;

import static java.lang.Thread.sleep;


@RestController
@SessionAttributes("userJSP")
public class MainController {

	@Autowired
    private TrainersService trainersService;
	@Autowired
	private PokemonsService pokemonsService;
	
	 @RequestMapping(value="/*")
	    public ModelAndView errors() {
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("notfound.jsp");
	        return modelAndView;
	    }

	
    /*First method on start application*/
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("userJSP", new User());
        modelAndView.setViewName("loginPage.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/loginCapa")
    public ModelAndView Cap(@ModelAttribute("userJSP") User user) {
        ModelAndView modelAndView = new ModelAndView();
        if(user == null){
            modelAndView.setViewName("loginPage.jsp");
            modelAndView.addObject("userJSP", new User());
            return modelAndView;
        }
        modelAndView.setViewName("loginPage.jsp");
        if(user.checkCaptcha()){
            user.resetLoginEr();
            if(user.getName().length()>10){
                user.setLoginEr("Имя пользователя длиннее 10 символов!");
            }else if(user.getName().length()<2){
                user.setLoginEr("Имя пользователя слишком короткое!");
            }else if(user.getPassword().length()<3) {
                user.setLoginEr("Слишком короткий пароль!");
            }else if(user.getPassword().length()>15){
                user.setLoginEr("Слишком длинный пароль!(не больше 15)");
            }else{
            	if(user.isTryToReg()) {
            		String rez = TrainersController.register(trainersService, user.getName(), user.getPassword());
            		if(rez.equals("-1")) {
            			user.setLoginEr("что-то пошло не так, попробуйте еще раз!");
            		}else if(rez.equals("0")) {
            			user.setLoginEr("пользователь с таким именем уже существует");
            		}else {
            			user.setLoged(true);
                        modelAndView.setViewName("menuPage.jsp");
                        modelAndView.addObject("userJSP", user);
                        user.setPassword("");
                        return modelAndView;
            		}
            	}else {
            		if(TrainersController.authorize(trainersService, user.getName(), user.getPassword())) {
            			user.setLoged(true);
            			modelAndView.setViewName("menuPage.jsp");
                        modelAndView.addObject("userJSP", user);
                        return modelAndView;
            		}else {
            			user.setLoginEr("Не удалось авторизироваться, проверьте данные и попробуйте снова!");
            			
            		}
            	}
            }
        }else {
        	user.setLoginEr("Не бот ли вы :/");
        }
        user.setName("");
        user.setMyCaptcha("");
        user.setPassword("");
        modelAndView.addObject("userJSP", user);
        return modelAndView;
    }


    @RequestMapping(value = "/hod")//РР—РњР•РќР•РќРРЇ
    public ModelAndView Hod(@ModelAttribute("userJSP") User user) {
        ModelAndView modelAndView = new ModelAndView();
        if(!user.isLoged() || user == null){
            modelAndView.setViewName("loginPage.jsp");
            modelAndView.addObject("userJSP", new User());
            return modelAndView;
        }
        
        if(!user.isActive()) {
        	modelAndView.setViewName("menuPage.jsp");
        	modelAndView.addObject("userJSP", user);
        	return modelAndView;
        }


        if(user.getMyCard().equals("o") || user.getMyCard().length()==0){
            user.setErrorMsg("Выберите карту!");
            modelAndView.setViewName("gamePage.jsp");
        }else if(user.getHisCard().equals("o") || user.getHisCard().length()==0){
            user.setErrorMsg("Выберите цель!");
            modelAndView.setViewName("gamePage.jsp");
        }else {
        
	        PokemonsController.makeMyHod(user);
	        if (user.getOpponentHP()<=0) {
	        	//System.out.println(user.getName());
	        	//TrainersController.changeRating(trainersService, user.getName(), user.getPassword(), 5);
	        	modelAndView.setViewName("winner.jsp");
	            TrainersController.changeTrainersRating(trainersService, user.getName(), 5);
	        }else {
	            user.resetAfterHod();
//	            try {
//	                sleep(3000);
//	            } catch (InterruptedException e) {
//	                e.printStackTrace();
//	            }
	            PokemonsController.makeOpponentHod(user);
	            if(user.getMyHP()<=0) {
	                modelAndView.setViewName("looser.jsp");
	                TrainersController.changeTrainersRating(trainersService, user.getName(), -5);
	            }
	            else {
	                modelAndView.setViewName("gamePage.jsp");
	            }
	        }
        }
        //user.resetAfterHod();
        
        // modelAndView.addObject("userJSP", user);

        return modelAndView; }

    @RequestMapping(value = "/game")
    public ModelAndView game(@ModelAttribute("userJSP") User user) {
        ModelAndView modelAndView = new ModelAndView();
        if(!user.isLoged() || user == null){
            modelAndView.setViewName("loginPage.jsp");
            modelAndView.addObject("userJSP", new User());
            return modelAndView;
        }
        user.setActive(true);
        modelAndView.setViewName("gamePage.jsp");
        
        user.setMyCards(PokemonsController.setMyCards(pokemonsService));
        user.setCards(PokemonsController.setCards(pokemonsService));
        modelAndView.addObject("userJSP", user);
        user.setMyHP(100);
        user.setOpponentHP(100);

        
        return modelAndView; //после уйдем на представление, указанное чуть выше, если оно будет найдено.
    }

    @RequestMapping(value = "/exit")
    public ModelAndView exit(@ModelAttribute("userJSP") User user) {
        ModelAndView modelAndView = new ModelAndView();
        if(!user.isLoged() || user == null){
            modelAndView.setViewName("loginPage.jsp");
            modelAndView.addObject("userJSP", new User());
            return modelAndView;
        }
        user.clearOnExit();
        //имя представления, куда нужно будет перейти
        modelAndView.setViewName("loginPage.jsp");
        //записываем в атрибут userJSP (используется на странице *.jsp объект user
        modelAndView.addObject("userJSP", user);

        return modelAndView; //после уйдем на представление, указанное чуть выше, если оно будет найдено.
    }

    @RequestMapping(value = "/top")
    public ModelAndView top(@ModelAttribute("userJSP") User user) {
        ModelAndView modelAndView = new ModelAndView();
        if(!user.isLoged() || user == null){
            modelAndView.setViewName("loginPage.jsp");
            modelAndView.addObject("userJSP", new User());
            return modelAndView;
        }
        modelAndView.addObject("train", new Train(trainersService));
        modelAndView.addObject("userJSP", user);
        modelAndView.setViewName("userInfo.jsp");

        //записываем в атрибут userJSP (используется на странице *.jsp объект user


        return modelAndView; //после уйдем на представление, указанное чуть выше, если оно будет найдено.
    }

    @RequestMapping(value = "/rules")
    public ModelAndView rules(@ModelAttribute("userJSP") User user) {
        ModelAndView modelAndView = new ModelAndView();
        if(!user.isLoged() || user == null){
            modelAndView.setViewName("loginPage.jsp");
            modelAndView.addObject("userJSP", new User());
            return modelAndView;
        }

        //имя представления, куда нужно будет перейти
        modelAndView.setViewName("rulesPage.jsp");

        //записываем в атрибут userJSP (используется на странице *.jsp объект user
        modelAndView.addObject("userJSP", user);

        return modelAndView; //после уйдем на представление, указанное чуть выше, если оно будет найдено.
    }

    @RequestMapping(value = "/menu")
    public ModelAndView backToMenu(@ModelAttribute("userJSP") User user) {
        ModelAndView modelAndView = new ModelAndView();
        if(!user.isLoged() || user == null){
            modelAndView.setViewName("loginPage.jsp");
            modelAndView.addObject("userJSP", new User());
            return modelAndView;
        }

        user.clearGameState();
        modelAndView.setViewName("menuPage.jsp");
        modelAndView.addObject("userJSP", user);
        return modelAndView;
    }

    @RequestMapping(value = "/wait")
    public ModelAndView wait(@ModelAttribute("userJSP") User user) {
        ModelAndView modelAndView = new ModelAndView();
        if(!user.isLoged() || user == null){
            modelAndView.setViewName("loginPage.jsp");
            modelAndView.addObject("userJSP", new User());
            return modelAndView;
        }

        //user.clearGameState();
        modelAndView.setViewName("menuPage.jsp");
        modelAndView.addObject("userJSP", user);
        return modelAndView;
    }
    
    @RequestMapping(value = "/try")
    public ModelAndView tryIt() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("winner.jsp");
        return modelAndView;
    }
    
    @RequestMapping(value="/tcu")
    public ModelAndView tryChangeUser(@ModelAttribute("userJSP") User user) {
        ModelAndView modelAndView = new ModelAndView();
        if(!user.isLoged() || user == null){
            modelAndView.setViewName("loginPage.jsp");
            modelAndView.addObject("userJSP", new User());
            return modelAndView;
        }
        user.setNewName(user.getName());
        user.setOldPass("");
        user.setNewPass("");
        user.setNewPass2("");
        modelAndView.setViewName("changeUser.jsp");
        modelAndView.addObject("userJSP", user);
        return modelAndView;
    }
    
    @RequestMapping(value="/win")
    public ModelAndView win() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("winner.jsp");
        return modelAndView;
    }

    
    
    @RequestMapping(value="/changeUser")
    public ModelAndView changeUser(@ModelAttribute("userJSP") User user) {
        ModelAndView modelAndView = new ModelAndView();
        if(!user.isLoged() || user == null){
            modelAndView.setViewName("loginPage.jsp");
            modelAndView.addObject("userJSP", new User());
            return modelAndView;
        }
        //поменять
        if(user.getPassword().equals(user.getOldPass())) {
	        if(user.getNewPass().equals(user.getNewPass2())) {
		        boolean rez = false;
		        if(rez) {
		        	user.setName(user.getNewName());
		        	user.setLoginEr("не удалось внести изменения");
		        }else{
		        	user.setLoginEr("изменения успешно сохранены");
		        }
	        }else{
	        	user.setLoginEr("пароли не совпадают");
	        }
        }else{
        	user.setLoginEr("пароль введен неверно");
        }
        modelAndView.setViewName("changeUser.jsp");
        modelAndView.addObject("userJSP", user);
        return modelAndView;
    }
    
    
}
