package com.testookla;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.util.DisplayMetrics;
import com.robotium.solo.Solo;

@SuppressWarnings("unchecked")
public class TestOokla extends ActivityInstrumentationTestCase2 {
//	String CACHE = Context.getExternalFilesDir().getPath();
//	public static final String ROOT = Environment.getExternalStorageDirectory().getPath() + "/test/";
	private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME =
        "com.ookla.speedtest.softfacade.MainActivity";
	private static Class launcherActivityClass;
	static {

		try {
			launcherActivityClass = Class
					.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public TestOokla() throws ClassNotFoundException {
		super(launcherActivityClass);
	}

	private Solo solo;

	@Override
	protected void setUp() throws Exception {
        solo = new Solo(getInstrumentation());
		Intent intent = new Intent(getInstrumentation().getTargetContext(), launcherActivityClass);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		getInstrumentation().getTargetContext().startActivity(intent);
	}

	public void test_ookla_speedtest_shot() throws Exception{
		solo.waitForText("Begin Test");
		solo.clickOnText("Begin Test");
		solo.sleep(30 * 1000);
		solo.clickOnText("RESULTS");
		solo.sleep(2*1000);
//		初始化参数,获得手机的宽带和高度像素单位为px
		DisplayMetrics dm;
		dm = new DisplayMetrics();
		solo.getCurrentActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
		solo.clickOnScreen(dm.widthPixels/2, dm.heightPixels*3/ 10);
		solo.sleep(2*1000);
		solo.takeScreenshot("ookla", 50);
	}

	@Override
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
        super.tearDown();
	}

}