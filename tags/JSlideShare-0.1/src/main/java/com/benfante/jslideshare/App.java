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

/**
 * Only for naively trying the API on "the real".
 *
 *
 */
public class App {

    private static final String API_KEY = "your api-key here";
    private static final String SHARED_SECRET = "your shared-secret here";

    public static void main(String[] args) throws Exception {
        SlideShareConnector connector = new SlideShareConnectorImpl(API_KEY,
                SHARED_SECRET, 10000);
        SlideShareAPI ssapi = new SlideShareAPIImpl(connector);
        System.out.println(ssapi.getSlideshow("414888"));
        Thread.sleep(2000);
        System.out.println(ssapi.getSlideshowByUser("john.leach"));
        Thread.sleep(2000);
        System.out.println(ssapi.getSlideshowByUser("john.leach", 1, 1));
        Thread.sleep(2000);
        System.out.println(ssapi.getSlideshowByTag("padova"));
        Thread.sleep(2000);
        System.out.println(ssapi.getSlideshowByTag("padova", 1, 2));
        Thread.sleep(2000);
        System.out.println(ssapi.getSlideshowByGroup("javaday-italy"));
        Thread.sleep(2000);
        System.out.println(ssapi.getSlideshowByGroup("javaday-italy", 1, 2));
    }
}
