package org.runningman.manager;

import java.util.concurrent.ConcurrentHashMap;
import org.runningman.core.AbstractMonitor;
import org.runningman.core.URLMonitor;

/**
 * @author Hechen Gao
 * @contact gao.h@husky.neu.edu
 * @date Jul 11, 2014
 */
public class MonitorManager {
    
    private ConcurrentHashMap<String, AbstractMonitor> monitors;
    
    public MonitorManager() {
        this.monitors = new ConcurrentHashMap<>();
    }
    
    public AbstractMonitor addMonitor(String id, String note, String target) {
        AbstractMonitor monitor = new URLMonitor(id, note, target);
        monitors.put(id, monitor);
        return monitor;
    }
    
    public AbstractMonitor addMonitor(String id, String note, String target, String startTimeStr, String endTimeStr, String freqency) {
        AbstractMonitor monitor = addMonitor(id, note, target);
        monitor.setStartTime(startTimeStr);
        monitor.setEndTime(endTimeStr);
        monitor.setFrequency(freqency);
        return monitor;
    }
    
    public AbstractMonitor getMonitor(String id) {
        return monitors.get(id);
    }
    
    /**
     * Remove the monitor identified by the key
     * 
     * @param id 
     */
    public void removeMonitor(String id) {
        monitors.remove(id);
    }
    
}
