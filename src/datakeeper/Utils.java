package datakeeper;

import java.util.Collection;

/**
 *
 * @author Amir Aslan Aslani
 */
public class Utils {
    
    public static String[] StringCollectionToArray(Collection<String> c){
        c.remove(null);
        
        String[] listData = new String[c.size()];
        
        int i = 0;
        for(String str : c){
            listData[i ++] = str;
        }
        
        return listData;
    }
}
