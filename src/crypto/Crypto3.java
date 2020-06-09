package crypto;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Crypto3 {
	
	
	
	static Cipher cipher;
	
	
	public static SecretKey generateurDeCle(int niveauDeSecurite) 
	{
		KeyGenerator keyGenerator = null;
		try {
			keyGenerator = KeyGenerator.getInstance("AES");
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		}
		keyGenerator.init(niveauDeSecurite);
		SecretKey secretKey = keyGenerator.generateKey();
		try {
			cipher = Cipher.getInstance("AES");
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
		
			e.printStackTrace();
		}
		return secretKey;
	}

	public static String chiffrer(String TextaCrypte, SecretKey cle)
			throws Exception {
		byte[] plainTextByte = TextaCrypte.getBytes();
		cipher.init(Cipher.ENCRYPT_MODE, cle);
		byte[] crypte= cipher.doFinal(plainTextByte);
		Base64.Encoder encoder = Base64.getEncoder();
		String encryptedText = encoder.encodeToString(crypte);
		return encryptedText;
	}

	public static String dechiffrer(String textcrypte , SecretKey cle)
			throws Exception {
		Base64.Decoder d = Base64.getDecoder();
		byte[] textCrypteB = d.decode(textcrypte);
		cipher.init(Cipher.DECRYPT_MODE, cle);
		byte[]  textDecrypteB = cipher.doFinal( textCrypteB);
		String Textdecrypte = new String( textDecrypteB );
		return Textdecrypte;
	}
}