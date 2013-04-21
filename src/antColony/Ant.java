package antColony;

import java.util.ArrayList;

public class Ant {

	ArrayList<Cell> path;
	Cell current;
	
	//CONSTRUCTORS
	public Ant(){
		current=null;
		path=new ArrayList<Cell>();
	}
	
	public Ant(Cell startLoc){
		path=new ArrayList<Cell>();
		current=startLoc;
		path.add(current);
	}
	
	//GET_METHODS
	public Cell getCurrent(){
		return current;
	}
	public ArrayList<Cell> getPath(){
		return path;
	}
	public Cell getPreviousCurrent(){
		return path.get(path.size()-2);
	}
	
	//SET_METHODS
	public void setLoc(Cell startLoc){
		current=startLoc;
		path.add(current);
	}

	//MUT_METHODS
	public void move(Cell newCell){
		current=newCell;
		path.add(current);
	}
	
	//sends ant home, returns the path the ant took
	public ArrayList<Cell> reset(Cell home){
		current=home;
		ArrayList<Cell> tempPath = path;
		path.clear();
		path.add(current);
		return tempPath;
	}
	//each movement of the ant on it's way home (used to place pheromones one by one)
	public Cell goHome(){
		return path.remove(path.size()-1);
	}
}
