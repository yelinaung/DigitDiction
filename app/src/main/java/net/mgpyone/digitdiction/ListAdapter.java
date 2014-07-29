
package net.mgpyone.digitdiction;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter {
    private final Activity context;
    private List<DigitQuestion> mQuestions = new ArrayList<DigitQuestion>();

    static class DigitQuestion {
        String mQuestion;
        int mId;


        public DigitQuestion(String question, int id) {
            mQuestion = question;
            mId = id;
        }
    }


    public ListAdapter(Activity context) {
        this.context = context;
    }
    
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

    // Using ViewHolder helps a lot better.
    static class ViewHolder {
        public TextView text;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DigitQuestion dQ = (DigitQuestion) getItem(position);
        View v = convertView;
        Typeface tf = Typeface.createFromAsset(context.getAssets(), "font/zawgyi.ttf");
        
        if (v == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            v = inflater.inflate(R.layout.list_row, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.text = (TextView) v.findViewById(R.id.question);
            viewHolder.text.setTypeface(tf);
            v.setTag(viewHolder);
        }
        
        ViewHolder holder = (ViewHolder) v.getTag();
        holder.text.setText(dQ.mQuestion);

        return v;
    }

}
