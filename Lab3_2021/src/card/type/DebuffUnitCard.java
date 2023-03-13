package card.type;

import card.base.UnitCard;

//You CAN modify the first line
public class DebuffUnitCard extends UnitCard {	
	private int debuffPower;
	
	public DebuffUnitCard(String name, String flavorText, int bloodCost, int power, int health, int debuffPower) {
		super(name,flavorText,bloodCost,power,health);
		setDebuffPower(debuffPower);
	}	
	
	public int attackUnit(UnitCard unitCard){
		int x;

		if(this.getPower() >= unitCard.getHealth()){
			x = unitCard.getHealth();
			unitCard.setHealth(0);
		}
		else{
			unitCard.setHealth(unitCard.getHealth()-this.getPower());
			x = this.getPower();
		}	
		
		if(this.getDebuffPower() >= unitCard.getPower()) {
			unitCard.setPower(0);
		}else {
			unitCard.setPower(unitCard.getPower() - this.getDebuffPower());
		}
		return x;
	}

	//setter 
	public void setDebuffPower(int debuffPower){
		if (debuffPower < 0) {
			this.debuffPower = 0;
		}else {
			this.debuffPower = debuffPower;
		}
	}

	//getter
	public int getDebuffPower(){
		return debuffPower;
	}
}
