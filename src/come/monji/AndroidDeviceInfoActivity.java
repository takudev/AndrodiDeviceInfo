package come.monji;

import java.lang.reflect.Field;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AndroidDeviceInfoActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        TextView tv = new TextView(this);
        StringBuffer sb = new StringBuffer();
        
        Field[] fs = Build.class.getDeclaredFields();
        for(Field f : fs){
             f.setAccessible(true);
             try{
                  sb.append(f.getName() + ":" + f.get(null) + "\n");
                  Log.d("AndroidDeviceInfo", f.getName() + ":" + f.get(null));
             }catch(Exception e){
                  e.printStackTrace();
             }
        }
        
        tv.setText(sb.toString());
        
        
        LinearLayout linearLayout_root = new LinearLayout(this);
        linearLayout_root.addView(tv);
        setContentView(linearLayout_root);
    }
}