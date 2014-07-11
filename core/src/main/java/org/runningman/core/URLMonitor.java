package org.runningman.core;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;

public class URLMonitor extends AbstractMonitor {
	
	private String url;
	private Thread monitorThread;
	private static HttpClient httpClient;
	private String response;
	
	public URLMonitor(String id, String note, String url) {
		super(id, note);
		this.url = url;
		if (URLMonitor.httpClient == null) {
			URLMonitor.httpClient = new HttpClient(new MultiThreadedHttpConnectionManager());
			httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(30000);
		}
	}
	
	public String getUrl() {
		return this.url;
	}
	
	public void setUrl(String url) {
		if (url != null) {
			this.url = url;
		}
	}
	
	public String status() {
		return this.response;
	}
	
	protected void monitor() {
		new Thread() {
			public void run() {
				GetMethod get = new GetMethod(url);
				get.setFollowRedirects(true);
				try {
					response = get.getResponseBodyAsString();
				} catch (Exception ex) {
					ex.printStackTrace();
				} finally {
					get.releaseConnection();
				}
			}
		}.start();
	}

	public void run() {
		try {
			while (true) {
				monitor();
				System.out.println(response);
				Thread.sleep(frequency);
			}
		} catch (InterruptedException ie) {
			
		}
	}
	
	public void start() {
		if (monitorThread == null) {
			this.monitorThread = new Thread(this, Constant.THREAD_PREFIX + "-" + id);
			monitorThread.start();
		}
	}
	
	public void stop() {
		// TODO Auto-generated method stub
		
	}
	
}
