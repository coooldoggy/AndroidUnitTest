package ;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;
import android.util.Log;


public class Login extends ExampleInstrumentedTest {
    private String errMsg;
    private UiDevice mDevice;
    private UiSelector uiSelector;

    @Override
    public void initialize() {
        super.initialize();
        mDevice = super.getmDevice();
    }

    @Override
    public void test() {
        try {
            openCamp(super.getPackageName());
        }catch (Exception e){
            Log.d("error", errMsg);
        }

    }

    private void openCamp(String packagename) {
        errMsg = "앱구동 오류";
        Context context = InstrumentationRegistry.getContext();
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(packagename);

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);

        mDevice.wait(Until.hasObject(By.pkg(packagename)), 3000);

        UiObject2 obj = mDevice.findObject(By.res(packagename + ":id/login_btn"));
        obj.clickAndWait(Until.newWindow(), 3000);

        obj = mDevice.findObject(By.res(packagename + ":id/login_button_email"));
        obj.clickAndWait(Until.newWindow(), 3000);

        obj = mDevice.findObject(By.res(packagename + ":id/email_address"));
        obj.click();
        obj.setText("text");

        obj = mDevice.findObject(By.res(packagename + ":id/password"));
        obj.click();
        obj.setText("text");

        mDevice.pressBack();

        obj = mDevice.findObject(By.res(packagename + ":id/login_email_confirm_button"));
        obj.clickAndWait(Until.newWindow(), 5000);

        
        obj = mDevice.findObject(By.res(packagename+":id/btn_right"));
        obj.click();
        obj.click();

    }

   

}
