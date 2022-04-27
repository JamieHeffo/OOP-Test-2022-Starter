package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet
{
	//ArrayList of Nematode Objects
	ArrayList<Nematode> nemo = new ArrayList<Nematode>();

	public float border;
	public int index;

	public void keyPressed()
	{		
		if (keyCode == LEFT)
		{
			index--;
		}	

		if (keyCode == RIGHT)
		{
			index++;
		}		
	}


	public void settings()
	{
		size(800, 800);
	}

	public void setup() 
	{
		colorMode(HSB);
		background(0);
		loadNematodes();
		printNematodes();
		smooth();	
		border = width * 0.1f;			
	}
	
	//Method to load nematodes and populate arraylist
	void loadNematodes()
	{
		//Create table of nematodes
		Table table = loadTable("nematodes.csv", "header");

		//Iterate through file and add to list
		for(TableRow r:table.rows()){

			Nematode n = new Nematode(r);
			nemo.add(n);

		}

	}

	void printNematodes(){
		for(Nematode n:nemo){
			System.out.println(n);
		}
	}
	
	public void draw()
	{	
		
		
		//loop through the array if we reach the end
		int n = nemo.size();
		int currentIndex = index % n;

		//clear canvas so nematodes arent cramped (they need space to breathe)
		clear();

		//Print nematode name
		textSize(80);
		textAlign(CENTER);
		String Name = nemo.get(currentIndex).name;
		text(Name, 400, 80);

		//Print length amount of circles stacked on top of each other
		int space = 50;
		for(int i = 0; i < nemo.get(currentIndex).length; i++){
			noFill();
			stroke(255);
			strokeWeight(12);
			circle(400, 300 + (space * i), 50);

			//Print one limb either side of the circle for each nematode which has limbs
			if(nemo.get(currentIndex).limbs == 1){
				line(360, 300 + (space * i), 300, 300 + (space * i));
				line(440, 300 + (space * i), 500, 300 + (space * i));
			}

			
		}

		






		

	}
}
