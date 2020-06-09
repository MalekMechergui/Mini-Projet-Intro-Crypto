package crypto;
public class Crypto2{
    
	private static int[] alphabet(Cle cle){ //tableau ayant comme indices les codes ASCII de l'alphabet
                                            //le contenu du tableau correspond au code ASCII de la lettre correspondante 
											//en cryptage ou en decryptage.
        int[] tab;
        tab = new int[26];
        for (int i=0;i<=25;i++){tab[i]=i;} 	//initialiser le tableau aux lettres ordoonnées de l'alphabet. 
        for (int i=0;i<cle.getclestr1().length();i++){
        	
        	int x=(int)cle.getclestr1().charAt(i)-65;		//modification du contenu du tableau selon la clé donnée.
            int y=(int)cle.getclestr2().charAt(i)-65;
            int z=tab[x];
            tab[x]=tab[y];
            tab[y]=z;
        }
        return(tab);
    } 
    
	public static String chiffrer(String text, Cle cle){ //chiffrer une chaine avec une cle chaine
        
		int [] tab=alphabet(cle);	//on obtient un tableau d'alphabet de contenu réorganisé selon la clé
        String chiff="";
        String text1=text.toUpperCase(); 	//on a utilisé le code ASCII de l'alphabet majiscule.
        for (int i=0;i<text1.length();i++){
            
        	int x=(int)text1.charAt(i)-65;	
            
        	if (x>=0 && x<=25){		//si la lettre appartient à l'intervalle des lettres en majiscule
                chiff=chiff+(char)(tab[x]+65);
            }
            else
                {chiff=chiff+text1.charAt(i);}	//sinon le cacartere n'est pas une lettre alphabetique(à garder).
        }
        return(chiff);                
    }
	
	public static String dechiffrer(String text, Cle cle){ //dechiffrer une chaine avec une cle de chaines
        
		int [] tab=alphabet(cle);	//on obtient un tableau d'alphabet de contenu réorganisé selon la clé
        String dechiff="";
        String text1=text.toUpperCase();
        for (int i=0;i<text1.length();i++){
        	
            int x=(int)text1.charAt(i)-65;
            if (x>=0 && x<=25){			//si la lettre à decrypter est une lettre majiscule selon l'ASCII
                int j;					//on aura besoin de l'indice de la lettre.
                for (j=0;j<tab.length;j++){
                	
                    if (tab[j]==x) break; } //recherche de l'indice j correspondant à la lettre chiffrée selon la clé. 
             
                dechiff=dechiff+(char)(j+65);
            }
            else
            	
            	{dechiff=dechiff+text1.charAt(i);}   //sinon le caractere n'est pas une lettre alphabetique(à garder).         
    }
        return(dechiff);
   }
	
	private static int indmax(int [] t){  //fonction qui retourne l'indice du max d'un tableau  
       
		int max=t[0],ind=0;
		for (int i=1;i<t.length;i++){
           if (t[i]>=max)
           {
               max=t[i];
               ind=i;
           }
        }
       return(ind);
   }
	
   private static int[] nbreOcc(String msg){
       
	   int[] nbOcc=new int [26] ; //tableau de 26 entiers (code ASCII des letltres etant les indices)
       
	   for  (int i=0;i<26;i++){ //initialiser un tableau des nombres d'occurence de chaque lettre à zero. 
            
		   nbOcc[i]=0;
		   
	   }
        
	   	int x ; 
        for (int i=0;i<msg.length();i++){
            
        	x=(int)(msg.charAt(i))-65; //si le caractere est une lettre on incremente le nbre d'occurence de 1.
            if (x>=0 && x<=25)
            {
                nbOcc[x]=nbOcc[x]+1;
            }
        }
        return nbOcc ; //retourne un tableau qui contient le nombre d'occurence de chaque lettre de msg.
       
   }
   
