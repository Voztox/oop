//Mert Faruk Gunes - 3105875
package griffith;

public class Boss extends Enemy {

	private String specialAbility;

	public Boss(int atk, int gold, String specialAbility, String bossName) {
		super(atk, gold, bossName);
		this.specialAbility = specialAbility;
	}
	//little text art from https://emojicombos.com/crown-ascii-art
	//to make it little bit spooky. 
	public String cursedCrown() {
		return  "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ Nameless King Here⠀⠀⠀⠀⠀⠀ ⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  Cursed Crown⠀⠀      ⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡠⠊⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠦⣀⠀⠀⠀⠀⠀⠀⠀⢴⠊⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡜⠀⠀⠉⠁⠒⡒⠀⠀⠀⢀⠇⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠜⠀⠀⠀⠀⠀⠀⠱⠤⠤⠐⠁⠀⠀⠀⢠⠋⡆⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⢀⣀⣀⡀⠀⠤⡤⠀⠀⠈⢢⠀⠀⠀⠀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⢿⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠈⢢⠀⠀⠀⠀⢇⠀⠀⡠⠜⠀⠀⠀⢀⠃⢈⡇⠀⠀⠀⠀⠀⠀⠀⠀⡸⠤⡀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠑⢄⠀⠀⠀⠉⠁⠀⠀⠀⠀⠀⠘⠣⢾⠀⠀⠀⠀⠀⠀⡠⠔⠁⠀⠀⡸⠤⡀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠈⢣⠤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠔⠉⠀⠀⠀⠀⡰⠁⠀⠈⠑⣄⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠣⢾⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠀⠀⠀⠀⠀⠀⠀⢀⠜⠀⠀⠀⠀⠀⠈⢆⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠃⠀⢀⣤⠠⠀⠀⠀⠀⠘⠁⠀⠀⠀⠀⠀⠀⢠⠊⠀⠀⠀⠀⠀⠀⠀⠈⡄⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⡔⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⢃⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⢃⠀⠀⠀⠀⠔⠉⡀⠀⠀⠀⠀⠀⠀⠀⡰⠁⠝⣠⣶⣶⣶⣦⡀⠀⠀⠀⢀⠇⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠈⡆⠀⠀⢸⠀⠀⠃⠀⠀⠰⡄⠀⡠⠊⠀⠀⣾⣿⣿⠿⣿⣿⣷⡀⠀⠀⡌⠀⠀\r\n"
				+ "⠀⠀⠀⠀⡔⠒⠉⠀⠀⠀⠘⢄⠀⠀⠀⠀⡷⢀⠊⣰⣧⠀⠀⣿⣿⣿⣶⣿⣿⡿⠁⠀⠀⠣⢀⠀\r\n"
				+ "⠀⠀⠀⠀⢁⠀⠀⠀⠀⠀⠀⠀⠑⠀⠀⠀⠀⡈⢰⣿⣿⣇⠀⠈⠻⠿⣿⠿⠛⠁⠀⠀⠀⠀⡰⠁\r\n"
				+ "⠀⠀⠀⠀⠈⠀⠉⠢⠠⢲⠀⠀⠀⠀⠀⠀⠀⡇⠈⠋⠘⠃⠀⠀⠀⠀⢀⣠⠀⠀⣠⠔⠂⠉⠁⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡄⠀⢸⣦⣤⠀⠀⢣⡠⠤⣠⠐⢴⠊⠑⢾⣿⣿⠀⡰⠁⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠃⠀⠘⣿⣷⡄⠀⡰⠀⠀⡇⠀⢸⣄⣠⣾⣿⡇⠀⠇⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⠀⢿⣿⣿⣦⣿⣦⣾⣷⣤⣿⣷⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⠀⠘⡯⠛⣿⠛⢿⠟⣿⠿⢻⡿⠛⢻⠃⠀⠀⡀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠑⢄⠀⠀⠰⣄⡥⣄⣀⡀⣸⡀⣠⣇⣀⠌⠀⢀⣠⠇⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣰⢦⠀⠈⠀⠉⠀⠋⠁⠛⠁⡙⠁⣠⠖⠉⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠑⣄⠀⠀⠀⠀⠀⠀⢠⡥⠊⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠈⠀⠒⠀⠊⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀";
	}
	//Made bosses give 999 gold so winning a battle against them once will be enough to end the game.
	public String getSpecialAbility() {
		return specialAbility;
	}
	public void setSpecialAbility(String specialAbility) {
		this.specialAbility = specialAbility;
	}
}
