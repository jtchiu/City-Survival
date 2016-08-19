import java.util.ArrayList;

public class Player {
	
	public final int MAX_HEALTH = 5;
	public static final int TOTAL_PIECES = 7;
	
	private int health = MAX_HEALTH;
	
	public ArrayList<Integer> inventory = new ArrayList<Integer>();
	

	private int x = 2;
	private int y = 2;
	private int pieceCounter = 0;
	
	public Player(){
		//default
	}
	
	public int getPieceCounter() {
		return pieceCounter;
	}

	public void setPieceCounter(int pieceCounter) {
		this.pieceCounter = pieceCounter;
	}

	public void increasePieceCounter(){
		pieceCounter++;
                if(pieceCounter == 7){
                    System.out.println("you win.");
                }
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	//Check if out of bound or any enemies already occupied ---> do later
	public void movePlayer(char direction){
		switch(Character.toLowerCase(direction)){
			case 'w':
				y--;
				break;
			case 's':
				y++;
				break;
			case 'a':
				x--;
				break;
			case 'd':
				x++;
				break;
		}
		Board.actions--;
		
	}
	
	public void killEnemy(char direction){
		char userInput = Character.toLowerCase(direction);
		switch(userInput){
		case 'w':
			if(Board.board[x][y-1].enemyFound())
				Board.board[x][y-1].minusEnemy();
			break;
		case 's':
			if(Board.board[x][y+1].enemyFound())
				Board.board[x][y+1].minusEnemy();
			break;
		case 'a':
			if(Board.board[x-1][y].enemyFound())
				Board.board[x-1][y].minusEnemy();
			break;
		case 'd':
			if(Board.board[x+1][y].enemyFound())
				Board.board[x+1][y].minusEnemy();
			break;
		}
		Board.actions--;
	}
	
	//Use wiht the nuke
	public void killEnemy(int x, int y){
		while(Board.board[x][y].enemyFound()){
			Board.board[x][y].minusEnemy();
		}
		Board.actions--;
	}
	
	public void searchArea(Tile tile){
		if(tile.enemyFound() == false){
			tile.flipTile(this);
		}
		Board.actions--;
	}
	
	public void useEquip(int item){
		if(inventory.contains(item)){
			switch(item){
			case Equipment.NUKE:
				//killEnemy();
				break;
			case Equipment.HEALTH_PACK:
				increaseHealth();
				break;
			case Equipment.SATELLITE_IMAGE:
				break;
			case Equipment.EXTRA_ACTIONS:
				break;
			}
			inventory.remove(item);
        		Board.actions--;                
		}
                
                
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	public void increaseHealth(){
		health+=2;
		if(health > MAX_HEALTH)
			health = MAX_HEALTH;
	}
	
	public void decreaseHealth(){
		health--;
		if(health == 0){
			System.out.println("SBU > BING however u died to filthy bing troops gg");
			System.exit(0);
		}
	}
}
