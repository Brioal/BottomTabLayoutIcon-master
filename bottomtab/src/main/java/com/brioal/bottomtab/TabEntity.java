package com.brioal.bottomtab;

/**
 * BottomTab Layout Entity
 * Created by Brioal on 2016/10/2.
 */

public class TabEntity {
    private int mIconNormal;
    private int mIconSelected;
    private String mTitle;

    public TabEntity() {

    }

    public TabEntity(String title, int iconNormal, int iconSelected) {
        mIconNormal = iconNormal;
        mIconSelected = iconSelected;
        mTitle = title;
    }

    public int getIconNormal() {
        return mIconNormal;
    }

    public void setIconNormal(int iconNormal) {
        mIconNormal = iconNormal;
    }

    public int getIconSelected() {
        return mIconSelected;
    }

    public void setIconSelected(int iconSelected) {
        mIconSelected = iconSelected;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
