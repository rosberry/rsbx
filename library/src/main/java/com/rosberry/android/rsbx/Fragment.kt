/*
 *
 *  * Copyright (c) 2020 Rosberry. All rights reserved.
 *
 */

package com.rosberry.android.rsbx

import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * @author Alexei Korshun on 20.03.2020.
 */

/**
 * Example usage:
 *
 * ```
 * private var boolArgument: Boolean by argument()
 *
 * companion object {
 *     fun newInstance(argument: Boolean) = YourFragment().apply {
 *         this.boolArgument = argument
 *     }
 * }
 * ```
 */
@Suppress("UNCHECKED_CAST")
fun <T : Any> Fragment.argument(
        key: (KProperty<*>) -> String = KProperty<*>::name
): ReadWriteProperty<Fragment, T> = object : ReadWriteProperty<Fragment, T> {

    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        return thisRef.arguments?.get(key.invoke(property)) as T
    }

    override fun setValue(thisRef: Fragment, property: KProperty<*>, value: T) {
        val args: Bundle = thisRef.arguments
            ?: Bundle().also(thisRef::setArguments)
        args.put(key.invoke(property), value)
    }
}