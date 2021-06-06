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
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class presidentChartViewController implements Initializable {
	@FXML private ImageView liveVoteInfoBtn;
	@FXML private ImageView candidateAndElectionInfoBtn;
	@FXML private PieChart pieChart;
	@FXML private LineChart<String, Integer> lineChart;
	@FXML private Text presidentParty; // ����� ����
	@FXML private Text presidentName; // ����� �̸�
	@FXML private Text firstCandidateName; // �缱�� �̸�
	@FXML private Text secondCandidateName; // ������ �̸�
	@FXML private Text firstCandidateParty; // �缱�� ����
	@FXML private Text secondCandidateParty; // ������ ����
	@FXML private Text firstCandidateVoteRate; // �缱�� ��ǥ��
	@FXML private Text secondCandidateVoteRate; // ������ ��ǥ��
	@FXML private Text firstCandidateVote; // �缱�� ��ǥ��
	@FXML private Text secondCandidateVote; // ������ ��ǥ��
	@FXML private ImageView presidentImage; // ����� ����
	@FXML private Rectangle firstCandidateVoteGraph; // �缱�� ��ǥ �׷���
	@FXML private Rectangle secondCandidateVoteGraph; // ������ ��ǥ �׷���
	@FXML private SplitMenuButton electionList; // ���� ���
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


    @Override
    public void initialize(URL location, ResourceBundle resoruces) {
    	 XYChart.Series<String, Integer> series = null;
    	 series = new XYChart.Series<String, Integer>();
         // series�� ���� ������ �߰� 
         series.getData().add(new XYChart.Data<String, Integer>("2018",30));
         series.getData().add(new XYChart.Data<String, Integer>("2019",40));
         series.getData().add(new XYChart.Data<String, Integer>("2020",50));
         series.getData().add(new XYChart.Data<String, Integer>("2021",30));

         series.setName("������");

         // ������Ʈ�� series �߰� 
         lineChart.getData().add(series);
    	pieChart.setData(FXCollections.observableArrayList(
    		    new PieChart.Data("������ ��", 20),
    		    new PieChart.Data("���Ҿ���ִ�", 32),
    		    new PieChart.Data("���Ǵ�", 24),
    		    new PieChart.Data("�����Ǵ�", 7)
    		));
    }
    
    public void setPresidentParty(String party)
    {
    	presidentParty.setText(party);
    }
    
    public void setPresidentName(String name)
    {
    	presidentName.setText(name);
    }
    
    public void setFirstCandidateName(String name)
    {
    	firstCandidateName.setText(name);
    }
    
    public void setSecondCandidateName(String name)
    {
    	secondCandidateName.setText(name);
    }
    
    public void setFirstCandidateParty(String party)
    {
    	firstCandidateParty.setText(party);
    }
    
    public void setSecondCandidateParty(String party)
    {
    	secondCandidateParty.setText(party);
    }
    
    public void setFirstCandidateVote(String vote)
    {
    	firstCandidateVote.setText(vote);
    }
    
    public void setSecondCandidateVote(String vote)
    {
    	secondCandidateVote.setText(vote);
    }
    
    public void setFirstCandidateVoteRate(String voteRate)
    {
    	firstCandidateVoteRate.setText(voteRate);
    }
    
    public void setPresidentImage(String candidate_name)
    {
    	try
    	{
        	Thread thread = new Thread() {
        		public void run() {
        	    	presidentImage.setImage(new Image(getClass().getResourceAsStream("../img/"+ candidate_name +"_����.jpg")));
        		}
        	};
        	thread.setDaemon(true);
        	thread.start();
    	}
    	catch(Exception e) {
    		presidentImage.setImage(new Image(getClass().getResourceAsStream("../img/�⺻�̹���.png")));
    		System.out.println("error");}
    }
    public void setSecondCandidateVoteRate(String voteRate)
    {
    	secondCandidateVoteRate.setText(voteRate);
    }
    
    public void setFirstCandidateVoteGraph(double voteRate)
    {
    	firstCandidateVoteGraph.setWidth(320 * voteRate);
    }
    
    public void setSecondCandidateVoteGraph(double voteRate)
    {
    	secondCandidateVoteGraph.setWidth(320 * voteRate);
    	secondCandidateVoteGraph.setLayoutX(418 - 320 * voteRate);
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