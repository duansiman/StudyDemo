# WebView
##1、定义
    WebView是一个基于Android WebKit浏览器引擎的一个框架。
##2、优缺点
###优点：
    a、兼容WEB项目，以前已经开发好的WEB项目，不需要再根据业务重新开发适应手机项目，可以使用WebView直接加载以前写好的页面。
    b、可以动态改变内容，只需要在服务器替换页面内容。
###缺点：
    a、加载速度慢。
    b、耗电，手机发热。
##3、WebViewClient
    设置WebViewClient，让WebView打开网页，否则会让系统默认浏览器打开。帮助WebView处理各种通知、请求事件。
```java
webView.setWebViewClient(new WebViewClient());
```
###自定义错误页面
```java
    new WebViewClient(){
        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            //加载本地错误页面
            view.loadUrl("file:///android_asset/error.html");
            //在这使用控件显示错误也可以
            errorView.setText("404 错误");
            view.setVisibility(View.GONE);
        }
    }
```
##4、WebChromeClient
    设置WebChromeClient，处理Javascript的对话框、网站图标、网站title、加载进度等。
```java
webView.setWebChromeClient(new WebChromeClient());
```
###设置标题
```java
    new WebChromeClient() {
        @Override
        public void onReceivedTitle(WebView view, String title) {
            //截取网页标题
            actionBar.setTitle(title);
            super.onReceivedTitle(view, title);
        }
    }
```
##5、监听下载
```java
  //设置下载监听
  webView.setDownloadListener(new DownloadListener() {
      /**
       * @param url http://7xo0ym.dl1.z0.glb.clouddn.com/@/android/test.apk
       * @param userAgent Mozilla/5.0 (Linux; Android 5.1; Google Nexus 10 - 5.1.0 - API 22 - 2560x1600 Build/LMY47D) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/39.0.0.0 Mobile Safari/537.36
       * @param contentDisposition attachment; filename="test.apk"
       * @param mimetype application/vnd.android.package-archive
       * @param contentLength 11833449
       */
      @Override
      public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
          System.out.println("download");
          //使用线程去下载
          //new Thread(new DownloadThread(url)).start();
          //用系统浏览器去下载
          Uri uri = Uri.parse(url);
          Intent intent = new Intent(Intent.ACTION_VIEW, uri);
          startActivity(intent);
      }
  });
```
##6、同步Cookie
```java
        //同步Cookie
        CookieSyncManager.createInstance(this);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        //设置对应URL地址的cookie
        cookieManager.setCookie(url, cookie);
        CookieSyncManager.getInstance().sync();
```
##7、与JS调用混淆问题
```java
        //与JS调用
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(this, "obj");
        webView.loadData("<script>obj.helloJs();</script>","text/html", "utf-8");
        
        @JavascriptInterface
        public void helloJs(){
            Toast.makeText(this, "hello js", Toast.LENGTH_SHORT).show();
        }
```
        保持某类中被JS调用的方法不被混淆
```java
    -keep public class com.webview.JsCall {
        public <method>;
    }
```
##8、Webview被注入问题
        4.2之前版本，可以通过searchBoxJavaBridge对象获取手机一些信息。
##9、WebView自定义协议
```java
        webView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //根据不同URL地址，做不同处理
                if(url.endsWith("?test")){
                    //做处理
                    return ture;
                }
                return super.shouldOverrideUrlLoading(view, url);
            }
        }
```
