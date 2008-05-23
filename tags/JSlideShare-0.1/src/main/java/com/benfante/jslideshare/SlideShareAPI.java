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

/**
 * Methods of the <a href="http://www.slideshare.net/developers/documentation">SlideShare API</a>.
 *
 * @author Lucio Benfante (<a href="mailto:lucio@benfante.com">lucio@benfante.com</a>)
 */
public interface SlideShareAPI {

    /**
     * Retrieve a slideshow using its id.
     * 
     * @param id The slideshow id
     * @return The slideshow
     * @throws com.benfante.jslideshare.SlideShareException In case of a SlideShareServiceError
     * @throws com.benfante.jslideshare.SlideShareErrorException In case of an error using the service (IO error, timeouts, http status other than OK, etc.)
     */
    Slideshow getSlideshow(String id) throws SlideShareException,
            SlideShareErrorException;

    /**
     * Retrieve slideshows for a given user.
     * 
     * @param username The username of the user.
     * @return The user data (name, slideshows, etc).
     * @throws com.benfante.jslideshare.SlideShareException In case of a SlideShareServiceError
     * @throws com.benfante.jslideshare.SlideShareErrorException In case of an error using the service (IO error, timeouts, http status other than OK, etc.)
     */
    User getSlideshowByUser(String username) throws SlideShareException,
            SlideShareErrorException;

    /**
     * Retrieve slideshows for a given user with limits for pagination.
     * 
     * @param username The username of the user.
     * @param offset The offset from which retrieving the slideshows. Starting from 0. A negative value means no offset.
     * @param limit How many slideshows to retrieve. A negative value means no limit.
     * @return The user data (name, slideshows, etc).
     * @throws com.benfante.jslideshare.SlideShareException In case of a SlideShareServiceError
     * @throws com.benfante.jslideshare.SlideShareErrorException In case of an error using the service (IO error, timeouts, http status other than OK, etc.)
     */
    User getSlideshowByUser(String username, int offset, int limit) throws 
            SlideShareException, SlideShareErrorException;

    /**
     * Retrieve slideshows with a given tag.
     * 
     * @param tag The tag
     * @return The tag data (name, slideshows, etc).
     * @throws com.benfante.jslideshare.SlideShareException In case of a SlideShareServiceError
     * @throws com.benfante.jslideshare.SlideShareErrorException In case of an error using the service (IO error, timeouts, http status other than OK, etc.)
     */
    Tag getSlideshowByTag(String tag) throws SlideShareException,
            SlideShareErrorException;

    /**
     * Retrieve slideshows with a given tag with limits for pagination.
     * 
     * @param tag The tag
     * @param offset The offset from which retrieving the slideshows. Starting from 0. A negative value means no offset.
     * @param limit How many slideshows to retrieve. A negative value means no limit.
     * @return The tag data (name, slideshows, etc).
     * @throws com.benfante.jslideshare.SlideShareException In case of a SlideShareServiceError
     * @throws com.benfante.jslideshare.SlideShareErrorException In case of an error using the service (IO error, timeouts, http status other than OK, etc.)
     */
    Tag getSlideshowByTag(String tag, int offset, int limit) throws 
            SlideShareException, SlideShareErrorException;

    /**
     * Retrieve slideshows from a given group.
     * 
     * @param groupName The name (id) of the group.
     * @return The group data (name, slideshows, etc).
     * @throws com.benfante.jslideshare.SlideShareException In case of a SlideShareServiceError
     * @throws com.benfante.jslideshare.SlideShareErrorException In case of an error using the service (IO error, timeouts, http status other than OK, etc.)
     */
    Group getSlideshowByGroup(String groupName) throws SlideShareException,
            SlideShareErrorException;

    /**
     * Retrieve slideshows from a given group with limits for pagination.
     * 
     * @param groupName The name (id) of the group.
     * @param offset The offset from which retrieving the slideshows. Starting from 0. A negative value means no offset.
     * @param limit How many slideshows to retrieve. A negative value means no limit.
     * @return The group data (name, slideshows, etc).
     * @throws com.benfante.jslideshare.SlideShareException In case of a SlideShareServiceError
     * @throws com.benfante.jslideshare.SlideShareErrorException In case of an error using the service (IO error, timeouts, http status other than OK, etc.)
     */
    Group getSlideshowByGroup(String groupName, int offset, int limit) throws 
            SlideShareException, SlideShareErrorException;
}
