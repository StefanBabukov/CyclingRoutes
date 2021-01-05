package controllers;

import app.CyclingRoutesApp;
import java.util.ArrayList;
import java.util.List;
import repositories.Repository;
import model.*;
import helpers.InputHelper;
import java.io.IOException;
import java.util.stream.Collectors;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane; 
import javafx.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import views.*;
import viewmodels.*;

public class Controller {
    private Repository repository;
    private InputHelper helper;
    private Stage primaryStage;
    private BorderPane rootLayout;        
    
    /*public Controller() {
        repository = new Repository();   
    }*/

   public Controller(Stage primaryStage) {
        this.primaryStage = primaryStage;
   }
   
   public void initRootLayout() {
        try {
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(CyclingRoutesApp.class
                   .getResource("/views/RootLayout.fxml"));

           rootLayout = (BorderPane) loader.load();

           Scene scene = new Scene(rootLayout);
           primaryStage.setScene(scene);

           RootLayoutController rootLayoutController = loader.getController();
           rootLayoutController.setMainController(this);

           primaryStage.show();
           listRoutes();            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    
    
    public void run() {
        Route route = new Route(1, "title", "point");
        System.out.println(route.getDeparturePoint());
        helper = new InputHelper();
        int choice = helper.readInt("Please enter the number of the operation you wish to do.\n"
                                  + "1. Add stage \n2. Add route");
        switch (choice) {
            case 1:
                addStageUsingConsoleInput();
                break;
            case 2:
                addRouteUsingConsoleInput();
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }   
        public void listRoutes() {
        ObservableList<RouteView> routeData = FXCollections.observableArrayList();  
        repository = new Repository();
        System.out.println(repository.getItems());
        List <RouteView> routeList = repository.getItems().stream().map(r -> new RouteView(r)).collect(Collectors.toList());
        routeData.setAll(routeList);        
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(CyclingRoutesApp.class.getResource("../views/RoutesList.fxml"));
            AnchorPane restaurantsListPane = (AnchorPane) loader.load();

            rootLayout.setCenter(restaurantsListPane);     
            
            // Give the controller access to the main app.
            RoutesListController rListController = loader.getController();
            rListController.setMainController(this, routeData);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }  
    private void listRoutesToConsole() {
        System.out.println("List Routes");
        System.out.println("===========");      	
        List<Route> routes = repository.getItems();
        //System.out.println(routes.get(0).getRouteTitle());
        Route route = repository.getItem(2);
        System.out.println(route.getDeparturePoint());
        RouteStage stage = new RouteStage(10,"testing", (float) 1.5,1);
        //repository.addRoute(route);
        
    }     
    
    private void addRouteUsingConsoleInput() {
        System.out.println("Add Route");
        System.out.println("=========");        
        helper = new InputHelper();
        String routeTitle = helper.readString("Enter route title");
        String departurePoint = helper.readString("Enter departure point");
        Route route = new Route(routeTitle, departurePoint);
        
        repository.addRoute(route);
      
    }
    
    private void addStageUsingConsoleInput() {
        System.out.println("Add Stage");
        System.out.println("=========");   
        helper = new InputHelper();
        int stageNumber = helper.readInt("Enter stage number");
        String endPoint = helper.readString("Enter endpoint");
        float stageLength = helper.readFloat("Enter stage length");
        int routeId = helper.readInt("Enter route id");
        
        RouteStage stage = new RouteStage(stageNumber, endPoint, stageLength, routeId);
        repository.addStage(stage);
    }
    
}
