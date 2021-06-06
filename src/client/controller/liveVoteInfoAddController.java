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
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class liveVoteInfoAddController implements Initializable {
	@FXML private ImageView candidateAndElectionInfoBtn;
	@FXML private ImageView electionHistoryInfoBtn;
	@FXML private Arc voteBallotRateGraph; // ��ǥ�� ����
	@FXML private Text voteBallotRate; // ��ǥ��
	@FXML private SplitMenuButton electionList; // ���� ���
	@FXML private ImageView regionImage; // ���� ����
	@FXML private Text region; // ����
	@FXML private Rectangle firstCandidateVoteGraph; // ù��°(����) �ĺ� ��ǥ �׷���
	@FXML private Rectangle secondCandidateVoteGraph; // ù��°(����) �ĺ� ��ǥ �׷���
	@FXML private TextField voteRate; // ��ǥ��
	@FXML private TextField voteCount; // ��ǥ��
	@FXML private TextField candidateCount; // �����μ�
	@FXML private Text electionTitle;
	@FXML private Text firstCandidateName; // ù��°(����) �ĺ� �̸�
	@FXML private Text secondCandidateName; // �ι�°(����) �ĺ� �̸�
	@FXML private Text firstCandidateNumber; // ù��°(����) �ĺ� ��ȣ
	@FXML private Text secondCandidateNumber; // �ι�°(����) �ĺ� ��ȣ
	@FXML private Text firstCandidateParty; // ù��°(����) �ĺ� ����
	@FXML private Text secondCandidateParty; // �ι�°(����) �ĺ� ����
	@FXML private Text firstCandidateVote; // ù��°(����) �ĺ� ��ǥ��
	@FXML private Text secondCandidateVote; // �ι�°(����) �ĺ� ��ǥ�� 
	@FXML private Text firstCandidateVoteRate; // ù��°(����) �ĺ� ��ǥ��
	@FXML private Text secondCandidateVoteRate; // �ι�°(����) �ĺ� ��ǥ��

    public void initialize(URL location, ResourceBundle resoruces) {
    	setBallotRateGraph(0.5);
    	addElectionList("���� �õ����� ����");
    	addElectionList("�λ� �õ����� ����");
    	setFirstCandidateVoteGraph(0.6);
    	setSecondCandidateVoteGraph(0.3);
    	setRegionImage("�λ�");
    	setVoteRate("50.4");
    }
    
    public void setBallotRateGraph(double voteBallotRate)
    {
    	voteBallotRateGraph.setLength(360 * voteBallotRate);
    }
    
    public void addElectionList(String election)
    {
        electionList.getItems().add(new MenuItem(election));
    }
    public void setFirstCandidateVoteGraph(double voteRate)
    {
    	firstCandidateVoteGraph.setWidth(469 * voteRate);
    }
    public void setSecondCandidateVoteGraph(double voteRate)
    {
    	secondCandidateVoteGraph.setWidth(469 * voteRate);
    	secondCandidateVoteGraph.setLayoutX(491 - 469 * voteRate);
    }
    public void setRegionImage(String region)
    {
    	try
    	{
        	Thread thread = new Thread() {
        		public void run() {
        	    	regionImage.setImage(new Image(getClass().getResourceAsStream("../img/catogram/�Ķ�/"+ region +"-�Ķ�-1.png")));
        		}
        	};
        	thread.setDaemon(true);
        	thread.start();
    	}
    	catch(Exception e) { System.out.println("error");}
    }

    public void setRegion(String region_in)
    {
    	region.setText(region_in);
    }
    
    
    public void setVoteRate(String rate_in)
    {
    	voteRate.setText(rate_in);
    }
    
    public void setVoteCount(String count_in)
    {
    	voteCount.setText(count_in);
    }
    
    public void setElectionTitle(String title)
    {
    	electionTitle.setText(title);
    }
    
    public void setFirstCandidateName(String name)
    {
    	firstCandidateName.setText(name);
    }
    
    public void setSecondCandidateName(String name)
    {
    	secondCandidateName.setText(name);
    }
    
    public void setFirstCandidateNumber(String number)
    {
    	firstCandidateNumber.setText(number);
    }
    
    public void setSecondCandidateNumber(String number)
    {
    	secondCandidateNumber.setText(number);
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
    
    public void setSecondCandidateVoteRate(String voteRate)
    {
    	secondCandidateVoteRate.setText(voteRate);
    }
}