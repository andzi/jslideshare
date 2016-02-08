<table><tr><td>JSlidesShare is a Java wrapper around the <a href='http://www.slideshare.net/developers'>SlideShare API</a>. It can be used for mashing up slides in your own Java Web application.<br>
<br>
<h2>An example</h2>

Using JSlideShare is very easy. For example, if you need to get the code for embedding a specific presentation starting from its SlideShare id:<br>
<br>
<pre><code>SlideShareAPI ssapi = SlideShareAPIFactory.getSlideShareAPI(
    API_KEY, // Your API key
    SHARED_SECRET  // Your shared secret
);
Slideshow slideshow = ssapi.getSlideshow("142806");
String embedCode = slideshow.getEmbedCode();
</code></pre>

<h2>Current features</h2>

At present you can:<br>
<br>
<ul><li>Retrieve a slideshow by its id or url<br>
</li><li>Retrieve the slideshows of an user<br>
</li><li>Retrieve the slideshows with a specific tag<br>
</li><li>Retrieve the slideshows from a group<br>
</li><li>Upload of a new presentation</li></ul>

<h2>Usage</h2>

Simply <a href='https://sourceforge.net/projects/jslideshare/files/'>download</a> and uncompress one of the binary distribution files (tar.gz or zip). Then add to the classpath of your application the <code>JSlideshare-*.jar</code> and all the (few) dependecies JARs you'll find in the  <code>lib</code> directory.<br>
<br>
NB: Google Code discontinued the download feature, so now the downloads are from the SourceForge site: <a href='https://sourceforge.net/projects/jslideshare/files/'>https://sourceforge.net/projects/jslideshare/files/</a>

If you are using Maven in your project, you can add to your pom.xml the following repository:<br>
<br>
<pre><code>&lt;repository&gt;
    &lt;id&gt;parancoe-org-repository&lt;/id&gt;
    &lt;name&gt;Parancoe Repository for Maven&lt;/name&gt;
    &lt;url&gt;http://maven2.parancoe.org/repo&lt;/url&gt;
    &lt;layout&gt;default&lt;/layout&gt;
&lt;/repository&gt;
</code></pre>

and dependency:<br>
<br>
<pre><code>&lt;dependency&gt;
    &lt;groupId&gt;com.benfante&lt;/groupId&gt;
    &lt;artifactId&gt;JSlideShare&lt;/artifactId&gt;
    &lt;version&gt;0.7&lt;/version&gt;
    &lt;scope&gt;compile&lt;/scope&gt;
&lt;/dependency&gt;
</code></pre>
</td><td valign='top'>
<wiki:gadget url="http://www.ohloh.net/p/69571/widgets/project_users.xml" height="100" border="0"/><br>
<wiki:gadget url="http://www.ohloh.net/p/69571/widgets/project_partner_badge.xml" height="53" border="0"/><br>
</td></tr></table>