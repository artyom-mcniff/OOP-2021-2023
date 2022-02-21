package ie.tudublin;

//import java.util.ArrayList;

import processing.core.PApplet;

public class Arrays extends PApplet {


    float[] rainfall = { 45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 58 };

    String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};

    float[] a1 = new float[100];
    float[] a2;

    int minIndex = 0;
    int maxIndex  = 0;
        

    public void settings()
    {
        size(500, 500);
    }

    public void setup()
    {
        for(int i = 0 ; i < rainfall.length ; i ++)
        {
            println(rainfall[i] + "\t" + months[i]);
        }
        for(float r:rainfall)
        {
            println(r);
        }
        
        int j = 0;
        for(float r:rainfall)
        {
            println(r + "\t" + months[j]);
            j ++;
        }

        for(int i = rainfall.length - 1; i >= 0 ; i -- )
        {
            println(rainfall[i] + "\t" + months[i]);
        }

        for(int i = 1 ; i < rainfall.length ; i ++)
        {
            if (rainfall[i] < rainfall[minIndex])
            {
                minIndex = i;
            }
            else if (rainfall[i] > rainfall[maxIndex])
            {
                maxIndex = i;
            } 
        }

        println("Max rainfall: " + rainfall[maxIndex] + " in month " + months[maxIndex]);
        println("Min rainfall: " + rainfall[minIndex] + " in month " + months[minIndex]);

    }

    public void draw()
    {
        
        background(0);
        colorMode(HSB);
        /*
        float w = width / (float)rainfall.length;
        noStroke();
        for(int i = 0 ; i < rainfall.length ; i ++)
        {
            float x = map(i, 0, rainfall.length, 0, width);
            int c = (int)map(i, 0, rainfall.length, 0, 255);
            fill(c, 255, 255);
            float h = map(rainfall[i], 0, rainfall[maxIndex], 0, -height);
            rect(x, height, w, h);
            fill(255);
            textAlign(CENTER, CENTER);
            text(months[i], x + (w / 2), height - 50);
        }
        */
        /*
        stroke(255);
        for (int i = 1; i < rainfall.length; i++){
            float y1 = map(rainfall[i-1], 0, rainfall[maxIndex], 0, height);
            float y2 = map(rainfall[i], 0, rainfall[maxIndex], 0, height);
            float x1 = map(i-1, 0, rainfall.length, 0, width);
            float x2 = map(i, 0, rainfall.length, 0, width);
            line(x1, y1, x2, y2);
        }
        */
        float sum = 0;
        for (int i = 0; i < rainfall.length; i++){
            sum += rainfall[i];
        }
        noStroke();
        float lastAngle = 0;
        for (int i = 0; i < rainfall.length; i++){
            
            fill(map(i, 0, rainfall.length, 0, 255), 255, 255);
            float angle = map(rainfall[i], 0, sum, 0, TWO_PI);
            arc(width/2, height/2, 400, 400, lastAngle, lastAngle + angle);
            lastAngle += angle;

        }
    }
    

}
