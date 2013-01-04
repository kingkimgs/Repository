package com.kks.Touchgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity {

	Button start;
	Button rank;
	static DBManger dbManager;
	clickListener listener = new clickListener();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); // 제목 표시줄 없애기
		setContentView(R.layout.main);
		
		dbManager = new DBManger(this);
		start = (Button) findViewById(R.id.start);
		rank = (Button) findViewById(R.id.rank);

		start.setOnClickListener(listener);
		rank.setOnClickListener(listener);
		
	}

	class clickListener implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			if (v.getId() == R.id.start) {
				Intent I1 = new Intent(MainActivity.this, GameActivity.class);
				startActivity(I1);
			} else if (v.getId() == R.id.rank) {
				Intent I2 = new Intent(MainActivity.this, RankActivity.class);			
				startActivity(I2);
			}
		}
	}
}
