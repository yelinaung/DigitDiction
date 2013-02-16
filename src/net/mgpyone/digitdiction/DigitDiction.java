
package net.mgpyone.digitdiction;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class DigitDiction extends ListActivity {

    private DigitAdapter mAdapter;
    private Toast toast;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAdapter = new DigitAdapter();
        String[] mQuestions = getResources().getStringArray(R.array.questions);

        for (int i = 1; i < mQuestions.length; i++) {
            mAdapter.addQuestions(mQuestions[i], i);
        }

        setListAdapter(mAdapter);

        LayoutInflater inflater = getLayoutInflater();
        final View layout = inflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast_layout_root));

        final TextView text = (TextView) layout.findViewById(R.id.toast_text);
        toast = new Toast(this);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
    }


    @Override
    public void onStop() {
        super.onStop();
        toast.cancel();
    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        DigitQuestion question = (DigitQuestion) mAdapter.getItem(position);
        switch (question.mId) {
            case 1:
                Toast.makeText(this, "Hello 1", Toast.LENGTH_LONG).show();
                break;

            default:
                break;
        }

    }

    private static class DigitQuestion {
        String mQuestion;
        int mId;


        public DigitQuestion(String question, int id) {
            mQuestion = question;
            mId = id;
        }
    }

    public class DigitAdapter extends BaseAdapter {

        private List<DigitQuestion> mQuestions = new ArrayList<DigitQuestion>();


        public void addQuestions(String question, int id) {
            mQuestions.add(new DigitQuestion(question, id));
        }


        @Override
        public int getCount() {
            return mQuestions.size();
        }


        @Override
        public Object getItem(int position) {
            return mQuestions.get(position);
        }


        @Override
        public long getItemId(int position) {
            return position;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            DigitQuestion dQ = (DigitQuestion) getItem(position);

            View v = convertView;
            if (v == null) {
                v = getLayoutInflater().inflate(R.layout.list_row, parent, false);
            }

            Typeface tf = Typeface.createFromAsset(getAssets(), "font/zawgyi.ttf");
            ((TextView) v.findViewById(R.id.question)).setText(dQ.mQuestion);
            ((TextView) v.findViewById(R.id.question)).setTypeface(tf);

            return v;
        }

    }
}
