package com.twiceyuan.kommonadapter

import android.content.Context
import com.twiceyuan.commonadapter.library.adapter.CommonAdapter
import com.twiceyuan.commonadapter.library.holder.CommonHolder

/**
 * Created by twiceYuan on 2017/12/10.
 *
 * CommonAdapter in kotlin wrapper
 */
class KommonAdapter {

    companion object {

        inline fun <reified T, reified VH : CommonHolder<T>> create(context: Context): CommonAdapter<T, VH> {
            return CommonAdapter<T, VH>(context, VH::class.java)
        }
    }
}