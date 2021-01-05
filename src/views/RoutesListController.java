package views;

import controllers.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import viewmodels.RouteView;
import viewmodels.RouteStageView;
/**
 *
 * @author grasp6
 */
public class RoutesListController {
    @FXML
    private TableView<RouteView> routes;
    @FXML
    private TableColumn<RouteView, String> id;
    @FXML
    private TableColumn<RouteView, String> routeTitleColumn;
    @FXML
    private TableColumn<RouteView, String> departurePointColumn;
    @FXML
    private TableView<RouteStageView> stages;    
    @FXML
    private TableColumn<RouteStageView, String> stageNumberColumn;
    @FXML
    private TableColumn<RouteView, String> endPointColumn;    
    @FXML
    private TableColumn<RouteView, String> stageLengthColumn;    
 	
    private Controller mainController;
    
    public void setMainController(Controller mainController, ObservableList<RouteView> routeData) {
        this.mainController = mainController;
        // Add observable list data to the table
        routes.setItems(routeData);
        routes.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);        
        ObservableList<RouteStageView> routeStageData = FXCollections.observableArrayList();         
        routeStageData.setAll(routeData.get(0).getRouteStages());
        stages.setItems(routeStageData);
        stages.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);         
    }    
}
