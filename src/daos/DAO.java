package daos;

import java.util.List;

import model.Route;
import model.RouteStage;

public abstract class DAO {
    public abstract void addRoute(Route route);
    public abstract void addStage(RouteStage stage);	
    public abstract Route getRoute(int routeId);
    public abstract List<Route> getRoutes();	
}
