package entity.counter;

import logic.Player;
import entity.container.Dish;

public class DishWasher extends Counter{
    
    //Constructors
    public DishWasher(){
        super("Dish Washer");
    }

    //Methods
    public void interact(Player p){

        if(!this.isPlacedContentEmpty()){
            super.interact(p);
        } 
        else if(p.getHoldingItem() instanceof Dish){
            Dish x = (Dish)p.getHoldingItem();
            if(x.isDirty()){
                super.interact(p);
            }
        }
    }
    
    public void update() {
    	
    	if(this.getPlacedContent() instanceof Dish){
    		Dish x = (Dish)this.getPlacedContent();
    		x.clean(15);
    	}
    }
}

