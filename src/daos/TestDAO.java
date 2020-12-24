package daos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Route;
import model.RouteStage;

public class TestDAO extends DAO {
	List<Route> routesList;
        
    public TestDAO() {
        routesList = new ArrayList<>();
        Route route = new Route(1, "Oor Wullie Route", "GCU");
        List<RouteStage> routeStages = new ArrayList<>();        
        RouteStage stage = new RouteStage(1, "City Chambers", 0.75f, 1);
        routeStages.add(stage);
        stage = new RouteStage(2, "Sir Chris Hoy Velodrome", 3.8f, 1);
        routeStages.add(stage);
        stage = new RouteStage(3, "People's Palace", 2.7f, 1);
        routeStages.add(stage);
        stage = new RouteStage(4, "Riverside Museum", 5.4f, 1);
        routeStages.add(stage);
        stage = new RouteStage(5, "Botanic Gardens", 2.4f, 1);
        routeStages.add(stage);
        stage = new RouteStage(6, "GCU", 3.4f, 1);
        routeStages.add(stage);      
    	route.setRouteStages(routeStages);
        routesList.add(route);
        route = new Route(2, "Religious Route", "Glasgow Cathedral");
        routeStages = new ArrayList<>();        
        stage = new RouteStage(1, "St Andrew's Cathedral", 1.8f, 2);
        routeStages.add(stage);
        stage = new RouteStage(2, "Central Mosque", 0.75f, 2);
        routeStages.add(stage);
        stage = new RouteStage(3, "University Chapel", 5.4f, 2);
        routeStages.add(stage);
        stage = new RouteStage(4, "Om Hindu Mandir", 1.3f, 2);
        routeStages.add(stage);
        stage = new RouteStage(5, "Gurdwara Singh Sabha", 0.6f, 2);
        routeStages.add(stage);
        stage = new RouteStage(6, "Quaker Meeting House", 1.2f, 2);
        routeStages.add(stage);      
        stage = new RouteStage(7, "Glasgow Buddhist Centre", 0.35f, 2);
        routeStages.add(stage);
        stage = new RouteStage(8, "Garnethill Synagogue", 0.45f, 2);
        routeStages.add(stage);
        stage = new RouteStage(9, "Glasgow Cathderal", 3.3f, 2);
        routeStages.add(stage);          
    	route.setRouteStages(routeStages);
        routesList.add(route);
        route = new Route(3, "Art Route", "Kelvingrove Art Gallery and Museum");
        routeStages = new ArrayList<>();        
        stage = new RouteStage(1, "Hunterian Art Gallery", 1.2f, 3);
        routeStages.add(stage);
        stage = new RouteStage(2, "MacKintosh Building", 2.2f, 3);
        routeStages.add(stage);
        stage = new RouteStage(3, "Gallery Of Modern Art", 1.4f, 3);
        routeStages.add(stage);
        stage = new RouteStage(4, "St. Mungo Museum Of Religious Life & Art", 1.3f, 3);
        routeStages.add(stage);
        stage = new RouteStage(5, "People's Palace", 2.0f, 3);
        routeStages.add(stage);
        stage = new RouteStage(6, "The Burrell Collection", 7.1f, 3);
        routeStages.add(stage);      
        stage = new RouteStage(7, "House For An Art Lover", 2.8f, 3);
        routeStages.add(stage);
        stage = new RouteStage(8, "Kelvingrove Art Gallery and Museum", 5.0f, 3);
        routeStages.add(stage);         
    	route.setRouteStages(routeStages);
        routesList.add(route);
        route = new Route(4, "Education Route", "GCU");
        routeStages = new ArrayList<>();        
        stage = new RouteStage(1, "University Of Strathclyde", 0.65f, 4);
        routeStages.add(stage);
        stage = new RouteStage(2, "City Of Glasgow College - Riverside Campus", 1.4f, 4);
        routeStages.add(stage);
        stage = new RouteStage(3, "School of Simulation and Visualisation", 3.9f, 4);
        routeStages.add(stage);
        stage = new RouteStage(4, "Glasgow Science Centre", 0.7f, 4);
        routeStages.add(stage);
        stage = new RouteStage(5, "University of Glasgow", 2.4f, 4);
        routeStages.add(stage);
        stage = new RouteStage(6, "The Mitchell Library", 1.9f, 4);
        routeStages.add(stage);      
        stage = new RouteStage(7, "Glasgow School Of Art", 0.9f, 4);
        routeStages.add(stage);
        stage = new RouteStage(8, "Royal Conservatoire Of Scotland", 0.75f, 4);
        routeStages.add(stage);
        stage = new RouteStage(9, "GCU", 0.6f, 4);
        routeStages.add(stage);          
    	route.setRouteStages(routeStages);
        routesList.add(route);        
    }
    
    @Override
    public List<Route> getRoutes() {
        return routesList;
    }
    
    @Override
    public Route getRoute(int routeId) {
        Iterator<Route> it = routesList.iterator();
        while (it.hasNext()) {
            Route route = (Route) it.next();            
            if (route.getId() == routeId) {
                return route;
            }
        }    	
        return null;
    }
    
    @Override
    public void addRoute(Route route) {
    	routesList.add(route);
    }
    
    @Override
    public void addStage(RouteStage stage) {
        Iterator<Route> it = routesList.iterator();
        while (it.hasNext()) {
            Route route = (Route) it.next();            
            if (route.getId() == stage.getRouteId()) {
            	route.addStageToRoute(stage);
            }
        }    	
    }  
}
