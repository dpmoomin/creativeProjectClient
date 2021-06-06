package client.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class electionInfoAddController implements Initializable {
	@FXML private ImageView election1;
	@FXML private ImageView election2;
	@FXML private ImageView election3;
	@FXML private AnchorPane electionInfo;
	@FXML private Text election1VoteDay; // Ï≤´Î≤àÏß∏ ÏÑ†Í±∞Ïùº
	@FXML private Text election2VoteDay; // ÎëêÎ≤àÏß∏ ÏÑ†Í±∞Ïùº
	@FXML private Text election3VoteDay; // ÏÑ∏Î≤àÏß∏ ÏÑ†Í±∞Ïùº
	@FXML private ImageView election1Mark; // Ï≤´Î≤àÏß∏ ÏÑ†Í±∞Íµ¨Î∂Ñ ÎßàÌÅ¨
	@FXML private ImageView election2Mark; // ÎëêÎ≤àÏß∏ ÏÑ†Í±∞Íµ¨Î∂Ñ ÎßàÌÅ¨
	@FXML private ImageView election3Mark; // ÏÑ∏Î≤àÏß∏ ÏÑ†Í±∞Íµ¨Î∂Ñ ÎßàÌÅ¨

    @Override
    public void initialize(URL location, ResourceBundle resoruces) {
          election1.setOnMouseClicked(new EventHandler<MouseEvent>() {
      	     public void handle(MouseEvent event) {
      	    	 changeElection1();
      	     };
        });

          election2.setOnMouseClicked(new EventHandler<MouseEvent>() {
      	     public void handle(MouseEvent event) {
      	    	 changeElection2();
      	     };
        });

          election3.setOnMouseClicked(new EventHandler<MouseEvent>() {
      	     public void handle(MouseEvent event) {
      	    	 changeElection3();
      	     };
        });
    }

    
    public void changeElection1()
    {
    	try
    	{
    	Parent main = FXMLLoader.load(getClass().getResource("../fxml/candidateListAdd.fxml"));
    	electionInfo.getChildren().clear();
    	electionInfo.getChildren().add(main);
    	}
    	catch(Exception e) { System.out.println("error");}
    }
    
    public void changeElection2()
    {
    	try
    	{
    	Parent main = FXMLLoader.load(getClass().getResource("../fxml/candidateList2Add.fxml"));
    	electionInfo.getChildren().clear();
    	electionInfo.getChildren().add(main);
    	}
    	catch(Exception e) { System.out.println("error");}
    }
    
    public void changeElection3()
    {
    	try
    	{
    	Parent main = FXMLLoader.load(getClass().getResource("../fxml/candidateList3Add.fxml"));
    	electionInfo.getChildren().clear();
    	electionInfo.getChildren().add(main);
    	}
    	catch(Exception e) { System.out.println("error");}
    }
    
    public void setElection1VoteDay(String voteDay_in)
    {
    	election1VoteDay.setText(voteDay_in);
    }
    
    public void setElection2VoteDay(String voteDay_in)
    {
    	election2VoteDay.setText(voteDay_in);
    }
    
    public void setElection3VoteDay(String voteDay_in)
    {
    	election3VoteDay.setText(voteDay_in);
    }
    
    public void setElection1Mark(String election_category)
    {
    	try
    	{
        	Thread thread = new Thread() {
        		public void run() {
        	    	election1Mark.setImage(new Image(getClass().getResourceAsStream("../img/"+ election_category +"_ªÁ¡¯.jpg")));
        		}
        	};
        	thread.setDaemon(true);
        	thread.start();
    	}
    	catch(Exception e) {
    		election1Mark.setImage(new Image(getClass().getResourceAsStream("../img/»Úªˆ_∏∂≈©.png")));
    		System.out.println("error");}
    }
    
    public void setElection2Mark(String election_category)
    {
    	try
    	{
        	Thread thread = new Thread() {
        		public void run() {
        	    	election2Mark.setImage(new Image(getClass().getResourceAsStream("../img/"+ election_category +"_ªÁ¡¯.jpg")));
        		}
        	};
        	thread.setDaemon(true);
        	thread.start();
    	}
    	catch(Exception e) {
    		election2Mark.setImage(new Image(getClass().getResourceAsStream("../img/»Úªˆ_∏∂≈©.png")));
    		System.out.println("error");}
    }
    
    public void setElection3Mark(String election_category)
    {
    	try
    	{
        	Thread thread = new Thread() {
        		public void run() {
        	    	election3Mark.setImage(new Image(getClass().getResourceAsStream("../img/"+ election_category +"_ªÁ¡¯.jpg")));
        		}
        	};
        	thread.setDaemon(true);
        	thread.start();
    	}
    	catch(Exception e) {
    		election3Mark.setImage(new Image(getClass().getResourceAsStream("../img/»Úªˆ_∏∂≈©.png")));
    		System.out.println("error");}
    }
}
