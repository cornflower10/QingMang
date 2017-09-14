package com.qlzgzg.network;

/**
 * Created by xiejingbao on 2017/6/8.
 */

public interface UploadProgressListener {
    /**
     * 上传进度
     * @param currentBytesCount
     * @param totalBytesCount
     */
    void onProgress(long currentBytesCount, long totalBytesCount);
}
