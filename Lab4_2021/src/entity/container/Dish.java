package entity.container;

import entity.base.Container;
import entity.base.Ingredient;
import logic.StringUtil;

public class Dish extends Container {
    
    private int dirty;

    //Constructor
    public Dish(){
        super("Dish",4);
        setDirty(0);
    }

    public Dish(int dirty){
        super("Dish",4);
        setDirty(dirty);
    }

    //Method
    public boolean isDirty(){
        if(this.getDirty() > 0){
            return true;
        }return false;
    }

    public boolean verifyContent(Ingredient i){
        if(!this.isDirty() && i.isEdible()){
            return true;
        }return false;
    }

    public void clean(int amount){
        this.setDirty(this.getDirty() - amount);
    }

    public String toString(){
        if(this.isDirty()){
            return StringUtil.formatNamePercentage(this.getName(), this.getDirty());
        }else{
            return super.toString();
        }
    }

    //setter
    public void setDirty(int dirty){
        if(dirty < 0){
            this.dirty = 0;
            setName("Dish");
        }else if(dirty > 0){
            setName("Dirty Dish");
            this.dirty = dirty;
        }else{
            setName("Dish");
            this.dirty = dirty;
        }
    }

    //getter
    public int getDirty(){
        return dirty;
    }
}
