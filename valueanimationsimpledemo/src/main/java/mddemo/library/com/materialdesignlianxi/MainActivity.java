package mddemo.library.com.materialdesignlianxi;

import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //这里是对值动画的简单的练习
    private void performAnimation(final View target, final int start, final int end) {

        ValueAnimator valueAnimator = ValueAnimator.ofInt(1, 100);

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            //持有一个intevaluator 对象方便估值的时候使用
            private IntEvaluator evaluator = new IntEvaluator();

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //在这这里可以获取到动画的进度值 整形的1-100
                int cuerrentValue = (int) animation.getAnimatedValue();
                //计算当前动画的所占的比例
                float faction = cuerrentValue / 100f;

                //直接调用估值器进行计算宽度的变化
                target.getLayoutParams().width = evaluator.evaluate(faction, start, end);
                target.requestLayout();
            }
        });
        valueAnimator.setDuration(5000).start();
    }
    private void onclick(View view){
        if (view instanceof Button){
            performAnimation(view,view.getWidth(),500);
        }
    }
}
