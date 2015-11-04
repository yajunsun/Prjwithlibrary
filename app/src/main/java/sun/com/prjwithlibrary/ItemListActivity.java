package sun.com.prjwithlibrary;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.iconics.IconicsDrawable;

import itemanimator.CustomItemAnimator;


/**
 * Created by yajunsun on 2015/10/26.
 */
public class ItemListActivity extends AppCompatActivity {
    private RecyclerView rv;
    private int itemCount = 9;
    private int[] imgdrawables;
    private String[] str1s;
    private String[] str2s;
    private final static int listType = 1;//列表方式
    private final static int gridType = 2;//表格方式
    private static int showType = listType;//当前表现方式
    private Menu thismenu;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        thismenu = menu;
        getMenuInflater().inflate(R.menu.menu_main, thismenu);
        switch (showType) {
            case gridType:
                thismenu.getItem(0).setIcon(new IconicsDrawable(this, GoogleMaterial.Icon.gmd_list).sizeDp(24).color(Color.RED));
                //thismenu.getItem(0).setIcon(R.drawable.ic_view_headline_black_18dp);
                break;
            case listType:
                //thismenu.getItem(0).setIcon(R.drawable.ic_view_module_black_18dp);
                thismenu.getItem(0).setIcon(new IconicsDrawable(this, GoogleMaterial.Icon.gmd_grid_on).sizeDp(24).color(Color.RED));
                break;
        }
        return true;
        //return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.action_type:
                BindData();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemlist);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        fillData();
        rv = (RecyclerView) findViewById(R.id.list);
        rv.setAdapter(new rcvAdapter());
        rv.setItemAnimator(new CustomItemAnimator());
        rv.setLayoutManager(new LinearLayoutManager(this));
    }

    private void BindData() {
        switch (showType) {
            case listType:
                rv.setLayoutManager(new GridLayoutManager(this, 2));
                invalidateOptionsMenu();
                showType = gridType;
                break;
            case gridType:
                rv.setLayoutManager(new LinearLayoutManager(this));
                invalidateOptionsMenu();
                showType = listType;
                break;
        }
    }

    private void fillData() {
        imgdrawables = new int[]{
                android.R.drawable.ic_dialog_alert,
                android.R.drawable.ic_btn_speak_now,
                android.R.drawable.ic_delete,
                android.R.drawable.ic_dialog_dialer,
                android.R.drawable.ic_dialog_email,
                android.R.drawable.ic_dialog_info,
                android.R.drawable.ic_dialog_map,
                android.R.drawable.ic_input_add,
                android.R.drawable.ic_input_get
        };
        str1s = new String[]{
                "蒙田", "歌德", "何其芳", " 罗素", "马尔林斯基", "巴尔扎克", "高尔基", "洛克", "刘易斯"
        };
        str2s = new String[]{
                "我需要三件东西：爱情友谊和图书。然而这三者之间何其相通！炽热的爱情可以充实图书的内容，图书又是人们最忠实的朋友",
                "这世界要是没有爱情，它在我们心中还会有什么意义！这就如一盏没有亮光的走马灯",
                "爱情原如树叶一样，在人忽视里绿了，在忍耐里露出蓓蕾",
                "爱情只有当它是自由自在时，才会叶茂花繁。认为爱情是某种义务的思想只能置爱情于死地。只消一句话：你应当爱某个人，就足以使你对这个人恨之入骨",
                "毫无经验的初恋是迷人的，但经得起考验的爱情是无价的",
                "过放荡不羁的生活，容易得像顺水推舟，但是要结识良朋益友，却难如登天",
                "生活有度，人生添寿",
                "我读的书愈多，就愈亲近世界，愈明了生活的意义，愈觉得生活的重要",
                "人生的磨难是很多的，所以我们不可对于每一件轻微的伤害都过于敏感。在生活磨难面前，精神上的坚强和无动于衷是我们抵抗罪恶和人生意外的最好武器"
        };
    }

    private class rcvAdapter extends RecyclerView.Adapter<ViewHolder> {
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(ItemListActivity.this).inflate(R.layout.listitem, parent, false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            holder.iv.setImageDrawable(getResources().getDrawable(imgdrawables[position]));
            holder.txt1.setText(str1s[position]);
            holder.txt2.setText(str2s[position]);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                                                   @Override
                                                   public void onClick(View v) {
                                                       Intent intent = new Intent(ItemListActivity.this, ItemDetail.class);
                                                       intent.putExtra("imgdrawable", imgdrawables[position]);
                                                       intent.putExtra("str1", str1s[position]);
                                                       intent.putExtra("str2", str2s[position]);
                                                       startActivity(intent);
                                                   }
                                               }
            );
        }

        @Override
        public int getItemCount() {
            return itemCount;
        }


    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView txt1;
        TextView txt2;

        public ViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.iv);
            txt1 = (TextView) itemView.findViewById(R.id.txt1);
            txt2 = (TextView) itemView.findViewById(R.id.txt2);
        }
    }
}
