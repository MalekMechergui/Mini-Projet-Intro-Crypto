package crypto;
public class Crypto1 {    
    
	public static String chiffrer(String text, Cle cle){ //crypter un texte avec un couple de clés carcatere
        String chiff="";
        String text1=text.toUpperCase();
        for (int i=0;i<text1.length();i++){
            if (text1.charAt(i)==cle.getcle1()) //cle1 dans la chaine est remplacée par cle2
            {
                chiff=chiff+cle.getcle2();
            }
            else if(text1.charAt(i)==cle.getcle2()) //le caractere à chiffrer est cle2 on le remplace par cle1 pour eviter les problemes dans le decryptage 
            {             
                chiff=chiff+cle.getcle1();              
            }
            else //la caractere est ni la cle1 ni la cle2
            {
                chiff=chiff+text1.charAt(i);
            }
        }
        return(chiff);
    }
    public static String dechiffrer(String mot, Cle cle){ //decrypter un texte avec une clé caractere
                                                          //operations inverses de la fonction precedante
        String dechiff="";
        String mot1=mot.toUpperCase();
        for (int i=0;i<mot1.length();i++){
            if (mot1.charAt(i)==cle.getcle2())
            {
                dechiff=dechiff+cle.getcle1();
            }
            else if(mot1.charAt(i)==cle.getcle1())
            {
                dechiff=dechiff+cle.getcle2();
            }
            else 
            {
                dechiff=dechiff+mot1.charAt(i);
            }
        }
        return(dechiff);
    }
     
}
