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

public class DriverInit extends Exception {

    private AsyncTask<Object, String, ServerResponse> async;
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");


    public DriverInit(final Context context, final String fullname, final String email, final String companyId, final Integer cityId, final String referenceId) {

        async = new AsyncTask<Object, String, ServerResponse>() {
            @Override
            protected void onPostExecute(ServerResponse res) {
                super.onPostExecute(res);
                if (!res.isError()){
                    onSessionOK(res.driver);
                } else {
                    onSessionError("Network Error");
                }
            }

            @Override
            protected ServerResponse doInBackground(Object... objects) {
                try {
                    Driver driver = init(context, fullname, email, companyId, cityId, referenceId);
                    return new ServerResponse(driver);
                }catch(IllegalArgumentException ex){
                } catch (Exception e) {
                    e.printStackTrace();
                }

                ServerResponse resp =new ServerResponse(null);
                resp.error = true;
                return resp;
            }
        }.execute();
    }

    public Driver init(Context context, String fullname, String email, String companyId, Integer cityId, String referenceId) throws Exception {

        if (fullname == null || fullname.length() == 0) {
            throw new Exception("MISSING NAME");
        }

        if (email == null || email.length() == 0) {
            throw new Exception("MISSING EMAIL");
        }

        if (companyId == null || companyId.length() == 0) {
            throw new Exception("MISSING COMPANY ID");
        }

        if (cityId == null || cityId == 0) {
            throw new Exception("MISSING CITY");
        }

        Map<String, Object> object = new HashMap<>();
        object.put("name", fullname);
        object.put("email", email);
        object.put("companyId",companyId);
        object.put("cityId", cityId);

        if(referenceId != null || !referenceId.equalsIgnoreCase("null")) {
            object.put("referenceId", referenceId);
        }

        RequestBody objRequest = RequestBody.create(JSON, object.toString());
        String strResponse;
        String urlString = "http://www.mocky.io/v2/5b2037ae3100006c1e230b66"; // SUCCESS MESSAGE
//        String urlString = "http://www.mocky.io/v2/5b2187f43000008f265c7503"; // FAILURE MESSAGE
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(urlString)
                .build();

        Response response = client.newCall(request).execute();
        if(response.isSuccessful()){
            Driver driver = new Driver();
            driver.fullName = fullname;
            driver.email = email;
            driver.companyId = companyId;
            driver.cityId = cityId;
            driver.referenceId = referenceId;
            driver.status = 3;
            driver.masId = "6022";
            return driver;
        }
        throw new Exception("FAILURE REQUEST");

    }

    public void onSessionOK(Driver response){
        //grab your new driver
    }

    public void onSessionError(String exceptionName){
        //grab your new session id
    }

    public class ServerResponse {
        boolean error;
        Driver driver;

        public ServerResponse(Driver driver){
            this.driver = driver;
        }

        public boolean isError(){ return error; }

    }

}
