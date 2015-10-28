package com.softtanck.qqzone.link;

import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.view.View;

/**
 * Created by Tanck on 2015/10/27.
 */
public class ClickLink extends ClickableSpan {

    /**
     * 文本
     */
    private String text;

    public ClickLink(String text) {
        super();
        this.text = text;
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        ds.setColor(ds.linkColor);
        ds.setUnderlineText(false); //去掉下划线
    }

    @Override
    public void onClick(View widget) {

    }
}
