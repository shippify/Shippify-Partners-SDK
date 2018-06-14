package shippify.com.shippify_java_sdk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import shippify.com.shippify_sdk.Driver;
import shippify.com.shippify_sdk.DriverInit;

public class MainActivity extends AppCompatActivity {

    private Driver mainDriver;
    private ArrayList<String> steps = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DriverInit driverInit = new DriverInit(this, "Kevin Campuzano", "kevincamp_90@me.com", "2",1,"12345"){
            @Override
            public void onSessionOK(Driver driver) {
                mainDriver = driver;
                System.out.println("MAIN DRIVER : "+mainDriver.masId);
                steps = mainDriver.getTimeline();
                System.out.println("COUNTER STEPS: "+ steps.size());
            }

            @Override
            public void onSessionError(String exceptionName) {
                System.out.println("FAILURE NEW DRIVER"+ exceptionName);
            }
        };




    }
}
