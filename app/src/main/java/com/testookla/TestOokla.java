package com.testookla;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

@SuppressWarnings("unchecked")
public class TestOokla extends ActivityInstrumentationTestCase2 {

//	private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "com.peanutswifi.MainActivity";
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
        solo = new Solo(getInstrumentation());
	}

	public void test_ookla() {
        solo.sleep(5000);
		solo.clickOnText("Begin Test");
//        solo.waitForText("SHARE", 0, 60000);
        solo.sleep(60000);
		// Verify that resultant of 10 x 20
//		assertTrue("xxxxxxxxxxxxxxxxxxx", expect);
	}

	@Override
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
        super.tearDown();
	}

}