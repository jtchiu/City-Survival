
public class Main {

	public static void main(String[] args) {
		//Board b = new Board();
		//Player p = new Player();
		
		System.out.println("You are alone in enemy territory, kekeroni pepperoni fettucini spaguetti baguetti. \n");
		System.out.println("On your way to the first hackathon at hackBU, you discover that Stony Brook University launched nukes to Binghamton"
							+ " and it is now a war-zone.\n");
		System.out.println("Apparently, Trump got voted president and hell broke loose! The AMS department, furious over Bernie Sanders' loss"
							+ " (Bernie and Alan Tucker are similar\n in that they are both MVPs). Kappa.\n");
		System.out.println("You find yourself in a 5x5 grid in 2D space somehow. (Don't worry about it.) Try your best to survive.\n");
		System.out.println("You begin with 5 health, and lose if the number drops to zero. You win if you gather all 7 pieces of the radio "
							+ "and land on the evac tile.\n");
		System.out.println("Reality has suddenly turned into a turn-based game, because LSD. You have four actions available per turn, each usage takes one from"
							+ " your turn total. \nSo, for example, you could spend your turn moving 4 times.\n");
		System.out.println("1) Move a tile in any of 4 directions (w/a/s/d); you may not move onto tiles that currently hold enemies");
		System.out.println("2) Kill an enemy (w/a/s/d) which can be performed on adjacent tiles");
		System.out.println("3) Search the area, only available if there are no enemies on that tile. Searching tiles will yield different results;"
							+ " There is 1 evac tile, 7 radio piece tiles,\n 3 Hospitals (that will heal you for 2), 2 Fake Hospitals (controlled by"
							+ " the enemy; they will decrease your health by 1), 10 equipment tiles, and 2 ambush tiles,\n which decrease your health by one.");
		System.out.println("4) Use an equipment that you have already collected.\n");
		System.out.println("There are 4 types of equipment. 3 nukes, 3 health packs, 3 satellite images, and 1 pack of Monster Energy drinks.");
		System.out.println("A nuke allows you to pick any tile and kill all enemies on that tile. A health pack will immediately restore 2 health.");
		System.out.println("A satellite image will allow you to peek at the contents of any tile; for example, if the Hospital is a fake or not.");
		System.out.println("The pack of Monster Energy drinks is so OP that it will give you another 5 actions free- one to make up for using the equipment.");


	}
                

	private static void printBoard(){
		
	}

}
