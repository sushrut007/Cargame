package javapackage;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.*;

class CarGame implements ActionListener,KeyListener {
	JFrame frame;
	JLayeredPane panel;
	ImageIcon Car,road,obs,obs2,player,obs4,obs5;
	JLabel Road,Newgame,obs1,obs12,obs13,obs14,Player,Score,level;
	Timer timer;
	boolean GameOver=false;
	int pos1[]= {50,100,150,200,250,300};
	int iy=-700,blink=0,x,num,y=540,y1=640,speed=10,chance=0;
	static int score=0;
	static int MaxScore=0;
	
	CarGame(){
		road=new ImageIcon("C:\\Users\\Shree\\Desktop\\Sushjava\\src\\javapackage\\img\\road.png");//road
		obs=new ImageIcon("C:\\Users\\Shree\\Desktop\\Sushjava\\src\\javapackage\\img\\C6.png");//light blue car
		obs2=new ImageIcon("C:\\Users\\Shree\\Desktop\\Sushjava\\src\\javapackage\\img\\C5.png");//yellow
		player=new ImageIcon("C:\\Users\\Shree\\Desktop\\Sushjava\\src\\javapackage\\img\\C1.png");//Black car
		obs4=new ImageIcon("C:\\Users\\Shree\\Desktop\\Sushjava\\src\\javapackage\\img\\C7.png");//purple
		obs5=new ImageIcon("C:\\Users\\Shree\\Desktop\\Sushjava\\src\\javapackage\\img\\C3.png");//dark blue
		
		Newgame = new JLabel();
		Newgame.setBounds(100, 400, 400, 50);
		Newgame.setFont(new Font("s", Font.BOLD, 25));
		Newgame.setForeground(Color.WHITE);
		Newgame.setText("GAME STARTING");
		
		Score = new JLabel();
		Score.setBounds(10, 10, 130, 40);
		Score.setFont(new Font("s", Font.BOLD, 20));
		Score.setBackground(Color.BLACK);
		Score.setForeground(Color.yellow);
		Score.setOpaque(true);
		
		level = new JLabel();
		level.setBounds(280, 10, 110, 40);
		level.setFont(new Font("s", Font.BOLD, 20));
		level.setBackground(Color.BLACK);
		level.setForeground(Color.yellow);
		level.setOpaque(true);
		
		obs14=new JLabel();
		obs14.setBounds(150,700, 50, 100);
		obs14.setBackground(Color.BLACK);
		obs14.setIcon(obs4);
		obs14.setVisible(false);
		
		obs1=new JLabel();
		obs1.setBounds(50,700, 50, 100);
		obs1.setBackground(Color.BLACK);
		obs1.setIcon(obs5);
		obs1.setVisible(false);
		
		obs12=new JLabel();
		obs12.setBounds(170,700, 50, 100);
		obs12.setBackground(Color.BLACK);
		obs12.setIcon(obs2);
		obs12.setVisible(false);
		
		obs13=new JLabel();
		obs13.setBounds(100,700, 50, 100);
		obs13.setBackground(Color.BLACK);
		obs13.setIcon(obs);
		obs13.setVisible(false);
	     
		Player=new JLabel();
		Player.setBounds(50,540, 50, 100);
		Player.setBackground(Color.BLACK);
		Player.setIcon(player);
		Player.setVisible(true);
	     
		Road=new JLabel();
		Road.setBounds(-100, 0, 600, 1400);
		Road.setIcon(road);
		
		panel= new JLayeredPane();
		panel.setBounds(0, iy,400, 1400);
		panel.setOpaque(true);
		panel.add(Road,Integer.valueOf(0));
		panel.add(obs1,Integer.valueOf(1));
		panel.add(obs12,Integer.valueOf(1));
		panel.add(obs13,Integer.valueOf(1));
		panel.add(obs14,Integer.valueOf(1));
		
		frame = new JFrame("Car Game");
		frame.setLayout(null);
		frame.add(Player);
		frame.add(Score);
		frame.add(level);
		frame.add(Newgame);
		frame.add(panel);
		frame.addKeyListener(this);
		frame.getContentPane().setBackground(Color.black);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0, 0, 415, 700);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		timer = new Timer(100, this);
		timer.start();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			CarGame g=new CarGame();	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(iy>-40&&!GameOver) {
			Player.setVisible(true);
			iy=-540;
			y=540;
			y1=660;
			Newgame.disable();
			Newgame.setText("");
			Random r = new Random();
		    num = r.nextInt(6);
		    x=pos1[num];
		    obs1.setVisible(true);
		    obs1.setLocation(x, y);
		    Random r1 = new Random();
		    num = r1.nextInt(6);
		    x=pos1[num];
		    obs12.setVisible(true);
		    obs12.setLocation(x, y);
		    Random r2 = new Random();
		    num = r2.nextInt(6);
		    x=pos1[num];
		    obs13.setVisible(true);
		    obs13.setLocation(x, y);
		    Random r3 = new Random();
		    num = r3.nextInt(6);
		    x=pos1[num];
		    obs14.setVisible(true);
		    obs14.setLocation(x, y1);
		    if(score<=400)
		    speed+=2;   
		    }
		    else if(score>600&&score<610) {
		    	 speed+=2;
		    }
		    else if(score>700&&score<710)
		    { speed+=2;}
		    else if(score>1000)
		     	{speed+=2;}
		iy=iy+speed;
		if(speed>=12&&!GameOver)
		score=score+1;
		panel.setLocation(0, iy);
		Blink();
		check();
		Level();
		game();
	}
