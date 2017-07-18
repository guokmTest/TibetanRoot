package com.guokm.tibetanroot.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by athena on 2015/11/11.
 * Email: guokm@utstarcom.com
 */
public class ThreadUtils {
    private static ThreadUtils instance = null;
    //线程池中线程最大个数
    private static final int THREAD_MAX_NUMBER = 10;
    //采用线程池来管理线程
    private static ExecutorService executorService = Executors.newFixedThreadPool(THREAD_MAX_NUMBER);

    private ThreadUtils(){}

    public static ThreadUtils getInstances(){
        if(instance == null){
            instance = new ThreadUtils();
        }
        return instance;
    }

    /**
     * 获取线程池
     * @return
     */
    public static ExecutorService getPool() {
        return  ThreadUtils.executorService;
    }
/**
 *   线程池在要是用的地方这样调用就可以，避免使用new Thread调用
 *    ThreadUtils.getPool().execute(new Runnable() {
@Override
public void run() {
int memoryCacheSize = CMethod.calculateMemoryCacheSize(BaseApplication.this);
Picasso picasso = new Picasso.Builder(BaseApplication.this).memoryCache(new LruCache(memoryCacheSize)).build();
Picasso.setSingletonInstance(picasso);//实际项目中并没有使用picsso实例，如需使用则需要抽取方法获取定义好的Picasso对象。
// 则才会使用，以后采取这种，方便复杂需求的复用
if (!PublicSwitch.isLog) {
CrashHandler crashHandler = CrashHandler.getInstance();//集成了umeng就基本无须使用自己的crashhandler了
crashHandler.init(getApplicationContext());
}

}
        });
 */

}

