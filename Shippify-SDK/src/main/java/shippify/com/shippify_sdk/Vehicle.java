package shippify.com.shippify_sdk;

/**
 * Created by shippify on 6/13/18.
 */

public class Vehicle {
    public Integer status;
    public String description;
    public String capacity;
    public String extras;
    public String referenceId;

    public static String TAG = "Vehicle";

    public Vehicle() {

    }

    public static void saveVehicle(Vehicle vehicle) {

        if (vehicle.status == null) {
            System.out.println("MISSING STATUS VEHICLE");
            return;
        }

        if (vehicle.description == null || vehicle.description.length() == 0) {
            System.out.println("MISSING DESCRIPTION");
            return;
        }

        if (vehicle.capacity == null || vehicle.capacity.length() == 0){
            System.out.println("MISSING CAPACITY");
            return;
        }

        if (vehicle.extras == null) {
            System.out.println("MISSING EXTRAS");
            return;
        }

        System.out.println("ALL PASS SEND TO REQUEST CREATION OF VEHICLE");
    }

    public static void getVehicle(){

    }

    public static void removeVehicle(){

    }

}
