package viewmodels;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.RouteStage;

public class RouteStageView {
    private StringProperty stageNumber;	
    private StringProperty endPoint;
    private StringProperty stageLength;
    private StringProperty routeId;    
    
    public RouteStageView(RouteStage stage) {
    	this.stageNumber = new SimpleStringProperty(Integer.toString(stage.getStageNumber()));     	
    	this.endPoint = new SimpleStringProperty(stage.getEndPoint());  
    	this.stageLength = new SimpleStringProperty(Float.toString(stage.getStageLength()));  
    	this.routeId = new SimpleStringProperty(Integer.toString(stage.getRouteId()));     	
    }
    
    public StringProperty getStageNumber() {
            return stageNumber;
    }    

    public StringProperty getEndPoint() {
            return endPoint;
    }

    public StringProperty getStageLength() {
            return stageLength;
    }

    public StringProperty getRouteId() {
            return routeId;
    }	
}
