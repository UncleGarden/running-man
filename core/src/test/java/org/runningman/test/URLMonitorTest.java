package org.runningman.test;

import org.runningman.core.AbstractMonitor;
import org.runningman.core.URLMonitor;

public class URLMonitorTest {
	
	public static void main(String[] args) {
		AbstractMonitor monitor = new URLMonitor("test", "test monitor", "www.google.com");
		monitor.start();
	}
	
}
