package com.tinkerlibrary.view;

import android.content.Context;
import android.text.InputType;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.tinkerlibrary.R;
import com.tinkerlibrary.R2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.content.ContentValues.TAG;

/**
 * 键盘事件封装 弹出键盘
 * Created by gaoxin on 2017/3/14.
 *
 *  使用R2需在当前主项目的build.gradle下dependencies配置如下内容
 *  classpath 'com.jakewharton:butterknife-gradle-plugin:8.4.0'
 *  classpath 'com.neenbedankt.gradle.plugins:android-apt:1.8' // 添加的部分
 *
 *
 */

public class MyKeyBoard extends RelativeLayout {

    @BindView(R2.id.btn_kb_keyboard_nK_1)
    Button btnKbKeyboardNK1;
    @BindView(R2.id.btn_kb_keyboard_nK_2)
    Button btnKbKeyboardNK2;

    @BindView(R2.id.btn_kb_keyboard_nK_4)
    Button btnKbKeyboardNK4;
    @BindView(R2.id.btn_kb_keyboard_nK_5)
    Button btnKbKeyboardNK5;
    @BindView(R2.id.btn_kb_keyboard_nK_6)
    Button btnKbKeyboardNK6;
    @BindView(R2.id.btn_kb_keyboard_nK_7)
    Button btnKbKeyboardNK7;
    @BindView(R2.id.btn_kb_keyboard_nK_8)
    Button btnKbKeyboardNK8;
    @BindView(R2.id.btn_kb_keyboard_nK_9)
    Button btnKbKeyboardNK9;
    @BindView(R2.id.btn_kb_keyboard_nK_0)
    Button btnKbKeyboardNK0;
    @BindView(R2.id.btn_kb_keyboard_nK_dian)
    Button btnKbKeyboardNKDian;
    @BindView(R2.id.btn_kb_keyboard_nK_00)
    Button btnKbKeyboardNK00;
    @BindView(R2.id.btn_kb_keyboard_nK_10)
    Button btnKbKeyboardNK10;
    @BindView(R2.id.btn_kb_keyboard_nK_50)
    Button btnKbKeyboardNK50;
    @BindView(R2.id.btn_kb_keyboard_nK_100)
    Button btnKbKeyboardNK100;
    @BindView(R2.id.btn_kb_keyboard_nK_500)
    Button btnKbKeyboardNK500;
    @BindView(R2.id.btn_kb_keyboard_nK_1000)
    Button btnKbKeyboardNK1000;
    @BindView(R2.id.btn_kb_keyboard_nK_2000)
    Button btnKbKeyboardNK2000;
    @BindView(R2.id.layout_kb_keyboard)
    LinearLayout layoutKbKeyboard;
    @BindView(R2.id.btn_kb_keyboard_nK_3)
    Button btnKbKeyboardNK3;
    private View view;
    ;
    private Animation mHiddenAction;
    private Animation mShowAction;

    public static EditText editText;
    public static View popupWindow_view;
    public static PopupWindow popupWindow;
    private String number ;

    public MyKeyBoard(Context context, EditText editText) {
        super(context);
        this.editText = editText;
        init(context);

    }


    public void register(View popupWindow_view, final PopupWindow popupWindow1) {
        MyKeyBoard.popupWindow_view = popupWindow_view;
        MyKeyBoard.popupWindow = popupWindow1;

    }

