package entity.counter;
import entity.base.Container;
import entity.base.Ingredient;
import logic.Player;

public class Bin extends Counter{

    //Constructor
    public Bin(){
        super("Bin");
    }

    //Methods
    public void interact(Player p){
        if(!p.isHandEmpty()){

            if(p.getHoldingItem() instanceof Ingredient){
                p.setHoldingItem(null);
            }else if(p.getHoldingItem() instanceof Container){
                Container x = (Container) p.getHoldingItem();
                x.clearContent();
            }
        }
    } 
}