void check() {
    if((Player.getX()==obs1.getX()||Player.getX()==obs12.getX()||Player.getX()==obs13.getX())&&(panel.getY()>=-100)&&(Player.getY()==obs1.getY()||Player.getY()==obs12.getY()||Player.getY()==obs13.getY())) {
    	frame.dispose();
    	GameOver=true;
	}
    if(Player.getX()==obs14.getX()&&(panel.getY()>=-220)&&(Player.getY()==obs14.getY()-120)) {
    	frame.dispose();
    	GameOver=true;
    }
}
void Level() {
	if(score<=100) {
		level.setText("LeVeL 1");
	}
	else if(score<=200) {
		level.setText("LeVeL 2");
	}
	else if(score<=300) {
		level.setText("LeVeL 3");
	}
	else if(score<=400) {
		level.setText("LeVeL 4");
	}
	else if(score<=600) {
		level.setText("LeVel Max");
	}
	else if(score<800){
		level.setText("Exterme");
	}
	else {
		level.setText("Hacker");
	}
}
void game() {
	if (GameOver&&chance==0) {
		if(MaxScore<score) {
			MaxScore=score;
		}
		new NewGame();
		score=0;
		chance=1;
	}
}
void Blink() {
	if(blink==0) {
		Newgame.setVisible(false);
		Score.setText("Score "+ score);
		blink=1;
	}
	else {
		Newgame.setVisible(true);
		Score.setText("");
		blink=0;
	}
}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==39) {
			if(Player.getX()<280)
			{
				int x=Player.getX();
				x=x+50;
				Player.setLocation(x, 540);
			}
		}
		if(e.getKeyCode()==37) {
			if(Player.getX()>50)
			{
			int x=Player.getX();
			x=x-50;
			Player.setLocation(x, 540);
	}} 
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub	
	}
}
class NewGame implements ActionListener{
	JFrame frame;
	JLabel label,Score,MaxScore,back;
	JLayeredPane pane;
	JButton button;
	ImageIcon Bg;
	NewGame(){
		Bg = new ImageIcon("C:\\\\Users\\\\Shree\\\\Desktop\\\\Sushjava\\\\src\\\\javapackage\\\\img\\\\bg.png");//background
		
		button = new JButton("NEW GAME");
		button.setFont(new Font("s3",Font.BOLD,20));
	    button.setBackground(Color.black);
	    button.setBounds(100,170,200,30);
	    button.setForeground(Color.YELLOW);
	    button.setFocusable(false);
	    button.addActionListener(this);
		
		label = new JLabel();
		label.setBounds(0, 0, 400, 300);
		label.add(button);
		
		Score = new JLabel("Your SCORE:- " + CarGame.score);
		Score.setFont(new Font("s3",Font.BOLD,25));
		Score.setForeground(Color.BLACK);
		Score.setBounds(100, 50, 400, 30);
		
		MaxScore = new JLabel("Max SCORE:- " + CarGame.MaxScore);
		MaxScore.setFont(new Font("s3",Font.BOLD,25));
		MaxScore.setForeground(Color.BLACK);
		MaxScore.setBounds(100, 20, 400, 30);
		
		back = new JLabel();
		back.setBounds(0, 0, 400, 300);
		back.setIcon(Bg);
		
		pane= new JLayeredPane();
		pane.setBounds(0, 0, 400, 300);
		pane.add(back,Integer.valueOf(0));
		pane.add(label,Integer.valueOf(1));
		pane.add(Score,Integer.valueOf(1));
		pane.add(MaxScore,Integer.valueOf(1));
		
		frame= new JFrame("GAME OVER");
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0, 0, 400, 300);
		frame.setResizable(false);
		frame.add(pane);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == button) {
			frame.dispose();
			new CarGame();
		}
		
	}
}
