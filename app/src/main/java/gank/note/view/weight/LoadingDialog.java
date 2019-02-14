package gank.note.view.weight;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * 进度dialog
 * Created by wuxubaiyang on 2017/3/23.
 */
public class LoadingDialog {
    private static ProgressDialog progressDialog;

    public static void showProgressDialog(Context context) {
        showProgressDialog(context, "", true);
    }

    public static void showProgressDialog(Context context, int message) {
        showProgressDialog(context, context.getResources().getString(message));
    }

    public static void showProgressDialog(Context context, String message) {
        showProgressDialog(context, message, true);
    }

    public static void showProgressDialog(Context context, boolean cancelable) {
        showProgressDialog(context, "", cancelable);
    }

    public static void showProgressDialog(Context context, int message, boolean cancelable) {
        showProgressDialog(context, context.getResources().getString(message), cancelable);
    }

    public static void showProgressDialog(Context context, String message, boolean cancelable) {
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(message);
        progressDialog.setCancelable(cancelable);
        progressDialog.show();
    }

    public static void updataMessage(Context context, int message) {
        updataMessage(context.getResources().getString(message));
    }

    public static void updataMessage(String message) {
        if (null != progressDialog) {
            progressDialog.setMessage(message);
        }
    }

    public static void dismissProgressDialog() {
        if (null != progressDialog) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }
}