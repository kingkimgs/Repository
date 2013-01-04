package com.kks.Touchgame;

import java.util.Vector;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DBManger {

	private static final String DATABASE_NAME = "rank.db";

	private static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS rank ("
			+ " id INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ " date VARCHAR(256) NOT NULL," + " time VARCHAR(256) NOT NULL)";

	private static final String TABLE_NAME = "rank";
	private static final String FIELD_ID = "id";
	private static final String FIELD_DATE = "date";
	private static final String FIELD_TIME = "time";
	private static final String TAG = "DBManager";
	// private Context context;
	private SQLiteDatabase db;
	private Vector<Rank> ranks = new Vector<Rank>();

	DBManger(Context context) {
		// this.context = context;
		db = context.openOrCreateDatabase(DATABASE_NAME, Context.MODE_PRIVATE,
				null);
		db.execSQL(CREATE_TABLE_SQL);
		loadData();
	}

	public class Rank {
		public Rank(Cursor cursor) {
			id = cursor.getInt(cursor.getColumnIndex(FIELD_ID));
			date = cursor.getString(cursor.getColumnIndex(FIELD_DATE));
			time = cursor.getString(cursor.getColumnIndex(FIELD_TIME));
		}

		public int id;
		public String time;
		public String date;

	}

	private void loadData() {
		ranks.removeAllElements();
		Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null,
				FIELD_ID);
		// Cursor cursor = db.rawQuery("SELECT * FROM person", null);
		while (cursor.moveToNext()) {
			Rank rank = new Rank(cursor);
			ranks.add(rank);
		}
		cursor.close();
	}

	public boolean add(String date, String time) {
		ContentValues values = new ContentValues();
		values.put(FIELD_DATE, date);
		values.put(FIELD_TIME, time);

		long row_id = db.insert(TABLE_NAME, null, values);
		if (row_id < 0) {
			return false;
		}
		Log.d(TAG, "Added row id = " + row_id);
		loadData();
		return true;
	}

	public int getCount() {
		return ranks.size();
	}

	public Rank getRankAt(int position) {
		return ranks.elementAt(position);
	}

	public void delete(Rank rank) {
		// String sql = "delete from person where id=" + person.id;
		// db.rawQuery(sql, null);
		//
		// db.delete(TABLE_NAME, "id=?", new String[] {
		// String.valueOf(person.id) });
		//
		db.delete(TABLE_NAME, "id=" + rank.id, null);
		loadData();
	}
}