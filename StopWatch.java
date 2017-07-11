package lab_9_10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class StopWatch extends JPanel
{
       
        private Timer timer;
        private JButton startBtn, stopBtn, resetBtn;
        private JLabel timeLabel;
        private JPanel topPanel, bottomPanel;
        private int clockTick;
        private String clockTimeString;
 
        public StopWatch()
        {
                clockTick = 0;
                clockTimeString = new Integer(clockTick).toString() + " second(s)";
                timeLabel = new JLabel();
                timeLabel.setText(clockTimeString);
                startBtn = new JButton("Start");
                stopBtn = new JButton("Stop");
                resetBtn = new JButton("Reset");
                
                timer = new Timer(1000, new ActionListener() //Increases time every 1000 milliseconds (1 second per second)
                {
                        public void actionPerformed(ActionEvent evt)
                        {
                                clockTick++;
                                clockTimeString = new Integer(clockTick).toString();
                                timeLabel.setText(clockTimeString + " second(s)");
                        }
                });
                
                startBtn.addActionListener(new ActionListener() //Start button
                {
                        public void actionPerformed(ActionEvent evt)
                        {
                                timer.start();
                        }
                });

                stopBtn.addActionListener(new ActionListener() //Stop button
                {
                        public void actionPerformed(ActionEvent evt)
                        {
                                timer.stop();
                        }
                });

                resetBtn.addActionListener(new ActionListener() //Reset button
                {
                        public void actionPerformed(ActionEvent evt) 
                        {
                                clockTick = 0; //Resets time to 0
                                clockTimeString = new Integer(clockTick).toString();
                                timeLabel.setText(clockTimeString + " second(s)");
                        }
                });
        }

        public void launchStopWatch()
        {
                topPanel = new JPanel(); //Frame accessories
                bottomPanel = new JPanel();
                topPanel.add(timeLabel);
                bottomPanel.add(startBtn);
                bottomPanel.add(stopBtn);
                bottomPanel.add(resetBtn);
                this.setLayout(new BorderLayout());
                add(topPanel, BorderLayout.CENTER);
                add(bottomPanel, BorderLayout.SOUTH);
                setSize(300, 300);
        }
 
        public static void main(String[] args)
        {
                test watch = new test();

        }

}
 
class test extends JFrame
{

        StopWatch stopWatch;
        public test()
        {
                super("Awesome Stopwatch");
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Container myPane = getContentPane();
                stopWatch = new StopWatch();
                stopWatch.launchStopWatch();
                myPane.add(stopWatch);
                pack();
                setVisible(true);
        }

}