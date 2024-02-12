//Mert Faruk Gunes - 3105875
package griffith;

public class Healer extends GameCharacter {

	private int cost;
	private int healAmount;
	
	//healer contructor and else.
	public Healer(String name, double gold, int cost, int healAmount) {
		super(name, gold);
		this.cost = cost;
		this.healAmount = healAmount;
	}

	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getHealAmount() {
		return healAmount;
	}

	public void setHealAmount(int healAmount) {
		this.healAmount = healAmount;
	}

	@Override
	public String getStats() {
		return null;
	}
}