# AnimationListView
动画效果列表

<img width="300" src="https://raw.githubusercontent.com/wailovet/AnimationListView/master/0.gif"/>


<pre>
在xml视图中
添加   
&lt;com.swzfpro.wailovet.animationlistview.AnimationListView
        android:id="@+id/list"
        android:layout_width="match_parent"
        android:layout_height="match_parent"&gt;
&lt;/com.swzfpro.wailovet.animationlistview.AnimationListView&gt;


用setAnimationType选择类型
(AnimationListView)findViewById(R.id.list).setAnimationType(AnimationListView.AnimationType.FADEIN);
AnimationListView.AnimationType.FADEIN为淡入淡出
AnimationListView.AnimationType.LEFTTORIGHT为从左向右滑入
AnimationListView.AnimationType.BOTTOMTOTOP为从底至上滑入
</pre>
