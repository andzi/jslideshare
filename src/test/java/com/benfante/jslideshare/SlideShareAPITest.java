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
import com.benfante.jslideshare.messages.SlideshowInfo;
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
        assertEquals(2, result.getTagArray().length);
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

    public void testGetSlideshowInfo() throws Exception {
        SlideShareAPI instance = new SlideShareAPIImpl(
                new MockSlideShareConnector(
                "xml/messages/get_slideshow_info.xml"));
        SlideshowInfo result = instance.getSlideshowInfo(null, "what you want");
        assertEquals("142806", result.getId());
        assertEquals(2, result.getStatus());
        assertEquals("Using DAOs without implementing them", result.getTitle());
        assertEquals(
                "With Parancoe (www.parancoe.org) You can define and use your DAOs without implementing them. This speeds up the development of your application and the satisfaction of the developers. This presentation was held at the JavaDay in Torino, the October 20, 2007.",
                result.getDescription());
        assertEquals("dao,parancoe,dao,hibernate,jpa", result.getTags());
        assertEquals(5, result.getTagArray().length);
        assertEquals(
                "<div style=\"width:425px;text-align:left\" id=\"__ss_142806\"><object style=\"margin:0px\" width=\"425\" height=\"355\"><param name=\"movie\" value=\"http://static.slideshare.net/swf/ssplayer2.swf?doc=using-daos-without-implementing-them-1193116570658927-4\"/><param name=\"allowFullScreen\" value=\"true\"/><param name=\"allowScriptAccess\" value=\"always\"/><embed src=\"http://static.slideshare.net/swf/ssplayer2.swf?doc=using-daos-without-implementing-them-1193116570658927-4\" type=\"application/x-shockwave-flash\" allowscriptaccess=\"always\" allowfullscreen=\"true\" width=\"425\" height=\"355\"></embed></object><div style=\"font-size:11px;font-family:tahoma,arial;height:26px;padding-top:2px;\"><a href=\"http://www.slideshare.net/?src=apiembed\"><img src=\"http://static.slideshare.net/swf/logo_embd.png\" style=\"border:0px none;margin-bottom:-5px\" alt=\"SlideShare\"/></a> | <a href=\"http://www.slideshare.net/benfante/using-daos-without-implementing-them?src=apiembed\" title=\"View Using DAOs without implementing them on SlideShare\">View</a> | <a href=\"http://www.slideshare.net/upload?src=apiembed\">Upload your own</a></div></div>",
                result.getEmbedCode());
        assertEquals("using-daos-without-implementing-them-1193116570658927-4",
                result.getPlayerDoc());
        assertEquals(29, result.getTotalSlides());
        assertEquals("using-daos-without-implementing-them", result.getUrlDoc());
        assertEquals("en", result.getLanguage());
        assertEquals(
                "http://www.slideshare.net/benfante/using-daos-without-implementing-them",
                result.getUrl());
        assertEquals("198837", result.getUserId());
        assertEquals("benfante", result.getUserLogin());
        assertEquals("96741,38699,193375,134318,44689,69765,31664,68855,69943,",
                result.getRelatedSlideshows());
        assertEquals(9, result.getRelatedSlideshowsArray().length);
        assertEquals(
                "http://cdn.slideshare.net/using-daos-without-implementing-them-1193116570658927-4-thumbnail?1193116571",
                result.getThumbnailUrl());
        assertEquals(
                "http://cdn.slideshare.net/using-daos-without-implementing-them-1193116570658927-4-thumbnail-2",
                result.getThumbnailSmallUrl());
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
