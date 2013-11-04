/**
 * Patrick John Haskins
 * Zachary Evans
 * CS7020 - Term Project
 */
package android.otasyn.cardgames.manage.account.http;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class WebManager {

    private static WebManager instance;

    public static WebManager instance() {
        if (instance == null) {
            instance = new WebManager();
        }
        return instance;
    }

    private HttpClient httpClient;

    private WebManager() {
        httpClient = new DefaultHttpClient();
    }

    public HttpClient getHttpClient() {
        return httpClient;
    }

    public static String post(final String url, final NameValuePair... params) {
        try {
            HttpPost httpPost = new HttpPost(url);
            if (params.length > 0) {
                httpPost.setEntity(new UrlEncodedFormEntity(Arrays.asList(params), HTTP.UTF_8));
            }
            HttpResponse response = WebManager.instance().getHttpClient().execute(httpPost);
            StatusLine statusLine = response.getStatusLine();
            if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                response.getEntity().writeTo(out);
                out.close();
                return out.toString();
            } else {
                response.getEntity().getContent().close();
                throw new IOException(statusLine.getReasonPhrase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String get(final String url, final NameValuePair... params) {
        try {
            String completeUrl = url;
            if (params.length > 0) {
                completeUrl += URLEncodedUtils.format(Arrays.asList(params), HTTP.UTF_8);
            }
            HttpGet httpGet = new HttpGet(completeUrl);
            HttpResponse response = WebManager.instance().getHttpClient().execute(httpGet);
            StatusLine statusLine = response.getStatusLine();
            if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                response.getEntity().writeTo(out);
                out.close();
                return out.toString();
            } else {
                response.getEntity().getContent().close();
                throw new IOException(statusLine.getReasonPhrase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
