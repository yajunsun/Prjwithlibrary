package sun.com.prjwithlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by yajunsun on 2015/10/27.
 */
public class ItemDetail extends AppCompatActivity {
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private ImageView iv;
    private TextView txt1;
    private TextView txt2;
    private Intent intent;
    private int imgdrawable;
    private String str1, str2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listitem);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setVisibility(View.VISIBLE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        iv = (ImageView) findViewById(R.id.iv);
        txt1 = (TextView) findViewById(R.id.txt1);
        txt2 = (TextView) findViewById(R.id.txt2);
        intent = getIntent();
        imgdrawable = intent.getIntExtra("imgdrawable", android.R.drawable.sym_def_app_icon);
        str1 = intent.getStringExtra("str1");
        str2 = intent.getStringExtra("str2");
        iv.setImageDrawable(getResources().getDrawable(imgdrawable));
        txt1.setText(str1);
        txt2.setText(str2);
    }
}
