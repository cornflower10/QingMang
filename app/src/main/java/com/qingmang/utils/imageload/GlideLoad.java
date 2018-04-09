package com.qingmang.utils.imageload;

import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.qingmang.utils.GlideCircleTransform;

import java.io.File;


public class GlideLoad implements ImageLoader {
    @Override
    public void showImage(String url, ImageView imageView, int defaultImage) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }

    @Override
    public void loadLocalImage(String url, ImageView imageView, int defaultImage) {
        Glide.with( imageView.getContext() )
                .load( Uri.parse(url))
                .asBitmap()
                .into( imageView );
    }

    @Override
    public void loadLocalCircleImage(String url, ImageView imageView, int defaultImage) {
        Glide.with( imageView.getContext() )
                .load( new File(url))
                .transform(new GlideCircleTransform(imageView.getContext()))
                .into( imageView );
    }

    @Override
    public void loadLocalCircleImage(File file, ImageView imageView, int defaultImage) {
        Glide.with( imageView.getContext() )
                .load(file)
                .transform(new GlideCircleTransform(imageView.getContext()))
                .into( imageView );
    }

    @Override
    public void loadCircleImage(String url, ImageView imageView, int defaultImage) {
        Glide.with( imageView.getContext() )
                .load( url )
                .centerCrop()
                .transform(new GlideCircleTransform(imageView.getContext()))
                .into( imageView );
    }

    @Override
    public void loadVideo(String url, ImageView imageView, int defaultImage) {
            Glide.with( imageView.getContext() )
                .load( Uri.fromFile( new File( url ) ) )
                .into( imageView );
    }

    @Override
    public void loadGif(String url, ImageView imageView, int defaultImage) {
            Glide.with(imageView.getContext()).load(url).asGif()
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(imageView);
    }
}
