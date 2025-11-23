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

public class XoayVongKyTu {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN699", qCode = "gashh";
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        List<Integer>a = port.requestCharacter(msv, qCode);
        int timerot = a.get(0) % a.size();
        Collections.rotate(a, timerot);
        port.submitCharacterCharArray(msv, qCode, a);
    }
}
