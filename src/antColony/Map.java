package antColony;

public class Map {
	
	Cell[][] map;
	Ant[] antList;
	//CONSTRUCTORS
	public Map(int width, int height, int antNum_in){//width=elements in each array, height=# of arrays
		createAntList(antNum_in);
		map=new Cell[width][height];
		Cell[] tempArray=new Cell[width];
		for(int i=0;i<height;i++){
			for(int j=0;i<width;i++){
				tempArray[j]=new Cell(2,3);
			}
			map[i]=tempArray;
		}
	}
	
	//HELPER_METHODS
	private void createAntList(int antNum){//creates a list of ants
		antList=new Ant[antNum];
		for(int i=0;i<antNum;i++){
			antList[i]=new Ant();
		}
	}
	
}
