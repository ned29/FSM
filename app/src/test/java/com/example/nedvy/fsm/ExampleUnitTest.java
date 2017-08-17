package com.example.nedvy.fsm;

import android.widget.Button;
import android.widget.Toast;

import com.example.nedvy.fsm.view.MainActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowToast;

import butterknife.BindView;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)

public class ExampleUnitTest {

    @BindView(R.id.lock)
    private Button lock;

    @BindView(R.id.unlock)
    private Button unLock;

    @BindView(R.id.lockx2)
    private Button lock_2;

    @BindView(R.id.unlockx2)
    private Button unLock_2;

    private MainActivity activity;

    @Before
    public void setup() {
        activity = Robolectric.buildActivity(MainActivity.class)
                .create().get();
    }

    @Test
    public void checkActivityNotNull() throws Exception {
        assertNotNull(activity);
    }

    @Test
    public void buttonClick() throws Exception {
        MainActivity activity = Robolectric.buildActivity(MainActivity.class)
                .create().get();
        lock.performClick();
        lock_2.performClick();
        unLock.performClick();
        unLock_2.performClick();
        assertNotNull(lock);
        assertThat(ShadowToast.getTextOfLatestToast(), equalTo("AlarmDisarmed_AllLocked"));
        assertNotNull(lock_2);
        assertThat(ShadowToast.getTextOfLatestToast(), equalTo("AlarmArmed_AllLocked"));
        assertNotNull(unLock);
        assertThat(ShadowToast.getTextOfLatestToast(), equalTo("AlarmDisarmed_DriverUnLocked"));
        assertNotNull(unLock_2);
        assertThat(ShadowToast.getTextOfLatestToast(), equalTo("AlarmDisarmed_DriverUnLocked"));
    }

}