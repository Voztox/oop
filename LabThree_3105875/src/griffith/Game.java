//Mert Faruk Gunes - 3105875
package griffith;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	final static int MAX_GOLD =999;
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);

		System.out.println("Welcome, Enter the players name");
		String name = input.nextLine();

		Player player = new Player(name);
		System.out.println("Try to get " +MAX_GOLD + " gold " + player.getName());


		//list of all characters a player can encounter
		ArrayList<GameCharacter> encounters = new ArrayList<GameCharacter>();
		//Adding some encouonters more than one so player can farm the weaker mobs.
		encounters.add(new Enemy(5, 10, "Elemental")); // Elemental
		encounters.add(new Enemy(5, 10, "Baby Dragon")); // Baby Dragon
		encounters.add(new Enemy(5, 10, "Archer")); // Archer
		encounters.add(new Enemy(10, 20, "Pyro")); // Pyro
		encounters.add(new Enemy(15, 20, "Soldier")); // Soldier
		encounters.add(new Enemy(20, 20, "Murloc")); // Murloc
		encounters.add(new Enemy(20, 30, "Beast")); // Beast
		encounters.add(new Enemy(25, 30, "Big Foot")); // Big Foot
		encounters.add(new Enemy(30, 40, "Yhorm the Giant")); // A Giant
		encounters.add(new Enemy(35, 50, "Fiend")); // Fiend
		encounters.add(new Enemy(45, 70, "Monstrosity")); //Monstrosity
		encounters.add(new Enemy(50, 80, "Cursed Princess")); // Cursed Princess

		Boss boss = new Boss(100, 999, "Curse of the Crown", "Nameless King");
		encounters.add(boss);

		Healer priest = new Healer("Priest", 100, 10, 20);
		encounters.add(priest);
		Healer druid = new Healer("Druid", 100, 25, 50);
		encounters.add(druid);

		//keeping the game on when player has less than 999 gold and more than 0 hp.
		while (player.getGold() < 999 && player.getHealth() > 0) {
			int i = (int) (Math.random() * encounters.size());
			GameCharacter character = encounters.get(i);
			//making the conditions for if the enemy is either enemy boss or healer.
			if (character instanceof Enemy) {
				Enemy enemy = (Enemy) character;
				System.out.println(player.getStats());
				System.out.println("You have encountered " + enemy.getName());
				System.out.println("attack: " + enemy.getAtk());
				System.out.println("gold: " + enemy.getGold());
				if (enemy instanceof Boss) {
					System.out.println(boss.cursedCrown());
				}

				System.out.println("Do you want to battle or run? (battle/run)");
				String userInput = input.nextLine();

				if (userInput.equals("battle")) {
					//if player has lower attack; lose gold as much as enemy's gold, lose health as much as the enemy's attack.
					if (player.getAtk() < enemy.getAtk()) {
						System.out.println("Enemy attack is higher. You lost the battle.");
						player.takeDamage(enemy.getAtk());
						player.loseGold(enemy.getGold());
						if (enemy instanceof Boss) {
							boss.getSpecialAbility();
						}
					} else if (player.getAtk() > enemy.getAtk()) {
						//if player has higher attack; add the enemy's exp and gold to yours.
						System.out.println("Your attack is higher. You won the battle.");
						player.increaseExp(enemy.getExp());
						player.addGold(enemy.getGold());
						if (enemy instanceof Boss) {
							boss.getSpecialAbility();
						}
					} else {
						//random result on exact same attacks (Which is almost impossible but anyways.)
						if (Math.random() < 0.5) {
							System.out.println("You won the battle.");
							player.increaseExp(enemy.getExp());
							player.addGold(enemy.getGold());
							if (enemy instanceof Boss) {
								boss.getSpecialAbility();
							}
						} else {
							System.out.println("Enemy attack is higher. You lost the battle.");
							player.takeDamage(enemy.getAtk());
							player.loseGold(enemy.getGold());
						}
					}
				} else if (userInput.equals("run")) {
					continue;
				} else {
					System.out.println("Invalid input.");
				}
				//conditions for heal. (if the player has enough amount of money etc.)
			} else if (character instanceof Healer) {
				Healer healer = (Healer) character;
				System.out.println("You have encountered " + healer.getName() + ".");
				System.out.println("Do you want healing? (yes/no)");
				String userInput = input.nextLine();

				if (userInput.equals("yes")) {
					if (player.getGold() >= healer.getCost()) {
						player.heal(healer.getHealAmount());
						player.loseGold(healer.getCost());
					} else {
						System.out.println("You don't have enough gold.");
						continue;
					}
				} else if (userInput.equals("no")) {
					continue;
				} else {
					System.out.println("Invalid input.");
				}
			}
		}
		//ending message for the game
		if (player.getHealth() <= 0)
			System.out.println("You died " + player.getName() + ".");
		else if (player.getGold() >= 999)
			System.out.println("You won " + player.getName() + ".");
		input.close();
	}
}


