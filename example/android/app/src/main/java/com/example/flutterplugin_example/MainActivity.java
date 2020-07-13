package com.example.flutterplugin_example;

import android.os.Bundle;

import androidx.annotation.NonNull;

import io.flutter.app.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.GeneratedPluginRegistrant;

public class MainActivity extends FlutterActivity {
  private static final String CHANNEL = "flutter.native/helper";
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    GeneratedPluginRegistrant.registerWith(new FlutterEngine(this));
    new MethodChannel(getFlutterView(), CHANNEL).setMethodCallHandler(
            new MethodChannel.MethodCallHandler() {
              @Override
              public void onMethodCall(MethodCall call, MethodChannel.Result result) {
                if (call.method.equals("helloFromNativeCode")) {
                  String greetings = helloFromNativeCode();
                  result.success(greetings);
                }
              }});
  }
  private String helloFromNativeCode() {
    return "Hello from Native Android Code nhan";
  }
}
