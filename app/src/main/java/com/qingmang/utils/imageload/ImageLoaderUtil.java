package com.qingmang.utils.imageload;

import android.widget.ImageView;

import java.io.File;


public class ImageLoaderUtil implements ImageLoader {

    private static ImageLoaderUtil mInstance;
    private ImageLoader imageLoader;

//    /**
//     * 策略模式注入
//     * @param imageLoader
//     */
//    public void setImageLoader(ImageLoader imageLoader){
//
//        this.imageLoader = imageLoader;
//    }

    public ImageLoaderUtil() {
        imageLoader = new GlideLoad();
    }

    public static ImageLoaderUtil getInstance() {
        if (mInstance == null) {
            synchronized (ImageLoaderUtil.class) {
                if (mInstance == null) {
                    mInstance = new ImageLoaderUtil();
                    return mInstance;
                }
            }
        }
        return mInstance;
    }

    @Override
    public void showImage(String url, ImageView imageView, int defaultImage) {
        imageLoader.showImage(url,imageView,defaultImage);
    }

    @Override
    public void loadLocalImage(String url, ImageView imageView, int defaultImage) {

    }

    @Override
    public void loadLocalCircleImage(String url, ImageView imageView, int defaultImage) {
        imageLoader.loadLocalCircleImage(url,imageView,defaultImage);
    }

    @Override
    public void loadLocalCircleImage(File file, ImageView imageView, int defaultImage) {
        imageLoader.loadLocalCircleImage(file,imageView,defaultImage);
    }

    @Override
    public void loadCircleImage(String url, ImageView imageView, int defaultImage) {
        imageLoader.loadCircleImage(url,imageView,defaultImage);
    }

    @Override
    public void loadVideo(String url, ImageView imageView, int defaultImage) {
        imageLoader.loadVideo(url,imageView,defaultImage);
    }

    @Override
    public void loadGif(String url, ImageView imageView, int defaultImage) {
        imageLoader.loadGif(url,imageView,defaultImage);
    }
}
