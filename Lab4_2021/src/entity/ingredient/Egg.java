package entity.ingredient;

import entity.base.Cookable;
import entity.base.Ingredient;
import logic.StringUtil;

public class Egg extends Ingredient implements Cookable {
    
    private int cookedPercentage;

    //Constructor
    public Egg(){
        super("Egg");
        setCookedPercentage(0);
    }

    //Method
    @Override
    public void cook(){
        this.setCookedPercentage(this.getCookedPercentage()+12);
        int x = this.getCookedPercentage();
        
        if(0 < x && x <= 50){
            this.setName("Raw Egg");
            this.setEdible(false);
        } else if (x > 50 && x <= 80){
            this.setName("Sunny Side Egg");
            this.setEdible(true);
        } else if (x > 80 && x <=100){
            this.setName("Fried Egg");
            this.setEdible(true);
        } else{
            this.setName("Burnt Egg");
            this.setEdible(false);
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
    public void setCookedPercentage(int cookedPercentage){
        this.cookedPercentage = cookedPercentage;
    }

    //getter
    public int getCookedPercentage(){
        return cookedPercentage;
    }
}
