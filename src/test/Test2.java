package test;
import crypto.Cle;
import crypto.Crypto1;
import java.util.Scanner;
public class Test2 {                   //tester la classe de cryptage par une clé caractere 
    private static Scanner s;

	public static void main(String[] args){
        s = new Scanner(System.in);
        System.out.println("Saisie de la cle (un seul caractere!)\n");
        char cle1;
        String c1;
        do{
            System.out.println("Donner la cle1 : ");
            c1= s.nextLine();
            c1=c1.toUpperCase();
            cle1=c1.charAt(0);
        } while(((int)cle1>90 || (int)cle1<65) || (c1.length()!=1));
        char cle2;
        String c2;
        do{
            System.out.println("Donner la cle2 : ");
            c2= s.nextLine();
            c2=c2.toUpperCase();
            cle2=c2.charAt(0);
        } while(((int)cle2>90 || (int)cle2<65) || (c2.length()!=1)); ;
    
    Cle cle=new Cle(cle1,cle2); //creation de cle caractere
    System.out.println("Donner le msg à crypter: \n");
    String msg= s.nextLine();
    String msgcrypte=Crypto1.chiffrer(msg,cle);
    System.out.println("Msg crypté :" + msgcrypte.toLowerCase());
    String msgdecrypte=Crypto1.dechiffrer(msgcrypte,cle);
    System.out.println("Msg decrypté pour test (initial) :" + msgdecrypte.toLowerCase());
    
    }
    
}

