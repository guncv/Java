package entity.ingredient;

import entity.base.Choppable;
import entity.base.Ingredient;

public class Lettuce extends Ingredient implements Choppable{

    private boolean chopState;

    //Constructor
    public Lettuce(){
        super("Lettuce");
        setChopState(false);
        setEdible(true);
    }

    //Methods
    @Override
    public void chop(){
        if(!this.isChopped()){
            this.setName("Chopped Lettuce");
            this.setChopState(true);
        }
    }

    //setter
    public void setChopState(boolean chopState){
        this.chopState = chopState;
    }

    //getter
    @Override
    public boolean isChopped(){
        return chopState;
    }

}
