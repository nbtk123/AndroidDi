package com.nbtk123.androiddi;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.nbtk123.androiddi.di.DaggerAppComponent;
import com.nbtk123.androiddi.di.NetworkClientModule;
import com.nbtk123.androiddi.di.RandomStringFactoryModule;
import com.nbtk123.androiddi.network.NetworkClient;
import com.nbtk123.androiddi.randomstring.RandomStringFactory;
import com.nbtk123.androiddi.ui.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityRule = new ActivityTestRule<>(MainActivity.class, true, false);

    @Test
    public void testFakeRandomStringOnly() throws Exception {

        /**
         * Steps we do here:
         *
         * 1. Create a fake instance.
         * 2. Create a DI tree with the fake instance, all the rest are original.
         * 3. launch the activity.
         */

        //Creating the fake
        RandomStringFactory fakeRandomStringFactory = createFakeRandomStringFactory();

        //Providing the fake RandomStringFactory instance to the DI tree.
        //NOTE: We don't have to provide NetworkClient here SINCE IT HAS CONSTRUCTOR WITHOUT PARAMETERS!
        App.appComponent = DaggerAppComponent.builder().randomStringFactoryModule(new RandomStringFactoryModule(fakeRandomStringFactory)).build();

        // Lunach the activity.
        mainActivityRule.launchActivity(null);

        //Just waiting enough time for you to see the results, this is not part of the test...
        Thread.sleep(7000);
    }

    @Test
    public void testFakeNetworkClientOnly() throws Exception {
        /**
         * Steps we do here:
         *
         * 1. Create a fake instance.
         * 2. Create a DI tree with the fake instance, all the rest are original.
         * 3. launch the activity.
         */

        //Creating the fake
        NetworkClient fakeNetworkClient = createFakeNetworkClient();

        //Providing the fake instance to the DI tree.
        //NOTE: We don't have to provide RandomStringFactory here SINCE IT HAS CONSTRUCTOR WITHOUT PARAMETERS!
        App.appComponent = DaggerAppComponent.builder().networkClientModule(new NetworkClientModule(fakeNetworkClient)).build();

        // Lunach the activity.
        mainActivityRule.launchActivity(null);

        //Just waiting enough time for you to see the results, this is not part of the test...
        Thread.sleep(7000);
    }

    @Test
    public void testBothFake() throws Exception {
        /**
         * Steps we do here:
         *
         * 1. Create fakes for both instance.
         * 2. Create a DI tree with the fake instances.
         * 3. launch the activity.
         */

        //Creating the network fake
        NetworkClient fakeNetworkClient = createFakeNetworkClient();
        //Creating the string fake
        RandomStringFactory fakeRandomStringFactory = createFakeRandomStringFactory();

        //Providing the fake instance to the DI tree.
        //NOTE: We don't have to provide RandomStringFactory here SINCE IT HAS CONSTRUCTOR WITHOUT PARAMETERS!
        App.appComponent = DaggerAppComponent.builder()
                .networkClientModule(new NetworkClientModule(fakeNetworkClient))
                .randomStringFactoryModule(new RandomStringFactoryModule(fakeRandomStringFactory)).build();

        // Lunach the activity.
        mainActivityRule.launchActivity(null);

        //Just waiting enough time for you to see the results, this is not part of the test...
        Thread.sleep(7000);
    }

    private NetworkClient createFakeNetworkClient() {

        // Anonymous extension
        // Can be implemented with mockito :)

        return new NetworkClient() {
            @Override
            public void performHttpGetRequest(String url, ResponseListener listener) {
                listener.onResponse("404 Not found dude :)");
            }
        };
    }

    private RandomStringFactory createFakeRandomStringFactory() {

        // Anonymous extension
        // Can be implemented with mockito :)

        return new RandomStringFactory() {
            @Override
            public String createString() {
                return "This is a fake dude :)";
            }
        };
    }
}