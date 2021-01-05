package app;

import controllers.Controller;
import javafx.application.Application;
import javafx.stage.Stage;
//import javafx.stage.Stage;

public class CyclingRoutesApp extends Application {
    private Stage primaryStage;
    
   @Override
   public void start(Stage primaryStage) {
      this.primaryStage = primaryStage;
      this.primaryStage.setTitle("Cycling Routes App");
      Controller controller = new Controller(primaryStage);
      controller.initRootLayout();
   } 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    //    CyclingRoutesApp.run();
    }
}
