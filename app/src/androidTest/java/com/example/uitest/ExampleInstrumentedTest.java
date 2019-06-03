package ;

import android.content.Context;
import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public abstract class ExampleInstrumentedTest {
    
    private UiDevice mDevice;
    private final String packageName = "your package name";

    public String getPackageName() {
        return packageName;
    }

    public UiDevice getmDevice() {
        return mDevice;
    }

    public void setmDevice(UiDevice mDevice) {
        this.mDevice = mDevice;
    }

    @Before
    public void initialize(){
        mDevice = UiDevice.getInstance(getInstrumentation());
        assertThat(mDevice, notNullValue());

        try {
            if(!mDevice.isScreenOn()){
            mDevice.wakeUp();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {
    }
}
