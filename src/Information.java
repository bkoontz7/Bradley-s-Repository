/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author csstudent
 */
public class Information {
    private InfoAtt dim;
    private int Value;
    
    public InfoAtt getDim(){
        return dim;
    }
    public int getValue(){
        return Value;
    }
    @Override
    public String toString(){
        return dim.getCOUNTRY() + " " + ":" + " " + this.getValue() + "%";
    }
}