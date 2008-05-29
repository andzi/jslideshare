/*
 *  Copyright 2008 The JSlideShare Team
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
 */
package com.benfante.jslideshare;

/**
 *
 * Factory for creating a SlideShareAPI implementation.
 *
 * @author Lucio Benfante (<a href="mailto:lucio@benfante.com">lucio@benfante.com</a>)
 */
public class SlideShareAPIFactory {

    private SlideShareAPIFactory() {
    }

    public static SlideShareAPI getSlideShareAPI(String api_key,
            String shared_secret) {
        SlideShareConnector connector = new SlideShareConnectorImpl(api_key,
                shared_secret, 10000);
        return new SlideShareAPIImpl(connector);
    }

    public static SlideShareAPI getSlideShareAPI(String api_key,
            String shared_secret, int timeout) {
        SlideShareConnector connector = new SlideShareConnectorImpl(api_key,
                shared_secret, timeout);
        return new SlideShareAPIImpl(connector);
    }
}
