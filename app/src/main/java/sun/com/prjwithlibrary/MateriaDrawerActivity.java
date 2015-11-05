package sun.com.prjwithlibrary;

import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.mikepenz.aboutlibraries.util.UIUtils;
import com.mikepenz.crossfader.Crossfader;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.view.IconicsImageView;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.MiniDrawer;
import com.mikepenz.materialdrawer.interfaces.OnCheckedChangeListener;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;

import utils.CrossfadeWrapper;
import utils.SystemUtils;

/**
 * Created by Administrator on 2015/10/29.
 */
public class MateriaDrawerActivity extends AppCompatActivity {
    AccountHeader accountHeader;
    Drawer result;
    MiniDrawer miniDrawer;
    com.mikepenz.iconics.view.IconicsImageView imageView;
    Crossfader crossfader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lo_materialdrawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        imageView = (IconicsImageView) findViewById(R.id.iv_main);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(false);
        final IProfile profile = new ProfileDrawerItem().withName("Yajun Sun").withIcon(getResources().getDrawable(R.drawable.yajunsun))
                .withEmail("407250568@qq.com");
        accountHeader = new AccountHeaderBuilder().withActivity(this).withTranslucentStatusBar(false)
                //.withHeaderBackground(getResources().getDrawable(R.drawable.header))
                .withHeaderBackground(new ColorDrawable(Color.parseColor("#FDFDFD")))
                .withCompactStyle(true).withHeightPx(com.mikepenz.materialize.util.UIUtils.getActionBarHeight(this))
                .withAccountHeader(R.layout.material_drawer_compact_persistent_header)
                .addProfiles(profile).withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean current) {
                        Toast.makeText(MateriaDrawerActivity.this, "My name is" + profile.getName() + " and my email is " + profile.getEmail(), Toast.LENGTH_LONG).show();
                        return false;
                    }
                })
                .withSavedInstance(savedInstanceState).withTranslucentStatusBar(true)
                .build();
        DrawerBuilder builder = new DrawerBuilder()
                .withActivity(this).withAccountHeader(accountHeader)
                .withHasStableIds(true).withToolbar(toolbar).withTranslucentStatusBar(false)
                .addDrawerItems(new PrimaryDrawerItem().withName("Red").withDescription("It will be paint to red").withIdentifier(R.color.md_red_700)
                        .withIcon(new IconicsDrawable(this, GoogleMaterial.Icon.gmd_adjust).sizeDp(24).colorRes(R.color.md_red_700)))
                .addDrawerItems(new SecondaryDrawerItem().withName("Red100").withIdentifier(R.color.md_red_100)
                        .withIcon(new IconicsDrawable(this, GoogleMaterial.Icon.gmd_adjust).sizeDp(18).colorRes(R.color.md_red_100)))
                .addDrawerItems(new SecondaryDrawerItem().withName("Red400").withIdentifier(R.color.md_red_400)
                        .withIcon(new IconicsDrawable(this, GoogleMaterial.Icon.gmd_adjust).sizeDp(18).colorRes(R.color.md_red_400)))
                .addDrawerItems(new DividerDrawerItem())
                .addDrawerItems(new PrimaryDrawerItem().withName("Green").withDescription("It will be paint to green")
                        .withIdentifier(R.color.md_green_700).withIcon(new IconicsDrawable(this, GoogleMaterial.Icon.gmd_airplay).sizeDp(24).
                                colorRes(R.color.md_green_700)))
                .addDrawerItems(new SecondaryDrawerItem().withName("Green100").withIdentifier(R.color.md_green_100)
                        .withIcon(new IconicsDrawable(this, GoogleMaterial.Icon.gmd_airplay).sizeDp(18).colorRes(R.color.md_green_100)))
                .addDrawerItems(new SecondaryDrawerItem().withName("Green400").withIdentifier(R.color.md_green_400)
                        .withIcon(new IconicsDrawable(this, GoogleMaterial.Icon.gmd_airplay).sizeDp(18).colorRes(R.color.md_green_400)))
                .addDrawerItems(new DividerDrawerItem())
                .addDrawerItems(new PrimaryDrawerItem().withName("Yellow").withDescription("It will be paint to yellow")
                        .withIdentifier(R.color.md_yellow_700).withIcon(new IconicsDrawable(this, GoogleMaterial.Icon.gmd_av_timer).sizeDp(24)
                                .colorRes(R.color.md_yellow_700)))
                .addDrawerItems(new SecondaryDrawerItem().withName("Yellow100").withIdentifier(R.color.md_yellow_100)
                        .withIcon(new IconicsDrawable(this, GoogleMaterial.Icon.gmd_av_timer).sizeDp(18).colorRes(R.color.md_yellow_100)))
                .addDrawerItems(new SecondaryDrawerItem().withName("Yellow400").withIdentifier(R.color.md_yellow_400)
                        .withIcon(new IconicsDrawable(this, GoogleMaterial.Icon.gmd_av_timer).sizeDp(18).colorRes(R.color.md_yellow_400)))
                .addDrawerItems(new DividerDrawerItem())
                .addDrawerItems(new PrimaryDrawerItem().withName("Orange").withDescription("It will be paint to orange")
                        .withIdentifier(R.color.md_deep_orange_700).withIcon(new IconicsDrawable(this, GoogleMaterial.Icon.gmd_blur_circular).sizeDp(24)
                                .colorRes(R.color.md_deep_orange_700)))
                .addDrawerItems(new SecondaryDrawerItem().withName("Orange100").withIdentifier(R.color.md_deep_orange_100)
                        .withIcon(new IconicsDrawable(this, GoogleMaterial.Icon.gmd_blur_circular).sizeDp(18).colorRes(R.color.md_deep_orange_400)))
                .addDrawerItems(new SecondaryDrawerItem().withName("Orange400").withIdentifier(R.color.md_deep_orange_400)
                        .withIcon(new IconicsDrawable(this, GoogleMaterial.Icon.gmd_blur_circular).sizeDp(18).colorRes(R.color.md_deep_orange_400)))
                .addDrawerItems(new DividerDrawerItem())
                .addDrawerItems(new PrimaryDrawerItem().withName("Blue").withDescription("It will be paint to blue")
                        .withIdentifier(R.color.md_blue_700).withIcon(new IconicsDrawable(this, GoogleMaterial.Icon.gmd_bug_report).sizeDp(24)
                                .colorRes(R.color.md_blue_700)))
                .addDrawerItems(new SecondaryDrawerItem().withName("Blue100").withIdentifier(R.color.md_blue_100)
                        .withIcon(new IconicsDrawable(this, GoogleMaterial.Icon.gmd_bug_report).sizeDp(18).colorRes(R.color.md_blue_100)))
                .addDrawerItems(new SecondaryDrawerItem().withName("Blue400").withIdentifier(R.color.md_blue_400)
                        .withIcon(new IconicsDrawable(this, GoogleMaterial.Icon.gmd_bug_report).sizeDp(18).colorRes(R.color.md_blue_400)))
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        setImageviewSource(drawerItem.getIdentifier());
                        //return false;
                        return miniDrawer.onItemClick(drawerItem);
                    }
                }).withSavedInstance(savedInstanceState);

        result = builder.buildView();

        miniDrawer = new MiniDrawer().withDrawer(result).withAccountHeader(accountHeader);
        int firstWidth = (int) UIUtils.convertDpToPixel(300, this);
        int secondWidth = (int) UIUtils.convertDpToPixel(70, this);
        crossfader = new Crossfader()
                .withContent(findViewById(R.id.content))
                .withFirst(result.getSlider(), firstWidth)
                .withSecond(miniDrawer.build(this), secondWidth)
                .withSavedInstance(savedInstanceState)
                .build();
        miniDrawer.withCrossFader(new CrossfadeWrapper(crossfader));
        //crossfader.getCrossFadeSlidingPaneLayout().setShadowResourceLeft(R.drawable.material_drawer_shadow_left);
        //define and create the arrow ;)
        ImageView toggle = (ImageView) accountHeader.getView().findViewById(R.id.material_drawer_account_header_toggle);
        //for RTL you would have to define the other arrow
        toggle.setImageDrawable(new IconicsDrawable(this, GoogleMaterial.Icon.gmd_keyboard_arrow_left).sizeDp(16).color(Color.BLACK));
        toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crossfader.crossFade();
            }
        });
    }

    void setImageviewSource(int color) {
        imageView.setImageDrawable(new IconicsDrawable(this, GoogleMaterial.Icon.gmd_directions_boat).sizeDp(240).colorRes(color));
    }

    private OnCheckedChangeListener onCheckedChangeListener = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(IDrawerItem drawerItem, CompoundButton buttonView, boolean isChecked) {
            if (drawerItem instanceof Nameable) {
                Log.i("material-drawer", "DrawerItem: " + ((Nameable) drawerItem).getName() + " - toggleChecked: " + isChecked);
            } else {
                Log.i("material-drawer", "toggleChecked: " + isChecked);
            }
        }
    };

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //add the values which need to be saved from the drawer to the bundle
        outState = result.saveInstanceState(outState);
        //add the values which need to be saved from the accountHeader to the bundle
        outState = accountHeader.saveInstanceState(outState);
        //add the values which need to be saved from the crossFader to the bundle
        outState = crossfader.saveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        if (SystemUtils.getScreenOrientation() == Configuration.ORIENTATION_LANDSCAPE) {
            inflater.inflate(R.menu.embedded, menu);
            menu.findItem(R.id.menu_1).setIcon(new IconicsDrawable(this, GoogleMaterial.Icon.gmd_sort).color(Color.WHITE).actionBar());
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        //handle the back press :D close the drawer first and if the drawer is closed close the activity
        if (result != null && result.isDrawerOpen()) {
            result.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //handle the click on the back arrow click
        switch (item.getItemId()) {
            case R.id.menu_1:
                crossfader.crossFade();
                return true;
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
