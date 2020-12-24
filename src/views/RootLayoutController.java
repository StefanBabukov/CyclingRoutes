package views;

import controllers.Controller;
import javafx.fxml.FXML;

public class RootLayoutController {
    private Controller mainController;
    
    public RootLayoutController() {
    }
    
    @FXML
    private void handleExit() {
        System.exit(0);
    }    
    
    @FXML
    private void handleListRoutes() {
    	//mainController.listRoutes();
    }  
    
    @FXML
    private void handleAddRoute() {
    	//mainController.addRouteForm();
    }	
    
    public void setMainController(Controller mainController) {
        this.mainController = mainController;
    }    
}
