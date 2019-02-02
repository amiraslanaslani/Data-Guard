package crypto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Base64;

/**
 *
 * @author Amir Aslan Aslani
 */
public class CryptoTools {
    public static final int AES = 0;
    public static final int TRIPLE_DES = 1;
    public static final int DES = 2;
    
    private static byte[] getFileBytes(File file) throws Exception{
        FileInputStream fis = new FileInputStream(file);
        byte[] fileBytes = new byte[(int) file.length()];
        fis.read(fileBytes);
        fis.close();
        return fileBytes;
    }
    
    private static void saveBytesInFile(File file,byte[] bytes) throws Exception{
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(bytes);
        fos.close();
    }
    
    public static byte[] readFileAndEncrypt(int Algorithm, String key, File file) throws Exception{
        byte[] fileBytes = getFileBytes(file);
        byte[] encrypted = getByteArrayEncrypt(Algorithm, key, fileBytes);
        return encrypted;
    }
    
    public static byte[] readFileAndDecrypt(int Algorithm, String key, File file) throws Exception{
        byte[] fileBytes = getFileBytes(file);
        byte[] decrypted = getByteArrayDecrypt(Algorithm, key, fileBytes);
        return decrypted;
    }
    
    public static void encryptBytesAndSaveFile(int Algorithm, String key, File file, byte[] bytes) throws Exception{
        byte[] byteArrayEncrypt = getByteArrayEncrypt(Algorithm, key, bytes);
        saveBytesInFile(file, byteArrayEncrypt);
    }
    
    public static void decryptBytesAndSaveFile(int Algorithm, String key, File file, byte[] bytes) throws Exception{
        byte[] byteArrayEncrypt = getByteArrayDecrypt(Algorithm, key, bytes);
        saveBytesInFile(file, byteArrayEncrypt);
    }
    
    public static void fileEncrypt(int Algorithm,String key, File source, File destination) throws Exception{
        byte[] encrypted = readFileAndEncrypt(Algorithm, key, source);
        saveBytesInFile(destination, encrypted);
    }
    
    public static void fileDecrypt(int Algorithm,String key, File source, File destination) throws Exception{
        byte[] decrypted = readFileAndDecrypt(Algorithm, key, source);
        saveBytesInFile(destination, decrypted);
    }
    
    public static byte[] getStringEncrypt(int Algorithm, String key, String secret) throws Exception{
        byte[] encrypt = getByteArrayEncrypt(Algorithm, key, secret.getBytes());
        return encrypt;
    }
    
    public static String getStringEncryptBase64(int Algorithm, String key, String secret) throws Exception{
        byte[] getStringEncrypt = getStringEncrypt(Algorithm, key, secret);
        byte[] encodeBase64 = Base64.getEncoder().encode(getStringEncrypt);
        return new String(encodeBase64);
    }
    
    public static byte[] getStringDecrypt(int Algorithm, String key, String secret) throws Exception{
        byte[] decrypt = getByteArrayDecrypt(Algorithm, key, secret.getBytes());
        return decrypt;
    }
    
    public static String getBase64StringDecrypt(int Algorithm, String key, String secret) throws Exception{
        byte[] decodeBase64 = Base64.getDecoder().decode(secret);
        byte[] decrypt = getByteArrayDecrypt(Algorithm, key, decodeBase64);
        return new String(decrypt);
    }
    
    public static byte[] getByteArrayEncrypt(int Algorithm, String key, byte[] secret) throws Exception{
        CryptoAlgorithm ca = CryptoConstants.getCryptoAlgorithmInstanceByID(Algorithm, key);
        return ca.encrypt(secret);
    }
    
    public static byte[] getByteArrayDecrypt(int Algorithm, String key, byte[] secret) throws Exception{
        CryptoAlgorithm ca = CryptoConstants.getCryptoAlgorithmInstanceByID(Algorithm, key);
        return ca.decrypt(secret);
    }
}