   private static int[] nbreOccurenceApres(String msg,int ordreAlphabitique){ //A partir d'un msg et de l'ordre alphabetique 
	   																		  //d'une lettre donnée contenu dans ce msg 
	   																		 //cette fonction retourne un tableau qui contient 
	   																		 //le nombre d'occurence des lettres qui viennent apres.
	   																		
       
	   int[] nbreOccApres=new int [26] ;
       
	   for  (int i=0;i<26;i++){
            nbreOccApres[i]=0;
        }
        int x,y ; 
        for (int i=0;i<msg.length()-1;i++){
            
        	x=(int)(msg.charAt(i))-65; 	
            y=(int)(msg.charAt(i+1))-65 ; 
            
            if (x==ordreAlphabitique && 0<=y && y<=65){
            										//si le caractere est le meme que la lettre qu'on demande 
            										//de calculer le nbre d'occurence des lettres qui viennet apres
            										//on incremente le nbre d'occurence de 1.
            	nbreOccApres[y]=nbreOccApres[y]+1;
            }
        }
        return nbreOccApres ; 
       
   }
   
   
   private static int[] nbreOccurenceAvant(String msg, int ordreAlphabitique){
	   																	//A partir d'un msg et de l'ordre alphabetique 
		  																//d'une lettre donnée contenu dans ce msg 
		 																//cette fonction retourne un tableau qui contient 
	   																	//le nombre d'occurence des lettres qui viennent avant.
       
	   int[] nbreOccAvant=new int [26] ;
       for  (int i=0;i<26;i++){
            nbreOccAvant[i]=0;
        }
        int x,y ; 
        for (int i=1;i<msg.length()-1;i++){
            
        	x=(int)(msg.charAt(i))-65;
            y=(int)(msg.charAt(i-1))-65 ; 
            if (x==ordreAlphabitique && 0<=y && y<=65)		//si le caractere est le meme que la lettre qu'on demande 
											//de calculer le nbre d'occurence des lettres qui viennet avant
											//on incremente le nbre d'occurence de 1.
            {
                nbreOccAvant[y]=nbreOccAvant[y]+1;
            }
        }
        return nbreOccAvant ; 
       
   }   
   
   

   public static String dechiffrer(String text){ //dechiffrer une chaine en utilisant l'analyse frequentiel des lettres français(sans clé).
        
	   
        String text1=text.toUpperCase();
        
        int[] nbOcc=nbreOcc(text1);
        int indE=indmax(nbOcc) ; //indice de la lettre E correpsond à l'indice de l'occurence maximale.
                
        
        String cle1=""+(char)(indE+65) ; 
        Cle cle=new Cle("E",cle1) ; 
        String dechiffre1=dechiffrer(text1,cle) ; //dechiffrer la lettre correspondante à E dans text1  
        int[] nbreOccurenceApresE=nbreOccurenceApres(dechiffre1.toUpperCase(),((int)('E')-65)) ; 
        nbOcc[indE]=0 ; //pour trouver la 2eme lettre la plus frequente dans text1. 
        int indA=indmax(nbOcc); //2eme lettre la plus frequente dans text1 peut etre S ou A. 
        int indS=indmax(nbreOccurenceApresE) ; //la lettre la plus frequente apres E est S. 
        nbreOccurenceApresE[indS]=0 ;
        int indN=indmax(nbreOccurenceApresE) ; //la lettre la plus frequente apres E est encore N (avec des proportions proches de S). 
        String cle2 ; 
        if (indS != indA  ){//dans ce cas la lettre qui apparait le plus dans le text1(apres E qui a le nbre d'occurence le plus elevé)
        					//est A ensuite vient S de plus on connait la lettre qui chiffre N. Donc on peut identifier ces lettres.        					    
        	
        	cle2=""+(char)(indS+65)+(char)(indA+65)+(char)(indN+65) ;
        
        }
        
        else {
        	
        	nbOcc[indA]=0; 
        	indA= indmax(nbOcc) ; //dans ce cas la lettre qui apparait le plus dans le text1(apres E qui a le nbre d'occurence 
                                     //le plus elevé) est S ensuite vient A.
        	
        	cle2=""+(char)(indS+65)+(char)(indA+65)+(char)(indN+65) ;
        	
        }
        Cle cleSAN=new Cle("SAN",cle2) ; 
        String dechiffrer2=dechiffrer(dechiffre1,cleSAN) ; 
        int[] nbreOccurenceAvantA=nbreOccurenceAvant(dechiffrer2,0) ;
        int[] nbreOccurenceAvantN=nbreOccurenceAvant(dechiffrer2,((int)('N')-65)) ; 
        int indL=indmax(nbreOccurenceAvantA);// il trop frquent de trouve 'L' Avant 'A' dans la langue francais .
        nbreOccurenceAvantN[((int)('A'))-65]=0;//il est tres frequent de trouve 'O' et 'A' et 'E' Avant N dans la langue francais 
        nbreOccurenceAvantN[((int)('E')-65)]=0;//donc on peut identifier 'O' . 
        int indO=indmax(nbreOccurenceAvantN); 
        int[] nbreOccurenceApresN=nbreOccurenceApres(dechiffrer2,((int)('N')-65)) ; 
        nbreOccurenceApresN[((int)('S'))-65]=0;//il est tres frequent de trouve 'T' et 'S' et 'E' Apres N dans la langue francais 
        nbreOccurenceApresN[((int)('E')-65)]=0;//donc on peut identifer 'T' 
        int indT=indmax(nbreOccurenceApresN);
        String cle3 = "" +(char)(indL+65)+(char)(indO+65)+(char)(indT+65);
        Cle cleLD=new Cle("LOT",cle3) ; 
        return dechiffrer(dechiffrer2,cleLD) ; 
        
   
        
   }
 
}