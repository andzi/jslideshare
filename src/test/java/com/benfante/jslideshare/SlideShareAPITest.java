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

import com.benfante.jslideshare.messages.Group;
import com.benfante.jslideshare.messages.Slideshow;
import com.benfante.jslideshare.messages.Tag;
import com.benfante.jslideshare.messages.User;
import java.io.File;
import junit.framework.TestCase;

/**
 * Tests on the base implementation of the SlideShare API.
 *
 * @author Lucio Benfante (<a href="mailto:lucio@benfante.com">lucio@benfante.com</a>)
 */
public class SlideShareAPITest extends TestCase {

    public SlideShareAPITest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getSlideshow method, of class SlideShareAPI.
     */
    public void testGetSlideshow() throws Exception {
        SlideShareAPI instance = new SlideShareAPIImpl(
                new MockSlideShareConnector("xml/messages/get_slideshow.xml"));
        Slideshow result = instance.getSlideshow("what you want");
        assertEquals(2, result.getStatus());
        assertEquals("ready", result.getStatusDescription());
        assertEquals("Groovy And Grails JUG Padova", result.getTitle());
        assertEquals(
                "Presentation of Groovy and Grails made at the JUG Padova on 17 May 2008",
                result.getDescription());
        assertEquals("grails,groovy", result.getTags());
        assertEquals(
                "<object type=\"application/x-shockwave-flash\" data=\"http://s3.amazonaws.com/slideshare/ssplayer.swf?id=414888&doc=groovyandgrails-1211192948866493-8&branding=no\" width=\"425\" height=\"348\"><param name=\"movie\" value=\"http://s3.amazonaws.com/slideshare/ssplayer.swf?id=414888&doc=groovyandgrails-1211192948866493-8&branding=no\" /></object>",
                result.getEmbedCode());
        assertEquals(
                "http://cdn.slideshare.net/groovyandgrails-1211192948866493-8-thumbnail-2",
                result.getThumbnail());
        assertEquals(
                "http://www.slideshare.net/john.leach/groovy-and-grails-jug-padova",
                result.getPermalink());
        assertEquals(25, result.getViews());
    }

    /**
     * Test of getSlideshowByUser method, of class SlideShareAPI.
     */
    public void testGetSlideshowByUser() throws Exception {
        SlideShareAPI instance = new SlideShareAPIImpl(
                new MockSlideShareConnector(
                "xml/messages/get_slideshow_by_user.xml"));
        User result = instance.getSlideshowByUser("what you want");
        assertEquals("john.leach", result.getName());
        assertEquals(3, result.getCount());
        assertEquals(3, result.getSlideshows().size());
    }

    /**
     * Test of getSlideshowByTag method, of class SlideShareAPI.
     */
    public void testGetSlideshowByTag() throws Exception {
        SlideShareAPI instance = new SlideShareAPIImpl(
                new MockSlideShareConnector(
                "xml/messages/get_slideshow_by_tag.xml"));
        Tag result = instance.getSlideshowByTag("what you want");
        assertEquals("padova", result.getName());
        assertEquals(12, result.getCount());
        assertEquals(12, result.getSlideshows().size());
    }

    /**
     * Test of getSlideshowByGroup method, of class SlideShareAPI.
     */
    public void testGetSlideshowByGroup() throws Exception {
        SlideShareAPI instance = new SlideShareAPIImpl(
                new MockSlideShareConnector(
                "xml/messages/get_slideshow_by_group.xml"));
        Group result = instance.getSlideshowByGroup("what you want");
        assertEquals("javaday-italy", result.getName());
        assertEquals(14, result.getCount());
        assertEquals(14, result.getSlideshows().size());
    }

    /**
     * Test of uploadSlideshow method, of class SlideShareAPI.
     */
    public void testUploadSlideshow() throws Exception {
        SlideShareAPI instance =
                new SlideShareAPIImpl(
                new MockSlideShareConnector("xml/messages/upload_slideshow.xml"));
        String result =
                instance.uploadSlideshow("username", "password", "title",
                new File("prova.pdf"), "description", "tags", true, false, false,
                false, false);
        assertEquals("435086", result);
    }
}
