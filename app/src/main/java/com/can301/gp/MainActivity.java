package com.can301.gp;

import static com.can301.gp.GlobalData.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.can301.gp.catviewer.CatViewMain;
import com.can301.gp.demos.AppSpecificFilesExample;
import com.can301.gp.demos.BGServiceExample;
import com.can301.gp.demos.BoundServiceExample;
import com.can301.gp.demos.AlertDialogExample;
import com.can301.gp.demos.ButtonWidget;
import com.can301.gp.demos.DatePickerDialogExample;
import com.can301.gp.demos.AnimationsExample;
import com.can301.gp.demos.EffectExampleDragView;
import com.can301.gp.demos.EffectExampleFancyLoadingEffect;
import com.can301.gp.demos.EffectExampleLoadingEffect;
import com.can301.gp.demos.EffectExampleProgressBarLoadingEffect;
import com.can301.gp.demos.EffectExampleZooming;
import com.can301.gp.demos.FGServiceExample;

import com.can301.gp.demos.FrameAnimationsExample;
import com.can301.gp.demos.AttributeAnimationsExample;
import com.can301.gp.demos.GoSystemSettingsExample;
import com.can301.gp.demos.NavigationDrawerExample;
import com.can301.gp.demos.InteractCalendarExample;
import com.can301.gp.demos.NavigationExample;
import com.can301.gp.demos.EffectExampleNightMode;
import com.can301.gp.demos.EffectExampleRippleEffect;
import com.can301.gp.demos.ProgressBarWidget;
import com.can301.gp.demos.QRcodeGenerateExample;
import com.can301.gp.demos.RadioGroupWidget;
import com.can301.gp.demos.RatingBarWidget;
import com.can301.gp.demos.RequestPermissionExample;
import com.can301.gp.demos.SeekBarWidget;
import com.can301.gp.demos.SensorsExampleActivity;
import com.can301.gp.demos.SwitchWidget;
import com.can301.gp.demos.TimerExample;
import com.can301.gp.searchbar.SearchBarMain;
import com.can301.gp.demos.PopupWindowExample;
import com.can301.gp.demos.BottomSheetDialogExample;
import com.can301.gp.demos.ProgressDialogExample;
import com.can301.gp.demos.TimePickerDialogExample;
import com.can301.gp.demos.InteractCameraExample;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    Drawable drawableFromId(int Id) {
        return this.getResources().getDrawable(Id);
    }

    /**
     * Init global data when this launcher activity starts
     * if the global data has not been inited.
     */
    public void setupGlobalData() {
        // Only initialise them once
        if (!categories.isEmpty()) {
            return;
        }

        // CatTitle -> Cat
        categories = new HashMap<String, Category>();
        // CatTitle -> {DemoTitle -> Demo}
        demos = new HashMap<String, HashMap<String, Demonstration>>();

        // Set up all categories.
        categories.put("Services", new Category(
                "Services",
                "Demonstrates how you can implement different kinds of system services," +
                        "including foreground, bound, and background services",
                R.drawable.ic_cat_services
        ));
        categories.put("QRcode", new Category(
                "QRcode",
                "Demonstrates activities about QRcode like scanning, creating",
                R.drawable.baseline_qr_code_24
        ));
        categories.put("System Interaction", new Category(
                "System Interaction",
                "Demonstrates how you can interact with the Android system. " +
                        "For example, asking for permissions",
                R.drawable.ic_cat_system
        ));
        categories.put("Storage", new Category(
                "Storage",
                "Learn how to preserve your app and user data via, for example, " +
                        "persistent or cached files on external or internal storage.",
                R.drawable.ic_cat_storage
        ));
        categories.put("Navagation", new Category(
                "Navigation", "navigation", R.drawable.ic_cat_navigation
        ));
        categories.put("Animations", new Category(
                "Animations", "description of Animations", R.drawable.baseline_image_24
        ));
        categories.put("Dialogs", new Category(
                "Dialogs",
                "Explore a variety of dialog styles and notification methods. " +
                        "Learn how to grab user attention with modals, pop-ups, toasts, " +
                        "and more for an engaging user experience.",
                R.drawable.baseline_chat_24
        ));
        categories.put("Effects", new Category(
                "Effects",
                "Shows various effects.",
                R.drawable.ic_cat_effect
        ));
        categories.put("Widgets", new Category(
                "Widgets",
                "Shows various widgets.",
                R.drawable.ic_widgets
        ));
        categories.put("Gestures", new Category(
                "Gestures",
                "Shows various gestures interacting with the system.",
                R.drawable.ic_gesture
        ));

        HashMap<String, Demonstration> catServicesDemos = new HashMap<String, Demonstration>();
        HashMap<String, Demonstration> catSystemDemos = new HashMap<String, Demonstration>();
        HashMap<String, Demonstration> catStorageDemos = new HashMap<String, Demonstration>();
        HashMap<String, Demonstration> catDialogsDemos = new HashMap<>();
        HashMap<String, Demonstration> catNavigationDemos = new HashMap<>();
        HashMap<String, Demonstration> catAnimationsDemos = new HashMap<>();
        HashMap<String, Demonstration> catEffectsDemos = new HashMap<>();
        HashMap<String, Demonstration> catWidgetsDemos = new HashMap<>();
        HashMap<String, Demonstration> catGesturesDemos = new HashMap<>();
        HashMap<String, Demonstration> catQrcodeDemos = new HashMap<>();

        // Set up all demos.
        catEffectsDemos.put("Night Mode", new Demonstration(
                        "Night Mode", R.string.night_mode_example_desc,
                R.drawable.ic_night, EffectExampleNightMode.class,"nightmode"
                )
        );
        catEffectsDemos.put("Ripple Effect", new Demonstration(
                        "Ripple Effect", R.string.ripple_effect_example_desc,
                R.drawable.ic_water, EffectExampleRippleEffect.class,"rippleeffect"
                )
        );
        catEffectsDemos.put("Shimmer Loading Effect", new Demonstration(
                        "Shimmer Loading Effect", R.string.loading_effect_example_desc,
                        R.drawable.baseline_image_24, EffectExampleLoadingEffect.class,"loadingeffect"
                )
        );
        catEffectsDemos.put("Progress Bar Loading Effect", new Demonstration(
                        "Progress Bar Loading Effect", R.string.progress_bar_effect_example_desc,
                        R.drawable.ic_progress_bar, EffectExampleProgressBarLoadingEffect.class,"progressbareffect"
                )
        );
        catEffectsDemos.put("Fancy Loading Effect", new Demonstration(
                        "Fancy Loading Effect", R.string.fancy_loading_effect_example_desc,
                        R.drawable.ic_progress_bar, EffectExampleFancyLoadingEffect.class,"fancyloadingeffect"
                )
        );
        catGesturesDemos.put("Zooming", new Demonstration(
                        "Zooming", R.string.zooming_example_desc,
                R.drawable.ic_zooming, EffectExampleZooming.class,"zooming"
                )
        );
        catGesturesDemos.put("Drag View", new Demonstration(
                        "Dragging", R.string.dragging_example_desc,
                R.drawable.ic_dragging, EffectExampleDragView.class,"dragging"
                )
        );

        catServicesDemos.put("Background Service", new Demonstration(
                "Background Service",
                R.string.bg_service_example_desc,
                R.drawable.ic_bg_service, BGServiceExample.class, "bgservice"
        ));
        catServicesDemos.put("Bound Service", new Demonstration(
                "Bound Service",
                R.string.bound_service_example_desc,
                R.drawable.ic_bound_service, BoundServiceExample.class, "boundservice"
        ));
        catServicesDemos.put("Foreground Service", new Demonstration(
                "Foreground Service",
                R.string.fg_service_example_desc,
                R.drawable.ic_fg_service, FGServiceExample.class, "fgservice"
        ));

        catSystemDemos.put("Request Permissions", new Demonstration(
                "Request Permissions",
                R.string.request_permission_example_desc,
                R.drawable.ic_request_permission, RequestPermissionExample.class, "reqpermission"
        ));
        catSystemDemos.put("Calendar Interaction", new Demonstration(
                "Calendar Interaction",
                R.string.interactcalendar_example_desc,
                R.drawable.baseline_edit_calendar_24, InteractCalendarExample.class, "interactcalendar"
        ));
        catSystemDemos.put("Go To System Settings", new Demonstration(
                "Go To System Settings",
                R.string.go_system_settings_example_desc,
                R.drawable.ic_demo_settings, GoSystemSettingsExample.class, "systemsettings"
        ));
        catSystemDemos.put("Camera Interaction", new Demonstration(
                "Camera Interaction",
                R.string.interactcamera_example_desc,
                R.drawable.baseline_photo_camera_24, InteractCameraExample.class, "interactcamera"
        ));
        catSystemDemos.put("Sensors", new Demonstration(
                "Sensors",
                R.string.sensors_example_desc,
                R.drawable.ic_sensors, SensorsExampleActivity.class, "sensors"
        ));

        catStorageDemos.put("App-specific Files", new Demonstration(
                "App-specific Files",
                R.string.app_specific_files_example_desc,
                R.drawable.ic_app_specific_files, AppSpecificFilesExample.class, "appspecific"
        ));
        catDialogsDemos.put("AlertDialog", new Demonstration(
                "AlertDialog",
                R.string.alertdialog_example_desc,
                R.drawable.baseline_chat_24, AlertDialogExample.class,"alertdialog"
        ));
        catDialogsDemos.put("DatePickerDialog", new Demonstration(
                        "DatePickerDialog", R.string.datepickerdialog_example_desc,
                        R.drawable.baseline_chat_24, DatePickerDialogExample.class,"datepickerdialog"
                )
        );
        catNavigationDemos.put("navigation", new Demonstration(
                "navigation", R.string.navigation_example_desc, R.drawable.baseline_navigation_24, NavigationExample.class, "navigation1"
        ));
        catNavigationDemos.put("drawernavigation", new Demonstration(
                "drawernavigation", R.string.navigation_drawer_example_desc, R.drawable.baseline_navigation_24, NavigationDrawerExample.class, "navigation2"
        ));

        catAnimationsDemos.put("Animations",new Demonstration(
                "Animations",R.string.animations_example_desc, R.drawable.baseline_image_24, AnimationsExample.class,"animation1"
        ));
        catAnimationsDemos.put("FrameAnimations",new Demonstration(
                "FrameAnimations",R.string.frame_animations_example_desc,R.drawable.baseline_animation_24, FrameAnimationsExample.class,"frameanimation"
        ));
        catAnimationsDemos.put("AttributeAnimations",new Demonstration(
                "AttributeAnimations",R.string.attribute_animations_example_desc,R.drawable.baseline_keyboard_double_arrow_right_24, AttributeAnimationsExample.class,"attributeanimation"
        ));

        catDialogsDemos.put("PopupWindow", new Demonstration(
                        "PopupWindow",
                        R.string.popupwindow_example_desc,
                        R.drawable.baseline_chat_24, PopupWindowExample.class,"popupwindow"
                )
        );
        catDialogsDemos.put("BottomSheetDialog", new Demonstration(
                        "BottomSheetDialog",
                        R.string.bottomsheetdialog_example_desc,
                        R.drawable.baseline_chat_24, BottomSheetDialogExample.class,"bottomsheetdialog"
                )
        );
        catDialogsDemos.put("TimePickerDialog", new Demonstration(
                        "TimePickerDialog",
                        R.string.timepickerdialog_example_desc,
                        R.drawable.baseline_chat_24, TimePickerDialogExample.class,"timepickerdialog"
                )
        );
        catDialogsDemos.put("TimerExample", new Demonstration(
                        "TimerExample",
                        R.string.timer_example_desc,
                        R.drawable.baseline_hourglass_top_24, TimerExample.class,"timer"
                )
        );

        catDialogsDemos.put("ProgressDialog", new Demonstration(
                        "ProgressDialog",
                        R.string.progressdialog_example_desc,
                        R.drawable.baseline_chat_24, ProgressDialogExample.class,"progressdialog"
                )
        );

        catWidgetsDemos.put("Button", new Demonstration(
                "Button",
                R.string.button_desc, R.drawable.ic_button, ButtonWidget.class, "button1"
        ));
        catWidgetsDemos.put("Switch", new Demonstration(
                "Switch",
                R.string.switch_desc,R.drawable.ic_switch, SwitchWidget.class, "switch1"
        ));
        catWidgetsDemos.put("Radio Group", new Demonstration(
                "Radio Group",
                R.string.radio_desc,R.drawable.ic_radio, RadioGroupWidget.class, "radio1"
        ));
        catWidgetsDemos.put("Progress bar", new Demonstration(
                "Progress bar",
                 R.string.progress_desc,R.drawable.ic_progress, ProgressBarWidget.class, "progress1"
        ));
        catWidgetsDemos.put("Seek Bar", new Demonstration(
                "Seek Bar",
                R.string.seek_desc,R.drawable.ic_seek_bar, SeekBarWidget.class, "seek1"
        ));
        catWidgetsDemos.put("Rating Bar", new Demonstration(
                "Rating Bar",
                R.string.rating_desc,R.drawable.ic_rating_bar, RatingBarWidget.class, "rating1"
        ));
        catQrcodeDemos.put("QRcodeGenerate",new Demonstration(
                "QRcodeGenerate",R.string.qrcode_generate_desc,R.drawable.baseline_qr_code_24, QRcodeGenerateExample.class,"qrcode1"
        ));

        // Decide which demos go into which category.
        demos.put("Services", catServicesDemos);
        demos.put("System Interaction", catSystemDemos);
        demos.put("Storage", catStorageDemos);
        demos.put("Dialogs", catDialogsDemos);
        demos.put("Navigation", catNavigationDemos);
        demos.put("Animations",catAnimationsDemos);
        demos.put("Effects",catEffectsDemos);
        demos.put("Widgets",catWidgetsDemos);
        demos.put("Gestures",catGesturesDemos);
        demos.put("QRcode",catQrcodeDemos);

        // Decided by ourselves
        highlightedCats = new ArrayList<>();
        // highlight Services
        highlightedCats.add(0);
        // highlight System Interaction
        highlightedCats.add(9);
        // highlight Animation
        highlightedCats.add(4);
        // highlight Effects
        highlightedCats.add(8);
        // highlight Dialogs
        highlightedCats.add(5);
        // highlight Widgets
        highlightedCats.add(2);

        // Fill in the lists
        catList = new ArrayList<Category>(categories.values());
        demoList = new ArrayList<Demonstration>();
        for (HashMap<String, Demonstration> h : demos.values()) {
            demoList.addAll(h.values());
        }
    }

    /**
     * Used for the Home button of other pages.
     * Click that button to go back to this activity.
     * @param context the context of that page.
     */
    static public void goBackToHomePage(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    /**
     * Called when the user clicks the search bar on the main activity.
     */
    void goToSearchActivity() {
        Intent intent = new Intent(this, SearchBarMain.class);
        startActivity(intent);
    }

    /**
     * Called when the user clicks the menu on the main activity.
     */
    void goToCategoriesPage() {
        Intent intent = new Intent(this, CategoriesPage.class);
        startActivity(intent);
    }

    /**
     * Called when the user clicks any of the highlighted categories on the main activity.
     */
    void goToCatViewPage(int catIndex) {
        Intent intent = new Intent(this, CatViewMain.class);
        intent.putExtra(CatViewMain.CAT_VIEW_INDEX_KEY, catIndex);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupGlobalData();

        setContentView(R.layout.activity_main);

        // Set up the cat buttons
        {
            assert highlightedCats.size() >= numHighlighedCats;
            Category cat1 = catList.get(highlightedCats.get(0));
            Category cat2 = catList.get(highlightedCats.get(1));
            Category cat3 = catList.get(highlightedCats.get(2));
            Category cat4 = catList.get(highlightedCats.get(3));
            Category cat5 = catList.get(highlightedCats.get(4));
            Category cat6 = catList.get(highlightedCats.get(5));

            Button bt1 = findViewById(R.id.mainCatButton1);
            Button bt2 = findViewById(R.id.mainCatButton2);
            Button bt3 = findViewById(R.id.mainCatButton3);
            Button bt4 = findViewById(R.id.mainCatButton4);
            Button bt5 = findViewById(R.id.mainCatButton5);
            Button bt6 = findViewById(R.id.mainCatButton6);

            // Button icons (on top)
            bt1.setCompoundDrawablesWithIntrinsicBounds(
                    null, drawableFromId(cat1.iconId), null, null);
            bt2.setCompoundDrawablesWithIntrinsicBounds(
                    null, drawableFromId(cat2.iconId), null, null);
            bt3.setCompoundDrawablesWithIntrinsicBounds(
                    null, drawableFromId(cat3.iconId), null, null);
            bt4.setCompoundDrawablesWithIntrinsicBounds(
                    null, drawableFromId(cat4.iconId), null, null);
            bt5.setCompoundDrawablesWithIntrinsicBounds(
                    null, drawableFromId(cat5.iconId), null, null);
            bt6.setCompoundDrawablesWithIntrinsicBounds(
                    null, drawableFromId(cat6.iconId), null, null);

            // Button texts
            bt1.setText(cat1.title);
            bt2.setText(cat2.title);
            bt3.setText(cat3.title);
            bt4.setText(cat4.title);
            bt5.setText(cat5.title);
            bt6.setText(cat6.title);

            // Redirections
            bt1.setOnClickListener(v -> goToCatViewPage(highlightedCats.get(0)));
            bt2.setOnClickListener(v -> goToCatViewPage(highlightedCats.get(1)));
            bt3.setOnClickListener(v -> goToCatViewPage(highlightedCats.get(2)));
            bt4.setOnClickListener(v -> goToCatViewPage(highlightedCats.get(3)));
            bt5.setOnClickListener(v -> goToCatViewPage(highlightedCats.get(4)));
            bt6.setOnClickListener(v -> goToCatViewPage(highlightedCats.get(5)));
        }

        // Search button
        {
            ImageButton sb = findViewById(R.id.searchButton);
            sb.setOnClickListener(v -> goToSearchActivity());
        }

        // Menu button
        {
            Button mb = findViewById(R.id.menuButton);
            mb.setOnClickListener(v -> goToCategoriesPage());
        }
    }
}