package client.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class localChartViewController implements Initializable {
	@FXML private ImageView liveVoteInfoBtn;
	@FXML private ImageView candidateAndElectionInfoBtn;
	@FXML private PieChart pieChart;
    @Override
    public void initialize(URL location, ResourceBundle resoruces) {
    	pieChart.setData(FXCollections.observableArrayList(
    		    new PieChart.Data("±ππŒ¿« »˚", 20),
    		    new PieChart.Data("¥ı∫“æÓπŒ¡÷¥Á", 32),
    		    new PieChart.Data("¡§¿«¥Á", 24),
    		    new PieChart.Data("±ππŒ¿«¥Á", 7)
    		));
    }
    
}