package org.runningman.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class URLMonitor extends AbstractMonitor {

    private String url;
    private Thread monitorThread;
    private CloseableHttpClient httpClient;
    private String msg;

    public URLMonitor(String id, String note, String url) {
        super(id, note);
        this.url = url;
        this.httpClient = HttpClients.createDefault();
    } 

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        if (url != null) {
            this.url = url;
        }
    }
    
    protected void setMsg(String msg) {
        this.msg = msg;
    }
    
    protected String getMsg() {
        return this.msg;
    }

    public String status() {
        return this.msg;
    }

    protected void monitor() throws Exception {
        new Thread() {
            @Override
            public void run() {
                try {
                    getResponse();
                } catch (IOException ioe) {
                    
                }
            }
        }.start();
    }

    public void run() {
        try {
            while (endTime.isAfterNow()) {
                try {
                    monitor();
                } catch (Exception e) {
                    // TODO throw an exception
                }
                Thread.sleep(frequency);
            }
            httpClient.close();
        } catch (InterruptedException ie) {
            // TODO throw an exception
        } catch (IOException ex) {
            // TODO throw an exception
        }
    }

    public void start() {
        if (monitorThread == null) {
            monitorThread = new Thread(this, Constant.THREAD_PREFIX + "-" + id);
            monitorThread.start();
        } else {
            // TODO throw an exception
        }
    }

    public void stop() {
        try {
            httpClient.close();
        } catch (IOException ex) {
            // TODO update the logging system to SLF4J and Logback
            Logger.getLogger(URLMonitor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void getResponse() throws IOException {
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse res = httpClient.execute(httpGet);
        try {
            HttpEntity entity = res.getEntity();
            if (entity != null) {
                Header encoding = entity.getContentEncoding();
                InputStream is = entity.getContent();
                if (encoding != null) {
                    msg = IOUtils.toString(is, encoding.getValue());
                } else {
                    msg = IOUtils.toString(is, "UTF-8");
                }
            }
        } catch (IOException ioe) {
            // TODO throw an exception
        } finally {
            res.close();
        }
    }
}
