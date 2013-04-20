package antColony;

import java.util.ArrayList;

public class Map {
	
	Cell[][] map;
	ArrayList<Ant> antList;
	int antMax;
	
	//CONSTRUCTORS
	public Map(int width, int height){//width=elements in each array, height=# of arrays
		antList=new ArrayList<Ant>();
		map=new Cell[width][height];
		Cell[] tempArray=new Cell[width];
		for(int i=0;i<height;i++){
			for(int j=0;i<width;i++){
				tempArray[j]=new Cell(2,3);
			}
			map[i]=tempArray;
		}
	}
	
	//RUN_THIS_BITCH_METHODS
	public void antColony(int antNum){
		antMax=antNum;
		/*

		 */
	}
	//HELPER_METHOD
	private void moveAnts(){
		for(Ant ant:antList){
			
		}
	}
}
