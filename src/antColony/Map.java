package antColony;

import java.util.ArrayList;

public class Map {
	
	Cell[][] map;
	ArrayList<Ant> antList;
	ArrayList<Ant> finishedAnts;
	int antMax;
	int width;
	int height;
	
	//CONSTRUCTORS
	public Map(int width_in, int height_in,int foodSource_in){//width=elements in each array, height=# of arrays
		width=width_in;
		height=height_in;
		antList=new ArrayList<Ant>();
		finishedAnts=new ArrayList<Ant>();
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
		int finishedAnts=0;//counts the number of ants who have completed their journey
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
				finishedAnts+=moveAnts();//moves all active ants (adds the number of finished ants to the "finishedAnts" counter)
				if(finishedAnts<=antMax){
					//PSUEDO_CODE
						//ADD helper method for removing pheromones from the map
							//->Maybe just go through the entire map and remove 1 pheromone from every cell that has at least one in it
						//ADD helper method for going through the "finishedAnts[]" ArrayList and adding pheromones to the appropriate cells
					//END_PSUEDO_CODE
				}
			}
		}else{
			System.out.println("One or more ants must be chosen to be in system!");
		}
		
	}
	//HELPER_METHOD
	private int moveAnts(){//moves ants, returns an int which is the number of ants who have found a food source
		int[] lastMove = new int[2];
		int[] currentLoc = new int[2];
		ArrayList<Cell> possibleMoves=new ArrayList<Cell>();
		ArrayList<Ant> tempFinishedAnts=new ArrayList<Ant>();
		int tempFinishedAntsSize=0;
		//***MIGHT NEED TO CHECK WHICH ONES ARE Y-AXIS AND X-AXIS IN MAP AND IN "lastMove[]"***//
		for(Ant ant:antList){
			//previous direction "lastMove[]" = current position - position before previous e.g. [1,1]-[0,0]=[1,1] (came from southWest)
			currentLoc[0]=ant.getCurrent().getLocation()[0];
			currentLoc[1]=ant.getCurrent().getLocation()[1];
			if(ant.getPath().size()<2){
				possibleMoves.add(map[currentLoc[1]+1][currentLoc[0]]);//N
				possibleMoves.add(map[currentLoc[1]-1][currentLoc[0]]);//S
				possibleMoves.add(map[currentLoc[1]][currentLoc[0]-1]);//W
				possibleMoves.add(map[currentLoc[1]][currentLoc[0]+1]);//E
				possibleMoves.add(map[currentLoc[1]-1][currentLoc[0]-1]);//SW
				possibleMoves.add(map[currentLoc[1]-1][currentLoc[0]+1]);//SE
				possibleMoves.add(map[currentLoc[1]+1][currentLoc[0]-1]);//NW
				possibleMoves.add(map[currentLoc[1]+1][currentLoc[0]+1]);//NE
			}else{
				lastMove[0]=ant.getCurrent().getLocation()[0]-ant.getPreviousCurrent().getLocation()[0];
				lastMove[1]=ant.getCurrent().getLocation()[1]-ant.getPreviousCurrent().getLocation()[1];
				//if proceeding in the same direction will put the ant out of bounds...
				if(currentLoc[0]+lastMove[0]<0 || currentLoc[1]+lastMove[1]<0 || currentLoc[0]+lastMove[0]>width-1 || currentLoc[1]+lastMove[1]>height-1){
					//PSUEDO_CODE
						//ignore the middle case and look at the side cases, choose between them. If none are acceptable then reverse direction.
					//END_PSUEDO_CODE
					possibleMoves.add(map[currentLoc[1]-lastMove[1]][currentLoc[0]-lastMove[0]]);
					//PSUEDO-REPLACE WITH THIS POLICY ->ignore the middle case and look at the side cases, choose between them. If none are acceptable then reverse direction.
				}else{
					//populate possible moves with 3 adjacent cells in direction you are going in if they are on the ap
					//randomly select one with pheromones taken into concideration
					if(lastMove[0]==0){//if the last move came from up or down
						possibleMoves.add(map[currentLoc[1]+lastMove[1]][currentLoc[0]]);//continueing along the same direction
						possibleMoves.add(map[currentLoc[1]+lastMove[1]][currentLoc[0]+1]);//changing the x-coordinate cell left
						possibleMoves.add(map[currentLoc[1]+lastMove[1]][currentLoc[0]-1]);//changing the x-coordinate cell right
					}else if(lastMove[1]==0){//if the last move came from left or right
						possibleMoves.add(map[currentLoc[1]][currentLoc[0]+lastMove[0]]);//continueing along the same direction
						possibleMoves.add(map[currentLoc[1]+1][currentLoc[0]+lastMove[0]]);//changing the x-coordinate cell left
						possibleMoves.add(map[currentLoc[1]-1][currentLoc[0]+lastMove[0]]);//changing the x-coordinate cell right
					}else{//if the last move came from a diagonal
						possibleMoves.add(map[currentLoc[1]+lastMove[1]][currentLoc[0]+lastMove[0]]);//continueing along the same diagonal
						possibleMoves.add(map[currentLoc[1]][currentLoc[0]+lastMove[0]]);//changing the x-coordinate cell
						possibleMoves.add(map[currentLoc[1]+lastMove[1]][currentLoc[0]]);//changing the y-coordinate cell
					}
				}
			}
			//PSUEDO_CODE
				//RANDOMLY CHOOSE CELL FROM "possibleMoves[]" TAKING PHEROMONES INTO CONCIDERATION
					//->This may require an additional array for normalizing the values and choosing from the cells
			//END_PSUEDO_CODE
			
			//TEST_MOVE//
			ant.move(possibleMoves.get((int) (Math.random()*possibleMoves.size())));
			if(ant.getCurrent().getType()==1){
				tempFinishedAnts.add(ant);
			}
			possibleMoves.clear();
		}
		antList.removeAll(tempFinishedAnts);
		tempFinishedAntsSize=tempFinishedAnts.size();
		finishedAnts.addAll(tempFinishedAnts);
		return tempFinishedAntsSize;
	}
	private void releasePheromones(){
		
	}
}
