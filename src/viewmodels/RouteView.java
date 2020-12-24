package viewmodels;

import java.util.List;
import java.util.stream.Collectors;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Route;

public class RouteView {
    private StringProperty id;
    private StringProperty routeTitle;
    private StringProperty departurePoint;
    private List<RouteStageView> routeStages;
      
    public RouteView(Route route) {
    	this.id = new SimpleStringProperty(Integer.toString(route.getId()));
    	this.routeTitle = new SimpleStringProperty(route.getRouteTitle());
    	this.departurePoint = new SimpleStringProperty(route.getDeparturePoint());
    	this.routeStages = route.getRouteStages().stream().map(s -> new RouteStageView(s)).collect(Collectors.toList());
    }

    public StringProperty getId() {
            return id;
    }

    public StringProperty getRouteTitle() {
            return routeTitle;
    }

    public StringProperty getDeparturePoint() {
            return departurePoint;
    }

    public List<RouteStageView> getRouteStages() {
            return routeStages;
    }
}
