
package javafxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class FXMLDocumentController implements Initializable {
    
    double x = 0, y = 0;
    
    
    @FXML
    void close(ActionEvent event) {
        Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        stage.close();
    }
    
        
    @FXML
    private AnchorPane topBarPane;
    
    @FXML
    private HBox topBar;
    
    @FXML
    private Button closeButton;
    
    @FXML
    private Button minimizeButton;
    
    @FXML
    private AnchorPane shadowpane;
    
    @FXML
    private AnchorPane mainAnchorPane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        shadowpane.setId("shadowpane");
        mainAnchorPane.setId("mainAnchorPane");
        topBar.setId("topBar");
        
        
        topBarPane.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
            
        });
        
        topBarPane.setOnMouseDragged(mouseEvent -> {
            JavaFXML.primStage.setX(mouseEvent.getScreenX() - x); 
            JavaFXML.primStage.setY(mouseEvent.getScreenY() - y); 
            
        });
        
        minimizeButton.setOnAction(e -> {
                ((Stage)((Button)e.getSource()).getScene().getWindow()).setIconified(true);
            });
        
        closeButton.setOnAction(e -> {
                Platform.exit();
            });
        
        
        Rectangle rect = new Rectangle(500,500);
        rect.setId("rect");
        rect.setArcHeight(15.0);
        rect.setArcWidth(15.0);
        rect.setArcHeight(15.0);
        rect.setArcWidth(15.0);
       
        
      mainAnchorPane.setClip(rect);
      
    }    
    
}
