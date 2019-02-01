package crypto;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Amir Aslan Aslani
 */
public abstract class StandardCryptoAlgorihm extends CryptoAlgorithm{

    protected String ALGO;
        
    public StandardCryptoAlgorihm(String key, String Algo) {
        super(key);
        this.ALGO = Algo;
    }
    
    /**
     * Encrypt a string with AES algorithm.
     *
     * @param data is a string
     * @return the encrypted string
     * @throws java.lang.Exception
     */
    @Override
    public byte[] encrypt(byte[] data) throws Exception {
        Key key = generateKey();
        
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(data);
        return encVal;
    }

    /**
     * Decrypt a string with AES algorithm.
     *
     * @param encryptedData is a string
     * @return the decrypted string
     * @throws java.lang.Exception
     */
    @Override
    public byte[] decrypt(byte[] encryptedData) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decValue = c.doFinal(encryptedData);
        return decValue;
    }
    
    /**
     * Generate a new encryption key.
     * @return 
     * @throws java.lang.Exception
     */
    protected Key generateKey() throws Exception {
        return new SecretKeySpec(keyValue, ALGO);
    }
}
