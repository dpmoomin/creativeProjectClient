package client.controller;

import java.net.URL;
import java.util.ResourceBundle;

import client.dataModel.ElectionResultDataModel;
import client.dataModel.ElectionResultDataModel2;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class localChartViewController implements Initializable {
	@FXML private ImageView liveVoteInfoBtn;
	@FXML private ImageView candidateAndElectionInfoBtn;
	@FXML private PieChart pieChart;
	@FXML private SplitMenuButton electionList; // ���� ���
	@FXML private TableView<ElectionResultDataModel2> electionResult; // ���� ���
	@FXML private TableColumn<ElectionResultDataModel2, String> partyCol; // ����
	@FXML private TableColumn<ElectionResultDataModel2, String> amountCol; // ����
	@FXML private TableColumn<ElectionResultDataModel2, String> rateCol; // ����
	@FXML private Text party1; // ���� 1
	@FXML private Text party2; // ���� 2
	@FXML private Text party3; // ���� 3
	@FXML private Text party4; // ���� 4
	@FXML private Text party5; // ���� 5
	
	//ī��׷�
	@FXML private ImageView chungcheongbukdo; // ��û�ϵ�
	@FXML private ImageView sejong; // ����
	@FXML private ImageView daejeon; // ����
	@FXML private ImageView jeollabukdo; // ����ϵ�
	@FXML private ImageView gyeongsangnamdo; // ��󳲵�
	@FXML private ImageView daegu; // �뱸
	@FXML private ImageView ulsan; // ���
	@FXML private ImageView busan; // �λ�
	@FXML private ImageView gwangju; // ����
	@FXML private ImageView jejudo; // ���ֵ�
	@FXML private ImageView gyeonggido; // ��⵵
	@FXML private ImageView gangwondo; // ������
	@FXML private ImageView incheon; // ��õ
	@FXML private ImageView seoul; // ����
	@FXML private ImageView jeollanamdo; // ���󳲵�
	@FXML private ImageView gyeongsangbukdo; // ���ϵ�
	@FXML private ImageView chungcheongnamdo; // ��û����
    ObservableList<ElectionResultDataModel2>myList = FXCollections.observableArrayList(
    		new ElectionResultDataModel2(new SimpleStringProperty("���Ҿ���ִ�"), new SimpleStringProperty("652��"), new SimpleStringProperty("79.1%"))
    		);
    @Override
    public void initialize(URL location, ResourceBundle resoruces) {
    	pieChart.setData(FXCollections.observableArrayList(
    		    new PieChart.Data("������ ��", 20),
    		    new PieChart.Data("���Ҿ���ִ�", 32),
    		    new PieChart.Data("���Ǵ�", 24),
    		    new PieChart.Data("�����Ǵ�", 7)
    		));
    	partyCol.setCellValueFactory(cellData->cellData.getValue().partyProperty());
    	amountCol.setCellValueFactory(cellData->cellData.getValue().amountProperty());
    	rateCol.setCellValueFactory(cellData->cellData.getValue().rateProperty());
    	electionResult.setItems(myList);
    }
    
    public void addElectionList(String election)
    {
        electionList.getItems().add(new MenuItem(election));
    }
    
    public void setParty1(String party)
    {
    	party1.setText(party);
    }
    
    public void setParty2(String party)
    {
    	party2.setText(party);
    }
    
    public void setParty3(String party)
    {
    	party3.setText(party);
    }
    
    public void setParty4(String party)
    {
    	party4.setText(party);
    }
    
    public void setParty5(String party)
    {
    	party5.setText(party);
    }
    
    public void setChungcheongbukdo(String color)
    {
    	try
    	{
        	Thread thread = new Thread() {
        		public void run() {
        			chungcheongbukdo.setImage(new Image(getClass().getResourceAsStream("../img/catogram/"+ color + "/��û�ϵ�-" + color +"-1.png")));
        		}
        	};
        	thread.setDaemon(true);
        	thread.start();
    	}
    	catch(Exception e) {
    		System.out.println("error");}
    }
    
    public void setSejong(String color)
    {
    	try
    	{
        	Thread thread = new Thread() {
        		public void run() {
        			sejong.setImage(new Image(getClass().getResourceAsStream("../img/catogram/"+ color + "/����-" + color +"-1.png")));
        		}
        	};
        	thread.setDaemon(true);
        	thread.start();
    	}
    	catch(Exception e) {
    		System.out.println("error");}
    }
    
    public void setDaejeon(String color)
    {
    	try
    	{
        	Thread thread = new Thread() {
        		public void run() {
        			daejeon.setImage(new Image(getClass().getResourceAsStream("../img/catogram/"+ color + "/����-" + color +"-1.png")));
        		}
        	};
        	thread.setDaemon(true);
        	thread.start();
    	}
    	catch(Exception e) {
    		System.out.println("error");}
    }
    
    public void setJeollabukdo(String color)
    {
    	try
    	{
        	Thread thread = new Thread() {
        		public void run() {
        			jeollabukdo.setImage(new Image(getClass().getResourceAsStream("../img/catogram/"+ color + "/����ϵ�-" + color +"-1.png")));
        		}
        	};
        	thread.setDaemon(true);
        	thread.start();
    	}
    	catch(Exception e) {
    		System.out.println("error");}
    }
    
    public void setGyeongsangnamdo(String color)
    {
    	try
    	{
        	Thread thread = new Thread() {
        		public void run() {
        			gyeongsangnamdo.setImage(new Image(getClass().getResourceAsStream("../img/catogram/"+ color + "/��󳲵�-" + color +"-1.png")));
        		}
        	};
        	thread.setDaemon(true);
        	thread.start();
    	}
    	catch(Exception e) {
    		System.out.println("error");}
    }
    
    public void setDaegu(String color)
    {
    	try
    	{
        	Thread thread = new Thread() {
        		public void run() {
        			daegu.setImage(new Image(getClass().getResourceAsStream("../img/catogram/"+ color + "/�뱸-" + color +"-1.png")));
        		}
        	};
        	thread.setDaemon(true);
        	thread.start();
    	}
    	catch(Exception e) {
    		System.out.println("error");}
    }
    
    public void setUlsan(String color)
    {
    	try
    	{
        	Thread thread = new Thread() {
        		public void run() {
        			ulsan.setImage(new Image(getClass().getResourceAsStream("../img/catogram/"+ color + "/���-" + color +"-1.png")));
        		}
        	};
        	thread.setDaemon(true);
        	thread.start();
    	}
    	catch(Exception e) {
    		System.out.println("error");}
    }
    
    public void setBusan(String color)
    {
    	try
    	{
        	Thread thread = new Thread() {
        		public void run() {
        			busan.setImage(new Image(getClass().getResourceAsStream("../img/catogram/"+ color + "/�λ�-" + color +"-1.png")));
        		}
        	};
        	thread.setDaemon(true);
        	thread.start();
    	}
    	catch(Exception e) {
    		System.out.println("error");}
    }
    
    public void setGwangju(String color)
    {
    	try
    	{
        	Thread thread = new Thread() {
        		public void run() {
        			gwangju.setImage(new Image(getClass().getResourceAsStream("../img/catogram/"+ color + "/����-" + color +"-1.png")));
        		}
        	};
        	thread.setDaemon(true);
        	thread.start();
    	}
    	catch(Exception e) {
    		System.out.println("error");}
    }
    
    public void setJejudo(String color)
    {
    	try
    	{
        	Thread thread = new Thread() {
        		public void run() {
        			jejudo.setImage(new Image(getClass().getResourceAsStream("../img/catogram/"+ color + "/���ֵ�-" + color +"-1.png")));
        		}
        	};
        	thread.setDaemon(true);
        	thread.start();
    	}
    	catch(Exception e) {
    		System.out.println("error");}
    }
    
    public void setGyeonggido(String color)
    {
    	try
    	{
        	Thread thread = new Thread() {
        		public void run() {
        			gyeonggido.setImage(new Image(getClass().getResourceAsStream("../img/catogram/"+ color + "/��⵵-" + color +"-1.png")));
        		}
        	};
        	thread.setDaemon(true);
        	thread.start();
    	}
    	catch(Exception e) {
    		System.out.println("error");}
    }
    
    public void setGangwondo(String color)
    {
    	try
    	{
        	Thread thread = new Thread() {
        		public void run() {
        			gangwondo.setImage(new Image(getClass().getResourceAsStream("../img/catogram/"+ color + "/������-" + color +"-1.png")));
        		}
        	};
        	thread.setDaemon(true);
        	thread.start();
    	}
    	catch(Exception e) {
    		System.out.println("error");}
    }
    
    public void setIncheon(String color)
    {
    	try
    	{
        	Thread thread = new Thread() {
        		public void run() {
        			incheon.setImage(new Image(getClass().getResourceAsStream("../img/catogram/"+ color + "/��õ-" + color +"-1.png")));
        		}
        	};
        	thread.setDaemon(true);
        	thread.start();
    	}
    	catch(Exception e) {
    		System.out.println("error");}
    }
    
    public void setSeoul(String color)
    {
    	try
    	{
        	Thread thread = new Thread() {
        		public void run() {
        			seoul.setImage(new Image(getClass().getResourceAsStream("../img/catogram/"+ color + "/����-" + color +"-1.png")));
        		}
        	};
        	thread.setDaemon(true);
        	thread.start();
    	}
    	catch(Exception e) {
    		System.out.println("error");}
    }
    
    public void setJeollanamdo(String color)
    {
    	try
    	{
        	Thread thread = new Thread() {
        		public void run() {
        			jeollanamdo.setImage(new Image(getClass().getResourceAsStream("../img/catogram/"+ color + "/���󳲵�-" + color +"-1.png")));
        		}
        	};
        	thread.setDaemon(true);
        	thread.start();
    	}
    	catch(Exception e) {
    		System.out.println("error");}
    }
    
    public void setGyeongsangbukdo(String color)
    {
    	try
    	{
        	Thread thread = new Thread() {
        		public void run() {
        			gyeongsangbukdo.setImage(new Image(getClass().getResourceAsStream("../img/catogram/"+ color + "/���ϵ�-" + color +"-1.png")));
        		}
        	};
        	thread.setDaemon(true);
        	thread.start();
    	}
    	catch(Exception e) {
    		System.out.println("error");}
    }
    
    public void setChungcheongnamdo(String color)
    {
    	try
    	{
        	Thread thread = new Thread() {
        		public void run() {
        			chungcheongnamdo.setImage(new Image(getClass().getResourceAsStream("../img/catogram/"+ color + "/��û����-" + color +"-1.png")));
        		}
        	};
        	thread.setDaemon(true);
        	thread.start();
    	}
    	catch(Exception e) {
    		System.out.println("error");}
    }
}