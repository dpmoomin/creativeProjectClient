package client.controller;

import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class candidateListAddController implements Initializable {
	@FXML private ImageView candidate1;
	@FXML private ImageView candidate2;
	@FXML private ImageView candidate3;
	@FXML private ImageView candidate4;
	@FXML private ImageView candidate5;
    @Override
    public void initialize(URL location, ResourceBundle resoruces) {
          candidate1.setOnMouseClicked(new EventHandler<MouseEvent>() {
      	     public void handle(MouseEvent event) {
      	    	 changeCandidateInfo();
      	     };
        });
          
          candidate2.setOnMouseClicked(new EventHandler<MouseEvent>() {
      	     public void handle(MouseEvent event) {
      	    	 changeCandidateInfo();
      	     };
        });

          candidate3.setOnMouseClicked(new EventHandler<MouseEvent>() {
      	     public void handle(MouseEvent event) {
      	    	 changeCandidateInfo();
      	     };
        });
          

          candidate4.setOnMouseClicked(new EventHandler<MouseEvent>() {
      	     public void handle(MouseEvent event) {
      	    	 changeCandidateInfo();
      	     };
        });
          

          candidate5.setOnMouseClicked(new EventHandler<MouseEvent>() {
      	     public void handle(MouseEvent event) {
      	    	 changeCandidateInfo();
      	     };
        });
    }
    public void changeCandidateInfo()
	{
    	try
    	{
			Socket clSocket = new Socket("localhost", 9594);
			PrintWriter pw = new PrintWriter(clSocket.getOutputStream(), true);
			//BufferedReader br = new BufferedReader(new InputStreamReader(clSocket.getInputStream()));

			pw.write("3");
			pw.flush();
			pw.close();
			clSocket.close();

    		Parent main = FXMLLoader.load(getClass().getResource("../fxml/candidateInfo.fxml"));
    		Scene scene = new Scene(main,512,540);
        	Thread thread = new Thread() {
        		public void run() {
    	    		Stage primaryStage = (Stage) candidate1.getScene().getWindow();
        			Platform.runLater(()->{primaryStage.setScene(scene);});
        		}
        	};
        	thread.setDaemon(true);
        	thread.start();
    	}
    	catch(Exception e) { System.out.println("error");}
    }
}
