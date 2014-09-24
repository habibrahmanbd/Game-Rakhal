/*
 	Rakhal is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Rakhal is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Rakhal.  If not, see <http://www.gnu.org/licenses/>.
*/

package package_rakhal;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Rakhal extends JFrame {
	private static final long serialVersionUID = 1L;
	public static int[] ball  = new int[9];
	public static int[] xP = new int[9];
	public static int[] yP = new int[9];
	public static int[]  PosX={290, 290+(750/2), 290+750,
								290, 290+(750/2), 290+750,
								290, 290+(750/2), 290+750};
	public static int[] PosY = {90, 			90,	 		90, 
								115+(450/2), 115+(450/2), 115+(450/2),
								115+450 ,		115+450,    115+450};
	public static int pointA=0, pointB=0, turn=1;
	public static int height=0;
	public static int width=0;
	public static int count=0;
	JTextField enterB = new JTextField("");
	JTextField enterS = new JTextField("");
	JLabel Ball = new JLabel("Ball From: ");
	JLabel Sel = new JLabel("Ball To:");
	JButton submit = new JButton("GO");
	JPanel p2  = new JPanel();
	public static int x,y;
	public Rakhal(){
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Rakal.jpg")));
	    
		initialization();
		Graph panel = new Graph();
		add(panel);
		
		
		Ball.setLocation(width/2-width/8-150, height-95);
		Ball.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		Ball.setSize(150, 20);

		enterB.setLocation(width/2-width/8-30, height-100);
		enterB.setSize(150, 30);

		Sel.setLocation(width/2-width/8+140, height-95);
		Sel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		Sel.setSize(150, 20);
	
		enterS.setLocation(width/2-width/8+240, height-100);
		enterS.setSize(150, 30);

		submit.setLocation(width/2-width/8+410, height-100);
		submit.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		submit.setSize(100, 30);

		
		
		Ball.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		Ball.setSize(150, 20);
		
		enterB.setSize(150, 30);
		
		Sel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		Sel.setSize(150, 20);
		
		enterS.setSize(150, 30);
		
		submit.setSize(100, 30);
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String B = enterB.getText();
				x = Integer.parseInt(B);
				String S = enterS.getText();
				y = Integer.parseInt(S);
				
				if(canGo(x, y)&&ball[x-1]==turn){
				xP[y-1] = PosX[y-1];
				yP[y-1] = PosY[y-1];
				ball[y-1]=ball[x-1];
				ball[x-1]=0;
				
				if(turn==1)
					turn=2;
					
				else
					turn=1;
				
				
				if(isgame())
					initialization();
				
				}
				repaint();
			}
			
		});
		}
	boolean canGo(int l, int m)
	{
		switch(l)
		{
		case 1:
			if((m==2||m==4||m==5)
			&&(ball[l-1]==1||ball[l-1]==2)
				&&(ball[m-1]==0))
						return true;
			else return false;
		
		case 2:
			if((m==1||m==3||m==5)
					&&(ball[l-1]==1||ball[l-1]==2)
						&&(ball[m-1]==0))
								return true;
					else return false;
		case 3:
			if((m==2||m==5||m==6)
					&&(ball[l-1]==1||ball[l-1]==2)
						&&(ball[m-1]==0))
								return true;
					else return false;
		case 4:
			if((m==1||m==5||m==7)
					&&(ball[l-1]==1||ball[l-1]==2)
						&&(ball[m-1]==0))
								return true;
					else return false;
		case 5:
			if((m==4||m==6||m==2||m==8||m==3||m==7||m==1||m==9)
					&&(ball[l-1]==1||ball[l-1]==2)
						&&(ball[m-1]==0))
								return true;
					else return false;
		case 6:
			if((m==3||m==5||m==9)
					&&(ball[l-1]==1||ball[l-1]==2)
						&&(ball[m-1]==0))
								return true;
					else return false;
		case 7:
			if((m==4||m==5||m==8)
					&&(ball[l-1]==1||ball[l-1]==2)
						&&(ball[m-1]==0))
								return true;
					else return false;
		case 8:
			if((m==7||m==5||m==9)
					&&(ball[l-1]==1||ball[l-1]==2)
						&&(ball[m-1]==0))
								return true;
					else return false;
		case 9:
			if((m==6||m==5||m==8)
					&&(ball[l-1]==1||ball[l-1]==2)
						&&(ball[m-1]==0))
								return true;
					else return false;
		}
		return false;
	}
	boolean isgame() {
		boolean p;
			if(ball[0]==ball[4]&&ball[4]==ball[5]&&ball[4]!=0){
			p=true;
			if(ball[4]==1)
				pointA++;
			else if(ball[4]==2) 
				pointB++;
			}
			else if(ball[2]==ball[4]&&ball[4]==ball[6]&&ball[4]!=0){
				p=true;
				if(ball[4]==1)
					pointA++;
				else if(ball[4]==2) 
					pointB++;
			}
			else if(ball[3]==ball[4]&&ball[3]==ball[5]&&ball[4]!=0){
				p=true;
				if(ball[4]==1)
					pointA++;
				else if(ball[4]==2)
					pointB++;
			}
			else if(ball[1]==ball[4]&&ball[4]==ball[7]&&ball[4]!=0){
				p=true;
				if(ball[4]==1)
					pointA++;
				else if(ball[4]==2) 
					pointB++;
			}
			else if(ball[1]==ball[3]&&ball[3]==ball[6]&&ball[3]!=0){
				p=true;
				if(ball[3]==1)
					pointA++;
				else if(ball[3]==2) 
					pointB++;
			}
			else if(ball[2]==ball[5]&&ball[8]==ball[5]&&ball[5]!=0){
				p=true;
				if(ball[5]==1)
					pointA++;
				else if(ball[5]==2) 
					pointB++;
			}
			else p=false;
			
			return p;
		}
	void initialization(){
	for(int i=0; i<9; i++)
	{
		if(i==0||i==1||i==2 ){
			ball[i]=1;
			xP[i] = PosX[i];
			yP[i] = PosY[i];
		}
		else if(i==6||i==7||i==8){
			ball[i]=2;
			xP[i] = PosX[i];
			yP[i] = PosY[i];
		}
		else
			ball[i]=0;
		
	}
	}

	public static void main(String args[]){
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		height = (int)screenSize.getHeight();
		width = (int) screenSize.getWidth();
		Rakhal frame = new Rakhal();
		frame.setTitle("Rakhal");
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
				
	}
	class Graph extends JPanel{
		
		private static final long serialVersionUID = 1L;
		private BufferedImage image, b1,b2;
		public Graph(){
			URL resource = getClass().getResource("back.jpg");
			URL r1 = getClass().getResource("b-1.png");
			URL r2 = getClass().getResource("b-2.png");
	        try {
	            image = ImageIO.read(resource);
	            b1 = ImageIO.read(r1);
	            b2 = ImageIO.read(r2);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}

		protected void paintComponent(Graphics g){
				super.paintComponents(g);
				g.drawImage(image,0,0,width, height, null);
				g.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
				g.setColor(Color.BLACK);
				g.drawString("Turn of Player: #"+turn, width/2-width/8+30, height-110);
				
				p2.setLayout(new GridLayout());
				p2.add(Ball);
				p2.add(enterB);
				p2.add(Sel);
				p2.add(enterS);
				p2.add(submit);
				
				p2.setLocation(width/2-width/8-150, height-95);
				p2.setSize(700, 30);
				add(p2);
				
				
				g.drawRoundRect(0, 0, width, height, 10, 10);
				g.drawString("Player #1: "+pointA, 325, 70);
				g.drawString("Player #2: "+pointB, 850, 70);				
				g.fillRect(325, 110, 750, 15);
				g.fillRect(310, 110, 15, 490);
				g.fillRect(310, 475+125, 750+15, 15);
				g.fillRect(325+750, 110, 15, 505);
				int xPoints[]={320,320, 325+750, 330+750};
				int yPoints[] ={110,135,490+120,490+100};
				int nPoints=4;
				g.fillPolygon(xPoints, yPoints, nPoints);
				int x1Points[]={320,320, 330+750, 330+750};
				int y1Points[] ={110+475,135+475,140,110};
				int n1Points=4;
				g.fillPolygon(x1Points, y1Points, n1Points);
				g.fillRect(315+(750/2), 125, 20, 475);
				g.fillRect(325, 115+(475/2), 750, 20);
				for(int i=0; i<9;i++)
				{
						if(ball[i]==1){
							g.drawImage(b1, xP[i], yP[i], 70,70,null);
						}
						else if(ball[i]==2)
							g.drawImage(b2, xP[i], yP[i], 70,70,null);
				}
				
				
				g.drawString("Player #1", 60, 250);
				
				g.drawImage(b1, 90, 270, 70,70,null);
				
				g.drawString("Player #2", 1160, 250);
				
				g.drawImage(b2, 1190, 270, 70,70,null);
				
				g.setFont(new Font("Comic Sans MS", Font.BOLD, 60));
				
				g.drawString("Rakhal", 620, 50);
				
				
				}
		}
		
	}
