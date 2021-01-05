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
        this.stageNumber = stageNumber;
    }    

    public String getEndPoint() {
        return this.endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public float getStageLength() {
        return this.stageLength;
    }

    public void setStageLength(float stageLength) {
        this.stageLength = stageLength;
    }    
    
    public int getRouteId() {
        return this.routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }       
    
    @Override
    public String toString() {
        return "\nStage number: " + Integer.toString(getStageNumber())+
                "\nEnd point: " + getEndPoint()+
                "\n Stage length: " + getStageLength()+
                "\n Route ID: " + getRouteId();
    }      
}
