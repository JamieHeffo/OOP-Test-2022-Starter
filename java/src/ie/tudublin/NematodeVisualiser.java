package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class NematodeVisualiser extends PApplet
{
	Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    int mode = 0;

    float[] lerpedBuffer;
    float y = 0;
    float smoothedY = 0;
    float smoothedAmplitude = 0;

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
		
		minim = new Minim(this);
        ap = minim.loadFile("bugz.mp3", 1024);
        ap.play();
        ab = ap.mix;
        colorMode(HSB);

        y = height / 2;
        smoothedY = y;

        lerpedBuffer = new float[width];
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
		int space = 50;

		//Iterate through arraylist the only way I know 
		for(int i = 0; i < nemo.get(currentIndex).length; i++){

			//Print length amount of circles stacked on top of each other
			noFill();
			stroke(255);
			strokeWeight(12);
			circle(400, 300 + (space * i), 50);

			//Print one limb either side of the circle for each nematode which has limbs
			if(nemo.get(currentIndex).limbs == 1){
				line(360, 300 + (space * i), 300, 300 + (space * i));
				line(440, 300 + (space * i), 500, 300 + (space * i));
			}

			//Gender of the nematode
			//Ran out of time but I totally could have finished this one :(
			String male = "m";
			String female = "f";
			String both = "h";
			String gender = nemo.get(currentIndex).gender;

			if(gender.compareTo(male) == 0){

			}
			else if(gender.compareTo(male) == 0){

			}
			else{

			}
			
			//Draw two lines and circles if value is 1 to give the lil dudes eyes
			if(nemo.get(currentIndex).eyes == 1){
				circle(350, 300 - (space), 30);
				circle(450, 300 - (space), 30);
				line(365, 300 - (space - 20), 380, 300 - (space - 40));
				line(435, 300 - (space - 20), 420, 300 - (space - 40));
			}

		}

		






		

	}
}
