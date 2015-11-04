package sun.com.prjwithlibrary;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.iconics.IconicsDrawable;

/**
 * Created by yajunsun on 2015/10/26.
 */
public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        fb = (FloatingActionButton) findViewById(R.id.fb_view);
        fb.setImageDrawable(new IconicsDrawable(this, GoogleMaterial.Icon.gmd_email).color(Color.WHITE).actionBar());
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent
                        = new Intent(MainActivity.this, ItemListActivity.class);
                startActivity(intent);
            }
        });
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        menu.getItem(0).setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_settings:
                return true;
            case R.id.action_type:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void viewClick(View v) {
        Toast.makeText(this, "你点击了 " + v.getId(), Toast.LENGTH_SHORT).show();
    }
}
