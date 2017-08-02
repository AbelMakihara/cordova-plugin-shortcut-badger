package me.leolin.shortcutbadger;


import android.content.Context;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;


public class CordovaShortcutBadger extends CordovaPlugin {
    private static final String SET_ACTION = "set";
    private static final String REMOVE_ACTION = "remove";

    @Override
    public boolean execute(String action, JSONArray data,
                           final CallbackContext callbackContext) throws JSONException {
        if (SET_ACTION.equals(action)) {
            int badgeCount = data.getInt(0);
            Context mContext = this.cordova.getActivity().getApplicationContext();
            ShortcutBadger.applyCount(mContext, badgeCount);
        } else if (REMOVE_ACTION.equals(action)) {
            Context mContext = this.cordova.getActivity().getApplicationContext();
            ShortcutBadger.removeCount(mContext);
        }
        return true;
    }
}