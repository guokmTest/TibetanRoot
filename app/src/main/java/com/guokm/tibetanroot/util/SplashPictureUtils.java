package com.guokm.tibetanroot.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.guokm.tibetanroot.Constants;
import com.guokm.tibetanroot.MyApplication;
import com.guokm.tibetanroot.R;
import com.guokm.tibetanroot.activity.SplashActivity;
import com.orhanobut.logger.Logger;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


/**
 * Created by lilonghui on 2015/12/11.
 * Email:lilonghui@bjjajale.com
 */
public class SplashPictureUtils {

    private Context mContext;
    private PhoneSPUtils phoneSPUtils;
    private SharedPreferences preferences;

    public SplashPictureUtils(Context context) {

        this.mContext = context;
        phoneSPUtils = new PhoneSPUtils(mContext);
        preferences = PreferenceManager.getDefaultSharedPreferences(MyApplication.getContext());

    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void setSplashBg(ImageView view) {
//        String sp_path = phoneSPUtils.getString("splash_image");
        String sp_path = preferences.getString("splash_image", null);
        boolean sdCardExist = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        if (sp_path != null) {
            Bitmap bitmap = getBitmaptoFile(sp_path);
            if (bitmap == null) {
                view.setBackgroundResource(R.drawable.splash);
                getImagePathFromNetwork();
            } else {
                view.setBackground(new BitmapDrawable(null, bitmap));
                getImagePathFromNetwork();
            }
        } else if (sdCardExist) {
            view.setBackgroundResource(R.drawable.splash);
            getImagePathFromNetwork();
        } else {
            Logger.e("sdcard", "sd卡不存在");
        }
    }

    /**
     * 从网络获取图片地址
     */
    private void getImagePathFromNetwork() {

        if (CMethod.isNet(mContext)) {
            HttpUtil.sendOkHttpRequest(Constants.bingImgUrl, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {

                    final String requestText = response.body().string();
                    Logger.e("picurl----:" + requestText);
                    String path = requestText;
                    if (path != null && !path.equals("")) {
//                        if (phoneSPUtils.getString("splash_image") != null && phoneSPUtils.getString("splash_image").equals(path)) {
                        if (preferences.getString("splash_image", null) != null && preferences.getString("splash_image", null).equals(path)) {
                        } else {
                            downLoadPicture(path);
                        }
                    }
                }
            });
        }
    }

    /**
     * 下载图片
     *
     * @param url
     */
    private void downLoadPicture(final String url) {

        try {
            Bitmap bitmap = Picasso.with(mContext).load(url).get();
            saveFile(bitmap, url);
//            phoneSPUtils.save("splash_image", url);
            SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(MyApplication.getContext()).edit();
            editor.putString("splash_image", url);
            editor.apply();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 保存文件
     *
     * @param bm
     * @throws IOException
     */
    private void saveFile(Bitmap bm, String urlPath) throws IOException {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(MyApplication.getContext()).edit();
        editor.putString("splash_image", urlPath);
        editor.apply();
//        String path = getSDPath() + "/splash/";
        String path =  FileUtils.getDiskCacheDir(mContext)+File.separator+"splash"+File.separator;
        File dirFile = new File(path);
        if (!dirFile.exists()) {
            dirFile.mkdir();
        }
        File myCaptureFile = new File(path + getFileName(urlPath));//
        if(!myCaptureFile.exists()){
            myCaptureFile.createNewFile();
        }
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(myCaptureFile));
        bm.compress(Bitmap.CompressFormat.JPEG, 80, bos);
        bos.flush();
        bos.close();
    }


    private String getSDPath() {
        File sdDir = null;
        boolean sdCardExist = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED); //判断sd卡是否存在
        if (sdCardExist) {
            sdDir = Environment.getExternalStorageDirectory();//获取跟目录
        }
        return sdDir.toString();
    }


    /**
     * 获取bitmap
     *
     * @param filePath
     * @return
     */
    public Bitmap getBitmaptoFile(String filePath) {
//        String path = getSDPath() + "/splash/" + getFileName(filePath);
        String path =  FileUtils.getDiskCacheDir(mContext)+File.separator+"splash"+File.separator+getFileName(filePath);
//        String path = "sdcard/jajale/a.jpg" ;
        Bitmap bitmap = null;
//        if (fileIsExists(filePath)) {
            bitmap = BitmapFactory.decodeFile(path);
//        }
        return bitmap;

    }

    /**
     * 文件是否存在
     *
     * @param path
     * @return
     */
    private boolean fileIsExists(String path) {
        try {
            File f = new File(getSDPath() + "/splash/" + getFileName(path));
            if (!f.exists()) {
                return false;
            }

        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
        return true;
    }


    /**
     * 文件名的获取
     *
     * @param url
     * @return
     */
    private String getFileName(String url) {
        // 从路径中获取
        if (url != null || !"".equals(url)) {
            url = url.substring(url.lastIndexOf("/") + 1);
        }
        return url;
    }


}
