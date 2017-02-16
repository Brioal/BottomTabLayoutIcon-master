# BottomTabLayoutIcon
## 最近更新:添加设置Icon文字的状态颜色代码
##适用于选中时Icon改变的BottomLayout[![](https://jitpack.io/v/Brioal/BottomTabLayoutIcon.svg)](https://jitpack.io/#Brioal/BottomTabLayoutIcon)
![](https://github.com/Brioal/BottomTabLayoutIcon/blob/master/art/device-2016-10-02-214523.png)
###Step 1. Add the JitPack repository to your build file

####Add it in your root build.gradle at the end of repositories:
```
	allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
```
####Step 2. Add the dependency
```
	dependencies {
	        compile 'com.github.Brioal:BottomTabLayoutIcon-master:1.0'
	}
```
####使用方法:
####1.xml
```
    <com.brioal.bottomtab.BottomTabLayout
        android:id="@+id/main_bottomTab"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"/>

```
####2.设置
```
 mList = new ArrayList<>();
        mList.add(new TabEntity("按钮1", R.mipmap.ic_normal, R.mipmap.ic_selected));
        mList.add(new TabEntity("按钮2", R.mipmap.ic_normal, R.mipmap.ic_selected));
        mList.add(new TabEntity("按钮3", R.mipmap.ic_normal, R.mipmap.ic_selected));
        mList.add(new TabEntity("按钮4", R.mipmap.ic_normal, R.mipmap.ic_selected));
        mLayout.setList(mList);
        mLayout.setListener(new OnTabSelectedListener() {
            @Override
            public void onSelected(int position) {
                if (mToast == null) {
                    mToast = Toast.makeText(MainActivity.this, position + "", Toast.LENGTH_LONG);
                } else {
                    mToast.setText(position + "");
                }
                mToast.show();
            }
        });
```
