package test;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import crypto.Crypto3;

public interface Test3 {

	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, Exception
	{
		

		Scanner sc = new Scanner(System.in);
		String texte; 
		int nvSecurite=0 ;
		SecretKey cle ; 
		int[] niveauSecurite ={128,192,256};
		Boolean v=true ; 
		do 
		{	System.out.println("Donner le texte à chiffrer : "); 
			texte = sc.nextLine(); 
			
			System.out.println("Choisir le niveau de sécurité (0 ou 1 ou 2 ) ");
			nvSecurite=sc.nextInt() ; 
			sc.nextLine();
			
			for (int i =0 ; i<3 ; i++ ){
				if (nvSecurite==i )
				{
					v=false ; 
					break ; 
				}
			}
			

		}while(texte.length()<1 || v   ) ; 		
		cle=Crypto3.generateurDeCle(niveauSecurite[nvSecurite]);  // Générer une clé 
		System.out.println("La cle de cryptage est :" +cle);
		long debutcryptage = System.nanoTime();
		String textecrypte = Crypto3.chiffrer(texte,cle) ;
		long fincryptage = System.nanoTime();
		//decryptage
		long debutdecryptage = System.nanoTime();
		String textedecrypte = Crypto3.dechiffrer(textecrypte,cle) ;
		long findecryptage = System.nanoTime();
		System.out.println("Voici le Texte chiffré : \n"+textecrypte);
		System.out.println("Texte déchiffré : \n"+textedecrypte);
		System.out.println("\nDurée de cryptage en ns:"+(fincryptage-debutcryptage));
		System.out.println("\nDurée de décryptage en ns:"+(findecryptage-debutdecryptage));
		

		}
		
		
	}

	