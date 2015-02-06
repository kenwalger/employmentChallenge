package zyzzyxtech.com.employmentchallenge.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import zyzzyxtech.com.employmentchallenge.ApplicationSettings;

/**
 * Created by Ken on 1/13/2015.
 */
public class FileUtilities {

    public static void saveAssets(Context context, String assetName) {
        File fileDirectory = getFileDirectory(context);
        File fileToWrite = new File(fileDirectory, assetName);

        AssetManager assetManager = context.getAssets();
        try {
            InputStream in = assetManager.open(assetName);
            FileOutputStream out = new FileOutputStream(fileToWrite);
            copyFile(in, out);
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static File getFileDirectory(Context context) {
        ApplicationSettings settings = new ApplicationSettings(context);
        String storageType = settings.getStoragePreference();
//        if(storageType.equals(StorageType.INTERNAL)) {
            return context.getFilesDir();
//        } else {
//            if(isExternalStorageAvailable()){
//                if(storageType.equals(StorageType.PRIVATE_EXTERNAL)) {
//                    return context.getExternalFilesDir(null);
//                } else {
//                    return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
//                }
//            } else {
//                return context.getFilesDir();
//            }
//        }
    }

    public static boolean isExternalStorageAvailable() {
        String state = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    private static void copyFile(InputStream in, OutputStream out) throws IOException{
        byte[] buffer = new byte[1024];
        int read;
        while((read = in.read(buffer)) != -1){
            out.write(buffer, 0, read);
        }
    }
}
