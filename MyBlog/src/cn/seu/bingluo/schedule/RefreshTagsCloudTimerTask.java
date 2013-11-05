package cn.seu.bingluo.schedule;

import java.util.TimerTask;

import cn.seu.bingluo.core.SystemContainer;
import cn.seu.bingluo.service.TagService;

public class RefreshTagsCloudTimerTask extends TimerTask {

	@Override
	public void run() {
		TagService tagService = (TagService) SystemContainer
				.lookup("tagService");
		tagService.constructTagXml();
	}
}
