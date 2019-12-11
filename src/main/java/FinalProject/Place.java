package FinalProject;

import java.util.Date;

//Represents one place in a wish list of places to travel to.

public class Place  implements Comparable<Place>/* TODO make Place objects Comparable, so they can be sorted */  {

    private String name;// name of the place to visit
    private String reason;//reason for visiting
    private Date created;//date created

    Place(String name){
        this.name = name;
    }
    Place(String name, String reason, Date created){
        this.name = name;
        this.reason = reason;
        this.created =  created;
    }


    // The constructor can create and set the Date created.
    public Place(String name, String reason){
        this.name = name;
        this.reason = reason;
        this.created = new Date();

    }


    // create get and set methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    // returns all the information about this place
    @Override
    public String  toString(){
        return "Place to visit: " + name +". Reason: " + reason + ". Date created: " + created;
    }

    @Override
    public int compareTo(Place otherPlace){
        // as we are comparing only names, we need to do it alphabetically, and make them case insensative in the same line of code
        int compareInt = this.name.toLowerCase().compareTo(otherPlace.name.toLowerCase());

        return  compareInt;

    }

}