package com.omricat.agpextensions.plugin

import com.android.build.gradle.internal.dsl.BuildType

fun BuildType.buildConfigString(name: String, value: String) =
  buildConfigField("String", name, "\"$value\"")

fun BuildType.buildConfigInt(name: String, value: Int) =
  buildConfigField("int", name, "$value")

fun BuildType.buildConfigLong(name: String, value: Long) =
  buildConfigField("long", name, "$value")

fun BuildType.buildConfigBoolean(name: String, value: Boolean) =
  buildConfigField("boolean", name, "$value")

