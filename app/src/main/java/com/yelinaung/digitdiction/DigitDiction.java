package com.yelinaung.digitdiction;

import java.util.Random;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import net.mgpyone.digitdiction.R;

public class DigitDiction extends ListActivity {

	private static final String STATE_ACTIVE_POSITION = "com.yelinaung.digitdiction.DigitDiction.activePosition";

	private ListAdapter mAdapter;

	private int mActivePosition = -1;

	Toast toast;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (savedInstanceState != null)
			mActivePosition = savedInstanceState.getInt(STATE_ACTIVE_POSITION);

		mAdapter = new ListAdapter(this);
		String[] mQuestions = getResources().getStringArray(R.array.questions);

		for (int i = 0; i < mQuestions.length; i++) {
			mAdapter.addQuestions(mQuestions[i], i);
		}

		setListAdapter(mAdapter);

		// LayoutInflater inflater = getLayoutInflater();
		// final View layout = inflater.inflate(R.layout.toast_layout, (ViewGroup)
		// findViewByid(R.id.toast_layout_root));
		// toast = new Toast(this);
		// toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		// toast.setDuration(Toast.LENGTH_LONG);
		// toast.setView(layout);
	}

	// TODO make custom toast layout.
	// is there any better way to write this code?
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		mActivePosition = position;
		ListAdapter.DigitQuestion question = (ListAdapter.DigitQuestion) mAdapter.getItem(position);
		Integer day = new Random().nextInt(9);
		switch (question.mId) {
			case 0:
				Toast.makeText(this, Predictions.results[0][day], Toast.LENGTH_SHORT).show();
				break;
			case 1:
				Toast.makeText(this, Predictions.results[1][day], Toast.LENGTH_SHORT).show();
				break;
			case 2:
				Toast.makeText(this, Predictions.results[2][day], Toast.LENGTH_SHORT).show();
				break;
			case 3:
				Toast.makeText(this, Predictions.results[3][day], Toast.LENGTH_SHORT).show();
				break;
			case 4:
				Toast.makeText(this, Predictions.results[4][day], Toast.LENGTH_SHORT).show();
				break;
			case 5:
				Toast.makeText(this, Predictions.results[5][day], Toast.LENGTH_SHORT).show();
				break;
			case 6:
				Toast.makeText(this, Predictions.results[6][day], Toast.LENGTH_SHORT).show();
				break;
			case 7:
				Toast.makeText(this, Predictions.results[7][day], Toast.LENGTH_SHORT).show();
				break;
			case 8:
				Toast.makeText(this, Predictions.results[8][day], Toast.LENGTH_SHORT).show();
				break;
			case 9:
				Toast.makeText(this, Predictions.results[9][day], Toast.LENGTH_SHORT).show();
				break;
			case 10:
				Toast.makeText(this, Predictions.results[10][day], Toast.LENGTH_SHORT).show();
				break;
			case 11:
				Toast.makeText(this, Predictions.results[11][day], Toast.LENGTH_SHORT).show();
				break;
			case 12:
				Toast.makeText(this, Predictions.results[12][day], Toast.LENGTH_SHORT).show();
				break;
			case 13:
				Toast.makeText(this, Predictions.results[13][day], Toast.LENGTH_SHORT).show();
				break;
			case 14:
				Toast.makeText(this, Predictions.results[14][day], Toast.LENGTH_SHORT).show();
				break;
			case 15:
				Toast.makeText(this, Predictions.results[15][day], Toast.LENGTH_SHORT).show();
				break;
			case 16:
				Toast.makeText(this, Predictions.results[16][day], Toast.LENGTH_SHORT).show();
				break;
			default:
				Toast.makeText(this, "Not yet implemented!", Toast.LENGTH_SHORT).show();
				break;
		}

	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt(STATE_ACTIVE_POSITION, mActivePosition);
	}

	@Override
	public void onStop() {
		super.onStop();
		// toast.cancel();
	}
}