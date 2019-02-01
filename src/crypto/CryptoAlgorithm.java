package crypto;

/**
 *
 * @author Amir Aslan Aslani
 */
public abstract class CryptoAlgorithm {
    
    protected byte[] keyValue;
    
    public CryptoAlgorithm(String key){
        this.setKey(key);
    }
    
    /**
     *
     * @param key
     */
    public abstract void setKey(String key);
    
    /**
     * Encrypt a string with AES algorithm.
     *
     * @param data is a string
     * @return the encrypted string
     * @throws java.lang.Exception
     */
    public abstract byte[] encrypt(byte[] data) throws Exception ;
    
    /**test
     * Decrypt a string with AES algorithm.
     *
     * @param data is a string
     * @return the decrypted string
     * @throws java.lang.Exception
     */
    public abstract byte[] decrypt(byte[] data) throws Exception ;
    
}
