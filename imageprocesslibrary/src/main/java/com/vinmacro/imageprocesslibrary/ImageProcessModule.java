package com.vinmacro.imageprocesslibrary;

import android.graphics.Bitmap;
import android.graphics.Matrix;

public class ImageProcessModule {


    private String TAG = "ImageProcessModule";

    private int FLIP_VERTICAL = 1;
    private int FLIP_HORIZONTAL = 2;

//    private static final ImageProcessModule imageProcessModule = new ImageProcessModule();



//    private ImageProcessModule() {
//
//    }

//    public static ImageProcessModule getInstance() {
//        return imageProcessModule;
//    }

    public ImageProcessModule(){

    }


    public int getFlipVertical(){
        return FLIP_VERTICAL;
    }


    public int getFlipHorizontal(){
        return FLIP_HORIZONTAL;
    }

    public int[] getPixels(Bitmap bmOriginal) {

        int width = bmOriginal.getWidth();
        int height = bmOriginal.getHeight();

        int[] srcPixels = new int[width * height];

        bmOriginal.getPixels(srcPixels, 0, width, 0, 0, width, height);

        return srcPixels;
    }


    public Bitmap flipImage(Bitmap src, int isFlipVerticalOrHorizontal) {

        // create new matrix for transformation
        Matrix matrix = new Matrix();
        // if vertical
        if (isFlipVerticalOrHorizontal == FLIP_VERTICAL) {
            matrix.preScale(1.0f, -1.0f);
        }
        // if horizonal
        else if (isFlipVerticalOrHorizontal == FLIP_HORIZONTAL) {
            matrix.preScale(-1.0f, 1.0f);
            // unknown type
        } else {
            return null;
        }

        // return transformed image
        return Bitmap.createBitmap(src, 0, 0, src.getWidth(), src.getHeight(), matrix, true);

    }
}
