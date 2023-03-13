package entity.counter;

import entity.base.Choppable;
import entity.base.Ingredient;
import logic.Player;

public class ChoppingBoard extends Counter{
    
    //Constructor
    public ChoppingBoard(){
        super("Chopping Board");
    }

    //Method
    public void interact(Player p){
        if(!this.isPlacedContentEmpty()){
            super.interact(p);
        } else if (p.getHoldingItem() instanceof Ingredient){
            Ingredient x = (Ingredient)p.getHoldingItem();
            super.interact(p);
            if(x instanceof Choppable){
                Choppable chop = (Choppable)x;
                chop.chop();
            }
        } 
    }

}