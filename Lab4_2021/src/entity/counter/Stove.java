package entity.counter;

import entity.base.Item;
import logic.Player;
import entity.container.Pan;

public class Stove extends Counter{
     
    //Constructor
    public Stove(){
        super("Stove");
    }

    public Stove(Item content){
        super("Stove");
        setPlacedContent(content);
    }

    //Method
    public void interact(Player p){
        if(!this.isPlacedContentEmpty()){
            super.interact(p);
        }else if(p.getHoldingItem() instanceof Pan){
            super.interact(p);
        }
    }

    public void update(){
        if(this.getPlacedContent() instanceof Pan){
            Pan x = (Pan)this.getPlacedContent();
            x.cook();
        }
    }
}

