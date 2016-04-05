package com.retinio.login;

/**
 * Created by championswimmer on 6/4/16.
 */
public class OnboardHelper {

    static boolean firstUsed = false;

    public static boolean isFirstAppUsage () {
        //TODO: Check for SharedPrefs for "is_first_use"
        return !firstUsed;
    }

    public static void setIntroDone () {
        //TODO: Set "is_first_use" as true in SHaredPrefs.
        firstUsed = true;
    }
}
