package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;

public class Nematode {

    //Variables to store data of nematodes
    String name;
    float length;
    int limbs;
    String gender;
    int eyes;

    public Nematode(TableRow tr) {
        this(
            tr.getString("name"),
            tr.getFloat("length"),
            tr.getInt("limbs"),
            tr.getString("gender"),
            tr.getInt("eyes")
        );
    }

    //Constructor
    public Nematode(String name, float length, int limbs, String gender, int eyes) {
        this.name = name;
        this.length = length;
        this.limbs = limbs;
        this.gender = gender;
        this.eyes = eyes;
    }
    
    //Accessor Methods
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getLength() {
        return length;
    }
    public void setLength(float length) {
        this.length = length;
    }
    public int getLimbs() {
        return limbs;
    }
    public void setLimbs(int limbs) {
        this.limbs = limbs;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getEyes() {
        return eyes;
    }
    public void setEyes(int eyes) {
        this.eyes = eyes;
    }

    //Overwrite toString method
    @Override
    public String toString() {
        return "Name : " +name+" Eyes : " + eyes + " Gender : " + gender + " length : " + length + " limbs : " + limbs;
    }

    public void render(NematodeVisualiser pa){

        float x = pa.width / 2;
        float y = pa.height / 2;

        for(int i = 0; i < length; i++){
            //Print the name of the nematode
            pa.fill(255);
            pa.textSize(50);
            pa.textAlign(PApplet.CENTER, PApplet.CENTER);
            //pa.text(Nematod, pa.width / 2, pa.height - (pa.border * 0.5f));
        }
        

        //Draw length amount of circles stacked on top of each other
        pa.stroke(80);
        pa.noFill();
        pa.circle(x, y-100, 100);


    }
 
}//end class
