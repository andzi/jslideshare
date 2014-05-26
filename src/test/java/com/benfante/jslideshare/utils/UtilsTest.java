/*
 *  Copyright 2008 JSlideShare Team.
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

package com.benfante.jslideshare.utils;

import java.util.Arrays;
import junit.framework.TestCase;

/**
 * Tests of the Util methods.
 * 
 * @author Lucio Benfante (<a href="mailto:lucio@benfante.com">lucio@benfante.com</a>)
 */
public class UtilsTest extends TestCase {
    
    public UtilsTest(String testName) {
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
     * Test of splitCsvLine method, of class Utils.
     */
    public void testSplitCsvLineSimple() {
        String csvLine = "a,b,c,d,e";
        String[] expResult = new String[] {"a","b","c","d","e"};
        String[] result = Utils.splitCsvLine(csvLine);
        assertTrue("Expected <"+Arrays.toString(expResult)+"> but was <"+Arrays.toString(result)+">", Arrays.equals(expResult, result));
    }

    /**
     * Test of splitCsvLine method, of class Utils.
     */
    public void testSplitCsvLineEndingWithComma() {
        String csvLine = "a,b,c,d,e,";
        String[] expResult = new String[] {"a","b","c","d","e"};
        String[] result = Utils.splitCsvLine(csvLine);
        assertTrue("Expected <"+Arrays.toString(expResult)+"> but was <"+Arrays.toString(result)+">", Arrays.equals(expResult, result));
    }

    /**
     * Test of splitCsvLine method, of class Utils.
     */
    public void testSplitCsvLineWithComposedWords() {
        String csvLine = "a,b,\"c c\",d,e";
        String[] expResult = new String[] {"a","b","\"c c\"","d","e"};
        String[] result = Utils.splitCsvLine(csvLine);
        assertTrue("Expected <"+Arrays.toString(expResult)+"> but was <"+Arrays.toString(result)+">", Arrays.equals(expResult, result));
    }

    /**
     * Test of splitCsvLine method, of class Utils.
     */
    public void testSplitCsvLineWithCommasInside() {
        String csvLine = "a,b,\"c,c\",d,e";
        String[] expResult = new String[] {"a","b","\"c,c\"","d","e"};
        String[] result = Utils.splitCsvLine(csvLine);
        assertTrue("Expected <"+Arrays.toString(expResult)+"> but was <"+Arrays.toString(result)+">", Arrays.equals(expResult, result));
    }
    
}
