package com.tathva17.tathva.tathva17;

import android.app.Application;

import com.vrjco.v.vtextview.VFontManager;

/**
 * Created by VRUSHABH on 08-10-2016.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        VFontManager.setDefaultAppFont("tathva.ttf", VFontManager.STYLE_NORMAL);
        VFontManager.setDefaultAppFont("avenir_bold.ttf", VFontManager.STYLE_BOLD);
        VFontManager.setDefaultAppFont("caviardreams.ttf", VFontManager.STYLE_ITALIC);
        VFontManager.setDefaultAppFont("caviardreams_bold.ttf",VFontManager.STYLE_BOLD_ITALIC);
    }
}
