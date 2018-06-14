package shippify.com.shippify_sdk;

import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONObject;

import java.util.ArrayList;

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
    private AsyncTask<Object, String, DriverInit.ServerResponse> async;

    public String fullName;
    public String email;
    public String companyId;
    public Integer cityId;
    public Integer status;
    public String referenceId;
    public String masId;
    public JSONObject extra_params;

    public Driver() {

    }

    public Driver(final Context context, final String fullname, final String email, final String companyId, final Integer cityId, final String referenceId) {
        this.fullName = fullname;
        this.email = email;
        this.companyId = companyId;
        this.cityId =cityId;
        this.referenceId = referenceId;
    }

    public ArrayList<String> getTimeline() {
        ArrayList<String> steps = new ArrayList<>();
        try {
            String urlString = "http://www.mocky.io/v2/5b2037ae3100006c1e230b66"; // SUCCESS MESSAGE
//        String urlString = "http://www.mocky.io/v2/5b2187f43000008f265c7503"; // FAILURE MESSAGE
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(urlString)
                    .build();

            Response response = client.newCall(request).execute();
            if(response.isSuccessful()){
                steps.add("a");
                steps.add("b");
                return steps;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return steps;

    }


    public static void addVehicle(Vehicle vehicle){

    }

    public static ArrayList<Vehicle> allVehicles(){
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        return vehicles;
    }

    public static void removeVehicle(){

    }

    public static void setCurrentVehicle(){

    }

    /* * * * * * * * * * * * * * * * * * * * * *
     * * * * * *  GETTERS AND SETTERS * * * * * *
     * * * * * * * * * * * * * * * * * * * * * */

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getMasId() {
        return masId;
    }

    public void setMasId(String masId) {
        this.masId = masId;
    }

    public JSONObject getExtra_params() {
        return extra_params;
    }

    public void setExtra_params(JSONObject extra_params) {
        this.extra_params = extra_params;
    }
}

