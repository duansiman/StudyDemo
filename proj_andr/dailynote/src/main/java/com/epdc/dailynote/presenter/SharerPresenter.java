package com.epdc.dailynote.presenter;

import com.epdc.commonlib.listener.OnPresenterNotifyListener;
import com.epdc.dailynote.entity.Sharer;
import com.epdc.dailynote.listener.SimpleSaveListener;
import com.epdc.dailynote.listener.SimpleSubscriber;
import com.epdc.dailynote.listener.SimpleUpdateListener;

import java.util.List;

import cn.bmob.v3.BmobQuery;

/**
 * Created by epdc on 2016/7/5.
 */
public class SharerPresenter extends BasePresenter {

    public SharerPresenter(OnPresenterNotifyListener listener) {
        super(listener);
    }

    public void queryAllSharer(final int reqCode, boolean cache) {

        final BmobQuery<Sharer> bmobQuery	 = new BmobQuery<Sharer>();
        if (cache) {
            //先判断是否有缓存
            boolean isCache = bmobQuery.hasCachedResult(Sharer.class);
            if (isCache) {
                bmobQuery.setCachePolicy(BmobQuery.CachePolicy.CACHE_ELSE_NETWORK);    // 先从缓存取数据，如果没有的话，再从网络取。
            } else {
                bmobQuery.setCachePolicy(BmobQuery.CachePolicy.NETWORK_ELSE_CACHE);    // 如果没有缓存的话，则先从网络中取
            }
        } else {
            bmobQuery.clearCachedResult(Sharer.class);
        }
//		observable形式
        bmobQuery.findObjectsObservable(Sharer.class)
                .subscribe(new SimpleSubscriber<List<Sharer>>(listener, reqCode));

    }


    public void addSharer(final int reqCode, Sharer sharer) {
            sharer.save(new SimpleSaveListener(listener, reqCode));
    }

    public void updateSharer(final int reqCode, Sharer sharer) {
        sharer.update(new SimpleUpdateListener(listener, reqCode));
    }
}
