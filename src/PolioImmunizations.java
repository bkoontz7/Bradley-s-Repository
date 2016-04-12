/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author csstudent
 */

import java.net.*;
import java.util.*;
import com.google.gson.*;
/**
 * Write a description of class PolioImmunizations here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PolioImmunizations{
    public static void main(String[] args){
        String s = "http://apps.who.int/gho/athena/data/GHO/WHS4_544.json?profile=simple&filter=YEAR:1980";
        URL myUrl = null;
        try{
            myUrl = new URL(s);
        } catch (Exception e){
            System.out.println("Wrong URL " + s);
            System.exit(-1);
        }
        
        Scanner scan = null;
        try{
            scan = new Scanner(myUrl.openStream());
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
        DataSet ds = gson.fromJson(str, DataSet.class);
        
        System.out.println(ds);
    }
}