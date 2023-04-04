package com.progsoft.table_list_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // 声明变量
    TableLayout tableLayout;
    private final ArrayList<DataItem> dataItems = new ArrayList<>();
    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG, "onCreate");

        // 添加要显示的数据
        dataItems.add(new DataItem("新星花园2号楼1001室", "(21, 104)", "90"));
        for (int i = 0; i < 20; i++)
            dataItems.add(new DataItem("地址" + i, "(22, 115)", "89"));
        // 绘制表格
        initTable();
        MyRunnable myRunnable = new MyRunnable();
        Thread mThread = new Thread(myRunnable, "Timer");
        mThread.start();
    }

    class MyRunnable implements Runnable {
        @Override
        public void run() {
            Log.e(TAG, "****HTTPS****:" + HttpClient.doGet("https://www.baidu.com/"));
            Log.e(TAG, "****HTTP*****:" + HttpClient.doGet("http://www.baidu.com/"));
        }
    }

    @SuppressLint("SetTextI18n")
    private void initTable() {
        tableLayout = findViewById(R.id.tableLayout);

        int padding = dip2px(getApplicationContext(), 5);

        // 遍历dataItems, 每一条数据都加进TableLayout中
        for(int i = 0; i<dataItems.size(); i++){
            // 获取一条数据
            DataItem dataItem = dataItems.get(i);

            // 新建一个TableRow并设置样式
            TableRow newRow = new TableRow(getApplicationContext());
            TableRow.LayoutParams layoutParams = new TableRow.LayoutParams();
            newRow.setLayoutParams(layoutParams);

            //新建一个LinearLayout
            LinearLayout linearLayout = new LinearLayout(getApplicationContext());
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);

            // 底部边框的宽度
            int bottomLine = dip2px(getApplicationContext(), 1);
            if(i == dataItems.size() - 1) {
                // 如果当前行是最后一行, 则底部边框加粗
                bottomLine = dip2px(getApplicationContext(), 2);
            }

            // 第一列
            TextView tvNo = new TextView(getApplicationContext());
            // 设置文字居中
            tvNo.setGravity(Gravity.CENTER);
            // 设置表格中的数据不自动换行
            tvNo.setSingleLine();
            // 设置边框和weight
            LinearLayout.LayoutParams lpNo = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 2f);
            lpNo.setMargins(dip2px(getApplicationContext(), 2), 0, dip2px(getApplicationContext(), 1), bottomLine);
            tvNo.setLayoutParams(lpNo);
            // 设置padding和背景颜色
            tvNo.setPadding(padding, padding, padding, padding);
            tvNo.setBackgroundColor(Color.parseColor("#FFFFFF"));
            // 填充文字数据
            tvNo.setText((i+1) + "");

            // 第二列
            TextView tvAddress = new TextView(getApplicationContext());
            // 设置文字居中
            tvAddress.setGravity(Gravity.CENTER);
            // 设置表格中的数据不自动换行
            tvAddress.setSingleLine();
            // 设置边框和weight
            LinearLayout.LayoutParams lpAd = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 4f);
            lpAd.setMargins(0, 0, dip2px(getApplicationContext(), 1), bottomLine);
            tvAddress.setLayoutParams(lpAd);
            // 设置padding和背景颜色
            tvAddress.setPadding(padding, padding, padding, padding);
            tvAddress.setBackgroundColor(Color.parseColor("#FFFFFF"));
            // 填充文字数据
            tvAddress.setText(dataItem.getAddress());

            // 第三列
            TextView tvLL = new TextView(getApplicationContext());
            // 设置文字居中
            tvLL.setGravity(Gravity.CENTER);
            // 设置表格中的数据不自动换行
            tvLL.setSingleLine();
            // 设置边框和weight
            LinearLayout.LayoutParams lpLL = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 2f);
            lpLL.setMargins(0, 0, dip2px(getApplicationContext(), 1), bottomLine);
            tvLL.setLayoutParams(lpLL);
            // 设置padding和背景颜色
            tvLL.setPadding(padding, padding, padding, padding);
            tvLL.setBackgroundColor(Color.parseColor("#FFFFFF"));
            // 填充文字数据
            tvLL.setText(dataItem.getLL());


            // 将所有新的组件加入到对应的视图中
            linearLayout.addView(tvNo);
            linearLayout.addView(tvAddress);
            linearLayout.addView(tvLL);


            // 第四列
            for (int j = 0; j < 20; j++) {
                TextView tvDistance = new TextView(getApplicationContext());
                // 设置文字居中
                tvDistance.setGravity(Gravity.CENTER);
                // 设置表格中的数据不自动换行
                tvDistance.setSingleLine();
                // 设置边框和weight
                LinearLayout.LayoutParams lpDistance = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 2f);
                lpDistance.setMargins(0, 0, dip2px(getApplicationContext(), 1), bottomLine);
                tvDistance.setLayoutParams(lpDistance);
                // 设置padding和背景颜色
                tvDistance.setPadding(padding, padding, padding, padding);
                tvDistance.setBackgroundColor(Color.parseColor("#FFFFFF"));
                // 填充文字数据
                tvDistance.setText(dataItem.getDistance());

                linearLayout.addView(tvDistance);
            }
            newRow.addView(linearLayout);
            tableLayout.addView(newRow);
        }
    }

    private int dip2px(Context context, int dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}