package antColony;

public class Cell {
	
	int pheromone;
	int cellType;//0=normal, 1=finish
	int[] loc;
	
	
	//CONSTRUCTORS
	public Cell(int x, int y){
		pheromone=1;
		cellType=0;
		loc=new int[2];
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
	public int getType(){
		return cellType;
	}
	
	//SET_METHODS
	
	///MUT_METHODS
	public void incPheromone(int inc_in){
		pheromone+=inc_in;
	}
	public void decPheromone(int dec_in){
		pheromone-=dec_in;
	}
	public void makeFoodSource(){
		cellType=1;
	}
	public void makeNormalCell(){
		cellType=0;
	}
}
