package ImageLoader;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import com.joinf.www.xclibrary.R;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

/**
 * Created by caijinzhu on 2017/12/22.
 * XCImageLoader 工具类,用来加载网络图片
 */

public class XCWebImageLoader {

    private static final int THREAD_COUNT = 4;   // 线程数

    private static final int PROPRITY = 2;      // 图片加载的优先级

    private static final int DISK_CACHE_SIZE = 50 * 1024; // 图片缓存个数

    private static final int CONNECT_TIME_OUT = 5 * 1000; // 超时时间

    private static final int READ_TIME_OUT = 30 * 1000;


    private static ImageLoader mImageLoader = null;

    private static XCWebImageLoader mInstance = null;

    /** 单利模式*/
    private static XCWebImageLoader getInstance(Context context){
        if (mInstance == null){
            synchronized (XCWebImageLoader.class){
                if (mInstance == null){
                    mInstance = new XCWebImageLoader(context);
                }
            }

        }
        return mInstance;

    }
    /**私有的构造*/
    private XCWebImageLoader(Context context){

        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(context)
                .threadPoolSize(THREAD_COUNT)       // 设置线程数
                .threadPriority(Thread.NORM_PRIORITY - PROPRITY)   // 设置优先级
                .denyCacheImageMultipleSizesInMemory()  // 防止缓存多份尺寸的图片
                .memoryCache(new WeakMemoryCache())     // 使用弱引用
                .diskCacheSize(DISK_CACHE_SIZE)         // 设置磁盘缓存大小
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())  // 使用md5命名缓存文件
                .tasksProcessingOrder(QueueProcessingType.LIFO)   // 设置图片下载顺序
                .defaultDisplayImageOptions(getDefaultOptions())  // 设置默认的图片加载选项
                .imageDownloader(new BaseImageDownloader(context,CONNECT_TIME_OUT,READ_TIME_OUT))        // 设置图片下载器
                .writeDebugLogs()   // debug 环境下输出日志
                .build();

        ImageLoader.getInstance().init(configuration);
        mImageLoader = ImageLoader.getInstance();
    }

    /** 图片显示的选项默认设置*/
    private DisplayImageOptions getDefaultOptions(){

        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageForEmptyUri(R.drawable.phone)     // 图片url为空时,显示的默认图片
                .showImageOnFail(R.drawable.phone)          // 图片下载失败是的默认显示图片
                .cacheInMemory(true)        // 设置图片在内存中缓存
                .cacheOnDisk(true)          // 设置图片在磁盘中缓存
                .bitmapConfig(Bitmap.Config.RGB_565)  // 设置解码类型
                .decodingOptions(new BitmapFactory.Options())   // 图片解码配置
                .build();
        return options;
    }

    /** 图片显示方法*/
    public void displayImage(ImageView imageView, String imgUrl, DisplayImageOptions options, ImageLoadingListener listener){
        if (mImageLoader != null){
            mImageLoader.displayImage(imgUrl,imageView,options,listener);
        }
    }
    /** 重载*/
    public void displayImage(ImageView imageView, String imgUrl){
        displayImage(imageView,imgUrl,null);

    }
    /** 重载*/
    public void displayImage(ImageView imageView, String imgUrl,ImageLoadingListener listener){
        displayImage(imageView,imgUrl,null,listener);
    }

}




