package controllers;

import repositories.Repository;

public class Controller {
    private Repository repository;
    //private Stage primaryStage;
    //private BorderPane rootLayout;        
    
    public Controller() {
        repository = null;   
    }

   /*public Controller(Stage primaryStage) {
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
    }    */
    
    public void run() {
        listRoutesToConsole();
    }   
    
    private void listRoutesToConsole() {
        System.out.println("List Routes");
        System.out.println("===========");      	
        // Complete this method
    }     
    
    private void addRouteUsingConsoleInput() {
        System.out.println("Add Route");
        System.out.println("=========");        
        // Complete this method        
    }
    
    private void addStageUsingConsoleInput() {
        System.out.println("Add Stage");
        System.out.println("=========");   
        // Complete this method        
    }
    
}
