package com.yl.study.utils;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanglei on 2018/9/6;
 */
public class CheckPermissionUtils {
    private static Activity context;
    private static CheckPermissionUtils checkPermissionUtils;
    private static InterfPermission interfPermission;

    private CheckPermissionUtils(Activity context) {
        this.context = context;
    }

    public static CheckPermissionUtils setContext(Activity activity) {
        if (checkPermissionUtils == null || context != activity) {
            checkPermissionUtils = new CheckPermissionUtils(activity);
        }
        return checkPermissionUtils;
    }

    public static CheckPermissionUtils setContext(Activity activity, InterfPermission permission) {
        interfPermission = permission;
        if (checkPermissionUtils == null || context != activity) {
            checkPermissionUtils = new CheckPermissionUtils(activity);
        }
        return checkPermissionUtils;

    }

    public interface InterfPermission {
        void Success();
    }

    private void doSuccess() {
        interfPermission.Success();
    }

    public void CheckSD() {
        if (Build.VERSION.SDK_INT >= 23) {
            List<String> permissions = null;
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
                    PackageManager.PERMISSION_GRANTED) {
                permissions = new ArrayList<>();
                permissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            }
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) !=
                    PackageManager.PERMISSION_GRANTED) {
                if (permissions == null) {
                    permissions = new ArrayList<>();
                }
                permissions.add(Manifest.permission.READ_EXTERNAL_STORAGE);
            }

            if (permissions == null) {
                doSuccess();
            } else {
                String[] permissionArray = new String[permissions.size()];
                permissions.toArray(permissionArray);
                // Request the permission. The result will be received
                // in onRequestPermissionResult()
                ActivityCompat.requestPermissions(context, permissionArray, 0);
            }
        } else {
            doSuccess();
        }
    }
    public void CheckContacts() {
        if (Build.VERSION.SDK_INT >= 23) {
            List<String> permissions = null;
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_CONTACTS) !=
                    PackageManager.PERMISSION_GRANTED) {
                permissions = new ArrayList<>();
                permissions.add(Manifest.permission.READ_CONTACTS);
            }

            if (permissions == null) {
                doSuccess();
            } else {
                String[] permissionArray = new String[permissions.size()];
                permissions.toArray(permissionArray);
                // Request the permission. The result will be received
                // in onRequestPermissionResult()
                ActivityCompat.requestPermissions(context, permissionArray, 0);
            }
        } else {
            doSuccess();
        }
    }
    public void CheckReadSMS() {
        if (Build.VERSION.SDK_INT >= 23) {
            List<String> permissions = null;
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_SMS) !=
                    PackageManager.PERMISSION_GRANTED) {
                permissions = new ArrayList<>();
                permissions.add(Manifest.permission.READ_SMS);
            }

            if (permissions == null) {
                doSuccess();
            } else {
                String[] permissionArray = new String[permissions.size()];
                permissions.toArray(permissionArray);
                // Request the permission. The result will be received
                // in onRequestPermissionResult()
                ActivityCompat.requestPermissions(context, permissionArray, 0);
            }
        } else {
            doSuccess();
        }
    }

    public void CheckCamera() {
        if (Build.VERSION.SDK_INT >= 23) {
            List<String> permissions = null;
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
                    PackageManager.PERMISSION_GRANTED) {
                permissions = new ArrayList<>();
                permissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            }
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) !=
                    PackageManager.PERMISSION_GRANTED) {
                if (permissions == null) {
                    permissions = new ArrayList<>();
                }
                permissions.add(Manifest.permission.READ_EXTERNAL_STORAGE);
            }
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) !=
                    PackageManager.PERMISSION_GRANTED) {
                if (permissions == null) {
                    permissions = new ArrayList<>();
                }
                permissions.add(Manifest.permission.CAMERA);
            }

            if (permissions == null) {
                doSuccess();
            } else {
                String[] permissionArray = new String[permissions.size()];
                permissions.toArray(permissionArray);
                // Request the permission. The result will be received
                // in onRequestPermissionResult()
                ActivityCompat.requestPermissions(context, permissionArray, 0);
            }
        } else {
            doSuccess();
        }
    }


    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Log.d("onRequestPermissionsResult", requestCode + "\n" + permissions + "\n" + grantResults.toString());
        for (int i = 0; i < permissions.length; i++) {
            Log.d("permissions["+i+"]", permissions[i]);
        }
        for (int i = 0; i < grantResults.length; i++) {
            Log.d("grantResults["+i+"]", grantResults[i]+"");
        }
        if (requestCode == 0) {
            // Request for WRITE_EXTERNAL_STORAGE permission.
            if (grantResults.length > 0
                    && grantResults[grantResults.length-1] == PackageManager.PERMISSION_GRANTED) {
                doSuccess();
            } else {
                // Permission request was denied.
                Toast.makeText(context, "权限检测失败，将影响后续使用，请检查应用权限设置", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
