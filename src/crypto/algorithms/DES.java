package crypto.algorithms;

import crypto.StandardCryptoAlgorihm;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Amir Aslan Aslani
 */
public class DES extends StandardCryptoAlgorihm{
    
    public DES(String key) {
        super(key,"DES");
    }

    @Override
    public void setKey(String key) {
        try {
            byte[] digestOfPassword = MessageDigest.getInstance("md5").digest(key.getBytes());
            
            byte[] keyBytes = new byte[8];
            
            for (int k = 0; k < 8;k ++) {
                keyBytes[k] = (byte) (digestOfPassword[k] ^ digestOfPassword[k + 8]);
            }
            
            this.keyValue = keyBytes;
            
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
    }
    
}