    public MyKeyBoard(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    public MyKeyBoard(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        view = LayoutInflater.from(context).inflate(R.layout.key_board_layout,this, true);
        ButterKnife.bind(view);

    }

    public void setEditText(final EditText editText) {
        this.editText = editText;
        this.editText.setOnTouchListener(new OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                show();
                return false;
            }
        });
        this.editText.setOnFocusChangeListener(new OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hint();
                }


            }
        });
    }

    public void hint() {
        if (this.getVisibility() == View.VISIBLE) {
            this.startAnimation(mHiddenAction);
            this.setVisibility(View.GONE);
        }
    }

    public void show() {
        if (this.getVisibility() == View.GONE) {
            this.startAnimation(mShowAction);
            this.setVisibility(View.VISIBLE);
        }
    }


    @OnClick({R2.id.btn_kb_keyboard_nK_1, R2.id.btn_kb_keyboard_nK_2, R2.id.btn_kb_keyboard_nK_3, R2.id.btn_kb_keyboard_nK_4, R2.id.btn_kb_keyboard_nK_5, R2.id.btn_kb_keyboard_nK_6, R2.id.btn_kb_keyboard_nK_7, R2.id.btn_kb_keyboard_nK_8, R2.id.btn_kb_keyboard_nK_9, R2.id.btn_kb_keyboard_nK_0, R2.id.btn_kb_keyboard_nK_dian, R2.id.btn_kb_keyboard_nK_00, R2.id.btn_kb_keyboard_nK_10, R2.id.btn_kb_keyboard_nK_50, R2.id.btn_kb_keyboard_nK_100, R2.id.btn_kb_keyboard_nK_500, R2.id.btn_kb_keyboard_nK_1000, R2.id.btn_kb_keyboard_nK_2000, R2.id.layout_kb_keyboard})
    public void onClick(View v) {
        if (editText.getText().toString() != null){
            number = editText.getText().toString();
        }
        switch (v.getId()) {
            case R2.id.btn_kb_keyboard_nK_0:
                number += btnKbKeyboardNK0.getText().toString();
                break;
            case R2.id.btn_kb_keyboard_nK_1:
                number += btnKbKeyboardNK1.getText().toString();
                break;
            case R2.id.btn_kb_keyboard_nK_2:
                number += btnKbKeyboardNK2.getText().toString();
                break;
            case R2.id.btn_kb_keyboard_nK_3:
                number += btnKbKeyboardNK3.getText().toString();
                break;
            case R2.id.btn_kb_keyboard_nK_4:
                number += btnKbKeyboardNK4.getText().toString();
                break;
            case R2.id.btn_kb_keyboard_nK_5:
                number += btnKbKeyboardNK5.getText().toString();
                break;
            case R2.id.btn_kb_keyboard_nK_6:
                number += btnKbKeyboardNK6.getText().toString();
                break;
            case R2.id.btn_kb_keyboard_nK_7:
                number += btnKbKeyboardNK7.getText().toString();
                break;
            case R2.id.btn_kb_keyboard_nK_8:
                number += btnKbKeyboardNK7.getText().toString();
                break;
            case R2.id.btn_kb_keyboard_nK_9:
                number += btnKbKeyboardNK9.getText().toString();
                break;
            case R2.id.btn_kb_keyboard_nK_dian:
                number += btnKbKeyboardNKDian.getText().toString();
                break;
            case R2.id.btn_kb_keyboard_nK_10:
                number += btnKbKeyboardNK10.getText().toString();
                break;
            case R2.id.btn_kb_keyboard_nK_50:
                number += btnKbKeyboardNK50.getText().toString();
                break;
            case R2.id.btn_kb_keyboard_nK_00:
                number += btnKbKeyboardNK00.getText().toString();
                break;
            case R2.id.btn_kb_keyboard_nK_100:
                number += btnKbKeyboardNK100.getText().toString();
                break;
            case R2.id.btn_kb_keyboard_nK_500:
                number += btnKbKeyboardNK50.getText().toString();
                break;
            case R2.id.btn_kb_keyboard_nK_1000:
                number += btnKbKeyboardNK1000.getText().toString();
                break;
            case R2.id.btn_kb_keyboard_nK_2000:
                number += btnKbKeyboardNK2000.getText().toString();
                break;
            case R2.id.layout_kb_keyboard:
                Log.wtf(TAG, "onClick: layout_kb_keyboard");
                break;
        }

        editText.setText(number);

    }

    //回车键点击事件
    public void setReturnKey() {

        if (this.editText.hasFocus()) {

            editText.requestFocus();
        }

    }

    public static void getCursorIndex(EditText et, int inType, View v, int sdkInt) {
        //隐藏输入法，显示光标
        et = (EditText) v;
        inType = et.getInputType(); // back up the input type

        if (sdkInt >= 11) {
            Class<EditText> cls = EditText.class;
            try {
                Method setShowSoftInputOnFocus = cls.getMethod("setShowSoftInputOnFocus", boolean.class);
                setShowSoftInputOnFocus.setAccessible(false);
                setShowSoftInputOnFocus.invoke(et, false);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } else {
            et.setInputType(InputType.TYPE_NULL); // disable soft input
            et.setInputType(inType);

        }
    }


}
