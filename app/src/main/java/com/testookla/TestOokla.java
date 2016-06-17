package com.testookla;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

@SuppressWarnings("unchecked")
public class TestOokla extends ActivityInstrumentationTestCase2 {

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
//		solo = new Solo(getInstrumentation(), getActivity());
//		solve getActivity() suspend AUT bug by this url below
//		http://stackoverflow.com/questions/20860832/why-does-getactivity-block-during-junit-test-when-custom-imageview-calls-start?answertab=oldest#tab-top
        solo = new Solo(getInstrumentation());
		Intent intent = new Intent(getInstrumentation().getTargetContext(), launcherActivityClass);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		getInstrumentation().getTargetContext().startActivity(intent);

	}

	public void test_ookla_speedtest() throws Exception{

//		String fileName = "routerTest";
//		String content = "this is a test";
//		File file = new File(ROOT + fileName);
//		try {
//			FileUtils.writeStringToFile(file, content);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		solo.sleep(5*1000);
//		solo.clickOnText("Begin Test");
//		solo.sleep(20*1000);
//		solo.clickOnText("No thanks");
//		solo.sleep(5*1000);
		solo.takeScreenshot("12345");
		// Verify that resultant of 10 x 20
//		assertTrue("xxxxxxxxxxxxxxxxxxx", expect);
	}

	@Override
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
        super.tearDown();
	}

}