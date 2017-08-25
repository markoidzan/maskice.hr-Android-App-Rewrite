package maskice.hr;


import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.ExpandedMenuView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ExpandableListAdapter;


public class GlavnoSucelje extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private int mSelectedId;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prikaz_weba);

        setToolbar();

        initView();

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerToggle.syncState();

        mSelectedId = savedInstanceState == null ? R.id.pocetno : savedInstanceState.getInt("SELECTED_ID");
        selectItem(mSelectedId);

    }

    private void setToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }

    private void initView() {
        NavigationView mDrawer = (NavigationView) findViewById(R.id.navigation_view);
        mDrawer.setNavigationItemSelectedListener(this);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

    }

    private void selectItem(int mSelectedId) {
        Fragment fragement = null;
        Class fragmentClass = null;
        switch (mSelectedId) {
            case R.id.pocetno:
                drawerLayout.closeDrawer(GravityCompat.START);
                fragmentClass = MasterWebSite.class;
                break;
            case R.id.kosarica:
                drawerLayout.closeDrawer(GravityCompat.START);
                fragmentClass = Kosarica.class;
                break;
            case R.id.mobitel:
                drawerLayout.closeDrawer(GravityCompat.START);
                fragmentClass = Mobitel.class;
                break;
            case R.id.tablet:
                drawerLayout.closeDrawer(GravityCompat.START);
                fragmentClass = Tablet.class;
                break;
            case R.id.drzac_punjac:
                drawerLayout.closeDrawer(GravityCompat.START);
                fragmentClass = DrzaciPunjaci.class;
                break;
            case R.id.slus:
                drawerLayout.closeDrawer(GravityCompat.START);
                fragmentClass = SlusaliceZvucnici.class;
                break;
            case R.id.kamere:
                drawerLayout.closeDrawer(GravityCompat.START);
                fragmentClass = Kamere.class;
                break;
            case R.id.drone:
                drawerLayout.closeDrawer(GravityCompat.START);
                fragmentClass = Dronovi.class;
                break;
            case R.id.vr_naoc:
                drawerLayout.closeDrawer(GravityCompat.START);
                fragmentClass = VrNaocale.class;
                break;
            case R.id.gadgets:
                drawerLayout.closeDrawer(GravityCompat.START);
                fragmentClass = Gadgeti.class;
                break;
            case R.id.pc_perif:
                drawerLayout.closeDrawer(GravityCompat.START);
                fragmentClass = RacunalnaPeriferija.class;
                break;
            case R.id.other:
                drawerLayout.closeDrawer(GravityCompat.START);
                fragmentClass = OstalaOprema.class;
                break;
            case R.id.about_us:
                drawerLayout.closeDrawer(GravityCompat.START);
                fragmentClass = AboutUs.class;
                break;
            case R.id.veleprodaja:
                drawerLayout.closeDrawer(GravityCompat.START);
                fragmentClass = Veleprodaja.class;
                break;
            case R.id.prod_mjesta:
                drawerLayout.closeDrawer(GravityCompat.START);
                fragmentClass = ProdajnaMjesta.class;
                break;
            case R.id.about_app:
                drawerLayout.closeDrawer(GravityCompat.START);
                fragmentClass = AboutApp.class;
                break;
        }

        try {
            fragement = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragement).commit();
    }


    @Override
    public void onConfigurationChanged(Configuration novaKonfiguracija) {
        super.onConfigurationChanged(novaKonfiguracija);
        drawerToggle.onConfigurationChanged(novaKonfiguracija);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        menuItem.setChecked(true);
        mSelectedId = menuItem.getItemId();
        selectItem(mSelectedId);
        return true;
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        //save selected item so it will remains same even after orientation change
        outState.putInt("SELECTED_ID", mSelectedId);
    }
}