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

public class NhomNguyenAm {
    private static int Dem(String str){
            int cnt = 0;
            String ngam = "aeuioAEUIO";
            for(int i = 0; i<str.length(); i++){
                if(ngam.indexOf(str.charAt(i)) != -1){
                    cnt++;
                }
            }
            return cnt;
    }
    public static void main(String[] args) throws Exception{
        String msv = "B17DCCN043", qCode = "aOuykVny";
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        List<String>a = port.requestStringArray(msv, qCode);
        
        System.out.println(a);
        Collections.sort(a, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                if(Dem(s1)!=Dem(s2)) return Dem(s1) - Dem(s2);
                return s1.compareTo(s2);
            }    
        });
        
        List<String>ans = new java.util.ArrayList<>();
        String gr = a.get(0);
        for(int i = 1; i < a.size(); i++){
            if(Dem(a.get(i)) == Dem(a.get(i-1))) gr += ", " + a.get(i);
            else{
                ans.add(gr);
                gr = a.get(i);
            }
        }
        ans.add(gr);
        port.submitCharacterStringArray(msv, qCode, ans);
        
    }
}
