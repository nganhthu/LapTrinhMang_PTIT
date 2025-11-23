/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Acer
 */
import vn.medianews.*;
import java.util.*;

public class DoDaiMaxMin {
    public static void main(String[] args) throws Exception{
        String msv ="B21DCCN699", qCode ="agag";
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        String s = port.requestString(msv, qCode);
        String[]res = s.trim().split("\\s+");
        int lenMin = res[0].length();
        int lenMax = res[0].length();
        String strMin = res[0];
        String strMax = res[0];
        for(String x : res){
            if(x.length()<lenMin){
                strMin = x;
                lenMin = x.length();
            }
            if(x.length()>lenMax){
                strMax = x;
                lenMax = x.length();
            }
        }
        String ans = strMax + ";" + strMin;
        port.submitCharacterString(msv, qCode, ans);
    }
}
