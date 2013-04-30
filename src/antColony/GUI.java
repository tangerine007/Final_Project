package antColony;


import javax.swing.JFrame; //imports JFrame library
import javax.swing.JButton; //imports JButton library
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.GridLayout; //imports GridLayout library
 
public class GUI {
 
        JFrame frame=new JFrame("ANT ANT ANT ANT ANT ANT ANT"); //creates frame
        JFrame countFrame = new JFrame("ant ant ant");
        JLabel finishedAnts;
        JLabel finishedAnts2;
        JLabel[][] grid; //names the grid of buttons
        Color antPresent = Color.red;
        Color antNotPresent = Color.white;
        Color foodCell = Color.green;
        Color textColor = Color.black;
        Color startCell = Color.CYAN;
//        Color backTrack = Color.YELLOW;
        Color obsticle = Color.black;
 
        public GUI(int width, int length){ //constructor
                frame.setLayout(new GridLayout(width,length)); //set layout
                countFrame.setLayout(new GridLayout(width,length)); //set layout
                finishedAnts = new JLabel("-----");
                finishedAnts2 = new JLabel("0");
                grid=new JLabel[width][length]; //allocate the size of grid
                for(int x=0; x<width; x++){
                        for(int y=0; y<length; y++){
                                grid[x][y]=new JLabel("1"); //creates new button  
                                grid[x][y].setOpaque(true);
                                grid[x][y].setBackground(antNotPresent);
                                grid[x][y].setForeground(textColor);
                                frame.add(grid[x][y]); //adds button to grid
                        }
                }
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           
                frame.pack(); //sets appropriate size for frame
                frame.setVisible(true); //makes frame visible
                
                countFrame.add(finishedAnts);
                countFrame.add(finishedAnts2);
                
                countFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                countFrame.pack(); //sets appropriate size for frame
                countFrame.setVisible(true); //makes frame visible
        }
        public void putAnt(int x, int y){
        	grid[x][y].setBackground(antPresent);
        	grid[x][y].updateUI();
        }
        public void removeAnt(int x, int y){
        	grid[x][y].setBackground(antNotPresent);
        	grid[x][y].updateUI();
        }
        public void makeFood(int x, int y){
        	grid[x][y].setBackground(foodCell);
        	grid[x][y].updateUI();
        }
        public void makeStart(int x, int y){
        	grid[x][y].setBackground(startCell);
        	grid[x][y].updateUI();
        }
/*        public void backTrack(int x, int y){
        	grid[x][y].setBackground(backTrack);
        	grid[x][y].updateUI();
        }
        */
        public void makeObsticle(int x, int y){
        	grid[x][y].setBackground(obsticle);
        	grid[x][y].updateUI();
        }
        public void decPheromone(int x, int y){
        	int pheromoneCount = Integer.parseInt(grid[x][y].getText());
        	grid[x][y].setText(String.valueOf(pheromoneCount-1));
        	grid[x][y].setBackground(Color.getHSBColor(60, pheromoneCount%100, 100));
        	if(pheromoneCount == 2) 
        		grid[x][y].setBackground(antNotPresent);
        	grid[x][y].updateUI();
        }
        public void incPheromone(int x, int y, int inc_in){
        	int pheromoneCount = Integer.parseInt(grid[x][y].getText());
        	grid[x][y].setText(String.valueOf(pheromoneCount+inc_in));
        	grid[x][y].setBackground(Color.getHSBColor(60, pheromoneCount, 100));
        	grid[x][y].updateUI();
        }
        public void incFinished(){
        	finishedAnts2.setText(String.valueOf(Integer.parseInt(finishedAnts2.getText())+1));
        	finishedAnts2.updateUI();
        }
        public void setFinished(int finished_in){
        	finishedAnts.setText("Best ant made the trip in "+String.valueOf(finished_in)+" moves!");
        	finishedAnts.updateUI();
        }


}