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
		//drawNemo();
		//loop through the array if we reach the end
		int n = nemo.size();
		int currentIndex = index % n;
		clear();
		textSize(80);
		textAlign(CENTER);
		String Name = nemo.get(currentIndex).name;
		text(Name, 400, 80);

		//Print length amount of circles stacked on top of each other
		




		

	}
}
