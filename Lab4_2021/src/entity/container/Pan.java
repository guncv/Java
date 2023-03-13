package entity.container;

import javax.swing.text.AbstractDocument.Content;

import entity.base.Container;
import entity.base.Cookable;
import entity.base.Ingredient;

public class Pan extends Container {
    
    //Constructor
    public Pan(){
        super("Pan",1);
    } 

    //Method
    public boolean verifyContent(Ingredient i){
        if(i instanceof Cookable){
            return true ;
        } return false;
    }

    public void cook(){
        if(!this.isEmpty()){
            for(Ingredient x : this.getContent()){
                if(x instanceof Cookable){
                    Cookable cook = (Cookable)x; 
                    cook.cook();
                }
            }
        }  
    }
}

