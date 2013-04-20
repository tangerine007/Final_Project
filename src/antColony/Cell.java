package antColony;

public class Cell {
	
	int pheromone;
	int cellType;//0=normal, 1=finish
	int[] loc;
	
	
	//CONSTRUCTORS
	public Cell(int x, int y){
		pheromone=0;
		loc[0]=x;
		loc[1]=y;
	}
	
	//GET_METHODS
	public int getPheromone(){
		return pheromone;
	}
	public int[] getLocation(){
		return loc;
	}
	
	//SET_METHODS
	
	///MUT_METHODS
	public void incPheromone(int inc_in){
		pheromone+=inc_in;
	}
	public void decPheromone(int dec_in){
		pheromone-=dec_in;
	}
}
