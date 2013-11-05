package cn.seu.bingluo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.seu.bingluo.core.SystemContainer;
import cn.seu.bingluo.schedule.DaySchedule;
import cn.seu.bingluo.schedule.RefreshTagsCloudTimerTask;

public class InitSystemListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"/config.xml");
		SystemContainer.setApplicationContext(applicationContext);

		// 执行日常任务
		DaySchedule daySchedule = new DaySchedule();
		daySchedule.addTaskAndExcute(new RefreshTagsCloudTimerTask());
	}
}
