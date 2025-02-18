package com.github.chinloyal.pusher_client

import androidx.annotation.NonNull
import com.github.chinloyal.pusher_client.pusher.PusherService
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result

/** PusherClientPlugin */
class PusherClientPlugin: FlutterPlugin, MethodCallHandler {

  private var pusherService: PusherService? = null

  override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
    pusherService = PusherService()
    pusherService?.register(flutterPluginBinding.binaryMessenger)
  }

  override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
    pusherService?.unregister()  // Ensure cleanup
    pusherService = null
  }

  fun unregister() {
    channel?.setMethodCallHandler(null)  // Detach method call handling
  }
}
