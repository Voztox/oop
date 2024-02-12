//Mert Faruk Gunes - 3105875
package griffith;

public interface Battle {
	//return exp
	int getExp();
	//return atk
	int getAtk();
	//take attack away from health
	void takeDamage(int attack);
	//add the amount to exp
	void increaseExp(int amount);
	//add the amount to health
	void heal(int amount);
	//add the amount to gold
	void addGold(double gold);
	//remove the amount to health
	void loseGold(double gold);
}
