package school.zx.newboston.demo.sharePreference;

import android.content.Context;
import android.content.SharedPreferences;
import school.zx.newboston.Constant;

/**
 * Created by THink on 2018/2/26.
 */

public class LogHelper {
    private String fn= Constant.LOG_FILE_NAME;
    public void setLastLogin(Context context,String lastLoginName,String lastLoginPassword) {
        SharedPreferences settings = context.getSharedPreferences(fn, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("lastLoginName", lastLoginName);
        editor.putString("lastLoginPassword",lastLoginPassword);
        editor.commit();
    }
    public String getLastLoginName(Context context) {
        SharedPreferences settings =context.getSharedPreferences(fn, 0);
        return settings.getString("lastLoginName", "");
    }
    public String getLastLoginPassword(Context context){
        SharedPreferences settings =context.getSharedPreferences(fn, 0);
        return settings.getString("lastLoginPassword", "");
    }
    public void clearLastLogin(Context context){
        SharedPreferences settings = context.getSharedPreferences(fn, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.clear().commit();
    }
}
