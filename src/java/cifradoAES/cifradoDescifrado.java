/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifradoAES;

/**
 *
 * @author ISSAC
 */
public class cifradoDescifrado {
    public static void main(String[] args) 
{
    final String secretKey = "ssshhhhhhhhhhh!!!!";
     
    String originalString = "hb";
    String encryptedString = AES.encrypt(originalString, secretKey) ;
    String decryptedString = AES.decrypt(encryptedString, secretKey) ;
     
    System.out.println(originalString);
    System.out.println(encryptedString);
    System.out.println(decryptedString);

}
}
