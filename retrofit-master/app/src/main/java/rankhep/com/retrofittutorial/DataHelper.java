package rankhep.com.retrofittutorial;

import android.content.Context;
import android.content.SharedPreferences;

public class DataHelper {
    Context mContext;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    DataHelper(Context context){
        mContext = context;
        preferences = mContext.
                getSharedPreferences("Tutorial", Context.MODE_PRIVATE);
        editor = preferences.edit();
//        preferences = context.getSharedPreferences("Safood", Context.MODE_PRIVATE);
//        editor = preferences.edit();
    }

    public void saveText(String text){
        editor.putString("text",text);//key,value
        editor.apply();
    }

    public String getText(){
        return preferences.getString("text","");
    }






//    private SharedPreferences preferences;
//    private SharedPreferences.Editor editor;
//
//    public DataManager(Context c) {
//        this.context = c;
//        preferences = context.getSharedPreferences("Safood", Context.MODE_PRIVATE);
//        editor = preferences.edit();
//    }
//
//    public void save(String key, String data) {
//        editor.putString(key, data);
//        editor.apply();
//    }
//
//    public void saveUserInfo(User user) {
//        editor.putString(USER_SCHEMA, new Gson().toJson(user));
//        editor.putBoolean(HAS_ACTIVE_USER, true);
//        editor.apply();
//    }
}
