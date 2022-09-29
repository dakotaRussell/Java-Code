//Dakota Dehn
//You have to expand the applet window when running it to view the textarea display given your different sort selection.


import java.awt.*;
import java.applet.Applet;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class SortDriver extends Applet {
   
   private int array[];  // array to be sorted
   private int limit=1000;  // size of array to be sorted - you may have to make
                             // this bigger for faster sorts
   private int largestNum; // need to know for color scaling purposes in paint()
                          // it's the value of the largest number (brightest)

  // flag to tell paint() whether to paint a single location or the whole array
   private enum PaintType {ALL, SINGLE};
   private PaintType doPaint = PaintType.ALL;

   private int index = -1;  // index of single array location to be painted

   //this listener object responds to button events
   private ButtonActionListener buttonListener;
   
   //button to start the sort
   private JButton startSort;
   
   // the picture of the sort will appear on this canvas
   private SortCanvas picture;
   private final int pictureWidth = 1001;  // size of the sort bar
   private final int pictureHeight = 50;

   // put buttons and canvas on this panel
   private JPanel sortPanel;

   // put radio buttons on this panel
   private JPanel radioPanel, radioPanel0;

   // declarations for some more GUI elements
   private JTextArea text, text1, text2, text3;
   private JLabel label; // a non-interactive text field
   private JRadioButton r1, r2, r3, r4, r5, r6, r7; // radio buttons
   private ButtonGroup rButtons, lButtons;
   private JTextField rText; // you can type text into this field

   public void init() {

      buttonListener = new ButtonActionListener();

      array = new int[limit];
       for (int i=0; i<limit; i++)
        {
          array[i] = i;
          
        }
      largestNum = array[limit - 1];
      

      // set up the window
      sortPanel = new JPanel();
      sortPanel.setLayout(new BoxLayout(sortPanel, BoxLayout.Y_AXIS));
      
      // first place the sort bar on top
      picture = new SortCanvas();
      sortPanel.add(picture);
      
      // now place a button
      startSort = new JButton("Start");
      // the listener is triggeblue when the button is clicked
      startSort.addActionListener(buttonListener);
      sortPanel.add(startSort);

      // here's some more code that you may find useful
      // they're all wide because of the BoxLayout:Y-AXIS

      label = new JLabel("LET'S GET SORTING!!");
      sortPanel.add(label);

      text = new JTextArea("The name bubblesort comes from the idea that the darkest color is sinking to the bottom (the left edge of the screen) while the lightest color is bubbling \nto the top! Oh yeah metaphors.");
      text1 = new JTextArea("I hope you were paying attention because gee golly goop, THAT WAS QUICK!");
      text2 = new JTextArea("This sort bums me out because it is LINEAR. That means that the size of your input is proportionate to the amount of work it has to do! AND THAT IS ALOT OF WORK!!");
      text3 = new JTextArea("Don't even ask how it works. It took me weeks to understand. Just enjoy the beauty of it. P.S. Award for the most fragile algorithm.");

      // text field with room for 20 characters
      rText = new JTextField("Type in your preferred array length", 30); 
      rText.addActionListener(buttonListener); 
      sortPanel.add(rText);

      // put these buttons in their own panel
      radioPanel = new JPanel();
      radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.X_AXIS));
      
      // radio buttons
      r1 = new JRadioButton("Bubblesort", true); // true sets this button by default
      r1.addActionListener(buttonListener);
      radioPanel.add(r1);

      r2 = new JRadioButton("QuickSort", false); 
      r2.addActionListener(buttonListener);
      radioPanel.add(r2);

      r3 = new JRadioButton("Insertion Sort", false); 
      r3.addActionListener(buttonListener);
      radioPanel.add(r3);

      r4 = new JRadioButton("Merge Sort", false); 
      r4.addActionListener(buttonListener);
      radioPanel.add(r4);
   
      // radio buttons have to be added to a ButtonGroup to work
      rButtons = new ButtonGroup(); 
      rButtons.add(r1);
      rButtons.add(r2);
      rButtons.add(r3);
      rButtons.add(r4);

      // now add the radio panel to the sort panel
      sortPanel.add(radioPanel);

      // add the panel to the window
      add(sortPanel);

      radioPanel0 = new JPanel();
      radioPanel0.setLayout(new BoxLayout(radioPanel0, BoxLayout.X_AXIS));
      
      // radio buttons
      r5 = new JRadioButton("Ascending Order", true); // true sets this button by default
      r5.addActionListener(buttonListener);
      radioPanel0.add(r5);

      r6 = new JRadioButton("Descending Order", false); 
      r6.addActionListener(buttonListener);
      radioPanel0.add(r6);

      r7 = new JRadioButton("Random Order", false); 
      r7.addActionListener(buttonListener);
      radioPanel0.add(r7);
   
      // radio buttons have to be added to a ButtonGroup to work
      lButtons = new ButtonGroup();
      lButtons.add(r5);
      lButtons.add(r6);
      lButtons.add(r7);

      // now add the radio panel to the sort panel
      sortPanel.add(radioPanel0);

      // add the panel to the window*/
      add(sortPanel);

      picture.paint(picture.getGraphics());
   }
   
   // this object is triggeblue whenever a button is clicked
   private class ButtonActionListener implements ActionListener 
   {
      public void actionPerformed(ActionEvent event) 
      {
          
        // find out which button was clicked 
        Object source = event.getSource();
            
        // called when user hits return in text field
        if (source == rText) {
          limit= Integer.parseInt(rText.getText());}

        if (r5.isSelected())
        {
          array = new int[limit];
          for (int i=0; i<limit; i++)
          { array[i] = i; }
          largestNum = array[limit-1];
          doPaint = PaintType.ALL;
          picture.paint(picture.getGraphics());
        }

        if (r6.isSelected())
        { array = new int[limit];
          for (int i=limit-1; i >=0; i--)
          { array[limit-1-i] = i; } 
          largestNum = array[0];       
          doPaint = PaintType.ALL;
          picture.paint(picture.getGraphics());
        }

        if (r7.isSelected())
        { array = new int[limit];
          largestNum = array[0] = (int) (Math.random()*1000000.0);
          for (int i=1; i<limit; i++) {
          array[i] = (int) (Math.random()*1000000.0);

          if (array[i] > largestNum) largestNum = array[i]; }
          doPaint = PaintType.ALL;
          picture.paint(picture.getGraphics());
        } 

        if (source == startSort)
        {
          if (r1.isSelected())
          { sortPanel.add(text);
            doBubbleSort();
          }
                  
          else if (r2.isSelected())
          { sortPanel.add(text1);
            doQuickSort(array, 0, limit-1);
          }
                  
          else if (r3.isSelected())
          { sortPanel.add(text2);
            doInsertionSort();
          }
                  
          else if(r4.isSelected())
          { sortPanel.add(text3);
            doMergeSort(array, 0, limit-1);
          }
        }
      }    
   }

   private void doBubbleSort() {
      int temp;

      // this is just bubblesort
      for (int i=0; i<limit-1; i++) {
         for (int j=0; j<limit-1-i; j++) {
            if (array[j]>array[j+1]) {
               temp = array[j]; array[j] = array[j+1]; array[j+1] = temp;
                  
               // redraw only locations j and j+1
               doPaint = PaintType.SINGLE;  // try changing this to ALL and see what happens
               index = j; 
               picture.paint(picture.getGraphics());
               index = j+1; 
               picture.paint(picture.getGraphics());
            }
         }
      }
   }      

   private void doQuickSort(int[] x, int begin, int end)
   {  
      if (begin >= end)
        {
          doPaint = PaintType.SINGLE;
          index = begin;
          picture.paint(picture.getGraphics());
          return;
        }

      //picking the median-of-three pivot
      medianOfThree(x, begin, end);

      //partition
      int p = partition(x,begin,end);
      
      //paint the partition
      doPaint = PaintType.SINGLE;
      index = p;
      picture.paint(picture.getGraphics());
      
      //recurse
      doQuickSort(x,begin,p-1); 
      doQuickSort(x,p+1,end);
   }

   private static void medianOfThree(int[] data,int first,int last)  
   {
      int temp,middle,median;

      if (last-first+1 < 3)
         return;
      middle = (first+last)/2;
      if (data[first] <= data[middle])
         if (data[middle]<=data[last])
            median = middle;
         else if (data[last]<=data[first])
            median = first;
         else
            median = last;
      else
         if (data[first] <= data[last])
            median = first;
         else if (data[last] <= data[middle])
            median = middle;
         else
            median = last;
      temp = data[first];
      data[first] = data[median];
      data[median] = temp;
   }

   private static int partition(int[] data,int first,int last)
   {
      int left = first+1;
      int right = last;
      int temp;
      while (left <= right)
      {
        while(left<=right && data[left] <= data[first])
            ++left;
         while(right>=left && data[first] < data[right])
            --right;
         if (left > right)
            break;
         temp = data[left];
         data[left] = data[right];
         data[right] = temp;
         ++left;
         --right;
      }
         
      temp = data[first];
      data[first] = data[right];
      data[right] = temp;
      return right;
   }

   private void doInsertionSort()
   {
      int ind;
      int temp;
      for (int i = 1; i < array.length; i++)
      {
         //calling binarySearch to produce correct index
         temp = array[i];
         int j;
         ind = linearSearch(i, array);
         //assigning the current number to said index
         for (j = i-1; j >= ind; j--)
         {
            array[j+1] = array[j];  
            doPaint= PaintType.SINGLE;
            index = j+1;
            picture.paint(picture.getGraphics());
         }

         array[ind] = temp;
         index = ind;
         picture.paint(picture.getGraphics());
      } 
   }

   Integer linearSearch(int end, int[] array)
   {
      for (int i = 1; i < end; i++)
      {
         if (array[i] > array[end])
         {
            return i;
         }
      }
      return end;
   }


   private void doMergeSort(int[] x, int begin, int end)
   {
      if (end-begin < 1)
         return;    

      int[] temp;
      int array1, array2;
      array1 = (end+begin)/2 - begin +1;
      array2 = end - (end+begin)/2;

      doMergeSort(x, begin, ((begin + end)/2));
      doMergeSort(x, ((begin+end)/2)+1, end);

      // initialize array1 & array2
      int[] temp1 = new int[array1];
      int[] temp2 = new int[array2];

      for (int i=0; i<temp1.length; i++) 
         temp1[i] = x[i+begin];

      for (int j=0; j<temp2.length; j++)
         temp2[j] = x[(begin+end)/2 + 1 +j];

      temp = merge(temp1, temp2);
  
      //copy temp into appropriate spots of x
      for (int k=0; k<temp.length; k++)
         x[begin+k] = temp[k];

      doPaint = PaintType.ALL;
      picture.paint(picture.getGraphics());
      
   }

   private static int[] merge(int[] x, int[] y)
   {
      int[] z = new int[x.length+y.length];
      int i = 0;
      int j = 0;
      for (int k = 0; k < z.length; k++)
      {
         if (i == x.length)
      {
              z[k] = y[j];
         j++;
      }
         else if (j == y.length)
           {
              z[k] = x[i];
         i++;
           }
         else 
           {
              if (x[i] < y[j])
            {
                    z[k] = x[i];
               i++;
                 }
              else if(x[i] > y[j])
                 {
                    z[k] = y[j];
                    j++;
                 }
              else
                 {
                    z[k] = x[i];
                    z[k+1] = y[j];
                    i++;
                    j++;
                    k++;
                 }
            }
      }
      return z;
   } 
             
   class SortCanvas extends Canvas {
      // this class paints the sort bar 
       
      SortCanvas() {
         setSize(pictureWidth, pictureHeight);
         setBackground(Color.white);
      }
       
      public void paint(Graphics g) {
         
         if (doPaint == PaintType.ALL) {
            // paint whole array - this takes time so it shouldn't be done too frequently
            setBackground(Color.white);
            g.setColor(Color.white);
            g.fillRect(0, 0, pictureWidth, pictureHeight);
            
            for (int i=0; i<limit; i++) {
               // the larger the number, the brighter blue it is
               // blue is between 0.0 and 1.0
               // divide by the largest number to get a value between 0 and 1
               float blue = (float)(array[i]/(float)largestNum);

               // clamp if necessary - it shouldn't be
               if (blue<0f) blue = 0f;
               if (blue>1f) blue = 1f;

               g.setColor(new Color(0.0f, blue, 0.0f));
               // array location 0 is painted at left; 
               //   array location limit-1 is painted to right
               //this is a single vertical line in the bar
               g.drawLine((int)(i*pictureWidth/limit), 0, 
                          (int)(i*pictureWidth/limit), pictureHeight);
            }
         }
         else {
            // just paint one location on the bar
            float blue = (float)(array[index]/(float)largestNum);
            if (blue<0f) blue = 0f;
            if (blue>1f) blue = 1f;
            g.setColor(new Color(0.0f, blue, 0.0f));
            g.drawLine((int)(index*pictureWidth/limit), 0, 
                       (int)(index*pictureWidth/limit), pictureHeight);
         }   
      }
   }
}