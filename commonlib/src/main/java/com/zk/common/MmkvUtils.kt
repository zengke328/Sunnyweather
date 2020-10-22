package com.zk.common

import com.tencent.mmkv.MMKV

/**
 * description ：
 * author : zk
 * date : 2020/10/22 19:37
 */

object MmkvUtils {

    fun putInt(key: String, value: Int) {
        val kv = MMKV.defaultMMKV()
        kv.encode(key, value)
    }

    fun getInt(key: String, value: Int) {
        val kv = MMKV.defaultMMKV()
        kv.decodeInt(key, value)
    }

    fun putString(key: String, value: String) {
        val kv = MMKV.defaultMMKV()
        kv.encode(key, value)
        kv.containsKey("11")
    }


    fun getString(key: String) {
        val kv = MMKV.defaultMMKV()
        kv.decodeString(key)
    }

    fun getString(key: String, defaultValue: String): String {
        val kv = MMKV.defaultMMKV()
        return kv.decodeString(key, defaultValue)
    }

    fun contains(key: String): Boolean {
      return MMKV.defaultMMKV().containsKey(key)
    }

}