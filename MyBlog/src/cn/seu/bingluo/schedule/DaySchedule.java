package cn.seu.bingluo.schedule;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class DaySchedule {
	private long DAY_MILLISECONDS = 86400000;

	private Timer timer = new Timer();
	private List<TimerTask> tasks = new ArrayList<TimerTask>();

	public void addTask(TimerTask task) {
		tasks.add(task);
	}

	public void addTaskAndExcute(TimerTask task) {
		tasks.add(task);
		timer.schedule(task, 0, DAY_MILLISECONDS);
	}

	public void startSchedule() {
		for (TimerTask task : tasks) {
			timer.schedule(task, 0, DAY_MILLISECONDS);
		}
	}
}
