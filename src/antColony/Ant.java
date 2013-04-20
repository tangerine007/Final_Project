package antColony;

public class Ant {

	Cell[] path;
	Cell current;
	
	//CONSTRUCTORS
	public Ant(Cell start){
		current=start;
		
		path=new Cell[1];
		path[0]=current;
	}
	
	//GET_METHODS
	public Cell getCurrent(){
		return current;
	}
	public Cell[] getPath(){
		return path;
	}
	
	//SET_METHODS
	public void move(){
		//ant colony optimization algorithm goes here
		//modify current cell
		//expand path and add current cell to path
	}
}
