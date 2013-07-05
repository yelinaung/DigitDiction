package net.mgpyone.digitdiction;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

@SuppressLint("HandlerLeak")
public class Splash extends Activity {

	//time in milliseconds
	private static final long SPLASH_TIME = 3000;

	@SuppressWarnings("unused")
	private ImageView splash;

	//Thread for splash screen
	Thread splashTread = new Thread() {
		@Override
		public void run() {
			try {
				Thread.sleep(SPLASH_TIME);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				Intent main = new Intent(getApplicationContext(), DigitDiction.class);
				startActivity(main);
				finish();
			}
		}
	};

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.splash);
		splash = (ImageView) findViewById(R.id.splashimg);

		splashTread.start();
	}
}