//Mert Faruk Gunes - 3105875
package griffith;

//enemy should be a sub class of gameCharacter
//enemy should implement the battle interface
public class Enemy extends GameCharacter implements Battle {
	private int atk;
	private int exp;


	public Enemy(int atk, int exp, String enemyName) {
		super(enemyName, atk); 
		this.atk = atk;
		this.exp = exp;
	}

	@Override
	public int getExp() {
		return exp;
	}

	@Override
	public int getAtk() {
		return atk;
	}

	@Override
	public void takeDamage(int attack) {

	}

	@Override
	public void increaseExp(int amount) {

	}

	@Override
	public void heal(int amount) {

	}

	@Override
	public void addGold(double gold) {
	}

	@Override
	public void loseGold(double gold) {

	}

	@Override
	public String getStats() {
		return null;
	}
}
