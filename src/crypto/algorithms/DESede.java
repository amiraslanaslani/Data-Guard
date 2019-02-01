package crypto.algorithms;

import crypto.StandardCryptoAlgorihm;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 *
 * @author Amir Aslan Aslani
 */
public class DESede extends StandardCryptoAlgorihm{
    
    public DESede(String key) {
        super(key,"DESede");
    }

    @Override
    public void setKey(String key) {
        try {
            byte[] digestOfPassword = MessageDigest.getInstance("md5").digest(key.getBytes());
            
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            
            for (int j = 0, k = 16; j < 8;) {
                keyBytes[k++] = keyBytes[j++];
            }
            
            this.keyValue = keyBytes;
            
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
    }
    
}
