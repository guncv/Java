package entity.ingredient;

import entity.base.Choppable;
import entity.base.Cookable;
import entity.base.Ingredient;
import logic.StringUtil;

public class Meat extends Ingredient implements Choppable, Cookable{
    
    private boolean chopState;
    private int cookedPercentage;

    //Constructor
    public Meat(){
        super("Meat");
        setCookedPercentage(0);
        setChopState(false);
    }

    //Methods
    @Override
    public void chop(){
        if( !(this.isChopped() || this.getCookedPercentage()>0)){
            this.setName("Minced Meat");
            this.setChopState(true);
        }

    }

    @Override
    public boolean isChopped(){
        return chopState;
    }

    @Override
    public void cook(){
        if (!this.isChopped()){
            this.setCookedPercentage(this.getCookedPercentage()+10);
        
        int x = this.getCookedPercentage();

            if(x > 0 && x <=50){
                this.setName("Raw Meat");
                this.setEdible(false);
            } else if(x > 50 && x <=80){
                this.setName("Medium Rare Steak");
                this.setEdible(true);
            } else if(x > 80 && x <=100){
                this.setName("Well Done Steak");
                this.setEdible(true);
            } else {
                this.setEdible(false);
                this.setName("Burnt Steak");
            }  
        } else{
            this.setCookedPercentage(this.getCookedPercentage()+15);
            
            int x = this.getCookedPercentage();

            if(x > 0 && x<=80){
                this.setName("Raw Burger");
                this.setEdible(false);
            } else if(x > 80 && x <=100){
                this.setName("Cooked Burger");
                this.setEdible(true);
            } else {
                this.setName("Burnt Burger");
                this.setEdible(false);
            }
        }
    }

    @Override
    public boolean isBurnt(){
        if(this.getCookedPercentage() > 100){
            return true;
        } return false;
    }

    @Override
    public String toString(){
        return StringUtil.formatNamePercentage(this.getName(),this.getCookedPercentage());
    }

    //setter
    public void setChopState(boolean chopState){
        this.chopState = chopState;
    }

    public void setCookedPercentage(int cookedPercentage){
        this.cookedPercentage = cookedPercentage;
    }

    public int getCookedPercentage(){
        return cookedPercentage;
    }

    
}
