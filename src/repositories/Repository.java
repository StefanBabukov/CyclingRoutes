package repositories;

import daos.DAO;
import daos.TestDAO;
import daos.SQLDAO;
import java.util.List;
import model.Route;
import model.RouteStage;

public class Repository {
    private DAO dao;
	
    public Repository() { 
    	dao = new SQLDAO (); 
    }
    
    public List<Route> getItems() {   
        return dao.getRoutes();
    }
    
    public void addRoute(Route item) {
        dao.addRoute(item);
    }
    
    public void addStage(RouteStage newStage) {
    	dao.addStage(newStage);
    }      
    
    public Route getItem(int id) {
        return dao.getRoute(id);
    }
    
    @Override
    public String toString() {
        return "\nItems: " + getItems();
    }       
}
