package PrefUtils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Alexcai on 2017/12/24.
 */

public class XCPrefUtils {

    public static boolean getBoolean(Context ctx, String key, boolean defValue){
        SharedPreferences config = ctx.getSharedPreferences("config", Context.MODE_PRIVATE);
        return config.getBoolean(key,defValue);
    }

    public static void setBoolean(Context ctx, String key,boolean value){
        SharedPreferences config = ctx.getSharedPreferences("config", Context.MODE_PRIVATE);
        config.edit().putBoolean(key,value).commit();
    }

    public static String getString(Context ctx, String key, String defValue){
        SharedPreferences config = ctx.getSharedPreferences("config", Context.MODE_PRIVATE);
        return config.getString(key,defValue);
    }

    public static void setString(Context ctx, String key,String value){
        SharedPreferences config = ctx.getSharedPreferences("config", Context.MODE_PRIVATE);
        config.edit().putString(key,value).commit();
    }
    public static int getInteger(Context ctx, String key, int defValue){
        SharedPreferences config = ctx.getSharedPreferences("config", Context.MODE_PRIVATE);
        return config.getInt(key,defValue);
    }

    public static void setIntValue(Context ctx, String key,Integer value){
        SharedPreferences config = ctx.getSharedPreferences("config", Context.MODE_PRIVATE);
        config.edit().putInt(key,value).commit();
    }

}
