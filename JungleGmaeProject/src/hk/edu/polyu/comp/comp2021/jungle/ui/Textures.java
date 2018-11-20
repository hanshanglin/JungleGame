package hk.edu.polyu.comp.comp2021.jungle.ui;

import javax.swing.ImageIcon;
import java.util.HashMap;

/**
 * Texture management system
 */
public class Textures {
    private static HashMap<String, ImageIcon> pool=new HashMap<>(18);

    static{
        String path="textures/";
        String suffix=".png";
        for (char c = 'A'; c < 'I'; c++)
            pool.put(c+"", new ImageIcon(path + c + suffix));
        for(int i=1;i<9;i++){
            pool.put(Character.toString((char)('a'+i-1)), new ImageIcon(path + i + suffix));
        }

        pool.put("board",new ImageIcon(path+"board"+suffix));
    }

    /**
     * Acquire the image for a specific String key
     * @param key key for indexing the icon
     * @return desired ImageIcon object
     */
    public static ImageIcon getIcon(String key){
        if(pool.containsKey(key))
            return pool.get(key);
        return new ImageIcon();
    }
}
