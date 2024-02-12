//Mert Faruk Gunes - 3105875
package griffith;

//player should implement the battle interface
public class Player extends GameCharacter implements Battle {

	private int health;
	private int exp;
	private int atk;

	public Player(String name) {
		super(name, 0);
		this.health = 100;
		this.exp = 0;
		this.atk = 10 + (exp / 2);
	}

	public int getHealth() {
		return health;
	}
	@Override
	public String getStats() {
		return "Stats:\tGold "+ getGold()+
				"\n\tHealth:"+ health+
				"\n\tAtk:"+ atk+
				"\n\tExp:"+ exp;
	}

	@Override
	public int getExp() {
		return exp;
	}

	@Override
	public int getAtk() {
		return atk = 10 + (exp / 5);
	}
	@Override
	public void takeDamage(int attack) {
		this.health -= attack;
	}

	@Override
	public void increaseExp(int amount) {
		this.exp += amount;
	}

	@Override
	public void heal(int amount) {
		this.health += amount;
	}

	@Override
	public void addGold(double gold) {
		this.setGold(this.getGold() + gold);
	}

	@Override
	public void loseGold(double gold) {
		this.setGold(this.getGold() - gold);
	}
}


