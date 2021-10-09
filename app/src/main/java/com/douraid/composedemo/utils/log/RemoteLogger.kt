package com.douraid.composedemo.utils.log

interface RemoteLogger {

    fun log(message: String)

    fun logRemoteException(throwable: Throwable)
}