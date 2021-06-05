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

public class presidentChartViewController implements Initializable {
	@FXML private ImageView liveVoteInfoBtn;
	@FXML private ImageView candidateAndElectionInfoBtn;
	@FXML private PieChart pieChart;
	@FXML private LineChart<String, Integer> lineChart;
    @Override
    public void initialize(URL location, ResourceBundle resoruces) {
    	 XYChart.Series<String, Integer> series = null;
    	 series = new XYChart.Series<String, Integer>();
         // series에 개별 데이터 추가 
         series.getData().add(new XYChart.Data<String, Integer>("2018",30));
         series.getData().add(new XYChart.Data<String, Integer>("2019",40));
         series.getData().add(new XYChart.Data<String, Integer>("2020",50));
         series.getData().add(new XYChart.Data<String, Integer>("2021",30));

         series.setName("지지율");

         // 라인차트에 series 추가 
         lineChart.getData().add(series);
    	pieChart.setData(FXCollections.observableArrayList(
    		    new PieChart.Data("국민의 힘", 20),
    		    new PieChart.Data("더불어민주당", 32),
    		    new PieChart.Data("정의당", 24),
    		    new PieChart.Data("국민의당", 7)
    		));
    }
    
}