package maskice.hr;


import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*


                                                                                                                                            ```
                                                                                                                                       `.,,,,,,,,,.`
                                                                                                                                     `,,,,,,,,,,,,,,,
                                                                                                                                    .,,,,,,,,,,,,,,,,,`
                                                                                                                                  `,,,,,,,,,,,,,,,,,,,,`
                                                                                                                                 `,,,,,`       `.,,,,,,,
                                                                                                                                `::,,`            .,,,,,`
                                                                                                                                ,,,,     ,@:       `:,,,`
                                                                                                                               ,,,.      @ #@#      `,,,.
                                                                                                                              `,,,      @`   ,@@:    ,,,.
                                                                                                                              ,,,      ,#       +@#  `,,.
                                                                                                                             `,,.      @          ;; `,,`
                                                                                                                             ,:,      +:          @   ,,
                                                                                                                             ,,,      @          ,#   ,.
                                                                                                                            `,,`     @`          @`   ,`
                                                                                                                            .,,`    :#          .@    .
                                                                                                                            .,,     @           @`   ``
                                                                                                                            .,,    #;          `@    `
                                                                                                                            .,,   `@           @,
                                                                                                                            `,,   @+          `@
                                                                                                                             ,,` ,@@@#`       @:
                                                                                                                             .,` .@@@@@@`     @
                                                                                                                             `,,   #@@# @@:  #'
                                                                                                                              .,     +@'@@@@;@
                                                                                                                               ,,      '@@@@@+
                                                                                                                                ,`       ;@@@
                                                                                                                     ;@,         ,         .
                                                         `                                                           @@@+         .
                                                        .@@'                                                         @@@+
                     `+                                  @@@                                                        .@@@'
         @@          @@@                                 @@@                                                        :@@@,
        '@@#        #@@@:                                @@@,          `@#                                          '@@@
        #@@@        @@@@'                                @@@:          .@@@#                                        #@@@
        #@@@       +@@@@'                                @@@'           @@@@@#`                                     @@@@
        #@@@       @@@@@:                                @@@+            @@@@@@@`                                   @@@@
        @@@@      +@@@@@,     @@@@                       @@@#             '@@@@@@`                                  @@@@          +,
        @@@@      @@@@@@.    @@@@@@                      @@@@               :@@@@`                 +@@@@#,          @@@#         ,@@@
        @@@@`    #@@@@@@.   @@@@@@@          ;@@@@@;     #@@@      '@@                `''         @@@@@@@@#         @@@'          @@@`
        @@@@;   .@@@@@@@.  #@@@@@@@+       ,@@@@@@@@@:   +@@@    '@@@@+  .@,         @@@@@,      @@@@@@@@@@;       `@@@;          @@@;
        @@@@@   @@@@.@@@`  @@@@,@@@@      .@@@@@@@@@@@.  '@@@  `@@@@@@:  #@@'       @@@@@@@    ::@@@@+''@@@@       .@@@,          @@@@     .
        @@@@@# @@@@@ @@@. :@@@#,@@@@#     @@@@@,   `##   :@@@ '@@@@@@;   '@@@      :@@@@#@@    @@@@@,,,,,@@@.      .@@@`:@@'      @@@@ '@@@@@
        @@@@@@@@@@@  @@@. @@@@,,@@@@@     @@@@           ,@@@+@@@@@@     ,@@@      @@@@'      `@@@@#,,,,,@@@:      :@@@+@@@@@     '@@@@@@@@@@'
        @@@#@@@@@@.  @@@` @@@@,.@@@@@'    ,@@@@#         `@@@@@@@@;      `@@@     `@@@@        @@@@@@###@@@@.      +@@@@@@@@@#    ,@@@@@@@@@@'
        @@@;,@@@@`   @@@``@@@+,,@@@@@@     .@@@@@@.       @@@@@@@         @@@`    '@@@         `@@@@@@@@@@@@       @@@@@@@@@@@    `@@@@@@'.
        @@@'  `.     @@@`,@@@,,#@@@@@@;      :@@@@@@    @@@@@@@'          @@@`    #@@@         +@@@@@@@@@@@.       @@@@@@@ @@@:    @@@@@`
        #@@@         @@@`;@@@.,@@@@'@@@   @@@.  @@@@@`  @@@@@@:           @@@.    @@@@         :@@@+@@@@+,         @@@@@@  @@@'    @@@@@
        ;@@@         @@@ ;@@@.@@@@. @@@#  @@@@#  `@@@@  .@@@@@@@'         @@@,    '@@@      '   @@@@           ,`  @@@@@#  @@@+    @@@@+
         @@@         `@, .@@@@@@@@  :@@@. #@@@@@@+@@@@@   ,@@@@@@@@''#    @@@;     @@@@';'#@@+  #@@@@       , '@@` @@@@@.  #@@+    '@@@'
         @@@              @@@@@@@    @@@#  @@@@@@@@@@@@    @@@@@@@@@@@;   @@@+     :@@@@@@@@@#   @@@@@#;,#@@@ @@@@ @@@@@   +@@#@,  ,@@@;
          ,`              ;@@@@@`     @@#   @@@@@@@@@'     @@@,;@@@@@@;   .@@@      :@@@@@@@@     @@@@@@@@@@@ @@@@ @@@@@   .@@@@#   @@@+
                           #@@@              @@@@          @@@#  .#@#,     ,@@        ,#@@#.       +@@@@@@@+   @@; @@@@+    @@@@:    @@'
                                               `           '@@@                                       ```          '@@@.     @@@
                                                            @@@                                                     '@@
                                                            #@@
                                                                                                                                                  `
                                                                                                                                                `@
                              `..,::;;;'''++++++++++++'''';;;:::,,..``                                                                        `@@``
                .:'#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#+';:.`                                               :@@@,`
          .'@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#+;,`                                .'@@@@@,`
        #@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#+;:,..```` `  `..,;+@@@@@@@@@,,`
       @@@@@@@@@@@@@@@@@@@@@@#####++++++++++++++++++++#######@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@,,,`
      #@@@@@@#+;:,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,:;'++#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#,,.`
     @#',,,,,,,,,,.....`````````                         `````````````.......,,,,,,,,,,,,,,,.,:'+#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@+,,,.`
    :`,,,.````                                                                        `````..,,,,,,,,,,,,:;'++#@@@@@@@@@@@@@@#+';,.,,,,`
    `.`                                                                                           ``....,,,,,,,,,,,,,,,,,,,,,,,,,..``
                                                                                                               ```````````````


                                                   ,           ,`                                   ;  :                   `,               `,
                                                 @,@.          @`@:                     @    ;@     `@#'                   .@    ,@         ,@
                                                   @`          @.                       @+   @'      .,                    ,@       @       ,@
        +@@# #@@+ @ @@# @@#  #@@:    @ @@@ `@@@' @`@ @@'  @@@, @.@. @@@`   @@@@@'@@@`   :@   @ #@@+ '@@@   .@'@@.'@@. ,@@@ .@'@@.`@+@@@ @@@`.@
       `@  , :  @,@@  @@  @,@# `@.   @@  @+ , `@ @`@@ `@,@+ `@`@.@.@' ,@      @;.  '@    @` ;@ :  @`@  ,   .@; +@; '@`@. #@,@: '@`@ @  @' .@.@
        @+    ``@:@;  @;  @:@   ##   @'  '#  ``@`@`@.  ##@   @+@.@`@```@`    +@   `.@    @' @;  ``@.@#     .@  `@  `@+@   @`@   @`@ @  @```@.@
        `@@#:@+;@:@:  @;  @;@   +@   @;  '@+@':@`@`@`  +@@   #+@`@.@++++`   `@  @@;;@    .@ @ ;@+:@: @@#   .@  `@  `@##   @.@   @.@ @ `@+++#.@
           @@;  @:@:  @:  @:@`  @#   @;  '#@`  @`@`@,  @+@   @'@`@`@        @. ,@  ,@     @,@ @:  @:   @.  .@  `@  `@;@   @.@   @ @ @  @    .@
       .'.:@@@.+@:@:  @:  @;+@:'@    @;  '#@#.@@`@`@@:'@ #@,+@ @.@.#@,,#   @@;:;@:,@@     #@: @@.#@,'.:@   .@  `@  `@ @+,@@,@@,@@`@ @+:+@,,#.@
        '#+` +#.,,;,  ',  ', .#+     ',  :;`#+ ; @`' '#`  ,#'  '`@. ,#+,   ;;;;',#' '     .;   +#`,.;#+`   `'  `;  `;  '#, `;`#' `; `#+ ,#+,.'
                                                 @`              @.
                                               #@@             +@@


 */

public class GlavnoSucelje extends AppCompatActivity
//        implements NavigationView.OnNavigationItemSelectedListener
{

    //private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    ExpandableListAdapter menuAdapter;
    ExpandableListView expandableList;
    List<ExpandedMenuModel> listDataHeader;
    HashMap<ExpandedMenuModel, List<String>> listDataChild;
//    private ActionBarDrawerToggle drawerToggle;
//    private int mSelectedId;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prikaz_weba);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        expandableList = (ExpandableListView) findViewById(R.id.navigationmenu);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);

        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        prepareListData();
        menuAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild, expandableList);

        expandableList.setAdapter(menuAdapter);

        expandableList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                return false;
            }
        });

        expandableList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                return false;
            }
        });

    }

    private void prepareListData() {

        listDataHeader = new ArrayList<ExpandedMenuModel>();
        listDataChild = new HashMap<ExpandedMenuModel, List<String>>();

        ExpandedMenuModel homepage = new ExpandedMenuModel();
        homepage.setIconImg(android.R.drawable.ic_delete);
        listDataHeader.add(homepage);

        ExpandedMenuModel search = new ExpandedMenuModel();
        search.setIconImg(android.R.drawable.ic_delete);
        listDataHeader.add(search);

        List<String> mobitel = new ArrayList<String>();
        mobitel.add("Alcatel");
        mobitel.add("Apple");

        listDataChild.put(listDataHeader.get(0), (List<String>) homepage);
        listDataChild.put(listDataHeader.get(1), (List<String>) search);

    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        //revision: this don't works, use setOnChildClickListener() and setOnGroupClickListener() above instead
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        drawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    /*private void setToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }*/

   /* private void initView() {
        NavigationView mDrawer = findViewById(R.id.navigation_view);
        mDrawer.setNavigationItemSelectedListener(this);
        drawerLayout = findViewById(R.id.drawerLayout);

    }*/

   /* private void selectItem(int mSelectedId) {
        Fragment fragement = null;
        Class fragmentClass = null;
        switch (mSelectedId) {
            case R.id.homepage:
                drawerLayout.closeDrawer(GravityCompat.START);
                fragmentClass = MasterWebSite.class;
                break;
            case R.id.searchbox:
                drawerLayout.closeDrawer(GravityCompat.START);
                fragmentClass = Pretraga.class;
                break;
            case R.id.cart:
                drawerLayout.closeDrawer(GravityCompat.START);
                fragmentClass = Kosarica.class;
                break;
            case R.id.phones_alcatel:
                drawerLayout.closeDrawer(GravityCompat.START);
                fragmentClass = Mobitel.class;
                break;
            case R.id.tablet:
                drawerLayout.closeDrawer(GravityCompat.START);
                fragmentClass = Tablet.class;
                break;
            case R.id.drzaci:
                drawerLayout.closeDrawer(GravityCompat.START);
                fragmentClass = Drzaci.class;
                break;
            case R.id.kamere:
                drawerLayout.closeDrawer(GravityCompat.START);
                fragmentClass = Kamere.class;
                break;
            case R.id.slus:
                drawerLayout.closeDrawer(GravityCompat.START);
                fragmentClass = Slusalice.class;
                break;
            case R.id.gadgets:
                drawerLayout.closeDrawer(GravityCompat.START);
                fragmentClass = GadgetiMemorije.class;
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
*/

   /* @Override
    public void onConfigurationChanged(Configuration novaKonfiguracija) {
        super.onConfigurationChanged(novaKonfiguracija);
        drawerToggle.onConfigurationChanged(novaKonfiguracija);
    }*/

   /* @Override
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
    }*/
}