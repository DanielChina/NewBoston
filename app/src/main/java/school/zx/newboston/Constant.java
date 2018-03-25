package school.zx.newboston;

import school.zx.newboston.demo.AnimationActivity;
import school.zx.newboston.demo.CodingUiActivity;
import school.zx.newboston.demo.FragmentTestActivity;
import school.zx.newboston.demo.GestureActivity;
import school.zx.newboston.demo.GridLayoutActivity;
import school.zx.newboston.demo.CameraPicInvert.ImageCaptureActivity;
import school.zx.newboston.demo.IntentTest.FirstActivity;
import school.zx.newboston.demo.LifeCycleActivity;
import school.zx.newboston.demo.ListenerTestActivity;
import school.zx.newboston.demo.MasterDetail.ItemListActivity;
import school.zx.newboston.demo.NotificationActivity;
import school.zx.newboston.demo.OverflowActivity;
import school.zx.newboston.demo.Service.ServiceActivity;
import school.zx.newboston.demo.sharePreference.SharedPreferenceActivity;
import school.zx.newboston.demo.Sqlite.SqliteActivity;
import school.zx.newboston.demo.ThreadHandlerActivity;
import school.zx.newboston.demo.UIActivity;
import school.zx.newboston.demo.video.VideoActivity;

/**
 * Created by THink on 2018/3/6.
 */

public class Constant {
    public static final String[] TITLE={
            "Lesson1-8 Overview",
            "Lesson9-10 Activity State",
            "Lesson11-12 Design UI",
            "Lesson13-16 Coding UI",
            "Lesson17 GridLayout",
            "Lesson18-20 Event Listener",
            "Lesson21-22 Gesture Listener",
            "Lesson23-30 Fragment Interaction",
            "Lesson31-32 Master Detail Flow",
            "Lesson33 Overflow Menu test",
            "Lesson34 Animations and Transitions",
            "Lesson35-38 Intent and Broadcast",
            "Lesson39-40 Thread and Handler",
            "Lesson41-44 Service, Bound Service",
            "Lesson45-48 ListView, Custom ListView",
            "Lesson49-54 Sqlite Operation",
            "Lesson55 Playing Video",
            "Lesson56-60 Capture, Invert and Overlay",
            "Lesson61-64 Notification, Style, Theme",
            "Lesson65-66 Shared Preference",
            "Lesson67 Launch Icon Setting",
            "Lesson68 Working with Github",
            "Lesson69 Creating an Apk file"
    };
    public static final Object[] ACTIVITY_NAME={
            null,LifeCycleActivity.class,
            UIActivity.class,CodingUiActivity.class,
            GridLayoutActivity.class,ListenerTestActivity.class,
            GestureActivity.class,FragmentTestActivity.class,
            ItemListActivity.class, OverflowActivity.class,
            AnimationActivity.class, FirstActivity.class,
            ThreadHandlerActivity.class, ServiceActivity.class,
            null,SqliteActivity.class,
            VideoActivity.class,ImageCaptureActivity.class,
            NotificationActivity.class,SharedPreferenceActivity.class,
            null,null,null
    };
    public static final String[] SUB_TITLE={
            "No Demo", "With Demo", "With Demo", "With Demo",
            "With Demo", "With Demo","With Demo","With Demo",
            "With Demo", "With Demo","With Demo","With Demo",
            "With Demo", "With Demo","Main menu","With Demo",
            "With Demo", "With Demo","With Demo","With Demo",
            "No Demo", "No Demo","No Demo"
    };
    public static final String[] INTRODUCTION_DETAIL={
            "Install Android Studio including JRE, tour of interface and some key points",
            "From the printing log, activity-state changes can be observed  by click different keys like Start Demo, HOME, BACK, MENU.",
            "Design User Interface by the visualization method, a interface similar to login will be demonstrated",
            "Design User Interface by java. In this demonstration, the button can be clicked to create or delete a edit view dynamically. Meanwhile, view positions can be set easily. Methods between the convert of dip, sp and px will also be introduced",
            "A new layout, GridLayout, is introduced. An application of this layout, Five direction keys are demonstrated.",
            "Practice of Event listeners, like short click or long click listeners.",
            "Touch screen with different gestures like scrolling, fling or long time press. The results can be shown on Android Studio Logcat as well as the app",
            "Fragment will be set up, and the interactions between different fragments will be created with the help of activity.",
            "A new application of Master/Detail Flow is built, and the webView is introduced.",
            "Theme can be selected and learn how to use the overflow menu. For example, the button in the right top corner can be clicked to set different background color.",
            "Animation is introduced by the simple animation of a button from left-top to right-bottom with size increase. Transitions is also used to make effects",
            "Intent and Broadcast are respectively used to interact between two activities and two apps",
            "Handler is used to communicate between threads. Do not forget add .start() when launching thread ",
            "Intent Service and self-defined Service are introduced. Service should be applied in manifests. How to bind service is described",
            "ListView with ArrayAdapter and custom adapter is introduced. Main Menu is just an application of listView",
            "Sqlite operation like adding, deleting ,printing is introduced",
            "VideoView and MediaController are introduced.",
            "Image is Captured and is inverted. The point is to make sure the permission has been set.",
            "Notification is introduced",
            "Shared preference is mainly used to store temporary data.",
            "Launch Icon can be set ",
            "Link GitHub and Android Studio in order to share code conveniently.",
            "Step-by-step-creating-apk is introduced."
    };
    public static final Object[] IMG_NAME={
            R.drawable.install,R.drawable.activity_state,
            R.drawable.design_ui,R.drawable.coding_ui,
            R.drawable.grid_layout,R.drawable.event_listener,
            R.drawable.gesture_listener,R.drawable.fragment_interaction,
            R.drawable.install,R.drawable.install,
            R.drawable.coding_ui,R.drawable.fragment_interaction,
            R.drawable.event_listener,R.drawable.install,
            R.drawable.design_ui,R.drawable.grid_layout,
            R.drawable.gesture_listener,R.drawable.activity_state,
            R.drawable.design_ui,R.drawable.grid_layout,
            R.drawable.install,R.drawable.event_listener,
            R.drawable.fragment_interaction
    };
    public static final String[] URL={
            "https://www.youtube.com",
            "https://learning.wintec.ac.nz/",
            "https://www.google.com/"
    };
    public static String ACTION_INTENT_RECEIVER = "com.gc.broadcast.receiver";
    public static String VIDEO_URL="https://www.youtube.com/watch?v=zCj5Qzzex_A&list=PL6gx4Cwl9DGBsvRxJJOzG4r4k_zLKrnxl&index=44";
    public static String LOG_FILE_NAME="newBoston";
}
