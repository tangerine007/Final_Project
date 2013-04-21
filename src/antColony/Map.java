package antColony;

import java.util.ArrayList;

public class Map {
	
	Cell[][] map;
	ArrayList<Ant> antList;
	int antMax;
	int width;
	int height;
	
	//CONSTRUCTORS
	public Map(int width_in, int height_in,int foodSource_in){//width=elements in each array, height=# of arrays
		width=width_in;
		height=height_in;
		antList=new ArrayList<Ant>();
		map=new Cell[height][width];
		Cell[] tempArray=new Cell[width];
		for(int i=0;i<map.length;i++){
			tempArray=new Cell[width];
			for(int j=0;j<map[i].length;j++){
				tempArray[j]=new Cell(j,i);
			}
			map[i]=tempArray;
		}
		int foodNum=0;
		if(width*height<foodSource_in){
			System.out.println("REMAKE MAP, TOO MANY FOOD SOURCES SPECIFIED!");
		}else{
			while(foodNum<foodSource_in){
				Cell tempCell=getRandomCell();
				
				if(tempCell.getType()==0){
					foodNum++;
					tempCell.makeFoodSource();
				}
			}
		}
	}
	
	//GET_METHODS
	public Cell getRandomCell(){
		return map[(int) (Math.random()*(height-1))][(int) (Math.random()*(width-1))];
	}
	
	//RUN_THIS_BITCH_METHODS
	public void antColony(int antMax_in,int antRelease_in,Cell start){
		antMax=antMax_in;//number of ants in the system
		int antRelease=antRelease_in;//how many moves do you want to go through before you release another ant
		int releaseCounter=0;
		int finishedAnts=0;
		if(antMax>=1){
			Ant tempAnt= new Ant(start);
			antList.add(tempAnt);
			while(finishedAnts<=antMax){
				//releases new ants into map based on counter specified
				releaseCounter++;
				if(releaseCounter>antRelease){
					antList.add(new Ant(start));
					releaseCounter=0;
				}
				moveAnts();//moves all active ants (finished ants release Pheromones on path taken)
			}
		}else{
			System.out.println("One or more ants must be chosen to be in system!");
		}
		
	}
	//HELPER_METHOD
	private void moveAnts(){
		int[] lastMove = new int[2];
		ArrayList<Cell> possibleMoves=new ArrayList<Cell>();
		for(Ant ant:antList){
			//current position - position before previous = previous direction e.g. [1,1]-[0,0]=[1,1] (came from southWest)
			if(ant.getPath().size()<2){
				//populate possible moves with 8 adjacent cells if they are on the map
				//randomly select one with pheromones taken into concideration
			}else{
				lastMove[0]=ant.getCurrent().getLocation()[0]-ant.getPreviousCurrent().getLocation()[0];
				lastMove[1]=ant.getCurrent().getLocation()[1]-ant.getPreviousCurrent().getLocation()[1];
				//if proceeding in the same direction will put the ant out of bounds...
				if(ant.getCurrent().getLocation()[0]+lastMove[0]<0 || ant.getCurrent().getLocation()[1]+lastMove[1]<0 || ant.getCurrent().getLocation()[0]+lastMove[0]>width || ant.getCurrent().getLocation()[1]+lastMove[1]>height){
					//ant dies? (remove ant)
					//ant reverses direction and goes in that direction? (some corner cases will result in infinite loop)
				//ignore the middle case and look at the side cases, choose between them. If none are acceptable then reverse direction.	
				}else{
					//populate possible moves with 3 adjacent cells in direction you are going in if they are on the ap
					//randomly select one with pheromones taken into concideration
				}
			}
		}
	}
	private void releasePheromones(){
		
	}
}
