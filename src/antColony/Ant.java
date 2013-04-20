package antColony;

public class Ant {

	Cell[] path;
	Cell current;
	boolean active;
	
	//CONSTRUCTORS
	public Ant(){
		current=null;
	}
	
	public Ant(Cell startLoc){
		current=startLoc;
		
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
	public void setLoc(Cell startLoc){
		current=startLoc;
		
		path=new Cell[1];
		path[0]=current;
	}

	//MUT_METHODS
	public void move(Cell newCell){
		current=newCell;
		//can optimize this
		Cell[] temp=path;
		path=new Cell[temp.length+1];
		for(int i=0;i<temp.length;i++){
			path[i]=temp[i];
		}
		path[temp.length]=current;
	}
}
