package com.douraid.composedemo.config

import com.douraid.composedemo.BuildConfig

abstract class BaseCommonConfigProvider : ConfigProvider {

    override val isDebug = BuildConfig.DEBUG

    override val mainHeroImageUrl = "https://az759258.vo.msecnd.net/media/2910/hero-home-2x.jpg"
}