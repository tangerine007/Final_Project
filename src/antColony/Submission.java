package antColony;

public class Submission {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long beforeTime = System.currentTimeMillis();
		
		
		////////////////////BELOW_HERE_IS_TIMED////////////////////////////////////
		//max map is around 4500000 which takes ~1000 ms to populate. sqrt(4500000)~2121
		//worst case scenario is ~10000 ms which occurs when # of food sources is very close to # of cells in map
		int x=100;
		int y=100;
		Map map=new Map(x,y,1);//creates a map width=5, height=6, w/ 1 food source
		map.antColony(1,1,map.getRandomCell());//runs ant colony optimization on this map using one ant (goes to finish and comes back one time)
		////////////////////ABOVE_HERE_IS_TIMED////////////////////////////////////
		
		
		long afterTime = System.currentTimeMillis();
		long performance = afterTime-beforeTime;
		System.out.println(performance);
	}

}
