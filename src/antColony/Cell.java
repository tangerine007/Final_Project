package antColony;

public class Cell {
	
	int pheromone;
	int cellType;//0=normal, 1=finish
	int[] loc;
	
	
	//CONSTRUCTORS
	public Cell(int[] loc_in){
		pheromone=0;
		loc= loc_in;
	}
	
	//GET_METHODS
	public int getPheromone(){
		return pheromone;
	}
	public int[] getLocation(){
		return loc;
	}
	
	//SET_METHODS
	
	//"MUTATE"_METHODS
	public void incPheromone(int inc_in){
		pheromone+=inc_in;
	}
	public void decPheromone(int dec_in){
		pheromone-=dec_in;
	}
}
