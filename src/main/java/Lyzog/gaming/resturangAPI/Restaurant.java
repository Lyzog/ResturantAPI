package Lyzog.gaming.resturangAPI;

import java.util.ArrayList;

public class Restaurant {

    private String id;
    private String name;
    private Personnels personnels = new Personnels();

    public Restaurant(){}

    public Restaurant(String id, String name){
        this.id = id;
        this.name = name;
      //  this.personnel = personnel;
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public Personnels getPersonnels(){
        return personnels;
    }




    public void setId(String id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPersonnels(Personnels personnels){
        this.personnels = personnels;
    }
}
