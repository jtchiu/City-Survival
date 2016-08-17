import java.util.ArrayList;

public class Equipment {

	public static final int NUKE = 0;
	public static final int HEALTH_PACK = 1;
	public static final int SATELLITE_IMAGE = 2;
	public static final int EXTRA_ACTIONS = 3;
	
	private static ArrayList<Integer> odds = new ArrayList<Integer>();
	
	public static int giveEquipment(){
		odds.add(NUKE);
		odds.add(NUKE);
		odds.add(NUKE);
		odds.add(HEALTH_PACK);
		odds.add(HEALTH_PACK);
		odds.add(HEALTH_PACK);
		odds.add(SATELLITE_IMAGE);
		odds.add(SATELLITE_IMAGE);
		odds.add(SATELLITE_IMAGE);
		odds.add(EXTRA_ACTIONS);
		
		return odds.get((int)(Math.random()*odds.size()));
		
		
	}
	
}
