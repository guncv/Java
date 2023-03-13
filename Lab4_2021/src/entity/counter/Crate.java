package entity.counter;
import entity.base.Ingredient;
import entity.base.Item;
import logic.LogicUtil;
import logic.Player;
public class Crate extends Counter{
    
    private String myIngredient;

    //Constructor
    public Crate(String s){
        super(s + " Crate");
        setMyIngredient(s);
    }

    //Method 
    public void interact(Player p){
        if(!p.isHandEmpty() || !this.isPlacedContentEmpty()){
            super.interact(p);
        } else {
            try{
                Ingredient x = LogicUtil.createIngredientFromName(myIngredient);
                p.setHoldingItem(x);
            }catch(Exception InvalidIngredientException){
                p.setHoldingItem(null);
            }
        }
    }

    //setter
    public void setMyIngredient(String myIngredient){
        this.myIngredient = myIngredient;
    }

    //getter
    public String getMyIngredient(){
        return myIngredient;
    }
}
