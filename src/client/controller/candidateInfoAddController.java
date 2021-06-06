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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class candidateInfoAddController implements Initializable {
	@FXML private ImageView candidateListBtn;
	@FXML private TextField name; // �̸�
	@FXML private TextField number;  // ��ȣ
	@FXML private TextField partyName; // �����
	@FXML private TextField birth; // �������
	@FXML private ImageView candidateImage; // �ĺ� ����
	@FXML private ImageView candidatePartyImage; // �ĺ� ���� ����
	@FXML private TextArea career; // ���
	@FXML private TextArea pledge; // ����

    @Override
    public void initialize(URL location, ResourceBundle resoruces) {
        candidateListBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
            	changePreElectionCandidateList();
      	  };
     });
    }
    
    public void changePreElectionCandidateList()
    {
    	try
    	{
    	Parent main = FXMLLoader.load(getClass().getResource("../fxml/candidateListAdd.fxml"));
    	AnchorPane root = (AnchorPane)candidateListBtn.getScene().getRoot();
    	ScrollPane sp = (ScrollPane)root.getChildren().get(6);
    	sp.setContent(main);
    	}
    	catch(Exception e) { System.out.println("error");}
    }
    
    public void changePreElectionCandidateList2()
    {
    	try
    	{
    	Parent main = FXMLLoader.load(getClass().getResource("../fxml/candidateList2Add.fxml"));
    	AnchorPane root = (AnchorPane)candidateListBtn.getScene().getRoot();
    	ScrollPane sp = (ScrollPane)root.getChildren().get(6);
    	sp.setContent(main);
    	}
    	catch(Exception e) { System.out.println("error");}
    }
    
    public void setName(String name_in)
    {
    	name.setText(name_in);
    }
    
    public void setNumber(String number_in)
    {
    	number.setText(number_in);
    }
    
    public void setPartyName(String partyName_in)
    {
    	name.setText(partyName_in);
    }
    
    public void setBirth(String birth_in)
    {
    	name.setText(birth_in);
    }
    
    public void setCareer(String career_in)
    {
    	name.setText(career_in);
    }
    
    public void setPledge(String pledge_in)
    {
    	name.setText(pledge_in);
    }
    
    public void setCandidateImage(String candidate_name)
    {
    	try
    	{
        	Thread thread = new Thread() {
        		public void run() {
        	    	candidateImage.setImage(new Image(getClass().getResourceAsStream("../img/"+ candidate_name +"_����.jpg")));
        		}
        	};
        	thread.setDaemon(true);
        	thread.start();
    	}
    	catch(Exception e) {
    		candidateImage.setImage(new Image(getClass().getResourceAsStream("../img/�⺻�̹���.png")));
    		System.out.println("error");}
    }
    
    public void setCandidatePartyImage(String candidate_party_name)
    {
    	try
    	{
        	Thread thread = new Thread() {
        		public void run() {
        	    	candidatePartyImage.setImage(new Image(getClass().getResourceAsStream("../img/"+ candidate_party_name +".png")));
        		}
        	};
        	thread.setDaemon(true);
        	thread.start();
    	}
    	catch(Exception e) {
    		candidateImage.setImage(new Image(getClass().getResourceAsStream("../img/���_�����.png")));
    		System.out.println("error");}
    }
}
