package test;
import crypto.Cle;
import crypto.Crypto2;
import java.util.Scanner;
public class Test1 {
    private static Scanner sc;

	public static void main(String[] args){
        sc = new Scanner(System.in);
        System.out.println("Saisie de la cle (il s'agit d'une clé chaine): \n");
        String c1;
        do{
            System.out.println("Donner la cle1 : ");
            c1=sc.nextLine();
            c1=c1.toUpperCase();
        }while(!Cle.testcle(c1) || c1.length()  < 1 );
        String c2;
        do{
            System.out.println("Donner la cle2 : ");
            c2=sc.nextLine();
            c2=c2.toUpperCase();
        }while(!Cle.testcle(c2) || c2.length()!=c1.length() || c2.length()  < 1 );
        
        Cle cle=new Cle(c1,c2);
        String msg;
        do {
        	System.out.println("Donner le msg à crypter: \n");
            msg= sc.nextLine();
        }while(msg.length()<1);
        String msgcrypte=Crypto2.chiffrer(msg,cle);
        System.out.println("Msg crypté :\n" + msgcrypte.toLowerCase());
        String msgdecrypte=Crypto2.dechiffrer(msgcrypte,cle);
        String msgdecrypte1=Crypto2.dechiffrer(msgcrypte);
        System.out.println("Msg decrypté pour test (initial) *AVEC CLE:\n" + msgdecrypte.toLowerCase());
        System.out.println("Msg decrypté pour test (initial) *SANS CLE:\n" + msgdecrypte1.toLowerCase());
    }
    
}