public class Tile {
	
	private int x;
	private int y;
	
	private int type;
	
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

	public static final int EVAC_TILE = 0;
	public static final int PIECE_TILE = 1;
	public static final int HOSPITAL_TILE = 2;
	public static final int FAKE_TILE = 3;
	public static final int EQUIPMENT_TILE = 4;
	public static final int AMBUSH_TILE = 5;
	
	
	private int enemyCount = 0;
        
        public int corRect;
	
	private boolean isCovered = true;
	
	public Tile(int x, int y, int type){
		this.x = x;
		this.y = y;
		this.type = type;
	}
	
	public boolean enemyFound(){
		if(enemyCount > 0)
			return true;
		else
			return false;
	}
	
	public void minusEnemy(){
		enemyCount--;
	}

	public void flipTile(Player p){
		if(isCovered){
			switch(type){
			case EVAC_TILE:
				if(p.getPieceCounter() == Player.TOTAL_PIECES)
					//THEY WIN
				break;
			case PIECE_TILE:
				p.increasePieceCounter();
				break;
			case HOSPITAL_TILE:
				p.increaseHealth();
				break;
			case FAKE_TILE:
				p.decreaseHealth();
				break;
			case EQUIPMENT_TILE:
				p.inventory.add(Equipment.giveEquipment());
				break;
			case AMBUSH_TILE:
				p.decreaseHealth();
				break;
			}
		}
		isCovered = false;
	
	}
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public boolean getIsCovered(){
		return isCovered;
	}
	
	public void addEnemy(){
		enemyCount++;
	}
	
	public int getEnemyCount(){
		return enemyCount;
	}
	
}
	
