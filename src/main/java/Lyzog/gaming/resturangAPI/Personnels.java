package Lyzog.gaming.resturangAPI;

import Lyzog.gaming.resturangAPI.Personnel;

import java.util.ArrayList;
import java.util.List;

public class Personnels {
    private List<Personnel> personnel;


    public Personnels(){
        this.personnel = new ArrayList<>();
        addMockData();
    }

    public void setPersonnel(List<Personnel> personnel) {
        this.personnel = personnel;
    }

    public List<Personnel> getPersonnel() {
        return personnel;
    }

    public List<Personnel> getPersonnelsBySearch(String searchString){

        if (searchString.equals(""))
            return personnel;


        ArrayList<Personnel> perss = new ArrayList<>();
        for (Personnel pers : personnel){
            if (pers.getName().toLowerCase().contains(searchString.toLowerCase()))
                perss.add(pers);
        }

        return perss;
    }

    public Personnel getPersonnel(String id){
        return findPersById(id);
    }

    public Personnel deletePers(String id){
        Personnel pers = findPersById(id);

        personnel.remove(pers);

        return pers;
    }

    public void addPers(Personnel pers){
        personnel.add(pers);
    }

    public void replacePersWithId(String id, Personnel newPers){
        Personnel oldPers = findPersById(id);

        personnel.remove(oldPers);

        newPers.setId(oldPers.getId());

        personnel.add(newPers);
    }

    private Personnel findPersById(String id){
        for (Personnel pers : personnel){
            if (pers.getId().equals(id))
                return pers;
        }
        return null;
    }

    private void  addMockData() {

        Personnel pers1 = new Personnel("0","daniel");
        Personnel pers2 = new Personnel("1","david");

        personnel.add(pers1);
        personnel.add(pers2);
    }
}
