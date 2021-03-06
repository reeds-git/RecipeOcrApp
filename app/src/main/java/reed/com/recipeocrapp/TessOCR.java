package reed.com.recipeocrapp;

import android.graphics.Bitmap;
import android.os.Environment;

import com.googlecode.tesseract.android.TessBaseAPI;

import java.io.File;

/**
 * Created by HP-laptop on 4/7/2018.
 */

public class TessOCR {

    private static final String TAG = TessOCR.class.getSimpleName();

    private TessBaseAPI mTess;

    public TessOCR() {
        // TODO Auto-generated constructor stub

        mTess = new TessBaseAPI();
        // AssetManager assetManager=
        String datapath = Environment.getExternalStorageDirectory() + "/DemoOCR/";
        String language = "eng";
        // AssetManager assetManager = getAssets();
        File dir = new File(datapath + "/tessdata/");
        if (!dir.exists())
            dir.mkdirs();
        mTess.init(datapath, language);
    }

    public String getOCRResult(Bitmap bitmap) {

        mTess.setImage(bitmap);
        String result = mTess.getUTF8Text();

        return result;
    }

    public void onDestroy() {
        if (mTess != null)
            mTess.end();
    }
}
