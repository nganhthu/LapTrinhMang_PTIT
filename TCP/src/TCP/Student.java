/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;
import java.io.*;

/**
 *
 * @author Acer
 */
public class Student implements Serializable{
    private static long serialVersionUID = 20151107;
    private int id;
    private String code;
    private float gpa;
    private String gpaLetterString;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getGpaLetterString() {
        return gpaLetterString;
    }

    public void setGpaLetterString(String gpaLetterString) {
        this.gpaLetterString = gpaLetterString;
    }
    
    @Override
    public String toString(){
        return id + code + gpa + gpaLetterString;
    }
}
