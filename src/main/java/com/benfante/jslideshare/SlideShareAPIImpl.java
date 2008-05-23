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
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;

/**
 * Base implementation of the <a href="http://www.slideshare.net/developers/documentation">SlideShare API</a>.
 *
 * @author Lucio Benfante (<a href="mailto:lucio@benfante.com">lucio@benfante.com</a>)
 */
public class SlideShareAPIImpl implements SlideShareAPI {

    private static final Logger logger = Logger.getLogger(
            SlideShareAPIImpl.class);
    public static final String URL_GET_SLIDESHOW =
            "http://www.slideshare.net/api/1/get_slideshow";
    public static final String URL_GET_SLIDESHOW_BY_USER =
            "http://www.slideshare.net/api/1/get_slideshow_by_user";
    public static final String URL_GET_SLIDESHOW_BY_TAG =
            "http://www.slideshare.net/api/1/get_slideshow_by_tag";
    public static final String URL_GET_SLIDESHOW_BY_GROUP =
            "http://www.slideshare.net/api/1/get_slideshow_from_group";
    protected SlideShareConnector connector;

    public SlideShareAPIImpl() {
    }

    public SlideShareAPIImpl(SlideShareConnector connector) {
        this.connector = connector;
    }

    public SlideShareConnector getConnector() {
        return connector;
    }

    public void setConnector(SlideShareConnector connector) {
        this.connector = connector;
    }

    public Slideshow getSlideshow(String id) throws SlideShareException,
            SlideShareErrorException {
        logger.info("Called getSlideshow with id=" + id);
        Slideshow result = null;
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("slideshow_id", id);
        try {
            InputStream response = connector.sendMessage(URL_GET_SLIDESHOW,
                    parameters);
            result = DocumentParser.parse(response).getSlideShow();
        } catch (IOException iOException) {
            throw new SlideShareErrorException(-1, "Error getting the slideshow",
                    iOException);
        }
        return result;
    }

    public User getSlideshowByUser(String username) throws SlideShareException,
            SlideShareErrorException {
        logger.info("Called getSlideshowByUser with username=" + username);
        return getSlideshowByUser(username, -1, -1);
    }

    public User getSlideshowByUser(String username, int offset, int limit)
            throws SlideShareException, SlideShareErrorException {
        logger.info("Called getSlideshowByUser with username=" + username +
                ", offset=" + offset + ", limit=" + limit);
        User result = null;
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("username_for", username);
        if (offset >= 0) {
            parameters.put("offset", Integer.toString(offset));
        }
        if (limit >= 0) {
            parameters.put("limit", Integer.toString(limit));
        }
        try {
            InputStream response = connector.sendMessage(
                    URL_GET_SLIDESHOW_BY_USER, parameters);
            result = DocumentParser.parse(response).getUser();
        } catch (IOException iOException) {
            throw new SlideShareErrorException(-1,
                    "Error getting the slideshow by user",
                    iOException);
        }
        return result;
    }

    public Tag getSlideshowByTag(String tag) throws SlideShareException,
            SlideShareErrorException {
        logger.info("Called getSlideshowByTag with tag=" + tag);
        return getSlideshowByTag(tag, -1, -1);
    }

    public Tag getSlideshowByTag(String tag, int offset, int limit) throws
            SlideShareException, SlideShareErrorException {
        logger.info("Called getSlideshowByTag with tag=" + tag +
                ", offset=" + offset + ", limit=" + limit);
        Tag result = null;
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("tag", tag);
        if (offset >= 0) {
            parameters.put("offset", Integer.toString(offset));
        }
        if (limit >= 0) {
            parameters.put("limit", Integer.toString(limit));
        }
        try {
            InputStream response = connector.sendMessage(
                    URL_GET_SLIDESHOW_BY_TAG, parameters);
            result = DocumentParser.parse(response).getTag();
        } catch (IOException iOException) {
            throw new SlideShareErrorException(-1,
                    "Error getting the slideshow by tag",
                    iOException);
        }
        return result;
    }

    public Group getSlideshowByGroup(String groupName) throws SlideShareException,
            SlideShareErrorException {
        logger.info("Called getSlideshowByGroup with groupName=" + groupName);
        return getSlideshowByGroup(groupName, -1, -1);
    }

    public Group getSlideshowByGroup(String groupName, int offset, int limit)
            throws SlideShareException, SlideShareErrorException {
        logger.info("Called getSlideshowByGrop with groupName=" + groupName +
                ", offset=" + offset + ", limit=" + limit);
        Group result = null;
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("group_name", groupName);
        if (offset >= 0) {
            parameters.put("offset", Integer.toString(offset));
        }
        if (limit >= 0) {
            parameters.put("limit", Integer.toString(limit));
        }
        try {
            InputStream response = connector.sendMessage(
                    URL_GET_SLIDESHOW_BY_GROUP, parameters);
            result = DocumentParser.parse(response).getGroup();
        } catch (IOException iOException) {
            throw new SlideShareErrorException(-1,
                    "Error getting the slideshow by group",
                    iOException);
        }
        return result;
    }

}
