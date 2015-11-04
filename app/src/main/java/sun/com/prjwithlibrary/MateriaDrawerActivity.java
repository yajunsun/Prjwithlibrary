package sun.com.prjwithlibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.view.IconicsImageView;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

/**
 * Created by Administrator on 2015/10/29.
 */
public class MateriaDrawerActivity extends AppCompatActivity {
    AccountHeader accountHeader;
    Drawer result;
    //MiniDrawer miniDrawer;
    com.mikepenz.iconics.view.IconicsImageView imageView;
    //Crossfader crossfader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lo_materialdrawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        imageView = (IconicsImageView) findViewById(R.id.iv_main);
        setSupportActionBar(toolbar);
        final IProfile profile = new ProfileDrawerItem().withName("Yajun Sun").withIcon(getResources().getDrawable(R.drawable.yajunsun))
                .withEmail("407250568@qq.com");
        accountHeader = new AccountHeaderBuilder().withActivity(this).
                withHeaderBackground(getResources().getDrawable(R.drawable.header))
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
                .withHasStableIds(true).withToolbar(toolbar)
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
                        return false;
                        //return miniDrawer.onItemClick(drawerItem);
                    }
                }).withSavedInstance(savedInstanceState);

        result=builder.build();

//        miniDrawer = new MiniDrawer().withDrawer(result).withAccountHeader(accountHeader);
//        int firstWidth = (int) UIUtils.convertDpToPixel(70, this);
//        int secondWidth = (int) UIUtils.convertDpToPixel(300, this);
//        crossfader = new Crossfader()
//                // .withContent(findViewById(R.id.txtcontent))
//                .withFirst(result.getSlider(), firstWidth)
//                .withSecond(miniDrawer.build(this), secondWidth)
//                .withSavedInstance(savedInstanceState)
//                .build();
//        miniDrawer.withCrossFader(new CrossfadeWrapper(crossfader));
//        crossfader.getCrossFadeSlidingPaneLayout().setShadowResourceLeft(R.drawable.material_drawer_shadow_left);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    void setImageviewSource(int color) {
        imageView.setImageDrawable(new IconicsDrawable(this, GoogleMaterial.Icon.gmd_directions_boat).sizeDp(320).colorRes(color));
    }
}
