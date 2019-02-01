package crypto;

import crypto.algorithms.DES;
import crypto.algorithms.DESede;
import crypto.algorithms.AES;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author Amir Aslan Aslani
 */
public class CryptoConstants {
    public static final String[] CRYPTO = new String[]{
        "AES",
        "DESede (3DES)",
        "DES"
    };
    
    public static final Class<CryptoAlgorithm>[] CRYPTO_INSTANCES = new Class[]{
        AES.class,
        DESede.class,
        DES.class
    };
    
    public static CryptoAlgorithm getCryptoAlgorithmInstanceByID(int id,String key) throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        Constructor<CryptoAlgorithm> constructor = CRYPTO_INSTANCES[id].getConstructor(String.class);
        CryptoAlgorithm ca = constructor.newInstance(new Object[]{key});
        return ca;
    }
}
