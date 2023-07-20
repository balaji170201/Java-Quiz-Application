package quiz;

//import statement
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import java.sql.Connection;
import java.sql.DriverManager;





public class Questions extends JFrame 
{
	
	private JPanel contentPane; 
	private JButton Next;
	private JButton Back;
	private ButtonGroup opg;
	private JRadioButton op1;
	private JRadioButton op2;
	private JRadioButton op3;
	private JRadioButton op4;
	private JLabel question;
	private JLabel username;
	private JSeparator separator;
	
	static final String DB_URL = "jdbc:mysql://localhost/sys";
	
	static final String USER = "root";
	static final String PASS = "";
	 String[][] a;
	 String[][] q;
	static int score=0;
	int count=0;
	int c=0;
	static String usernameq;
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run()
			{
				try 
				{
					Questions frame = new Questions();
					frame.setVisible(true);
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			
		});
		
	}
	
	public Questions() throws SQLException, ClassNotFoundException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        score=0;
        
        Game();
      q =new String[10][5];
      a=new String[10][5];
      
      Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
      
      String myDriver = "org.gjt.mm.mysql.Driver";
      String myUrl = "jdbc:mysql://localhost/sys";
      Class.forName(myDriver);
      
      //ques
      Statement st = conn.createStatement();
      int min=1;
      int max=20;
      
      ArrayList rand=new ArrayList();
      
      for(int i=0;i<20;i++) {
    	 
    	  rand.add(i+1);
    		  
    	  //System.out.println(rand[i]);
      }
      
      Collections.shuffle(rand);
     
      
      String query = "SELECT `ques`,`opt1`,`opt2`,`opt3`,`opt4`,`ans` from `ans2` WHERE `sno`= "+rand.get(0)+"";
      ResultSet rs = st.executeQuery(query);
      String ques=null;
      String opt1=null;
      String opt2=null;
      String opt3=null;
      String opt4=null;
      String ans=null;
      while (rs.next()) {
    	  ques=rs.getString(1);
    	  opt1=rs.getString(2);
    	  opt2=rs.getString(3);
    	  opt3=rs.getString(4);
    	  opt4=rs.getString(5);
    	  ans=rs.getString(6);
   
      }
      
     
      //qn1
      q[0][0]=ques;
      q[0][1]=opt1;
      q[0][2]=opt2;
      q[0][3]=opt3;
      q[0][4]=opt4;
     
      a[0][1]=ans;
      
      
      String query2 = "SELECT `ques`,`opt1`,`opt2`,`opt3`,`opt4`,`ans` from `ans2` WHERE `sno`= "+rand.get(1)+"";
      ResultSet rs2 = st.executeQuery(query2);
      String ques2=null;
      String opt12=null;
      String opt22=null;
      String opt32=null;
      String opt42=null;
      String ans2=null;
      while (rs2.next()) {
    	  ques2=rs2.getString(1);
    	  opt12=rs2.getString(2);
    	  opt22=rs2.getString(3);
    	  opt32=rs2.getString(4);
    	  opt42=rs2.getString(5);
    	  ans2=rs2.getString(6);
   
      }
      
      
      //qn2
      q[1][0]=ques2;
      q[1][1]=opt12;
      q[1][2]=opt22;
      q[1][3]=opt32;
      q[1][4]=opt42;
      
      a[1][1]=ans2;
      
      String query3 = "SELECT `ques`,`opt1`,`opt2`,`opt3`,`opt4`,`ans` from `ans2` WHERE `sno`= "+rand.get(2)+"";
      ResultSet rs3 = st.executeQuery(query3);
      String ques3=null;
      String opt13=null;
      String opt23=null;
      String opt33=null;
      String opt43=null;
      String ans3=null;
      while (rs3.next()) {
    	  ques3=rs3.getString(1);
    	  opt13=rs3.getString(2);
    	  opt23=rs3.getString(3);
    	  opt33=rs3.getString(4);
    	  opt43=rs3.getString(5);
    	  ans3=rs3.getString(6);
   
      }
      
      //qn3
      q[2][0]=ques3;
      q[2][1]=opt13;
      q[2][2]=opt23;
      q[2][3]=opt33;
      q[2][4]=opt43;
      
      a[2][1]=ans3;
      
      String query4 = "SELECT `ques`,`opt1`,`opt2`,`opt3`,`opt4`,`ans` from `ans2` WHERE `sno`= "+rand.get(3)+"";
      ResultSet rs4 = st.executeQuery(query4);
      String ques4=null;
      String opt14=null;
      String opt24=null;
      String opt34=null;
      String opt44=null;
      String ans4=null;
      while (rs4.next()) {
    	  ques4=rs4.getString(1);
    	  opt14=rs4.getString(2);
    	  opt24=rs4.getString(3);
    	  opt34=rs4.getString(4);
    	  opt44=rs4.getString(5);
    	  ans4=rs4.getString(6);
   
      }
      
      
      //qn4
      q[3][0]=ques4;
      q[3][1]=opt14;
      q[3][2]=opt24;
      q[3][3]=opt34;
      q[3][4]=opt44;
      
      a[3][1]=ans4;
      
      String query5 = "SELECT `ques`,`opt1`,`opt2`,`opt3`,`opt4`,`ans` from `ans2` WHERE `sno`= "+rand.get(4)+"";
      ResultSet rs5 = st.executeQuery(query5);
      String ques5=null;
      String opt15=null;
      String opt25=null;
      String opt35=null;
      String opt45=null;
      String ans5=null;
      while (rs5.next()) {
    	  ques5=rs5.getString(1);
    	  opt15=rs5.getString(2);
    	  opt25=rs5.getString(3);
    	  opt35=rs5.getString(4);
    	  opt45=rs5.getString(5);
    	  ans5=rs5.getString(6);
   
      }
      
      //qn5
      q[4][0]=ques5;
      q[4][1]=opt15;
      q[4][2]=opt25;
      q[4][3]=opt35;
      q[4][4]=opt45;
      
      a[4][1]=ans5;
      
      
      String query6 = "SELECT `ques`,`opt1`,`opt2`,`opt3`,`opt4`,`ans` from `ans2` WHERE `sno`= "+rand.get(5)+"";
      ResultSet rs6 = st.executeQuery(query6);
      String ques6=null;
      String opt16=null;
      String opt26=null;
      String opt36=null;
      String opt46=null;
      String ans6=null;
      while (rs6.next()) {
    	  ques=rs6.getString(1);
    	  opt1=rs6.getString(2);
    	  opt2=rs6.getString(3);
    	  opt3=rs6.getString(4);
    	  opt4=rs6.getString(5);
    	  ans=rs6.getString(6);
   
      }
      
      //qn6
      q[5][0]=ques;
      q[5][1]=opt1;
      q[5][2]=opt2;
      q[5][3]=opt3;
      q[5][4]=opt4;
      
      a[5][1]=ans;
      
      String query7 = "SELECT `ques`,`opt1`,`opt2`,`opt3`,`opt4`,`ans` from `ans2` WHERE `sno`= "+rand.get(6)+"";
      ResultSet rs7 = st.executeQuery(query7);
      String ques7=null;
      String opt17=null;
      String opt27=null;
      String opt37=null;
      String opt47=null;
      String ans7=null;
      while (rs7.next()) {
    	  ques=rs7.getString(1);
    	  opt1=rs7.getString(2);
    	  opt2=rs7.getString(3);
    	  opt3=rs7.getString(4);
    	  opt4=rs7.getString(5);
    	  ans=rs7.getString(6);
   
      }
      //qn7
      q[6][0]=ques;
      q[6][1]=opt1;
      q[6][2]=opt2;
      q[6][3]=opt3;
      q[6][4]=opt4;
      
      a[6][1]=ans;
      
      query = "SELECT `ques`,`opt1`,`opt2`,`opt3`,`opt4`,`ans` from `ans2` WHERE `sno`= "+rand.get(7)+"";
      rs = st.executeQuery(query);
      ques=null;
      opt1=null;
      opt2=null;
      opt3=null;
      opt4=null;
      ans=null;
      while (rs.next()) {
    	  ques=rs.getString(1);
    	  opt1=rs.getString(2);
    	  opt2=rs.getString(3);
    	  opt3=rs.getString(4);
    	  opt4=rs.getString(5);
    	  ans=rs.getString(6);
   
      }
     
      //qn8
      q[7][0]=ques;
      q[7][1]=opt1;
      q[7][2]=opt2;
      q[7][3]=opt3;
      q[7][4]=opt4;
      
      a[7][1]=ans;
      
      
      query = "SELECT `ques`,`opt1`,`opt2`,`opt3`,`opt4`,`ans` from `ans2` WHERE `sno`= "+rand.get(8)+"";
      rs = st.executeQuery(query);
      ques=null;
      opt1=null;
      opt2=null;
      opt3=null;
      opt4=null;
      ans=null;
      while (rs.next()) {
    	  ques=rs.getString(1);
    	  opt1=rs.getString(2);
    	  opt2=rs.getString(3);
    	  opt3=rs.getString(4);
    	  opt4=rs.getString(5);
    	  ans=rs.getString(6);
   
      }
      //qn9
      q[8][0]=ques;
      q[8][1]=opt1;
      q[8][2]=opt2;
      q[8][3]=opt3;
      q[8][4]=opt4;
      
      a[8][1]=ans;
      
      query = "SELECT `ques`,`opt1`,`opt2`,`opt3`,`opt4`,`ans` from `ans2` WHERE `sno`= "+rand.get(9)+"";
      rs = st.executeQuery(query);
      ques=null;
      opt1=null;
      opt2=null;
      opt3=null;
      opt4=null;
      ans=null;
      while (rs.next()) {
    	  ques=rs.getString(1);
    	  opt1=rs.getString(2);
    	  opt2=rs.getString(3);
    	  opt3=rs.getString(4);
    	  opt4=rs.getString(5);
    	  ans=rs.getString(6);
   
      }
      //qn10
      q[9][0]=ques;
      q[9][1]=opt1;
      q[9][2]=opt2;
      q[9][3]=opt3;
      q[9][4]=opt4;
      
      a[9][1]=ans;
      //Answers are stored in a[][]
      
      
    
      start(0);
	}
	 
	 public String[][] qarray() {
	        return q.clone();
	    }
	 public String[][] ansarray() {
	        return a.clone();
	    }
	private void Game() throws ClassNotFoundException, SQLException
	{	
		setTitle("CB_QUIZ:Questions");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Initializations
		opg=new ButtonGroup();
		op1=new JRadioButton();
		op2=new JRadioButton();
		op3=new JRadioButton();
		op4=new JRadioButton();
		question=new JLabel();
		username=new JLabel();
		separator=new JSeparator();
		Next=new JButton();
		Back=new JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        final JLabel timer = new JLabel("01:00");
        final Timer t = new Timer(1000, new ActionListener() {
            int time = 60;
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                time--;
                timer.setText(format(time / 60) + ":" + format(time % 60));
                if(c==10) {
                    final Timer timer = (Timer) e.getSource();
                	timer.stop();
                }else {
                if (time == 0) {
                	if(c>=10) {
                    final Timer timer = (Timer) e.getSource();
                    timer.stop();
                	}else {
                    JOptionPane.showMessageDialog(null,"Time Up Click Ok To Check Your Score","bye..",JOptionPane.ERROR_MESSAGE);
                    System.out.println(score);
        			try {
						new Results().setVisible(true);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                    final Timer timer = (Timer) e.getSource();
        			timer.stop();
        			dispose();
                }
                }
            }
            }
            
        });
        t.start();

        opg.add(op1);
        op1.setText("option1");
        op1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op1Selected(evt);
            }

		
        });

        opg.add(op2);
        op2.setText("option2");
        op2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op2selected(evt);
            }

		
        });

        opg.add(op3);
        op3.setText("option3");
        op3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op3selected(evt);
            }

        });

        opg.add(op4);
        op4.setText("option4");
        op4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op4selected(evt);
            }

			
        });

        question.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        question.setText("question");
        username.setText("Playing As:"+Login.usernameq);
        
        String myDriver = "org.gjt.mm.mysql.Driver";
	      String myUrl = "jdbc:mysql://localhost/sys";
	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(myUrl, "root", "");
        String query = "SELECT scores from quiz where user_name='"+Login.usernameq+"'";
	      Statement st = conn.createStatement();
	      ResultSet rs = st.executeQuery(query);
	      String answer=null;
	      while (rs.next()) {
	    	  answer=rs.getString("scores");
	      }
	    username.setText("Playing As:"+Login.usernameq+ "                \nHigh score :"+answer);  
        Next.setText("Next");
        Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					NextClicked(evt);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }

        });
        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackClicked(evt);
            }

        });
	
	//GUI
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(op1)
                    .addComponent(op3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(op2)
                    .addComponent(op4))
                .addGap(60, 60, 60))
            .addComponent(separator, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                    		.addComponent(timer)
                        .addComponent(question, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(username)
                        .addGap(642, 642, 642)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Next, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                    .addComponent(Back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username)
                    .addComponent(Next))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                		.addComponent(timer)
                    .addComponent(question, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Back))
                .addGap(18, 18, 18)
                .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(op1)
                    .addComponent(op2))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(op3)
                    .addComponent(op4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addContainerGap())
        );

	pack();
	}    

	

	protected void BackClicked(ActionEvent evt) {
		
		if(c==0) {
			
		}else {
			if(score==c)
			{
		score--;
		c--;
		start(c);
			}
			else {
				c--;
				start(c);
			}
		}
		
	}
	protected void NextClicked(ActionEvent evt) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String myDriver = "org.gjt.mm.mysql.Driver";
	      String myUrl = "jdbc:mysql://localhost/sys";
	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(myUrl, "root", "");
	      
	      String query = "SELECT ans FROM ans2 WHERE ques='"+q[c][0]+"'";
	      Statement st = conn.createStatement();
	      ResultSet rs = st.executeQuery(query);
	      String answer=null;
	      while (rs.next()) {
	    	  answer=rs.getString("ans");
	      
	      System.out.format("%s\n", answer);
	      }
	      
	     if(getSelectedButtonText(opg).equals(answer)) {
			score++;
			count++;
			c++;
		}
		else
		{
			c++;
			count++;
		}
			if(c!=10)
		{
			start(c);
		System.out.println(score);
		}
		else {
			System.out.println(score);
			new Results().setVisible(true);
			this.dispose();
		}
	}
	protected void op4selected(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}
	protected void op3selected(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}
	protected void op2selected(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}
	protected void op1Selected(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}
	String getSelectedButtonText(ButtonGroup buttonGroup) {
		    for (Enumeration buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
		        AbstractButton button = (AbstractButton) buttons.nextElement();

		        if (button.isSelected()) {
		            return button.getText();
		        }
		    }
		    return null;
	}
	public void start(int i) {
		
		 question.setText(q[i][0]);
	        op1.setText(q[i][1]);
	        op2.setText(q[i][2]);
	        op3.setText(q[i][3]);
	        op4.setText(q[i][4]);
	        opg.clearSelection();

	        


		
	}
	private static String format(int i) {
        String result = String.valueOf(i);
        if (result.length() == 1) {
            result = "0" + result;
        }
        //System.out.println(result);
        return result;
    }
	

		 }
