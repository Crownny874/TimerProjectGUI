/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mytimerproject;

/**
 *
 * @author leonovo
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
public class TimerProgram implements ActionListener {
     private static JFrame TimerFrame;
     private static JPanel TimerPanel;
     
     private static Timer timer;
     
     private static JButton startButton;
     
     private static JLabel TimerLabel;
     
     private static JComboBox hrsBox;
     private static JComboBox minsBox;
     private static JComboBox secsBox;
     
     String[] HrsValue;
     String[] M_SValue;
     
     private static int hrs = 0;
     private static int mins =0;
     private static int secs = 0;
     
     private static boolean isStarted = false;
     
     private static JLabel hrsLabel;
     private static JLabel minsLabel;
     private static JLabel secsLabel;
     
     private static JButton stopButton;
     
     private static JButton resetButton;
     
    public TimerProgram() {
        
        //setting border for TimerLabel
         Border border = BorderFactory.createLineBorder(Color.GREEN, 10,true);
         
         //setting border for Start and Stop Button
         Border border1 =BorderFactory.createLineBorder(Color.GREEN, 10, true);
        
         //string array for ComboBox for Hrs
         HrsValue = new String[]{
             "0","1","2","3","4","5","6","7","8","9","10","11","12","13",
           "14","15","16","17","18","19","20","21","22","22","23",
         };
         
         // string array for ComboBox for Mins and Secs
         M_SValue = new String[] {
             "0","1","2","3","4","5","6","7","8","9","10","11","12","13",
           "14","15","16","17","18","19","20","21","22","23",
           "24","25","26","27","28","29","30","31","32","33","34",
           "35","36","37","38","40","41","42","43","44","45","46",
           "47","48","49","50","51","52","53","54","55","56","57","58",
           "59"
         };
         
         /*setting and initializing comboBox for 
                    hrs
                    mins
                    secs
         */
         hrsBox = new JComboBox(HrsValue);
         hrsBox.setBounds( 50, 200, 80, 40);
         hrsBox.setVisible(true);
         hrsBox.addActionListener(e -> {
            hrs = Integer.parseInt(hrsBox.getSelectedItem().toString());
            
            System.out.println(hrs);
         });
         hrsBox.setForeground(Color.GREEN);
         hrsBox.setFocusable(false);
         hrsBox.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
         
         
         minsBox = new JComboBox(M_SValue);
         minsBox.setBounds( 150, 200, 80, 40);
         minsBox.setVisible(true);
         minsBox.addActionListener(e -> {
            mins = Integer.parseInt(minsBox.getSelectedItem().toString());
            
            System.out.println(mins);
         });
         minsBox.setForeground(Color.GREEN);
         minsBox.setFocusable(false);
         minsBox.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
         
         secsBox = new JComboBox(M_SValue);
         secsBox.setBounds( 250, 200, 80, 40);
         secsBox.setVisible(true);
         secsBox.addActionListener(e -> {
            secs = Integer.parseInt(secsBox.getSelectedItem().toString());
            
            System.out.println(secs);
         });
         secsBox.setForeground(Color.GREEN);
         secsBox.setFocusable(false);
         secsBox.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
         
         
         //setting and initializing timer that executes actionPerformed method every seconds
         timer = new Timer(1000,this);
        
         //starting timer
         timer.start();
         
         /*setting label for
            hrs
            mins
            secs
         */
      
        hrsLabel = new JLabel("HH");
        hrsLabel.setBounds(70, 180, 50, 15);
        hrsLabel.setOpaque(true);
        hrsLabel.setVisible(true);
        hrsLabel.setForeground(Color.WHITE);
        hrsLabel.setBackground(Color.DARK_GRAY);
        
        
        minsLabel = new JLabel("MM");
        minsLabel.setBounds(170, 180, 50, 15);
        minsLabel.setOpaque(true);
        minsLabel.setVisible(true);
        minsLabel.setForeground(Color.WHITE);
        minsLabel.setBackground(Color.DARK_GRAY);
        
        
        secsLabel = new JLabel("SS");
        secsLabel.setBounds(270, 180, 50, 15);
        secsLabel.setOpaque(true);
        secsLabel.setVisible(true);
        secsLabel.setForeground(Color.WHITE);
        secsLabel.setBackground(Color.DARK_GRAY);
       
        
        //setting and initializing JLabel for Timer
        TimerLabel = new JLabel();
        TimerLabel.setBounds(25, 70, 350, 100);
        TimerLabel.setOpaque(true);
        TimerLabel.setVisible(true);
        TimerLabel.setBorder(border);
        TimerLabel.setBackground(Color.DARK_GRAY);
        TimerLabel.setFont(new Font(Font.SANS_SERIF, 30,50));
        TimerLabel.setText("   0"+0+" : 0"+0+" : 0"+0); 
   
       
        //setting and initalizing startButton 
        startButton = new JButton("START");
        startButton.setVisible(true);
        startButton.setBounds(20,260,100,50);
        startButton.setFocusable(false);
        startButton.addActionListener(this);
        startButton.setBorder(border1);
        startButton.setBackground(Color.GREEN);
        startButton.setForeground(Color.WHITE);
        startButton.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
        
        //setting and initalizing resetButton 
        resetButton = new JButton("RESET");
        resetButton.setVisible(true);
        resetButton.setBounds(150,260,100,50);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);
        resetButton.setBorder(border1);
        resetButton.setBackground(Color.GREEN);
        resetButton.setForeground(Color.WHITE);
        resetButton.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
        
        
        //setting and initializing stopButton
        stopButton = new JButton("STOP");
        stopButton.setVisible(true);
        stopButton.setBounds(280,260,100,50);
        stopButton.setFocusable(false);
        stopButton.addActionListener(this);
        stopButton.setBorder(border1);
        stopButton.setBackground(Color.GREEN);
        stopButton.setForeground(Color.WHITE);
        stopButton.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
        
        //this is the panel of the frame where other components are added to
        TimerPanel = new JPanel();
        TimerPanel.setSize(420,420);
        TimerPanel.setVisible(true);
        TimerPanel.setOpaque(true);
        TimerPanel.setLayout(null);
        TimerPanel.add(startButton);
        TimerPanel.add(TimerLabel);
        TimerPanel.add(hrsBox);
        TimerPanel.add(minsBox);
        TimerPanel.add(secsBox);
        TimerPanel.setBackground(Color.DARK_GRAY);
        TimerPanel.add(hrsLabel);
        TimerPanel.add(minsLabel);
        TimerPanel.add(secsLabel);
        TimerPanel.add(stopButton);
        TimerPanel.add(resetButton);
        
        
        //timer frame which the panel is added to
        TimerFrame = new JFrame();
        TimerFrame.setSize(420,420);
        TimerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TimerFrame.setVisible(true);
        TimerFrame.setLayout(null);
        TimerFrame.add(TimerPanel);
        TimerFrame.setLocationRelativeTo(null);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //executes if stratButton is clicked and set isStarted variable to true
         if(e.getSource() == startButton) {
                   isStarted = true;
               System.out.println("TIMER STARTED");
               
           //executes if isStarted is equals true
             if(isStarted) { 
             
                 
            //this gets selected item from the comboBox and sets it to (hrs, mins ,secs)
            // only if value is zero
                if(isZero()) {
            hrs = Integer.parseInt(hrsBox.getSelectedItem().toString());
            
            mins = Integer.parseInt(minsBox.getSelectedItem().toString());
            
            secs = Integer.parseInt(secsBox.getSelectedItem().toString());
               
         
              }
                
              /*
        
                NOTE: ONCE THE VALUE OF HRS, MINS, SECS IS EQUALS TO ZERO 
                (HRS, MINS, SECS) VALUE IS EQUAL TO THE VALUE SELECTED FROM THE COMBOBOX 
                
                  ELSE 
                
                
                THE (HRS, MINS, SECS) VALUE IS EQUAL TO THE VALUE THE TIMER IS AT 
                    WHEN THE TIMER IS STOPPED.
                
                */
           }
         }
         
         
         //this executes and calls needed method when startButton is clicked
         if(isStarted) {
             
         TimerSecs(); 
         TimerMins();
         TimerHrs();
         stop(e);
         printFormat(hrs,mins,secs);
         
         } 
         
         reset(e);
       
     } 
    
   //works if seconds value is not equal to zero
   public void TimerSecs() {
       if(secs != 0) {
           secs--;
    
      }
  }
  
  //works if mins value is not equal to zero
 public void TimerMins() {
     if(mins != 0  && secs == 0) {
         secs = 59;
         mins--;
     }
 }
 
 //works if value of hrs is not equal to zero
 public void TimerHrs() {
     if(mins == 0 && hrs != 0) {
         mins = 59;
         hrs--;
     }
 }
 
 //this prints the format of the timer to the frame
 public void printFormat(int hours,int mins, int seconds) {
      if(hours < 10 && mins < 10 && seconds <  10){
         TimerLabel.setText("   0"+hours+" : 0"+mins+" : 0"+seconds); 
     }
     if(hours < 10 && mins >= 10 && seconds >= 10) {
         TimerLabel.setText("   0"+hours+" : "+mins+" : "+seconds);
     }
     if(hours < 10 && mins >= 10 && seconds < 10){
        TimerLabel.setText("   0"+hours+" : "+mins+" : 0"+seconds);
     }
     if(hours < 10 && mins < 10 && seconds >= 10) {
        TimerLabel.setText("   0"+hours+" : 0"+mins+" : "+seconds);   
     }
     
    if(hours >= 10 && mins >= 10 && seconds >= 10) {
        TimerLabel.setText("    "+hours+" : "+mins+" : "+seconds);
    }
    if(hours >= 10 && mins < 10 && seconds < 10) {
       TimerLabel.setText("    "+hours+" : 0"+mins+" : 0"+seconds);
     }
     if(hours >= 10 && mins < 10 && seconds >= 10){
       TimerLabel.setText("    "+hours+" : 0"+mins+" : "+seconds);
     }
     if(hours >= 10 && mins >= 10 && seconds < 10) {
       TimerLabel.setText("    "+hours+" : "+mins+" : 0"+seconds);
     }
  }
 //this stops the timer by setting isStarted = false;
 
 public void stop(ActionEvent e) {
      if(e.getSource() == stopButton) {
    
         isStarted = false;
         
         System.out.println("TIMER STOPPED");
         
      }
 }
 
 
 //this checks if the last value by the (hrs, mins,secs) when the timer was stopped is equals zero
 public boolean isZero()  {
    
    if(hrs == 0 && mins == 0 && secs == 0) {
        return true;
    }
    
    else {
        
       return false;
    }
   }
public void reset(ActionEvent e) {
   
    if(e.getSource() == resetButton) {
        hrsBox.setSelectedItem("0");
        minsBox.setSelectedItem("0");
        secsBox.setSelectedItem("0");
        
        hrs = 0;
        mins = 0;
        secs = 0;
        
        TimerLabel.setText("   0"+hrs+" : 0"+mins+" : 0"+secs);
      
         System.out.println("TIMER RESETTED");
       }
    }
 }
 

 

