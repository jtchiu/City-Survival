import java.util.ArrayList;
import java.util.Collections;

public class Board {

	public static Tile[][] board = new Tile[5][5];
	public static int actions = 4;
	public static int enemyRate = 1;
       
	
	public Board(){
		ArrayList<Integer> types = new ArrayList<Integer>();
		types.add(Tile.EVAC_TILE);
		types.add(Tile.PIECE_TILE);
		types.add(Tile.PIECE_TILE);
		types.add(Tile.PIECE_TILE);
		types.add(Tile.PIECE_TILE);
		types.add(Tile.PIECE_TILE);
		types.add(Tile.PIECE_TILE);
		types.add(Tile.PIECE_TILE);
		types.add(Tile.HOSPITAL_TILE);
		types.add(Tile.HOSPITAL_TILE);
		types.add(Tile.HOSPITAL_TILE);
		types.add(Tile.FAKE_TILE);
		types.add(Tile.FAKE_TILE);
		types.add(Tile.EQUIPMENT_TILE);
		types.add(Tile.EQUIPMENT_TILE);
		types.add(Tile.EQUIPMENT_TILE);
		types.add(Tile.EQUIPMENT_TILE);
		types.add(Tile.EQUIPMENT_TILE);
		types.add(Tile.EQUIPMENT_TILE);
		types.add(Tile.EQUIPMENT_TILE);
		types.add(Tile.EQUIPMENT_TILE);
		types.add(Tile.EQUIPMENT_TILE);
		types.add(Tile.EQUIPMENT_TILE);
		types.add(Tile.AMBUSH_TILE);
		types.add(Tile.AMBUSH_TILE);
		Collections.shuffle(types);
		int index = 0;
		for(int i =  0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				board[i][j] = new Tile(i, j, types.get(index));
				index++;
			}	
		}	
	}
        
        public void onLaunch(){
            for(int i = 0; i < 5; i++){
                board[(int)(Math.random()*5)][(int)(Math.random()*5)].addEnemy();
            }
        }
	
	public void placeEnemy(int x, int y){
		board[x][y].addEnemy();
	}
	
	public String drawCards(int num, Player p){
		String result = "";
                for(int i = 0; i < num; i++){
			int card = Cards.drawCard();
			switch(card){
				case Cards.ENEMY_APPEAR:
					for(int j =0; j < enemyRate; j++){
						board[(int)(Math.random()*5)][(int)(Math.random()*5)].addEnemy();
					}
                                        result += "Enemy Appears\n";
                                        break;
				case Cards.ENEMY_RATE:
						enemyRate++;
                                                result += "Enemy Rate Increase\n";
					break;
				case Cards.CARE_PACKAGE:
						p.increaseHealth();
                                                result += "Increase Health\n";
					break;
				case Cards.SHOTS_FIRED:
					p.decreaseHealth();
                                        result += "Lose Health\n";
					break;
			}
		}
                return result;
	}
	
}
