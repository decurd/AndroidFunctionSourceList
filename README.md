## Chrome Custom Tabs Guide
#### 참조링크
https://developer.chrome.com/multidevice/android/customtabs <br>
http://sirubomber.tistory.com/38<br>
https://github.com/GoogleChrome/custom-tabs-client
### dependency 추가
```html
dependencies {
    ...
    compile 'com.android.support:customtabs:25.3.1'
}
```
#### [ 주의사항 ]
```html
Bitmap backArrowBitmap = BitmapFactory.decodeResource(activity.getResources(), R.drawable.ic_arrow_back_black_24dp);
CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
builder.setToolbarColor(ContextCompat.getColor(activity, R.color.white));
builder.setShowTitle(true);
builder.setCloseButtonIcon(backArrowBitmap);
```
\* Bitmap 아이콘이 24dp를 넘으면 안된다. <p>
\* 기기의 기본 웹 브라우저가 크롬이 아닌 다른 브라우저로 설정되어 있으면 크롬 탭이 열리지 않는다.