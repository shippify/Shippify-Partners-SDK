package shippify.com.shippify_sdk;

import android.content.Context;
import android.os.AsyncTask;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by shippify on 6/13/18.
 */

public class Driver extends Exception {

    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    public String fullName;
    public String email;
    public String companyId;
    public Integer cityId;
    public Integer status;
    public String referenceId;
    public String masId;

    public Driver() {

    }

    public Driver(final Context context, final String fullname, final String email, final String companyId, final Integer cityId, final String referenceId) {

    }
}

