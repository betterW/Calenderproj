package com.ecology.calenderproj.ui;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.Window;
import android.widget.AbsListView.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ecology.calenderproj.R;
import com.ecology.calenderproj.base.BorderTextView;
import com.ecology.calenderproj.bean.ScheduleDAO;
import com.ecology.calenderproj.constants.CalendarConstant;
import com.ecology.calenderproj.vo.ScheduleVO;

public class ScheduleInfoDetailActivity extends Activity {


	private TextView scheduledetailsTextView;
	private BorderTextView scheduledetailsType,scheduledetailsDate;
	
	
	private ScheduleDAO dao = null;
	private ArrayList<String> scheduleDate;
	private String[] scheduleIDs;
	private ScheduleVO scheduleVO;
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.scan_schedule_details);
		
		dao = new ScheduleDAO(this);
		
		
		initView();
		
		Intent intent = getIntent();
		//scheduleID = Integer.parseInt(intent.getStringExtra("scheduleID"));
		//一个日期可能对应多个标记日程(scheduleID)
		scheduleDate=intent.getStringArrayListExtra("scheduleDate");
		
		Log.i("scheduinfodetails", "获得日程详细日期="+scheduleDate);
		scheduledetailsDate.setText(""+scheduleDate);
		scheduleVO=(ScheduleVO) intent.getExtras().getSerializable("scheduleVO");
				
	}
	
	private void initView() {
		scheduledetailsTextView=(TextView)this.findViewById(R.id.scheduledetailsTextView);
		scheduledetailsType=(BorderTextView)this.findViewById(R.id.scheduledetailsType);
		scheduledetailsDate=(BorderTextView)this.findViewById(R.id.scheduledetailsDate);
	}

	/**
	 * 显示日程所有信息
	 */
	public void handlerInfo(ScheduleVO scheduleVO){		
		scheduledetailsDate.setText(scheduleVO.getScheduleDate());					
		
	}
}
