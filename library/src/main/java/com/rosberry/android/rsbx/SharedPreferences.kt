/*
 *
 *  * Copyright (c) 2020 Rosberry. All rights reserved.
 *
 */

package com.rosberry.android.rsbx

import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * @author Alexei Korshun on 26.07.2020.
 */
fun SharedPreferences.string(
        defaultValue: String = "",
        key: (KProperty<*>) -> String = KProperty<*>::name
): ReadWriteProperty<Any, String> =
        object : ReadWriteProperty<Any, String> {
            override fun getValue(
                    thisRef: Any,
                    property: KProperty<*>
            ) = getString(key(property), defaultValue) ?: defaultValue

            override fun setValue(
                    thisRef: Any,
                    property: KProperty<*>,
                    value: String
            ) = edit().putString(key(property), value).apply()
        }

fun SharedPreferences.int(
        defaultValue: Int = 0,
        key: (KProperty<*>) -> String = KProperty<*>::name
): ReadWriteProperty<Any, Int> =
        object : ReadWriteProperty<Any, Int> {
            override fun getValue(
                    thisRef: Any,
                    property: KProperty<*>
            ) = getInt(key(property), defaultValue)

            override fun setValue(
                    thisRef: Any,
                    property: KProperty<*>,
                    value: Int
            ) = edit().putInt(key(property), value).apply()
        }

fun SharedPreferences.boolean(
        defaultValue: Boolean = false,
        key: (KProperty<*>) -> String = KProperty<*>::name
): ReadWriteProperty<Any, Boolean> =
        object : ReadWriteProperty<Any, Boolean> {
            override fun getValue(
                    thisRef: Any,
                    property: KProperty<*>
            ) = getBoolean(key(property), defaultValue)

            override fun setValue(
                    thisRef: Any,
                    property: KProperty<*>,
                    value: Boolean
            ) = edit().putBoolean(key(property), value).apply()
        }

fun SharedPreferences.long(
        defaultValue: Long = 0,
        key: (KProperty<*>) -> String = KProperty<*>::name
): ReadWriteProperty<Any, Long> =
        object : ReadWriteProperty<Any, Long> {
            override fun getValue(
                    thisRef: Any,
                    property: KProperty<*>
            ) = getLong(key(property), defaultValue)

            override fun setValue(
                    thisRef: Any,
                    property: KProperty<*>,
                    value: Long
            ) = edit().putLong(key(property), value).apply()
        }

fun SharedPreferences.float(
        defaultValue: Float = 0f,
        key: (KProperty<*>) -> String = KProperty<*>::name
): ReadWriteProperty<Any, Float> =
        object : ReadWriteProperty<Any, Float> {
            override fun getValue(
                    thisRef: Any,
                    property: KProperty<*>
            ) = getFloat(key(property), defaultValue)

            override fun setValue(
                    thisRef: Any,
                    property: KProperty<*>,
                    value: Float
            ) = edit().putFloat(key(property), value).apply()
        }

fun SharedPreferences.stringSet(
        defaultValue: Set<String> = emptySet(),
        key: (KProperty<*>) -> String = KProperty<*>::name
): ReadWriteProperty<Any, Set<String>> =
        object : ReadWriteProperty<Any, Set<String>> {
            override fun getValue(
                    thisRef: Any,
                    property: KProperty<*>
            ) = getStringSet(key(property), defaultValue) ?: defaultValue

            override fun setValue(
                    thisRef: Any,
                    property: KProperty<*>,
                    value: Set<String>
            ) = edit().putStringSet(key(property), value).apply()
        }