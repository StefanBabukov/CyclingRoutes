package daos;
import java.sql.*;
import java.util.ArrayList;
import model.Route;
import model.RouteStage;
import java.util.List;
/**
 *
 * @author Stefan Babukov 
 */
public class SQLDAO extends DAO {
    static private String userName = "user";
    static private String password = "userpass";
    static private String url = "jdbc:mysql://localhost:3306/routes";
    static private Connection connection = null;
    static private Statement stmt = null;
    static private ResultSet rs = null; 
    public SQLDAO(){
        try {
            connection =
            DriverManager.getConnection(url, userName, password);
            stmt = connection.createStatement();
            System.out.println("Connected to database");
        } catch (SQLException ex) { System.out.println(ex);} 
    }
    
    @Override
    public List<Route> getRoutes(){
        List <Route> routesList = new ArrayList<>();
        try{
            String queryString = "SELECT * FROM ROUTE ORDER BY ROUTEID";
            rs = stmt.executeQuery(queryString);
            while(rs.next()){
                int routeId = rs.getInt("ROUTEID");
                String routeTitle = rs.getString("ROUTETITLE");
                String departurePoint = rs.getString("DEPARTUREPOINT");

                Route route = new Route(routeId, routeTitle, departurePoint);
                List <RouteStage> stageList = new ArrayList<>();

                queryString = "SELECT STAGEID, STAGENUMBER, ENDPOINT, "
                        + "STAGELENGTH FROM STAGE WHERE ROUTEID = " + routeId;
                Statement stmt2 = connection.createStatement();
                ResultSet rs2 = stmt2.executeQuery(queryString);
                while(rs2.next()){
                    int stageNumber = rs2.getInt("STAGENUMBER");
                    String endpoint = rs2.getString("ENDPOINT");
                    float stageLength = rs2.getFloat("STAGELENGTH");
                    RouteStage stage = new RouteStage(stageNumber, endpoint, stageLength, routeId);
                    stageList.add(stage);
                }
                route.setRouteStages(stageList);
                routesList.add(route);
            }
    }catch(SQLException ex) {}
    return routesList;
    }
    
    @Override
    public Route getRoute(int id){
        String queryString = "SELECT * FROM ROUTE WHERE ROUTEID = "+id;
        Route route = null;
        try{
            rs = stmt.executeQuery(queryString);
            while(rs.next()){
                //getting the route
                String routeTitle = rs.getString("ROUTETITLE");
                String departurePoint = rs.getString("DEPARTUREPOINT");
                route = new Route(id, routeTitle, departurePoint);
                System.out.println(departurePoint);
                System.out.println(route.getDeparturePoint());
                //getting the stages of the route
                
                queryString = "SELECT * FROM STAGE WHERE ROUTEID = "+id;
                Statement stmt2 = connection.createStatement();
                ResultSet rs2 =  stmt2.executeQuery(queryString);
                List<RouteStage> stageList = new ArrayList<>();
                while(rs2.next()){
                    int stageNumber = rs2.getInt("STAGENUMBER");
                    String endpoint = rs2.getString("ENDPOINT");
                    float stageLength = rs2.getFloat("STAGELENGTH");
                    RouteStage stage = new RouteStage(stageNumber, endpoint, stageLength, id);
                    stageList.add(stage);
                }
                route.setRouteStages(stageList);
            }
        }catch(SQLException ex) {}
        return route;
    }
    
    @Override
    public void addStage(RouteStage stage){
        String queryString = "INSERT INTO STAGE (STAGENUMBER, ENDPOINT, STAGELENGTH, ROUTEID)"
                + "VALUES ("+Integer.toString(stage.getStageNumber())+",'"+stage.getEndPoint()+" ',' "
                + Float.toString(stage.getStageLength()) + "',"+Integer.toString(stage.getRouteId())+")";
        try{
            stmt.executeUpdate(queryString);
        }catch(SQLException ex){}
    }
    
    @Override
    public void addRoute(Route route){
        String queryString = "INSERT INTO ROUTE (ROUTETITLE, DEPARTUREPOINT) VALUES ("
               +"'"+ route.getRouteTitle() +" ',' "+ route.getDeparturePoint() +"')";
        try{
            stmt.executeUpdate(queryString);
        }catch(SQLException ex){}
    }
}
