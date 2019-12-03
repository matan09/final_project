package FinalProject;

// * Represents one place in a wish list of places to travel to.
// */
// A place object will need three private fields, with these names:
//    *    name: A String for the place name (for example, Hawaii)
//    *    reason: A String reason (a reason for visiting, for example, to go surfing)
//created: A Date created (when the Place object was created.

import java.util.Date;

public class Place implements Comparable<Place>{
    private String name;
    private String reason;
    private Date created;

//constructor that takes two arguments,
//    * the name, and the reason.
//    * The constructor can create and set the Date created.
public Place(String name, String reason){
        this.name = name;
        this.reason = reason;
        this.created = new Date();

}


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


@Override
public int compareTo(Place otherPlace) {
// as we are comparing only names, we need to do it alphabetically, and make them case insensative in the same line of code
        int compareInt = this.name.toLowerCase().compareTo(otherPlace.name.toLowerCase());

        return  compareInt;
}
}
