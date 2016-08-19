import java.util.ArrayList;
import java.util.Collections;

public class Cards {

	public static final int ENEMY_APPEAR = 0;
	public static final int ENEMY_RATE = 1;
	public static final int SHOTS_FIRED = 2;
	public static final int CARE_PACKAGE = 3;
	
	public static ArrayList<Integer> cards = new ArrayList<Integer>();
	
	public static int drawCard(){
		cards.add(ENEMY_APPEAR);
		cards.add(ENEMY_APPEAR);
		cards.add(ENEMY_APPEAR);
		cards.add(ENEMY_APPEAR);
		cards.add(ENEMY_APPEAR);
		cards.add(ENEMY_APPEAR);
		cards.add(ENEMY_RATE);
		cards.add(CARE_PACKAGE);
		cards.add(SHOTS_FIRED);
		cards.add(SHOTS_FIRED);
		
		Collections.shuffle(cards);
		
		return cards.get(0);
		
	}
	
	
	
	
	
}
