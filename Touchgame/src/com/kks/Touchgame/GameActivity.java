package com.kks.Touchgame;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends Activity {

	TextView min;
	TextView sec;
	TextView num;
	Button[] b;
	int buttonid[] = { R.id.Button01, R.id.Button02, R.id.Button03,
			R.id.Button04, R.id.Button05, R.id.Button06, R.id.Button07,
			R.id.Button08, R.id.Button09, R.id.Button10 };
	Timer progresTimer;
	int s = 100;
	int m = 100;
	int n = 1;
	clickListener listener = new clickListener();

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); // 제목 표시줄 없애기
		setContentView(R.layout.game);
		num = (TextView) findViewById(R.id.num);
		min = (TextView) findViewById(R.id.min);
		sec = (TextView) findViewById(R.id.sec);
		b = new Button[10];
		for (int i = 0; i < 10; i++) {
			b[i] = (Button) findViewById(buttonid[i]);
			b[i].setOnClickListener(listener);
		}

		num.setText(Integer.toString(n));

		progresTimer = new Timer();
		progresTimer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {

				sec.post(new Runnable() {
					@Override
					public void run() {
						sec.setText(Integer.toString(s));
						if (s != 60) {
							s++;
						} else
							s = 0;
					}
				});
				min.post(new Runnable() {
					@Override
					public void run() {
						if (s == 60)
							m++;
						min.setText(Integer.toString(m));
					}
				});
			}
		}, 0, 1000);
	}

	class clickListener implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			if (v.getId() == R.id.Button01) {
				if (Integer.parseInt(b[0].getText().toString()) == n) {
					if (Integer.parseInt(b[0].getText().toString()) == 11) {
						b[0].setEnabled(false);
						b[0].setText(" ");
						n++;
						num.setText(Integer.toString(n));
						return;
					}
					n++;
					num.setText(Integer.toString(n));
					b[0].setText(11 + "");
				} else {
					Toast.makeText(getApplication(), "잘못된숫자입니다.",
							Toast.LENGTH_SHORT).show();
				}
			} else if (v.getId() == R.id.Button02) {
				if (Integer.parseInt(b[1].getText().toString()) == n) {
					if (Integer.parseInt(b[1].getText().toString()) == 12) {
						b[1].setEnabled(false);
						b[1].setText(" ");
						n++;
						num.setText(Integer.toString(n));
						return;
					}
					n++;
					num.setText(Integer.toString(n));
					b[1].setText(12 + "");
				} else {
					Toast.makeText(getApplication(), "잘못된숫자입니다.",
							Toast.LENGTH_SHORT).show();
				}

			} else if (v.getId() == R.id.Button03) {
				if (Integer.parseInt(b[2].getText().toString()) == n) {
					if (Integer.parseInt(b[2].getText().toString()) == 13) {
						b[2].setEnabled(false);
						b[2].setText(" ");
						n++;
						num.setText(Integer.toString(n));
						return;
					}
					n++;
					num.setText(Integer.toString(n));
					b[2].setText(13 + "");
				} else {
					Toast.makeText(getApplication(), "잘못된숫자입니다.",
							Toast.LENGTH_SHORT).show();
				}

			} else if (v.getId() == R.id.Button04) {
				if (Integer.parseInt(b[3].getText().toString()) == n) {
					if (Integer.parseInt(b[3].getText().toString()) == 14) {
						b[3].setEnabled(false);
						b[3].setText(" ");
						n++;
						num.setText(Integer.toString(n));
						return;
					}
					n++;
					num.setText(Integer.toString(n));
					b[3].setText(14 + "");
				} else {
					Toast.makeText(getApplication(), "잘못된숫자입니다.",
							Toast.LENGTH_SHORT).show();
				}

			} else if (v.getId() == R.id.Button05) {
				if (Integer.parseInt(b[4].getText().toString()) == n) {
					if (Integer.parseInt(b[4].getText().toString()) == 15) {
						b[4].setEnabled(false);
						b[4].setText(" ");
						n++;
						num.setText(Integer.toString(n));
						return;
					}
					n++;
					num.setText(Integer.toString(n));
					b[4].setText(15 + "");
				} else {
					Toast.makeText(getApplication(), "잘못된숫자입니다.",
							Toast.LENGTH_SHORT).show();
				}

			} else if (v.getId() == R.id.Button06) {
				if (Integer.parseInt(b[5].getText().toString()) == n) {
					if (Integer.parseInt(b[5].getText().toString()) == 16) {
						b[5].setEnabled(false);
						b[5].setText(" ");
						n++;
						num.setText(Integer.toString(n));
						return;
					}
					n++;
					num.setText(Integer.toString(n));
					b[5].setText(16 + "");
				} else {
					Toast.makeText(getApplication(), "잘못된숫자입니다.",
							Toast.LENGTH_SHORT).show();
				}

			} else if (v.getId() == R.id.Button07) {
				if (Integer.parseInt(b[6].getText().toString()) == n) {
					if (Integer.parseInt(b[6].getText().toString()) == 17) {
						b[6].setEnabled(false);
						b[6].setText(" ");
						n++;
						num.setText(Integer.toString(n));
						return;
					}
					n++;
					num.setText(Integer.toString(n));
					b[6].setText(17 + "");
				} else {
					Toast.makeText(getApplication(), "잘못된숫자입니다.",
							Toast.LENGTH_SHORT).show();
				}

			} else if (v.getId() == R.id.Button08) {
				if (Integer.parseInt(b[7].getText().toString()) == n) {
					if (Integer.parseInt(b[7].getText().toString()) == 18) {
						b[7].setEnabled(false);
						b[7].setText(" ");
						n++;
						num.setText(Integer.toString(n));
						return;
					}
					n++;
					num.setText(Integer.toString(n));
					b[7].setText(18 + "");
				} else {
					Toast.makeText(getApplication(), "잘못된숫자입니다.",
							Toast.LENGTH_SHORT).show();
				}

			} else if (v.getId() == R.id.Button09) {
				if (Integer.parseInt(b[8].getText().toString()) == n) {
					if (Integer.parseInt(b[8].getText().toString()) == 19) {
						b[8].setEnabled(false);
						b[8].setText(" ");
						n++;
						num.setText(Integer.toString(n));
						return;
					}
					n++;
					num.setText(Integer.toString(n));
					b[8].setText(19 + "");
				} else {
					Toast.makeText(getApplication(), "잘못된숫자입니다.",
							Toast.LENGTH_SHORT).show();
				}

			} else if (v.getId() == R.id.Button10) {
				if (Integer.parseInt(b[9].getText().toString()) == n) {
					if (Integer.parseInt(b[9].getText().toString()) == 20) {
						b[9].setEnabled(false);
						b[9].setText(" ");
						progresTimer.cancel();
						progresTimer.purge();

						new AlertDialog.Builder(GameActivity.this)
								.setTitle("게임종료")
								.setMessage("시간저장하시겠습니까??")
								.setPositiveButton("저장",
										new DialogInterface.OnClickListener() {

											@Override
											public void onClick(
													DialogInterface dialog,
													int which) {

												Date date = new Date();
												int year = date.getYear() + 1900;
												int month = date.getMonth() + 1;
												int day = date.getDate();
												String sumdate = String
														.valueOf(year)
														+ "/"
														+ String.valueOf(month)
														+ "/"
														+ String.valueOf(day);

												String sumtime = min.getText()
														.toString()
														+ ":"
														+ sec.getText()
																.toString();
												MainActivity.dbManager.add(
														sumdate, sumtime);

												Intent I2 = new Intent(
														GameActivity.this,
														RankActivity.class);

												startActivity(I2);
												finish();// 엑티비티 종료
											}
										})
								.setNegativeButton("취소",
										new DialogInterface.OnClickListener() {

											@Override
											public void onClick(
													DialogInterface dialog,
													int which) {
												finish();// 엑티비티 종료
											}
										}).show();
						return;
					}
					n++;
					num.setText(Integer.toString(n));
					b[9].setText(20 + "");
				} else {
					Toast.makeText(getApplication(), "잘못된숫자입니다.",
							Toast.LENGTH_SHORT).show();
				}

			}

		}
	}
}
