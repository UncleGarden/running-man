package org.runningman.webui.service;

import java.util.ArrayList;
import java.util.List;

import org.runningman.core.AbstractMonitor;
import org.runningman.manager.MonitorManager;
import org.runningman.webui.model.MonitorData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonitorService {

	private static Logger logger = LoggerFactory.getLogger(MonitorService.class);
	
	@Autowired
	private MonitorManager mm;
	
	public MonitorData addMonitor(MonitorData data) {
		mm.addMonitor(data.getId(), data.getNote(), data.getTarget(), data.getStartTime(), data.getEndTime(), data.getFrequency());
		return data;
	}
	
	public MonitorData addMonitor(String id, String note, String target, String startTimeStr, String endTimeStr, String freqency) {
		AbstractMonitor monitor = mm.addMonitor(id, note, target, startTimeStr, endTimeStr, freqency);
		return packData(monitor);
	}
	
	public MonitorData getMonitor(String id) {
		if (id == null) {
			return null;
		}
		AbstractMonitor monitor = mm.getMonitor(id);
		if (monitor == null) {
			return null;
		}
		return packData(monitor);
	}
	
	public List<MonitorData> getAll() {
		List<AbstractMonitor> monitors = mm.getAll();
		List<MonitorData> datas = new ArrayList<MonitorData>();
		for (AbstractMonitor m : monitors) {
			datas.add(packData(m));
		}
		return datas;
	}
	
	public void removeMonitor(String id) {
		if (id == null) {
			return;
		}
		mm.removeMonitor(id);
	}
	
	private MonitorData packData(AbstractMonitor monitor) {
		MonitorData data = new MonitorData();
		data.setId(monitor.getId());
		data.setNote(monitor.getNote());
		data.setStartTime(monitor.getStartTime());
		data.setEndTime(monitor.getEndTime());
		data.setFrequency(String.valueOf(monitor.getFrequency()));
		data.setTarget(monitor.getTarget());
		data.setStatus(monitor.status());
		return data;
	}
	
}
