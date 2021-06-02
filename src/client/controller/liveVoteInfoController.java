package client.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class liveVoteInfoController implements Initializable {
	@FXML private ImageView candidateAndElectionInfoBtn;
	@FXML private ImageView electionHistoryInfoBtn;
	@FXML private PieChart voteCountingRate;

    public void initialize(URL location, ResourceBundle resoruces) {
    	//������Ʈ ������ �߰�
    	/* voteCountingRate.setData(FXCollections.observableArrayList(
    		    new PieChart.Data("��ǥ", 65),  

    		    new PieChart.Data("", 35)
    		)); */
    	candidateAndElectionInfoBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
    		public void handle(MouseEvent event) {
    			changeCandidateAndElectionInfo();
    			};
    	});

    	electionHistoryInfoBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
    		public void handle(MouseEvent event) {
    			changeElectionHistoryInfo();
     	     	};
    	});
    }
    
    public void changeCandidateAndElectionInfo()
    {
    	try
    	{
    	Parent main = FXMLLoader.load(getClass().getResource("../fxml/electionInfo.fxml"));
    	Scene scene = new Scene(main,512,540);
        	Thread thread = new Thread() {
        		public void run() {
    	    		Stage primaryStage = (Stage) candidateAndElectionInfoBtn.getScene().getWindow();
        			Platform.runLater(()->{primaryStage.setScene(scene);});
        		}
        	};
        	thread.setDaemon(true);
        	thread.start();
    	}
    	catch(Exception e) { System.out.println("error");}
    }
    

    
    public void changeElectionHistoryInfo()
    {
    	try
    	{
    	Parent main = FXMLLoader.load(getClass().getResource("../fxml/electionHistoryInfo.fxml"));
    	Scene scene = new Scene(main,512,540);
        	Thread thread = new Thread() {
        		public void run() {
    	    		Stage primaryStage = (Stage) electionHistoryInfoBtn.getScene().getWindow();
        			Platform.runLater(()->{primaryStage.setScene(scene);});
        		}
        	};
        	thread.setDaemon(true);
        	thread.start();
    	}
    	catch(Exception e) { System.out.println("error");}
    }
}