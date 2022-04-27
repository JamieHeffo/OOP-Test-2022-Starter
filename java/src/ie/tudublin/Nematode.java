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
 
}//end class
