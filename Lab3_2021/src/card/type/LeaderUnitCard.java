//งง attackUnit
package card.type;

import card.base.UnitCard;
import player.Player;
import java.util.Objects;

//You CAN modify the first line
public class LeaderUnitCard extends UnitCard {
	private int buffPower,buffHealth;

	public LeaderUnitCard(String name, String flavorText, int bloodCost, int power, int health, int buffPower, int buffHealth) {
		super(name, flavorText, bloodCost, power, health);
		setBuffPower(buffPower);
		setBuffHealth(buffHealth);
	}
	
	public int attackUnit(UnitCard unitCard){
		int x;
		if(this.getPower() >= unitCard.getHealth()){
			x = unitCard.getHealth();
			unitCard.setHealth(0);
			return x;
		}else{
			unitCard.setHealth(unitCard.getHealth() - this.getPower());
			return this.getPower();
		}
	}

	public void buffUnit(UnitCard[] alliesCard){
		for(UnitCard unitCard : alliesCard){
			if(!Objects.isNull(unitCard)){
				unitCard.setPower(unitCard.getPower()+this.getBuffPower());
				unitCard.setHealth(unitCard.getHealth()+this.getBuffHealth());
			}
		}
	}

	//setter
	public void setBuffPower(int buffPower){
		if(buffPower <= 0) {
			this.buffPower = 0;
		}else {
			this.buffPower = buffPower;
		}
	}

	public void setBuffHealth(int buffHealth){
		if(buffHealth < 0) {
			this.buffHealth = 0;
		}else {
			this.buffHealth = buffHealth;
		}
	}

	//getter
	public int getBuffPower(){
		return buffPower;
	}

	public int getBuffHealth(){
		return buffHealth;
	}

	@Override
	public String toString() {
		return super.getName() + " (POW: " + super.getPower() + ", HP: " + super.getHealth() + 
				" | POW Inc: "+ this.getBuffPower() + ", HP Inc: " + this.getBuffHealth() + ")";
	}

}