package logic.unit;

import java.util.ArrayList;
public class RangeUnit extends BaseUnit{

    public RangeUnit(int startColumn ,int startRow ,
        boolean isWhite ,String name){
            super(startColumn, startRow, isWhite, name);
            this.setHp(2) ;
    }
    
    public void attack(ArrayList<BaseUnit> targetPieces){
        if (this.isWhite() == true){
            for(BaseUnit unit : targetPieces){
                if (this.getRow() + 1 == unit.getRow() && this.getColumn() == unit.getColumn()){
                    unit.setHp(unit.getHp() - this.getPower());
                    System.out.println(this.getName() + "attacks" + unit.getName());
                }
            }
        } else {
            for(BaseUnit unit : targetPieces){
               if (this.getRow() - 1 == unit.getRow() && this.getColumn() == unit.getColumn()){
                    unit.setHp(unit.getHp() - this.getPower());
                    System.out.println(this.getName() + "attacks" + unit.getName());
                } 
            }
        }
    
    }
}