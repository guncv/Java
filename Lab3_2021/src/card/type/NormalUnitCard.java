package card.type;

import card.base.UnitCard;

//You CAN modify the first line
public class NormalUnitCard extends UnitCard {
	
	public NormalUnitCard(String name, String flavorText, int bloodCost, int power, int health) {
		super(name,flavorText,bloodCost,power,health);
	}
	
	public int attackUnit(UnitCard u) {
		int x;
		if(this.getPower() >= u.getHealth()){
			x = u.getHealth();
			u.setHealth(0);
			return x;
		}else{
			u.setHealth(u.getHealth() - this.getPower());
			return this.getPower();
		}
	}

}
