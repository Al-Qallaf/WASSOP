package wasso.dundee.ac.uk;


import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class TabWidget extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Resources res = getResources();
        TabHost tabHost = getTabHost(); 
        TabHost.TabSpec spec; 
        Intent intent;  

       
        intent = new Intent().setClass(this, ShareSystemActivity.class);
        spec = tabHost.newTabSpec("Shares").setIndicator("Shares",
                          res.getDrawable(R.drawable.ic_tab_chan))
                      .setContent(intent);
        tabHost.addTab(spec);
        
        intent = new Intent().setClass(this, viewsalerts.class);
        spec = tabHost.newTabSpec("Alerts").setIndicator("Alerts",
                          res.getDrawable(R.drawable.ic_tab_share))
                      .setContent(intent);
        tabHost.addTab(spec);
        
        //intent = new Intent().setClass(this, viewtotal.class);
        spec = tabHost.newTabSpec("Portfolio").setIndicator("Worth&Total",
                          res.getDrawable(R.drawable.ic_tab_port))
                      .setContent(new Intent(this, viewtotal.class)
                      .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
        tabHost.addTab(spec);
        //tabHost.setCurrentTab(0);
    }
}
