package com.chan.rsv.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.github.channguyen.rsv.RangeSliderView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  private RangeSliderView smallSlider;

  private RangeSliderView largeSlider;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    smallSlider = (RangeSliderView) findViewById(
      R.id.rsv_small);
    largeSlider = (RangeSliderView) findViewById(
      R.id.rsv_large);
    List<String> list=new ArrayList<>();
    list.add("q");
    list.add("qdd");
    list.add("qxxx");
    list.add("哈哈");
    list.add("qddda");
    smallSlider.setTextTarget(list);
    smallSlider.setIsOpen(true);
    final RangeSliderView.OnSlideListener listener = new RangeSliderView.OnSlideListener() {
      @Override
      public void onSlide(int index) {
        Toast.makeText(
          getApplicationContext(),
          "Hi index: " + index,
          Toast.LENGTH_SHORT)
          .show();
      }
    };
    smallSlider.setOnSlideListener(listener);
    largeSlider.setOnSlideListener(listener);
  }
}