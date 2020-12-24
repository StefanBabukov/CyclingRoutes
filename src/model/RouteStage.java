package model;

public class RouteStage {
    private int stageNumber;
    private String endPoint;
    private float stageLength;
    private int routeId;

    public RouteStage() {
        this.stageNumber = -1;
        this.endPoint = "Unknown";
        this.stageLength = 0.0f;
        this.routeId = 0;
    } 

    public RouteStage(int stageNumber, String endPoint, float stageLength, int routeId) {
    	this.stageNumber = stageNumber;    	
        this.endPoint = endPoint;
        this.stageLength = stageLength;
        this.routeId = routeId;        
    }
    
    public int getStageNumber() {
        return stageNumber;
    }

    public void setStageNumber(int stageNumber) {
        // Complete this method
    }    

    public String getEndPoint() {
        // Complete this method
        return null;
    }

    public void setEndPoint(String endPoint) {
        // Complete this method
    }

    public float getStageLength() {
        // Complete this method
        return 0.0f;
    }

    public void setStageLength(float stageLength) {
        // Complete this method
    }    
    
    public int getRouteId() {
        // Complete this method
        return 0;
    }

    public void setRouteId(int routeId) {
        // Complete this method
    }       
    
    @Override
    public String toString() {
        // Complete this method
        return null;
    }      
}
