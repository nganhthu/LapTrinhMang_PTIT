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

public class ChuoiDoDaiTangDan {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN699", qCode = "fhdsaghl";
        CharacterService_Service  service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        List<String>a = port.requestStringArray(msv, qCode);
        Collections.sort(a, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return s1.length() - s2.length();
            }
        });
        
        port.submitCharacterStringArray(msv, qCode, a);
    }
}
