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

public class LocKyTu {
    public static void main(String[] args) throws Exception{
        String msv="B21DCCN699", qCode ="jkahsgk";
        CharacterService_Service  service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        String s = port.requestString(msv, qCode);
        String ans ="";
        for(char x : s.toCharArray()){
            if(Character.isAlphabetic(x)){
                ans = x + ans;
            }
        }
        port.submitCharacterString(msv, qCode, ans);
    }
}
