package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;

public class Nematode {

    //Variables to store data of nematodes
    private String name;
    private float length;
    private int limbs;
    private String gender;
    private String eyes;

    public Nematode(TableRow tr) {
        this(
            tr.getString("name"),
            tr.getFloat("length"),
            tr.getInt("limbs"),
            tr.getString("gender"),
            tr.getString("eyes")
        );
    }

    //Constructor
    public Nematode(String name, float length, int limbs, String gender, String eyes) {
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
    public String getEyes() {
        return eyes;
    }
    public void setEyes(String eyes) {
        this.eyes = eyes;
    }

    //Overwrite toString method
    @Override
    public String toString() {
        return "Nematode Eyes : " + eyes + " Gender : " + gender + " length : " + length + " limbs : " + limbs + " name : "
                + name;
    }
 
}//end class
