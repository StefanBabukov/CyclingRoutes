package model;

import java.util.ArrayList;
import java.util.List;

public class Route {
    private final int id;
    private String routeTitle;
    private String departurePoint;
    private List<RouteStage> routeStages;
    
    public static int lastIdAllocated = 0;
    
    public Route() {
        this.id = ++lastIdAllocated;
        this.routeTitle = "Unknown";
        this.departurePoint = "Unknown";        
        this.routeStages = new ArrayList<>();
    }
    
    public Route(String routeTitle, String departurePoint) {
        this.id = ++lastIdAllocated;
        this.routeTitle = routeTitle;
        this.departurePoint = departurePoint;        
        this.routeStages = new ArrayList<>();
    }
    
    public Route(int id, String routeTitle, String departurePoint) {
        this.id = id;
        this.routeTitle = routeTitle;
        this.departurePoint = departurePoint;
        this.routeStages = new ArrayList<>();
        if (id > lastIdAllocated)
            lastIdAllocated = id;
    }
    
    public Route(int id, String routeTitle, String departurePoint, List<RouteStage> routeStages) {
        this.id = id;
        this.routeTitle = routeTitle;
        this.departurePoint = departurePoint;  
        this.routeStages = routeStages;
        if (id > lastIdAllocated)
            lastIdAllocated = id;        
    }    
        
    public int getId() {
        return this.id;
    }
    
    public String getRouteTitle() {
        return this.routeTitle;
    }
    
    public void setRouteTitle(String routeTitle) {
        // Complete this method
    }
    
    public String getDeparturePoint() {
        // Complete this method
        return null;
    }
    
    public void setDeparturePoint(String departurePoint) {
        // Complete this method
    }    
    
    public List<RouteStage> getRouteStages() {
        // Complete this method
        return null;
    }
    
    public void setRouteStages(List<RouteStage> routeStages) {
        // Complete this method
    }
    
    public void addStageToRoute(RouteStage stage) {
        // Complete this method
    }
    
    public int getLastStageNumber() {
        int lastStageNumber = 0;
        for (RouteStage stage:this.routeStages)
            if (stage.getStageNumber() > lastStageNumber)
                lastStageNumber = stage.getStageNumber();
        return lastStageNumber;
    }
   
    @Override
    public String toString() {
        // Complete this method
        return null;
    }
}
