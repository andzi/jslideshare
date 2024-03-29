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

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * A mock SlideShareConnector that simply return as result a static xml resource.
 *
 * @author Lucio Benfante (<a href="mailto:lucio@benfante.com">lucio@benfante.com</a>)
 */
class MockSlideShareConnector implements SlideShareConnector {
    protected String resource;

    public MockSlideShareConnector(String resource) {
        this.resource = resource;
    }

    public InputStream sendMessage(String url,
            Map<String, String> parameters) throws IOException {
        return this.getClass().getClassLoader().getResourceAsStream(resource);
    }

    public InputStream sendGetMessage(String url,
            Map<String, String> parameters) throws IOException {
        return this.getClass().getClassLoader().getResourceAsStream(resource);
    }
    
    public InputStream sendMultiPartMessage(String url,
            Map<String, String> parameters,
            Map<String, File> files) throws IOException,
            SlideShareErrorException {
        return this.getClass().getClassLoader().getResourceAsStream(resource);
    }

}
