package crypto;
public class Cle {      //Classe clé pour les clés carcateres et chaines
    private char cle1;
    private char cle2;
    private String clestr1;
    private String clestr2;
    public Cle(){               //Constructeur par défaut
        cle1='?';
        cle2='?';
    }
    public Cle(char c1,char c2){    //Constructeur des clés caracteres(utiliser les majiscules seulement)
        String cl1="",cl2="";
        cl1=cl1+c1; cl1=cl1.toUpperCase();
        cl2=cl2+c2; cl2=cl2.toUpperCase();
        cle1=cl1.charAt(0);
        cle2=cl2.charAt(0); 
    }
    public Cle(String c1,String c2){    //Constructeur des clés chaines(utiliser des clés chaines en majiscule)
       String cl1,cl2; 
       cl1=c1.toUpperCase(); 
       cl2=c2.toUpperCase();
       clestr1=cl1;
       clestr2=cl2;
    }
    public void setcle1(char c1){      //definir la 1ere clé caractere 
        cle1=c1;
    }
    public void setcle2(char c2){      //definir la 2eme clé caractere
        cle2=c2;
    }
    public char getcle1(){          //retourne la 1ere clé caractere
        return(cle1);
    }
    public char getcle2(){          //retourne la 2eme clé caractere
        return(cle2);
    }
    public void setclestr1(String c1){      //definir la 1ere clé chaine
        clestr1=c1;
    }
    public void setclestr2(String c2){      //definir la 2eme clé chaine
        clestr2=c2;
    }
    public String getclestr1(){     //retourne la 1ere clé chaine
        return(clestr1);
    }
    public String getclestr2(){     //retourne la 2eme clé chaine
        return(clestr2);
    }
    public static boolean testcle(String ch){   //validation de la clé chaine
        String ch1=ch.toUpperCase();
        char [] tab;
        tab = ch1.toCharArray();
        for (int i=0;i<ch.length();i++){
            int occ=0;
            char x=tab[i];
            if ((int)x<65 || (int)x>90) return(false);  //la clé chaine n'est pas constituée de caracteres alphabetiques
                                                        //utiliser les codes ASCI
            for (int j=0;j<ch.length();j++){           
               if (x==tab[j]) occ=occ+1;
            }
            if (occ>1)return(false);        //la clé chaine ne contient pas la meme lettre 2 fois!!
        }
        return(true);
    }
    
}  