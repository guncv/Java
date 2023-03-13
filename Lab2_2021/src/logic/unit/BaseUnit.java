package logic.unit;

import java.util.ArrayList ;
public class BaseUnit {
    private int row , column ;
    private boolean  isWhite ;
    private String name ;
    protected boolean isFlying;
    protected int hp,power;

    public BaseUnit(int startColumn ,int startRow ,boolean isWhite
        , String name){
        setColumn(startColumn) ;
        setRow(startRow) ;
        setName(name) ;
        setIsWhite(isWhite) ; 
        this.hp = 2 ;
        this.power = 1 ;
        this.isFlying = false;

        }

    public boolean move(int direction){
        if(direction == 0){
            if (this.getRow() + 1 > 4){
                return false;
            } else {
                setRow(this.getRow() + 1) ;
                return true ;
            }
        } else if(direction == 1){
            if (this.getColumn() + 1 > 4){
                return false ;
            } else {
                setColumn(this.getColumn() + 1) ;
                return true ;
            }
        } else if(direction == 2){
            if (this.getRow() - 1 < 0){
                return false ;
            } else {
                setRow(this.getRow() - 1);
                return true ;
            }
        }  else if(direction == 3){
            if (this.getColumn() - 1 < 0){
                return false ;
            } else {
                setColumn(this.getColumn() - 1);
                return true ;
            }
        } else {
            return false ;
        }
    }

    public void attack(ArrayList<BaseUnit> targetPieces){
        for(BaseUnit x : targetPieces){
            if(x.isFlying() == false){
                if (x.getRow() == this.getRow() && x.getColumn() == this.getColumn()){
                    x.setHp(x.getHp() - this.getPower()) ;
                    System.out.println(this.getName() + "attacks" + x.getName());
                }
            }
        }
    }

    //setter
    public void setRow(int row){
        if (row < 0){
            this.row = 0 ;
        } else if (row > 4){
            this.row = 4 ;
        } else {
            this.row = row;
        }
    }

    public void setColumn(int column){
        if (column < 0){
            this.column = 0 ;
        } else if (column > 4){
            this.column = 4 ;
        } else {
            this.column = column ;
        }
    }

    public void setIsWhite(boolean isWhite){
        this.isWhite = isWhite ;
    }

    public void setName(String name){
        this.name = name ;
    }

    public void setHp(int hp){
        this.hp = hp ;
    }

    //getter

    public int getHp(){
        return hp ;
    }

    public int getRow(){
        return row;
    }

    public int getColumn(){
        return column ;
    }

    public String getName(){
        return name ;
    }

    public boolean isWhite(){
        return isWhite ;
    }

    public boolean isFlying(){
        return isFlying ;
    }

    public int getPower(){
        return power ;
    }
}