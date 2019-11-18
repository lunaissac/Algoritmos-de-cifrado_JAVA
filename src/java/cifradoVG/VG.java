/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifradoVG;

import cifradoAES.AES;
import cifradoVigenere.Vigenere;
import java.io.IOException;
import java.security.*;
import javax.crypto.*;

//Encriptación y desencriptación con VG
public class VG {
    public static void main(String[] args) throws Exception {
        System.out.println("\n________________________________Crear clave pública y privada_____________________________________");
//Creación y obtención del par de claves
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(512);//tamaño de la clave
        KeyPair clavesRSA = keyGen.generateKeyPair();

//Clave privada
        PrivateKey clavePrivada = clavesRSA.getPrivate();

//Clave pública
        PublicKey clavePublica = clavesRSA.getPublic();

//Se pueden mostrar las claves para ver cuáles son, aunque esto no es aconsejable
        System.out.println("clavePublica: " + clavePublica);
        System.out.println("clavePrivada: " + clavePrivada);
        System.out.println("\n");
//Texto plano
        Vigenere vigenere = new Vigenere();
//Clave para AES
        final String secretKey = "ssshhhhhhhhhhh!!!!";
//Contraseña
        String originalString = "PARIS";

        System.out.println("\n________________________________CIFRADO_VG_______________________________________");

        System.out.println("Contraseña :" + originalString);
//Ciframos con Vigenère y su Clave es LOUP
        String encryptedVigenere = (vigenere.encriptarTextoClaro(originalString, "LOUP"));
        System.out.println("Cifrado Vigenère :" + encryptedVigenere);
//Ciframos con AES y su Clave es ssshhhhhhhhhhh!!!!
        byte[] bufferClaro = AES.encrypt(encryptedVigenere, secretKey).getBytes();
        String Mostrar = new String(bufferClaro);
        System.out.println("Cifrado AES :" + Mostrar);
//Ciframos con clave pública el texto plano utilizando VG
        Cipher cifrador = Cipher.getInstance("RSA");
        cifrador.init(Cipher.ENCRYPT_MODE, clavePublica);
        System.out.println("Cifrar con clave pública RSA :");
        byte[] bufferCifrado = cifrador.doFinal(bufferClaro);
        mostrarBytes(bufferCifrado);
        System.out.println("\n________________________________DESCIFRADO_VG____________________________________");
//Desencriptación utilizando la clave privada RSA
        cifrador.init(Cipher.DECRYPT_MODE, clavePrivada);
        System.out.println("Descifrar con clave privada :");
        bufferClaro = cifrador.doFinal(bufferCifrado);
        System.out.println(bufferClaro);
        System.out.println("Descifrar AES :");
        String DesifrarRSA = new String(bufferClaro);
        String decryptedAES = AES.decrypt(DesifrarRSA, secretKey);
        System.out.println(decryptedAES);
        System.out.println("Descifrar Vigenère :");
        System.out.println(vigenere.desencriptarTextoCifrado(decryptedAES, "LOUP"));
        System.out.println("\n____________________________________FIN____________________________________________");
    }
    public static void mostrarBytes(byte[] buffer) throws IOException {
        System.out.write(buffer);
    }
}
