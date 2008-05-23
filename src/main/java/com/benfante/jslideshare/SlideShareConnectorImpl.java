// Copyright 2008 The JSlideShare Team
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package com.benfante.jslideshare;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;

/**
 * A class for managing requests to SlideShare.
 *
 * @author Lucio Benfante (<a href="mailto:lucio@benfante.com">lucio@benfante.com</a>)
 */
public class SlideShareConnectorImpl implements SlideShareConnector {

    private static final Logger logger = Logger.getLogger(
            SlideShareConnectorImpl.class);
    protected String apiKey;
    protected String sharedSecret;
    protected int soTimeout;

    public SlideShareConnectorImpl() {
    }

    public SlideShareConnectorImpl(String apiKey, String sharedSecret) {
        this(apiKey, sharedSecret, 0);
    }

    public SlideShareConnectorImpl(String apiKey, String sharedSecret,
            int soTimeout) {
        this.apiKey = apiKey;
        this.sharedSecret = sharedSecret;
        this.soTimeout = soTimeout;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getSharedSecret() {
        return sharedSecret;
    }

    public void setSharedSecret(String sharedSecret) {
        this.sharedSecret = sharedSecret;
    }

    public int getSoTimeout() {
        return soTimeout;
    }

    public void setSoTimeout(int soTimeout) {
        this.soTimeout = soTimeout;
    }

    public InputStream sendMessage(String url, Map<String, String> parameters)
            throws IOException, SlideShareErrorException {
        HttpClient client = new HttpClient();
        client.getParams().setSoTimeout(this.soTimeout);
        PostMethod method = new PostMethod(url);
        method.addParameter("api_key", this.apiKey);
        Iterator<Map.Entry<String, String>> entryIt =
                parameters.entrySet().iterator();
        while (entryIt.hasNext()) {
            Map.Entry<String, String> entry = entryIt.next();
            method.addParameter(entry.getKey(), entry.getValue());
        }
        Date now = new Date();
        String ts = Long.toString(now.getTime() / 1000);
        String hash = DigestUtils.shaHex(this.sharedSecret + ts).toLowerCase();
        method.addParameter("ts", ts);
        method.addParameter("hash", hash);
        logger.debug("Sending POST message to " + method.getURI().getURI()+" with parameters "+Arrays.toString(method.getParameters()));
        int statusCode = client.executeMethod(method);
        if (statusCode != HttpStatus.SC_OK) {
            logger.debug("Server replied with a " + statusCode +
                    " HTTP status code (" + HttpStatus.getStatusText(statusCode) +
                    ")");
            throw new SlideShareErrorException(statusCode,
                    HttpStatus.getStatusText(statusCode));
        }
        if (logger.isDebugEnabled()) {
            logger.debug(method.getResponseBodyAsString());
        }
        return method.getResponseBodyAsStream();
    }
}
