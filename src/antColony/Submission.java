package antColony;

public class Submission {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long beforeTime = System.currentTimeMillis();
		////////////////////BELOW_HERE_IS_TIMED////////////////////////////////////
		/////////////*~*~*~*~*~*~*VARIABLES*~*~*~*~*~*~*///////////////////////////

		//MAP_INFO - info about spawning the map
			//max map is around 4500000 which takes ~1000 ms to populate. sqrt(4500000)~2121
			//worst case scenario is ~10000 ms which occurs when # of food sources is very close to # of cells in map
			int mapWidth=80;//the map will be populated with this many cells on the X-axis
			int mapHeight=40;//the map will be populated with this many cells on the Y-axis
			int foodSources=1;//number of food sources on the map (must be less than available spaces on map)
		
		//COLONY_INFO - info about the way that the algorithm operates
			//start_location - where the ants will start their journey from
				int startX=(int) Math.floor(mapWidth/2);//the X-axis location of start
				int startY=(int) Math.floor(mapHeight/2);//the Y-axis location of start
				//****SET ONE OR BOTH TO 0 to have a randomly generated cell selected***//
				//****VALUES CANNOT LIE ON THE "EDGE" OF THE MAP***//
			int terminateValue=1000;//how many ants need to retrieve food and come back before algorithm is terminated
			int releaseValue=0;//After how many "time periods"/"moves" should another ant be released onto the map
			int pheromoneRelease=5;//On its way back to the colony, how many pheromones does an ant release in each cell
			int specialAntMultiplier=10;//multiplies the number of pheromones released by this value for ants that make a shorter trip
			int antColonySize=10;//The ant colony consists of this many ants, once this only this many ants can exist in the system at one time
			
		//GUI_CONTROL
			int delay=50;//number of miliseconds between each antMove();
		///////////////*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*/////////////////////////////

			
			
			
	
			
			
			
		Map map=new Map(mapWidth,mapHeight,foodSources);//creates the map
		Cell start= map.getCell(startX, startY); //random Cell = map.getRandomCell();
		//makes sure that the start location is not on the edge of the map (simplifies the movement of the ants)
		while(start.getLocation()[0]==0 || start.getLocation()[1]==0 || start.getLocation()[0]==mapWidth-1 || start.getLocation()[1]==mapHeight-1){
			start = map.getRandomCell();
		}
		//runs ant colony optimization on this map for a certain number of runs, which is later averaged out
		
	
		map.antColony(terminateValue,releaseValue,start,pheromoneRelease,antColonySize,specialAntMultiplier,delay);//runs the ant colony optimization algorithm for given parameters

		System.out.println("<<"+terminateValue+">>"+" ants have brought food back to the colony!");
		System.out.println("A total of <<"+map.getAntCounter()+">> ants have left the colony to search for food!");
		System.out.println("The best ant took <<"+map.getBestAntMovements()+">> moves to find the food!");

		////////////////////ABOVE_HERE_IS_TIMED////////////////////////////////////
		long afterTime = System.currentTimeMillis();
		long performance = (afterTime-beforeTime);
		System.out.println(performance);
		
	}

}
