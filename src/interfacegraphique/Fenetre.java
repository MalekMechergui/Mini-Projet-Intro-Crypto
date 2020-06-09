package interfacegraphique;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.CardLayout ; 
import javax.swing.JTextField ; 

import crypto.Cle;
import crypto.Crypto1;
import crypto.Crypto2;
import crypto.Crypto3;

public class Fenetre extends JFrame{
	static CardLayout c=new CardLayout() ; 
	static JPanel content= new JPanel() ; 
	
	static String[] listContent ={"MenuPrincipal","Crypto1","Crypto2","Crypto3","Decrypatge1","Decrypatge2","Decrypatge3"} ; 
	 
	
	public Fenetre (){
		
		  	
		  	JButton b1 =new JButton("CRYPTO niveau 1 ") ; 
		  	JButton b2 =new JButton("CRYPTO niveau 2 ") ; 
		  	JButton b3 =new JButton("CRYPTO niveau 3 ") ; 
		  	JButton b4 =new JButton("DECRYPTO niveau 1 ") ; 
		  	JButton b5 =new JButton("DECRYPTO niveau 2 ") ; 
		  	JButton b6 =new JButton("DECRYPTO niveau 3 ") ; 
		  	// -------------------------------------------------- 
		  	JPanel menuPrincipale = menuPrincipale(b1,b2,b3,b4,b5,b6) ; 
		  	content.setLayout(c); 
		    content.add(menuPrincipale,listContent[0]) ;
		  	
		  	JPanel crypto1 = crypto1() ;		
		  	JPanel crypto2 = crypto2() ;	
		  	JPanel crypto3 = crypto3() ; 
		    JPanel decrypto1= decrypto1() ;
		    JPanel decrypto2= decrypto2() ;
		    JPanel decrypto3= decrypto3() ;
		    		
		    JPanel c3 = new JPanel();
		    c3.setBackground(Color.green);
		    this.setTitle("Mini Projet Java");
		    this.setSize(500, 750);
		    this.setLocationRelativeTo(null);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
		    
		    
		    content.add(crypto1,listContent[1]) ;
		    content.add(crypto2,listContent[2]) ;
		    content.add(crypto3,listContent[3]) ;
		    content.add(decrypto1,listContent[4]) ;
		    content.add(decrypto2,listContent[5]) ;
		    content.add(decrypto3,listContent[6]) ;
		    this.setContentPane(content);
		    this.setVisible(true);
		    b1.addActionListener(new ActionListener(){
		        public void actionPerformed(ActionEvent event){				
		          
		          c.show(content, listContent[1]);
		        }
		      });
		    b2.addActionListener(new ActionListener(){
		        public void actionPerformed(ActionEvent event){				
		          
		          c.show(content, listContent[2]);
		        }
		      });
		    b3.addActionListener(new ActionListener(){
		        public void actionPerformed(ActionEvent event){				
		          
		          c.show(content, listContent[3]);
		        }
		        
		      });
		    b4.addActionListener(new ActionListener(){
		        public void actionPerformed(ActionEvent event){				
		          
		          c.show(content, listContent[4]);
		        }
		        
		      });
		    b5.addActionListener(new ActionListener(){
		        public void actionPerformed(ActionEvent event){				
		          
		          c.show(content, listContent[5]);
		        }
		        
		      });
		    b6.addActionListener(new ActionListener(){
		        public void actionPerformed(ActionEvent event){				
		          
		          c.show(content, listContent[6]);
		        }
		        
		      });
		
		  }
		public static JPanel menuPrincipale(JButton b1,JButton b2,JButton b3,JButton b4,JButton b5,JButton b6){
			JPanel menu = new JPanel() ;
			//defintion des boutons de le menu principale  
			JPanel bouton  = new JPanel() ;
			JPanel bouton2  = new JPanel() ;
			
		  	b1.setPreferredSize(new Dimension(150,100)) ; 
		  	b2.setPreferredSize(new Dimension(150,100)) ;
		  	b3.setPreferredSize(new Dimension(150,100)) ;
		  	b4.setPreferredSize(new Dimension(150,100)) ;
		  	b5.setPreferredSize(new Dimension(150,100)) ;
		  	b6.setPreferredSize(new Dimension(150,100)) ;
			
		  	menu.setBackground(Color.BLACK);
		
		    //bouton.setLayout(new BoxLayout(pan,BoxLayout.LINE_AXIS)); 
		    bouton.add(b1);
		    bouton.add(b2) ; 
		    bouton.add(b3) ;
		    bouton2.add(b4) ;
		    bouton2.add(b5) ;
		    bouton2.add(b6) ;
		    JLabel label1 =new JLabel("BIENVENUE AU MINI PROJET (CR/DEC)YPTO!!") ;
		    JLabel label2 =new JLabel("Choisir le niveau de cryptage :") ;
		    JLabel label3 =new JLabel("Choisir le niveau de decryptage :") ;
		    Font police = new Font ("Arial",Font.BOLD,17) ; 
		    label1.setPreferredSize(new Dimension(400,50)) ;
		    label1.setForeground(Color.red);
		    label1.setFont(police); 
		    label2.setPreferredSize(new Dimension(400,50)) ; 
		    label2.setFont(police);
		    label2.setForeground(Color.BLUE);
		    label3.setPreferredSize(new Dimension(400,50)) ; 
		    label3.setFont(police);
		    label3.setForeground(Color.BLUE);
		    menu.add(label1);
		    menu.add(label2);
		    menu.add(bouton);
		    menu.add(label3);
		    menu.add(bouton2) ; 
			return menu ; 
		}
		public static JPanel crypto2(){  
			JPanel c1=new JPanel() ;
			JButton b7 = new JButton("Menu Principal") ;
			b7.setPreferredSize(new Dimension(500,30)) ;
			c1.add(b7) ; 
		    b7.addActionListener(new ActionListener(){
		        public void actionPerformed(ActionEvent event){				
		          
		          c.show(content, listContent[0]);
		        }
		        
		      });
		  
			JLabel texteL =new JLabel("Entrer le texte à crypter : ") ; 
			JLabel texteE =new JLabel("") ; 
			JLabel cle1L =new JLabel("Donner la cle1 : ") ; 
			JLabel cle1E =new JLabel(" ") ; 
			JLabel cle2L =new JLabel("Donner la cle2 : ") ; 
			JLabel cle2E =new JLabel(" ") ;
			JLabel texteChL =new JLabel("Le texte crypté est : ") ; 
			JTextField texte=new JTextField("## Attention! Le message ne doit pas etre vide! ") ;  
			JTextField cle1=new JTextField("(Lettres)") ;
			JTextField cle2=new JTextField("(Lettres) et meme taille cle1") ;
			JTextField texteCh=new JTextField("") ;
			Font police = new Font ("Arial",Font.BOLD,14) ; 
			Font police2= new Font ("Arial",Font.BOLD,10) ; 
			// set
			texteL.setFont(police); 
			texteL.setPreferredSize(new Dimension(400,50)) ; 
			texteL.setForeground(Color.BLUE);
			cle1L.setFont(police); 
			cle1L.setPreferredSize(new Dimension(150,50)) ; 
			cle1L.setForeground(Color.BLUE);
			cle2L.setFont(police); 
			cle2L.setPreferredSize(new Dimension(150,50)) ; 
			cle2L.setForeground(Color.BLUE);
			texteChL.setFont(police); 
			texteChL.setPreferredSize(new Dimension(400,50)) ; 
			texteChL.setForeground(Color.BLUE);
			//ok 
			texteE.setFont(police2); 
			texteE.setPreferredSize(new Dimension(400,20)) ; 
			texteE.setForeground(Color.GREEN);
			cle1E.setFont(police2); 
			cle1E.setPreferredSize(new Dimension(400,20)) ; 
			cle1E.setForeground(Color.GREEN);
			cle2E.setFont(police2); 
			cle2E.setPreferredSize(new Dimension(400,20)) ; 
			cle2E.setForeground(Color.GREEN);
			
			
			//ok 
			texte.setFont(police); 
			texte.setPreferredSize(new Dimension(450,150)) ; 
			texte.setForeground(Color.red);
			cle1.setFont(police); 
			cle1.setPreferredSize(new Dimension(150,50)) ; 
			cle1.setForeground(Color.red);
			cle2.setFont(police); 
			cle2.setPreferredSize(new Dimension(150,50)) ; 
			cle2.setForeground(Color.red);
			texteCh.setFont(police); 
			texteCh.setPreferredSize(new Dimension(450,100)) ; 
			texteCh.setForeground(Color.red);
			c1.setBackground(Color.BLACK);
			
			JButton cry=new JButton("CRYPTE !!!" ) ; 
			cry.setPreferredSize(new Dimension(400,80)) ; 
			c1.add(b7) ; 
			c1.add(texteL) ; 
			c1.add(texte) ;
			c1.add(texteE) ; 
			c1.add(cle1L) ; 
			c1.add(cle1) ; 
			c1.add(cle1E) ; 
			c1.add(cle2L) ;
			c1.add(cle2) ;
			c1.add(cle2E) ; 
			c1.add(cry) ; 
			c1.add(texteChL);
			c1.add(texteCh) ;
			cry.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent event){	
		    		Boolean v=true ; 
		    		String cE1 =cle1.getText()  ;
		    		if (!Cle.testcle(cE1) || cE1.length()  < 1 ) {
		    			v=false ; 
		    			cle1E.setForeground(Color.red);
		    			cle1E.setText("Erreur !!!!!!!! ");  
		    		}
		    		else {
		    			cle1E.setForeground(Color.green);
		    			cle1E.setText("Valide !!!!!!!! ");
		    		}
		    		String cE2 =cle2.getText()  ; 
		    		if (!Cle.testcle(cE2) || cE2.length()!=cE1.length() || cE2.length()  < 1 ) {
		    			v=false ; 
		    			cle2E.setForeground(Color.RED);
		    			cle2E.setText("Erreur !!!!!!!! ");  
		    		}
		    		else {
		    			cle2E.setForeground(Color.green);
		    			cle2E.setText("Valide !!!!!!!! ");
		    		}
		    		String  text =texte.getText()  ;
		    		if (text.length()<1 ) {
		    			v=false ; 
		    			texteE.setForeground(Color.red);
		    			texteE.setText("Erreur !!!!!!!! ");  
		    		}
		    		else {
		    			texteE.setForeground(Color.green);
		    			texteE.setText("Valide !!!!!!!! ");
		    		}
		    		if (v){
		    		Cle cle = new Cle(cE1,cE2) ;
		 	        String msgcrypte=Crypto2.chiffrer(text,cle);
		    		texteCh.setText(msgcrypte);
		    		}
		    		else 
		    		{
		    			texteCh.setText("Impossible de crypter il y a une erreur !!!!" );
		    		}
		        }
		      });
	   
	        
			return c1 ; 
			
			}
		public static JPanel crypto1(){  
 			JPanel c1=new JPanel() ;
			//--------------------------------
			JButton b7 = new JButton("Menu Principal") ;
			b7.setPreferredSize(new Dimension(500,30)) ;
			c1.add(b7) ; 
		    b7.addActionListener(new ActionListener(){
		        public void actionPerformed(ActionEvent event){				
		          
		          c.show(content, listContent[0]);
		        }
		        
		      });
		    //---------------------------------------------------------------
		
			JLabel texteL =new JLabel("Entrer le texte à crypter : ") ; 
			JLabel texteE =new JLabel("") ; 
			JLabel cle1L =new JLabel("Donner la cle1 : ") ; 
			JLabel cle1E =new JLabel(" ") ; 
			JLabel cle2L =new JLabel("Donner la cle2 : ") ; 
			JLabel cle2E =new JLabel(" ") ;
			JLabel texteChL =new JLabel("Le texte crypté est : ") ; 
			JTextField texte=new JTextField("##Attention! Le message ne doit pas etre vide!") ;  
			JTextField cle1=new JTextField("(Lettres)") ;
			JTextField cle2=new JTextField("(Lettres)et meme taille cle1 ") ;
			JTextField texteCh=new JTextField("") ;
			Font police = new Font ("Arial",Font.BOLD,14) ; 
			Font police2= new Font ("Arial",Font.BOLD,10) ; 
			// set
			texteL.setFont(police); 
			texteL.setPreferredSize(new Dimension(400,50)) ; 
			texteL.setForeground(Color.BLUE);
			cle1L.setFont(police); 
			cle1L.setPreferredSize(new Dimension(150,50)) ; 
			cle1L.setForeground(Color.BLUE);
			cle2L.setFont(police); 
			cle2L.setPreferredSize(new Dimension(150,50)) ; 
			cle2L.setForeground(Color.BLUE);
			texteChL.setFont(police); 
			texteChL.setPreferredSize(new Dimension(400,50)) ; 
			texteChL.setForeground(Color.BLUE);
			//ok 
			texteE.setFont(police2); 
			texteE.setPreferredSize(new Dimension(400,20)) ; 
			texteE.setForeground(Color.GREEN);
			cle1E.setFont(police2); 
			cle1E.setPreferredSize(new Dimension(400,20)) ; 
			cle1E.setForeground(Color.GREEN);
			cle2E.setFont(police2); 
			cle2E.setPreferredSize(new Dimension(400,20)) ; 
			cle2E.setForeground(Color.GREEN);
			
			
			//ok 
			texte.setFont(police); 
			texte.setPreferredSize(new Dimension(400,100)) ; 
			texte.setForeground(Color.RED);
			cle1.setFont(police); 
			cle1.setPreferredSize(new Dimension(150,50)) ; 
			cle1.setForeground(Color.RED);
			cle2.setFont(police); 
			cle2.setPreferredSize(new Dimension(150,50)) ; 
			cle2.setForeground(Color.RED);
			texteCh.setFont(police); 
			texteCh.setPreferredSize(new Dimension(400,100)) ; 
			texteCh.setForeground(Color.BLUE);
			c1.setBackground(Color.BLACK);
			
			JButton cry=new JButton("CRYPTE !!!" ) ; 
			cry.setPreferredSize(new Dimension(400,80)) ; 
			c1.add(b7) ; 
			c1.add(texteL) ; 
			c1.add(texte) ;
			c1.add(texteE) ; 
			c1.add(cle1L) ; 
			c1.add(cle1) ; 
			c1.add(cle1E) ; 
			c1.add(cle2L) ;
			c1.add(cle2) ;
			c1.add(cle2E) ; 
			c1.add(cry) ; 
			c1.add(texteChL);
			c1.add(texteCh) ;
			cry.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent event){	
		    		Boolean v=true ; 
		    		String cE1 =cle1.getText()  ;
		    		cE1=cE1.toUpperCase() ; 
		    		char cle1C='?' ; 
		    		if (cE1.length()!= 0 ){
		    			cle1C=cE1.charAt(0);
		    		}
		    		if (((int)cle1C>90 || (int)cle1C<65) || (cE1.length()!=1)) {
		    			v=false ; 
		    			cle1E.setForeground(Color.red);
		    			cle1E.setText("Erreur !!!!!!!! ");  
		    		}
		    		else {
		    			cle1E.setForeground(Color.green);
		    			cle1E.setText("Valide !!!!!!!! ");
		    		}
		    		String cE2 =cle2.getText()  ; 
		    		cE2=cE2.toUpperCase() ; 
		    		char cle2C='?' ; 
		    		if (cE2.length()!= 0 ){
		    			cle2C=cE2.charAt(0);
		    		}
		    		if (((int)cle2C>90 || (int)cle2C<65) || (cE2.length()!=1)) {
		    			v=false ; 
		    			cle2E.setForeground(Color.RED);
		    			cle2E.setText("Erreur !!!!!!!! ");  
		    		}
		    		else {
		    			cle2E.setForeground(Color.green);
		    			cle2E.setText("Valide !!!!!!!! ");
		    		}
		    		String  text =texte.getText()  ;
		    		if (text.length()<1 ) {
		    			v=false ; 
		    			texteE.setForeground(Color.red);
		    			texteE.setText("Erreur !!!!!!!! ");  
		    		}
		    		else {
		    			texteE.setForeground(Color.green);
		    			texteE.setText("Valide !!!!!!!! ");
		    		}
		    		if (v){
		    		Cle cle = new Cle(cle1C,cle2C) ;
		 	        String msgcrypte=Crypto1.chiffrer(text,cle);
		    		texteCh.setText(msgcrypte);
		    		}
		    		else 
		    		{
		    			texteCh.setText("Impossible de crypter il y a une erreur !!!!" );
		    		}
		        }
		      });
	   
	        
			return c1 ; 
			
			}
		public static JPanel decrypto1(){  
			JPanel c1=new JPanel() ;
			//------------------------
			JButton b7 = new JButton("Menu Principal") ;
			b7.setPreferredSize(new Dimension(500,30)) ;
			c1.add(b7) ; 
		    b7.addActionListener(new ActionListener(){
		        public void actionPerformed(ActionEvent event){				
		          
		          c.show(content, listContent[0]);
		        }
		        
		      });
		    //----------------------------------------
		
			JLabel texteL =new JLabel("Entrer le texte à decrypter : ") ; 
			JLabel texteE =new JLabel("") ; 
			JLabel cle1L =new JLabel("Donner la cle1 : ") ; 
			JLabel cle1E =new JLabel(" ") ; 
			JLabel cle2L =new JLabel("Donner la cle2 : ") ; 
			JLabel cle2E =new JLabel(" ") ;
			JLabel texteChL =new JLabel("Le texte decrypté est : ") ; 
			JTextField texte=new JTextField("##Attention! Le message ne doit pas etre vide! ") ;  
			JTextField cle1=new JTextField("(Une seule lettre!)") ;
			JTextField cle2=new JTextField("(Une seule lettre!)") ;
			JTextField texteCh=new JTextField("") ;
			Font police = new Font ("Arial",Font.BOLD,14) ; 
			Font police2= new Font ("Arial",Font.BOLD,10) ; 
			// set
			texteL.setFont(police); 
			texteL.setPreferredSize(new Dimension(400,50)) ; 
			texteL.setForeground(Color.BLUE);
			cle1L.setFont(police); 
			cle1L.setPreferredSize(new Dimension(150,50)) ; 
			cle1L.setForeground(Color.BLUE);
			cle2L.setFont(police); 
			cle2L.setPreferredSize(new Dimension(150,50)) ; 
			cle2L.setForeground(Color.BLUE);
			texteChL.setFont(police); 
			texteChL.setPreferredSize(new Dimension(400,50)) ; 
			texteChL.setForeground(Color.BLUE);
			//ok 
			texteE.setFont(police2); 
			texteE.setPreferredSize(new Dimension(400,20)) ; 
			texteE.setForeground(Color.GREEN);
			cle1E.setFont(police2); 
			cle1E.setPreferredSize(new Dimension(400,20)) ; 
			cle1E.setForeground(Color.GREEN);
			cle2E.setFont(police2); 
			cle2E.setPreferredSize(new Dimension(400,20)) ; 
			cle2E.setForeground(Color.GREEN);
			
			
			//ok 
			texte.setFont(police); 
			texte.setPreferredSize(new Dimension(400,100)) ; 
			texte.setForeground(Color.RED);
			cle1.setFont(police); 
			cle1.setPreferredSize(new Dimension(150,50)) ; 
			cle1.setForeground(Color.RED);
			cle2.setFont(police); 
			cle2.setPreferredSize(new Dimension(150,50)) ; 
			cle2.setForeground(Color.RED);
			texteCh.setFont(police); 
			texteCh.setPreferredSize(new Dimension(400,100)) ; 
			texteCh.setForeground(Color.BLUE);
			c1.setBackground(Color.BLACK);
			
			JButton cry=new JButton("DECRYPTE !!!" ) ; 
			cry.setPreferredSize(new Dimension(400,80)) ; 
			c1.add( b7) ; 
			c1.add(texteL) ; 
			
			c1.add(texte) ;
			c1.add(texteE) ; 
			c1.add(cle1L) ; 
			c1.add(cle1) ; 
			c1.add(cle1E) ; 
			c1.add(cle2L) ;
			c1.add(cle2) ;
			c1.add(cle2E) ; 
			c1.add(cry) ; 
			c1.add(texteChL);
			c1.add(texteCh) ;
			cry.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent event){	
		    		Boolean v=true ; 
		    		String cE1 =cle1.getText()  ;
		    		cE1=cE1.toUpperCase() ; 
		    		char cle1C='?' ; 
		    		if (cE1.length()!= 0 ){
		    			cle1C=cE1.charAt(0);
		    		}
		    		
		    		if (((int)cle1C>90 || (int)cle1C<65) || (cE1.length()!=1)) {
		    			v=false ; 
		    			cle1E.setForeground(Color.red);
		    			cle1E.setText("Erreur !!!!!!!! ");  
		    		}
		    		else {
		    			cle1E.setForeground(Color.green);
		    			cle1E.setText("Valide !!!!!!!! ");
		    		}
		    		String cE2 =cle2.getText()  ; 
		    		cE2=cE2.toUpperCase() ; 
		    		char cle2C='?' ; 
		    		if (cE2.length()!= 0 ){
		    			cle2C=cE2.charAt(0);
		    		}
		    		
		    			
		    		if ((int)cle2C>90 || (int)cle2C<65 || ((cE2.length())!=1)) {
		    			v=false ; 
		    			cle2E.setForeground(Color.RED);
		    			cle2E.setText("Erreur !!!!!!!! ");  
		    		}
		    		else {
		    			cle2E.setForeground(Color.green);
		    			cle2E.setText("Valide !!!!!!!! ");
		    		}
		    		String  text =texte.getText()  ;
		    		if (text.length()<1 ) {
		    			v=false ; 
		    			texteE.setForeground(Color.red);
		    			texteE.setText("Erreur !!!!!!!! ");  
		    		}
		    		else {
		    			texteE.setForeground(Color.green);
		    			texteE.setText("Valide !!!!!!!! ");
		    		}
		    		if (v){
		    		Cle cle = new Cle(cle1C,cle2C) ;
		 	        String msgDecrypte=Crypto1.dechiffrer(text,cle);
		    		texteCh.setText(msgDecrypte);
		    		}
		    		else 
		    		{
		    			texteCh.setText("Impossible de decrypter il y a une erreur !!!!" );
		    		}
		        }
		      });
	   
	        
			return c1 ; 
			
			}
		public static JPanel decrypto2(){  
			JPanel c1=new JPanel() ;
			//--------------
			JButton b7 = new JButton("Menu Principal") ;
			b7.setPreferredSize(new Dimension(500,30)) ;
			c1.add(b7) ; 
		    b7.addActionListener(new ActionListener(){
		        public void actionPerformed(ActionEvent event){				
		          
		          c.show(content, listContent[0]);
		        }
		        
		      });
		    //------------------------------------------------
		
			JLabel texteL =new JLabel("Entrer le texte à decrypter : ") ; 
			JLabel texteE =new JLabel("") ; 
			
			JLabel texteChL =new JLabel("Le texte decrypté est : ") ; 
			JTextField texte=new JTextField("##Attention! Le message ne doit pas etre vide! ") ;  
			
			JTextField texteCh=new JTextField("") ;
			Font police = new Font ("Arial",Font.BOLD,14) ; 
			Font police2= new Font ("Arial",Font.BOLD,10) ; 
			// set
			texteL.setFont(police); 
			texteL.setPreferredSize(new Dimension(400,50)) ; 
			texteL.setForeground(Color.BLUE);
			
			texteChL.setFont(police); 
			texteChL.setPreferredSize(new Dimension(400,100)) ; 
			texteChL.setForeground(Color.BLUE);
			//ok 
			texteE.setFont(police2); 
			texteE.setPreferredSize(new Dimension(400,20)) ; 
			texteE.setForeground(Color.GREEN);
			
			
			//ok 
			texte.setFont(police); 
			texte.setPreferredSize(new Dimension(400,100)) ; 
			texte.setForeground(Color.RED);
			
			texteCh.setFont(police); 
			texteCh.setPreferredSize(new Dimension(400,100)) ; 
			texteCh.setForeground(Color.BLUE);
			c1.setBackground(Color.BLACK);
			
			JButton cry=new JButton("DECRYPTE !!!" ) ; 
			cry.setPreferredSize(new Dimension(400,80)) ;
			c1.add(b7) ; 
			c1.add(texteL) ; 
			c1.add(texte) ;
			c1.add(texteE) ; 
			c1.add(cry) ; 
			c1.add(texteChL);
			c1.add(texteCh) ;
			cry.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent event){	
		    		Boolean v=true ; 
		    	
		    		String  text =texte.getText()  ;
		    		if (text.length()<1 ) {
		    			v=false ; 
		    			texteE.setForeground(Color.red);
		    			texteE.setText("Erreur !!!!!!!! ");  
		    		}
		    		else {
		    			texteE.setForeground(Color.green);
		    			texteE.setText("Valide !!!!!!!! ");
		    		}
		    		if (v){
		    		
		 	        String msgcrypte=Crypto2.dechiffrer(text);
		    		texteCh.setText(msgcrypte);
		    		}
		    		else 
		    		{
		    			texteCh.setText("Impossible de crypter il y a une erreur !!!!" );
		    		}
		        }
		      });
	   
	        
			return c1 ; 
			
			}
		public static JPanel crypto3(){  
			JPanel c1=new JPanel() ;
			JButton b7 = new JButton("Menu Principale") ;
			b7.setPreferredSize(new Dimension(500,30)) ;
			c1.add(b7) ; 
		    b7.addActionListener(new ActionListener(){
		        public void actionPerformed(ActionEvent event){				
		          
		          c.show(content, listContent[0]);
		        }
		        
		      });
		    //----------------------------------------------------------------------------
		    String[] tab = {"Niveau 1", "Niveau 2", "Niveau 3"};
		    JComboBox combo = new JComboBox(tab);
		    //Ajout du listener
		
		    combo.setPreferredSize(new Dimension(100, 20));
		    combo.setForeground(Color.blue);
		    //---------------------------------------------------------------------------
			JLabel texteL =new JLabel("Entrer le texte à crypter : ") ; 
			JLabel texteE =new JLabel("") ; 
			JLabel cleLabel = new JLabel("Choisir le niveau de securite de la cle : ");
			JLabel texteChL =new JLabel("Le texte crypté est : ") ;
			JLabel cleLabelGen=new JLabel("La cle de cryptage est : ") ; 
			JLabel dureeDeCryptage= new JLabel("Duree de cryptage en (ns) : ") ;
			//----------------------------------------------------------------------------------
			JTextField texte=new JTextField("##Attention! Le message ne doit pas etre vide!") ;  
			JTextField texteCh=new JTextField("") ;
			JTextField cleGen=new JTextField("") ;
			JTextField duree=new JTextField("") ; 
			
			//----------------------------------------------------------------------------------
	
			//-----------------------------------------------------------------------------------
			Font police = new Font ("Arial",Font.BOLD,14) ; 
			Font police2= new Font ("Arial",Font.BOLD,10) ; 
			// set
			texteL.setFont(police); 
			texteL.setPreferredSize(new Dimension(350,50)) ; 
			texteL.setForeground(Color.BLUE);
			texteChL.setFont(police); 
			texteChL.setPreferredSize(new Dimension(350,50)) ; 
			texteChL.setForeground(Color.BLUE);
			cleLabel.setFont(police);
			cleLabel.setPreferredSize(new Dimension(350,50)) ; 
			cleLabel.setForeground(Color.BLUE);
			cleGen.setFont(police);
			cleGen.setPreferredSize(new Dimension(400,50)) ; 
			cleGen.setForeground(Color.BLUE);
			cleLabelGen.setFont(police);
			cleLabelGen.setPreferredSize(new Dimension(400,50)) ; 
			cleLabelGen.setForeground(Color.BLUE);
			//ok 
			texteE.setFont(police2); 
			texteE.setPreferredSize(new Dimension(400,20)) ; 
			texteE.setForeground(Color.GREEN);
			
			
			
			//ok 
			texte.setFont(police); 
			texte.setPreferredSize(new Dimension(400,50)) ; 
			texte.setForeground(Color.RED);
			texteCh.setFont(police); 
			texteCh.setPreferredSize(new Dimension(400,50)) ; 
			texteCh.setForeground(Color.BLUE);
			duree.setFont(police); 
			duree.setPreferredSize(new Dimension(400,50)) ; 
			duree.setForeground(Color.BLUE);
			dureeDeCryptage.setFont(police); 
			dureeDeCryptage.setPreferredSize(new Dimension(350,50)) ; 
			dureeDeCryptage.setForeground(Color.BLUE);
			
			//-------------------------------------------
			c1.setBackground(Color.BLACK);
			JButton cry=new JButton("CRYPTE !!!" ) ; 
			cry.setPreferredSize(new Dimension(400,80)) ; 
			c1.add(b7) ; 
			c1.add(texteL) ; 
			c1.add(texte) ;
			c1.add(texteE) ; 
			c1.add(cleLabel) ; 
			c1.add(combo) ;
			c1.add(cry) ; 
			c1.add(texteChL);
			c1.add(texteCh) ;
			cry.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent event){	
		    	Boolean v= true ; 
		    	String text = texte.getText() ; 
		    	if (text.length()<1 ) 
		    	{
		    		v=false ; 
		    		texteE.setForeground(Color.RED);
		    		texteE.setText("Erreur !!!!!!!!!!!!!!!!!!!");
		    	}
		    	else 
		    	{
		    		texteE.setForeground(Color.green);
		    		texteE.setText("valide !!!!!!!!!!!!!!!!!!!");
		    	}
		    	if (v) {
		    		String niv =(String) combo.getSelectedItem() ;
		    		String textecrypte="" ; 
		    		int[] niveauSecurite ={128,192,256};
		    		SecretKey cle ; 
		    		if (niv.equals(tab[0])) {
		    			cle=Crypto3.generateurDeCle(niveauSecurite[0]);
		    			}
		    		else if (niv.equals(tab[1])){
		    			cle=Crypto3.generateurDeCle(niveauSecurite[1]);
		    		}
		    		else{
		    			cle=Crypto3.generateurDeCle(niveauSecurite[2]);
		    		}
		    		c1.add(cleLabelGen) ; 
		    		c1.add(cleGen) ;
		    		String stringKey = keyToString(cle); 
		    		cleGen.setText(stringKey );
		    		long debutCryptage = System.nanoTime();
		    		try {
						textecrypte = Crypto3.chiffrer(text,cle) ;
					} catch (Exception e) {e.printStackTrace();
					}
		    		long finCryptage = System.nanoTime();
		    		texteCh.setText(textecrypte);
		    		c1.add(dureeDeCryptage) ; 
		    		long du =(finCryptage-debutCryptage)  ; 
		    		String s=String.valueOf(du) ;
		    		duree.setText(s);
		    		 
		    		c1.add(duree); 
		    		
		
		    		}
		    	else {
		    		texteCh.setText("impossible de crypter il y a une erreur ") ; 
		    	}
		    	
		    		
		        }
		      });
	   
	        
			return c1 ; 
			
			}
		public static JPanel decrypto3(){  
			JPanel c1=new JPanel() ;
			JButton b7 = new JButton("Menu Principal") ;
			b7.setPreferredSize(new Dimension(500,30)) ;
			c1.add(b7) ; 
		    b7.addActionListener(new ActionListener(){
		        public void actionPerformed(ActionEvent event){				
		          
		          c.show(content, listContent[0]);
		        }
		        
		      });
		    //----------------------------------------------------------------------------
		  
			JLabel texteL =new JLabel("Entrer le texte à decrypter : ") ; 
			JLabel texteE =new JLabel("") ; 
			JLabel cleLabel = new JLabel("Entrer la cle de securite : ");
			JLabel texteChL =new JLabel("Le texte decrypté est : ") ; 
			JLabel dureeDeCryptage= new JLabel("Duree de cryptage en (ns) : ") ;
			JLabel cleLabelErreur = new JLabel("");
			//----------------------------------------------------------------------------------
			JTextField texte=new JTextField("##Attention! Le message ne doit pas etre vide!") ;  
			JTextField texteCh=new JTextField("") ;
			JTextField cleGen=new JTextField("") ;
			JTextField duree=new JTextField("") ; 
			
			//----------------------------------------------------------------------------------
	
			//-----------------------------------------------------------------------------------
			Font police = new Font ("Arial",Font.BOLD,14) ; 
			Font police2= new Font ("Arial",Font.BOLD,10) ; 
			// set
			texteL.setFont(police); 
			texteL.setPreferredSize(new Dimension(350,50)) ; 
			texteL.setForeground(Color.BLUE);
			texteChL.setFont(police); 
			texteChL.setPreferredSize(new Dimension(350,50)) ; 
			texteChL.setForeground(Color.BLUE);
			cleLabel.setFont(police);
			cleLabel.setPreferredSize(new Dimension(350,50)) ; 
			cleLabel.setForeground(Color.BLUE);
			cleGen.setFont(police);
			cleGen.setPreferredSize(new Dimension(400,50)) ; 
			cleGen.setForeground(Color.BLUE);
			cleLabelErreur.setFont(police);
			cleLabelErreur.setPreferredSize(new Dimension(400,50)) ; 
			cleLabelErreur.setForeground(Color.BLUE);
			
			//ok 
			texteE.setFont(police2); 
			texteE.setPreferredSize(new Dimension(400,20)) ; 
			texteE.setForeground(Color.GREEN);
			//ok 
			texte.setFont(police); 
			texte.setPreferredSize(new Dimension(400,150)) ; 
			texte.setForeground(Color.RED);
			texteCh.setFont(police); 
			texteCh.setPreferredSize(new Dimension(400,150)) ; 
			texteCh.setForeground(Color.BLUE);
			duree.setFont(police); 
			duree.setPreferredSize(new Dimension(400,50)) ; 
			duree.setForeground(Color.BLUE);
			dureeDeCryptage.setFont(police); 
			dureeDeCryptage.setPreferredSize(new Dimension(350,50)) ; 
			dureeDeCryptage.setForeground(Color.BLUE);
			
			//-------------------------------------------
			c1.setBackground(Color.BLACK);
			JButton cry=new JButton("DECRYPTE !!!" ) ; 
			cry.setPreferredSize(new Dimension(400,80)) ; 
			c1.add(b7) ; 
			c1.add(texteL) ; 
			c1.add(texte) ;
			c1.add(texteE) ; 
			c1.add(cleLabel) ; 
			c1.add(cleGen ) ; 
			c1.add(cry) ; 
			c1.add(texteChL);
			c1.add(texteCh) ;
			cry.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent event){	
		    	Boolean v= true ; 
		    	String text = texte.getText() ; 
		    	String texteDecrypte="" ; 
		    	if (text.length()<1 ) 
		    	{
		    		v=false ; 
		    		texteE.setForeground(Color.RED);
		    		texteE.setText("Erreur !!!!!!!!!!!!!!!!!!!");
		    	}
		    	else 
		    	{
		    		texteE.setForeground(Color.green);
		    		texteE.setText("valide !!!!!!!!!!!!!!!!!!!");
		    	}
		    	if (v) {
		    	String cleG = cleGen.getText() ;
		    	SecretKey Key = decodeKeyFromString(cleG) ; 
		    	long debutDecryptage = System.nanoTime();
		    		try {
						texteDecrypte = Crypto3.dechiffrer(text,Key ) ;
					} catch (Exception e) {e.printStackTrace();
					}
		    		long finDecryptage = System.nanoTime();
		    		texteCh.setText(texteDecrypte);
		    		c1.add(dureeDeCryptage) ; 
		    		long du =(finDecryptage-debutDecryptage)  ; 
		    		String s=String.valueOf(du) ;
		    		duree.setText(s);
		    		 
		    		c1.add(duree); 
		    		
		
		    		}
		    	else {
		    		texteCh.setText("impossible de decrypter il y a une erreur ") ; 
		    	}
		    	
		    		
		        }
		      });
	   
	        
			return c1 ; 
			
			}
		public static String keyToString(SecretKey secretKey) {
			  /* Get key in encoding format */
			  byte encoded[] = secretKey.getEncoded();

			  /*
			   * Encodes the specified byte array into a String using Base64 encoding
			   * scheme
			   */
			  String encodedKey = Base64.getEncoder().encodeToString(encoded);

			  return encodedKey;
			 }

		public static SecretKey decodeKeyFromString(String keyStr) {
			  /* Decodes a Base64 encoded String into a byte array */
			  byte[] decodedKey = Base64.getDecoder().decode(keyStr);

			  /* Constructs a secret key from the given byte array */
			  SecretKey secretKey = new SecretKeySpec(decodedKey, 0,
			    decodedKey.length, "AES");

			  return secretKey;
			 }
}

		
		
