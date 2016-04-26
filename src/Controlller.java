import java.net.*;
import java.util.*;
import com.google.gson.*;
import javafx.scene.chart.XYChart;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author csstudent
 */
public class Controlller {
    private static Object chart;
    public static void main(String[] args){
        String s = "http://apps.who.int/gho/athena/data/GHO/WHS4_544.json?profile=simple&filter=YEAR:1980";
        URL url = null;
        try{
            url = new URL(s);
        } catch (Exception e){
            System.out.println("Wrong URL " + s);
            System.exit(-1);
        }
        
        Scanner scan = null;
        try{
            scan = new Scanner(url.openStream());
        } catch (Exception e) {
            System.out.println("No connection to " + s);
            System.exit(-1);
        }
        
        String str = new String();
        while (scan.hasNext()) {
            str += scan.nextLine() + "\n";
        }
        scan.close();
        
        Gson gson = new Gson();
        Immunizations i = gson.fromJson(str, Immunizations.class);
        System.out.println(i);  
    
        XYChart.Series<String, Number> failedSeries  = new XYChart.Series();
        Information[] info = i.getFact();
        for(Information singular : info){
            failedSeries.getData(singular.getCOUNTRY(), singular.getValue());
        }
        chart.getValue().add(failedSeries);
    }
}