package crypto.algorithms;

import crypto.StandardCryptoAlgorihm;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amir Aslan Aslani
 */
public class AES extends StandardCryptoAlgorihm{

    public AES(String key) {
        super(key,"AES");
    }
    
    /**
     *
     * @param key
     */
    @Override
    public void setKey(String key){        
        if(key.length() <= 16){
            this.keyValue = setKeyWithSize(key,16);
        }
        else if(key.length() <= 24){
            this.keyValue = setKeyWithSize(key,24);
        }
        else{
            this.keyValue = setKeyWithSize(key,32);
        }
    }
    
    protected byte[] setKeyWithSize(String key, int size){
        try {
            
            byte[] digestOfPassword = MessageDigest.getInstance("md5").digest(key.getBytes());
            
            byte[] newKey = new byte[size];
        
            for(int i = 0;i < size;i ++){
                if(i < key.getBytes().length)
                    newKey[i] = key.getBytes()[i];
                else
                    newKey[i] = digestOfPassword[i % digestOfPassword.length];
            }
            return newKey;
            
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AES.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new byte[size];
    }
    
}
