package org.ginryan.lamelab.demo;

import java.io.File;
import java.io.IOException;

import org.ginryan.lameslab.mp3encoder.MP3Recorder;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private MP3Recorder mRecorder = new MP3Recorder(new File(
			Environment.getExternalStorageDirectory(), "test.mp3"));

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button startButton = (Button) findViewById(R.id.StartButton);
		startButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					mRecorder.start();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		Button stopButton = (Button) findViewById(R.id.StopButton);
		stopButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mRecorder.stop();
			}
		});
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		mRecorder.stop();
	}
}
