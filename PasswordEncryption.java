/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SwingGui;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 *
 * @author CoOl
 */
public class PasswordEncryption {
     /*
    manage user bata encrypt password ma password ko (password) ma j value pathau chau tei value ayera encrypt value ma bascha
    */
    public static String encryptpassword(String inputValue){
        String salt="admin123!@#";//encrypt string
        //admin123!@#
        String inputValuewithsalt=inputValue+salt;//a+admin123!@3=aadmin123!@#
        String encryptedValue=null;
        if(null==inputValue)return null;
        
        try{
            
            MessageDigest digest=MessageDigest.getInstance("MD5");
            
            
            
            digest.update(inputValuewithsalt.getBytes(),0,inputValuewithsalt.length());
            encryptedValue=new BigInteger(1,digest.digest()).toString(16);
        }catch(Exception e){
            System.out.println("not converted");
        }
    return encryptedValue;
    }
}
