package ie.tudublin;

import processing.core.PApplet;

public class Arrays extends PApplet {
    float [] rainfall = {45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 58};
    String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
    float[] a1 = new float[100];
    float[] a2;
    public void settings()
    {
        size(500, 500);
    }

    public void setup()
    {
        colorMode(RGB);
        for (int i = 0; i < rainfall.length; i++){
            println(rainfall[i] + "\t" + months[i]);
        }
        int ii = 0;
        for (float r : rainfall){
            println(r + "\t" + months[ii]);
            ii++;
        }
        for (int i = rainfall.length - 1; i >= 0; i--){

        }
        /*
        Float.MIN_VALUE;
        Float.MAX_VALUE;
        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 0; i < rainfall.length; i++){
            if (rainfall[i] < rainfall[minIndex]){
                minIndex = i;
            }
            else if (rainfall[i] > rainfall[maxIndex]){
                maxIndex = i;
            }
        }

        */

        float total = 0;
        float average = rainfall.length;
        float min = rainfall[0];
        int index1 = 0;
        int index2 = 0;
        float max = rainfall[0];
        for (int i = 0; i < rainfall.length; i++){
            if (min > rainfall[i]){
                min = rainfall[i];
                index1 = i;
            }
            if (max < rainfall[i]){
                max = rainfall[i];
                index2 = i;
            }
            total += rainfall[i];
            
        }
        average = total / average;
        println("The month with the least rainfall is ", months[index1], min);
        println("The month with the most rainfall is ", months[index2], max);
        println("The total amount of rainfall is ", total);
        println("The average amount of rainfall is ", average);
    }

    public void draw()
    {   
        background(0);
        colorMode(HSB);
        float w = width / (float) rainfall.length;
        for (int i = 0; i < rainfall.length; i++){
            float x = i * w;
            
            noStroke();
            fill(map(i, 0, rainfall.length, 0, 255), 255, 255);
            rect(x, height, w, -rainfall[i]);
            
        }
    }
}
