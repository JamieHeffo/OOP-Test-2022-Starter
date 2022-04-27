package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet
{
	//ArrayList of Nematode Objects
	ArrayList<Nematode> nemo = new ArrayList<Nematode>();

	public void keyPressed()
	{		
		if (keyCode == LEFT)
		{
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
		smooth();				
	}
	

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


	public void draw()
	{	
		loadNematodes();
	}
}
