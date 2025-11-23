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

public class ChuanHoaCHuoi {
    public static String ChuanHoa(String str){
        return Character.toUpperCase(str.charAt(0)) + str.substring(1).toLowerCase();
    }
    public static void main(String[] args) throws Exception{
        String msv ="B21DCCN014", qCode = "vvouxTi5";
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        String s = port.requestString(msv, qCode);
        System.out.println(s);
        List<String>ans = new java.util.ArrayList<>();
        s = s.replace("_", " ");
        String[]res = s.trim().split("\\s+");
        String p = "";
        String c = res[0].toLowerCase();
        String sn = "";
        for(String x : res) p += ChuanHoa(x);
        System.out.println(p);
        for(int i = 1; i<res.length; i++){
            c += ChuanHoa(res[i]);
        }
        System.out.println(c);
        for(String x : res) sn += x.toLowerCase() + "_";
        sn = sn.substring(0, sn.length()-1);
        System.out.println(sn);
        ans.add(p); ans.add(c); ans.add(sn);
        port.submitCharacterStringArray(msv, qCode, ans);
    }
}
