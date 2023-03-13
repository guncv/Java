package logic.unit;

public class FlyingUnit extends BaseUnit{

    public FlyingUnit(int startColumn, int startRow, boolean isWhite, String name){
        super(startColumn, startRow, isWhite, name);
        this.hp = 2;
        this.isFlying = true;
    }

    public boolean move(int direction){
        if (direction == 0){
            if (this.getRow() + 2 > 4){
                return false;
            } else {
                setRow(this.getRow() + 2) ;
                return true ;
            }
        } else if(direction == 1){
            if (this.getColumn() + 2 > 4){
                return false ;
            } else {
                setColumn(this.getColumn() + 2);
                return true ;
            }
        }else if (direction == 2){
            if (this.getRow() - 2 < 0){
                return false ;
            }else {
                setRow(this.getRow() - 2);
                return true ;
            }
        } else if (direction == 3){
            if (this.getColumn() - 2 < 0){
                return false ;
            }else {
                setColumn(this.getColumn() - 2);
                return true ;
            }
        } else{
            return false;
        }
    }
}