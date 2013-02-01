package net.mgpyone.digitdiction;

import java.util.Random;

import net.mgpyone.digitdiction.Predictions;
import net.mgpyone.digitdiction.R;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;


public class digitdiction extends Activity implements  OnClickListener
{
	
	private Toast toast;
	
    @Override  
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.main);
        LayoutInflater inflater = getLayoutInflater();
        final View layout = inflater.inflate(R.layout.toast_layout, 
        		(ViewGroup) findViewById(R.id.toast_layout_root));
        
        final TextView text = (TextView) layout.findViewById(R.id.toast_text);
	    //final Toast toast = new Toast(getApplicationContext());
        toast = new Toast(this);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        final OnClickListener clickListener = new OnClickListener() {

	        
        	public void onClick(View v) {
				try {
			        Integer day = new Random().nextInt(9);
			        switch (v.getId()){
			        case R.id.s1:
				        text.setText(Predictions.results[0][day]);
				        break;
			        case R.id.s2:
				        text.setText(Predictions.results[1][day]);
				        break;
			        case R.id.s3:
				        text.setText(Predictions.results[2][day]);
				        break;
			        case R.id.s4:
				        text.setText(Predictions.results[3][day]);
				        break;
			        case R.id.s5:
				        text.setText(Predictions.results[4][day]);
				        break;
			        case R.id.s6:
				        text.setText(Predictions.results[5][day]);
				        break;		
			        case R.id.s7:
				        text.setText(Predictions.results[6][day]);
				        break;
			        case R.id.s8:
				        text.setText(Predictions.results[7][day]);
				        break;
			        case R.id.s9:
				        text.setText(Predictions.results[8][day]);
				        break;
			        case R.id.s10:
				        text.setText(Predictions.results[9][day]);
				        break;
			        case R.id.s11:
				        text.setText(Predictions.results[10][day]);
				        break;
			        case R.id.s12:
				        text.setText(Predictions.results[11][day]);
				        break;
			        case R.id.s13:
				        text.setText(Predictions.results[12][day]);
				        break;
			        case R.id.s14:
				        text.setText(Predictions.results[13][day]);
				        break;
			        case R.id.s15:
				        text.setText(Predictions.results[14][day]);
				        break;
			        case R.id.s16:
				        text.setText(Predictions.results[15][day]);
				        break;
			        }

					toast.show();
				}
				catch (Exception e) {
					Toast.makeText(digitdiction.this,"Exception:" +e, 500000);
				}
			}  	
		};
		

        try {
        TextView[] tv;
        tv = new TextView[17];
        Typeface face = Typeface.createFromAsset(getAssets(),"font/zawgyi.ttf");
        text.setTypeface(face); 
        toast.cancel();
        
        for (int i=1; i<17; i++)
        {   
            int id = R.id.class.getField("s"+i).getInt(0); 
        	tv[i] = (TextView)findViewById(id);
        	tv[i].setTypeface(face);
        	tv[i].setClickable(true);
        	tv[i].setOnClickListener(clickListener);
        }
        
        } 
        catch (NullPointerException npe) {
			System.out.println(npe);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    
	
    @Override
	public void onStop(){
		super.onStop();
		toast.cancel();
	}

	@Override
	public void onClick(View v) {

	}
}
