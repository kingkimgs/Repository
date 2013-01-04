package com.kks.Touchgame;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.kks.Touchgame.DBManger.Rank;

public class RankActivity extends Activity {

	ListView listview;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); // 제목 표시줄 없애기

		setContentView(R.layout.rank);
		listview = (ListView) findViewById(R.id.listView1);
		listview.setAdapter(adapter);
		listview.setOnItemClickListener(listener);

	}

	public OnItemClickListener listener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> list, View view, int position,
				long id) {
			final Rank rank = MainActivity.dbManager.getRankAt(position);
			String msg = "Do you want to delete " + rank.date + "?";
			AlertDialog dlg = new AlertDialog.Builder(RankActivity.this)
					.setTitle("Delete?").setMessage(msg)
					.setPositiveButton("Yes", new OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							MainActivity.dbManager.delete(rank);
							adapter.notifyDataSetChanged();
						}
					}).setNegativeButton("No", null).create();
			dlg.show();
		}
	};

	class RankView extends LinearLayout {

		TextView date;
		TextView time;
		TextView num;

		public RankView() {
			super(RankActivity.this);
			LayoutInflater inflator = getLayoutInflater();
			inflator.inflate(R.layout.rank_list, this, true);
			date = (TextView) findViewById(R.id.date);
			time = (TextView) findViewById(R.id.time);
			num = (TextView)findViewById(R.id.num);
		}

		public void setRank(Rank rank) {
			date.setText(rank.date);
			time.setText(rank.time);
			num.setText(String.valueOf(rank.id));
		}
	}

	private BaseAdapter adapter = new BaseAdapter() {

		@Override
		public int getCount() {
			return MainActivity.dbManager.getCount();
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			Rank rank = MainActivity.dbManager.getRankAt(position);
			RankView rankView = null;
			if (convertView != null) {
				rankView = (RankView) convertView;
			} else {
				rankView = new RankView();
			}
			rankView.setRank(rank);
			return rankView;
		}

	};

}
