/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impactradiustest1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Michael
 */
public class GraphicalUserInterface implements ActionListener{
    private JFrame jf;
    private JPanel panelNorth, panelCenter, panelSouth,panelEast;
    private JLabel lblTitle, lblDesc, lblMin, lblMax, lblLength;
    private JTextField txtMin, txtMax, txtLength;
    private JTextArea taList, taGroupedList;
    private JButton btnReset, btnGroup, btnRandom;
    private JScrollPane listScroll, groupedListScroll;
    
    GenerateListOfNumbers instanceGenerateListofNumbers = new GenerateListOfNumbers();
        
    public GraphicalUserInterface()
    {
        
    }
    
    public void graphicalUserInterface()
    {        
        //Initialise Fonts
        Font fontTitle1 = new Font("Serif", Font.PLAIN, 30);
        Font fontNormal = new Font("Serif", Font.PLAIN, 16);
             
        //Initialise JFrame
        jf = new JFrame("Number Grouping by Michael Fouche");
         
        //Initialise JPanel
        panelNorth = new JPanel(new GridLayout(3,1));
        panelCenter = new JPanel(new GridLayout(4,2));
        panelSouth = new JPanel();
        panelEast = new JPanel(new GridLayout(3,1));
        
        //Initialise JLabels
        lblTitle = new JLabel("Number Grouping",SwingConstants.CENTER);    
        lblDesc = new JLabel("This program allows a user to generate a list or enter the list themselves to group.",SwingConstants.CENTER);
        lblMin = new JLabel("Lowest value");
        lblMax = new JLabel("Highest value");
        lblLength = new JLabel("Amount of values");
        
        //Set font to JLabels
        lblTitle.setFont(fontTitle1);
        lblDesc.setFont(fontNormal);
        lblMin.setFont(fontNormal);
        lblMax.setFont(fontNormal);        
        lblLength.setFont(fontNormal);               
          
        //Initialise JTextFields
        txtMin = new JTextField(10);
        txtMin.setToolTipText("Lowest value occuring in the list");
        txtMax = new JTextField(10);        
        txtMax.setToolTipText("Highest value occuring in the list");
        txtLength = new JTextField(10);
        txtLength.setToolTipText("Amount of values to be generated in the list");
        
        
        //Initialise JTextAreas
        taList = new JTextArea(5,20);
        taList.setLineWrap(true);
        taList.setWrapStyleWord(true);
        taGroupedList = new JTextArea(5,20);
        taGroupedList.setLineWrap(true);
        taGroupedList.setWrapStyleWord(true);
        
        //Initialise JButtons
        btnReset = new JButton("Reset Values");
        btnReset.addActionListener(this);
        btnGroup = new JButton("Group List >>");
        btnGroup.addActionListener(this);
        btnGroup.setPreferredSize(new Dimension(120, 80));
        btnRandom = new JButton("Generate random values");
        btnRandom.addActionListener(this);
        
        //Add items to top panel
        panelNorth.add(lblTitle);
        panelNorth.add(lblDesc);         
        panelNorth.add(new JLabel()); 
        
        //Add items to center panel
        panelCenter.add(lblMin);
        panelCenter.add(txtMin);
        panelCenter.add(lblMax);
        panelCenter.add(txtMax);
        panelCenter.add(lblLength);
        panelCenter.add(txtLength);
        panelCenter.add(new JLabel());
        panelCenter.add(new JLabel()); 
        
        //Initialise the JScrollPane for the list text area
        listScroll = new JScrollPane ();
        listScroll = new JScrollPane(taList);
        listScroll.setPreferredSize(new Dimension(220, 100));
        listScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        //Initialise the JScrollPane for the grouped list text area
        groupedListScroll = new JScrollPane ();
        groupedListScroll = new JScrollPane(taGroupedList);
        groupedListScroll.setPreferredSize(new Dimension(220, 100));
        groupedListScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        //add items to bottom panel
        panelSouth.add(listScroll);
        panelSouth.add(btnGroup);
        panelSouth.add(groupedListScroll);
        
        //add buttons to the east panel
        panelEast.add(btnRandom);        
        panelEast.add(btnReset);
        
        //Configure and add items to the JFrame
        jf.add(panelNorth, BorderLayout.NORTH);
        jf.add(panelCenter, BorderLayout.CENTER);
        jf.add(panelSouth, BorderLayout.SOUTH);        
        jf.add(panelEast, BorderLayout.EAST);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
        jf.addWindowListener(new WindowAdapter() 
        {
            @Override
            public void windowClosing(WindowEvent e) 
            {
                int result = JOptionPane.showConfirmDialog(jf, "Are you sure you want to exit?");
                if( result==JOptionPane.OK_OPTION)
                {
                    // NOW we change it to dispose on close..
                    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    jf.setVisible(false);
                    jf.dispose();
                }
                jf.setVisible(true);
            }
        });
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == btnReset)
        {
            txtMin.setText(""); 
            txtMax.setText(""); 
            txtLength.setText(""); 
            taList.setText(""); 
            taGroupedList.setText("");        
        }
        if(e.getSource() == btnRandom)
        { //When the 'Generate random values' button is pressed  the following code will retrieve the values, check that they are valid, and if so generate the values based on the input     
            try
            {
                String sMin = (txtMin.getText());                
                String sMax = (txtMax.getText());
                String sLength = (txtLength.getText());
                int min;
                int max;
                int length;
                if(sMin.isEmpty())
                {
                    JOptionPane.showMessageDialog(panelCenter, "Please enter a minimum value");
                }
                else if(sMax.isEmpty())
                {
                    JOptionPane.showMessageDialog(panelCenter, "Please enter a maximum value");
                }
                else if(sLength.isEmpty())
                {
                    JOptionPane.showMessageDialog(panelCenter, "Please enter the list length");
                }                
                else
                {
                    min = Integer.parseInt(sMin);
                    max = Integer.parseInt(sMax);
                    length = Integer.parseInt(sLength);
                    if(max<min)
                    {//if the user entered a higher value in the min value compared to the max value the values will be swopped
                        JOptionPane.showMessageDialog(panelCenter, "The lowest value is higher than the highest value, the values have been swopped for your convenience");
                        txtMin.setText(max+"");
                        txtMax.setText(min+"");
                        int temp = min;
                        min = max;
                        max = temp;                                
                    }                    
                    taList.setText(instanceGenerateListofNumbers.generateListOfNumbers(length, min, max));
                }
            }
            catch(NumberFormatException error)
            {
                JOptionPane.showMessageDialog(panelCenter, "Please ensure all the input fields contain numeric values");
            }
            catch(HeadlessException error)
            {
                JOptionPane.showMessageDialog(panelCenter, error);
            }
        }
        if(e.getSource() == btnGroup)
        {//If the 'Group List' button was pressed the following code will retrieve the list from the ungrouped list text area and call the necessary functions to group the list, 
         //finally the results will be displayed in the bottom right text area
            String taListData = taList.getText();
            if(!taListData.isEmpty())
            {
                String inputData = taListData;                

                //Group the array of integers into a string value
                GroupNumbers instanceGN = new GroupNumbers();
                String resultData = instanceGN.groupNumbers(inputData);

                taGroupedList.setText(resultData);
            }
            else
            {
               JOptionPane.showMessageDialog(panelCenter, "You need to generate values, or enter them manually in the bottom left text area to be able to group them");
            }
        }
    }
    
    
    
}
