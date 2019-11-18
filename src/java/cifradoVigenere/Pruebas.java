
package cifradoVigenere;

public class Pruebas {
 
    public static void main(String[] args) {

        Vigenere vigenere = new Vigenere();
        System.out.println("Encriptamos el texto claro...");
        
        System.out.println(vigenere.encriptarTextoClaro("ÑSGE|||----", "LOUP"));
        System.out.println("Ahora desencriptamos el resultado que nos dio la encriptación anterior...");
        System.out.println(vigenere.desencriptarTextoCifrado("YHATLOUPLOU", "LOUP"));
    }
}