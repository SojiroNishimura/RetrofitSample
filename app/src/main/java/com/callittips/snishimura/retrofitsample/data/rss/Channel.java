package com.callittips.snishimura.retrofitsample.data.rss;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Created by snishimura on 16/04/17.
 */
@Root(strict = false)
public class Channel {
    private static final String TAG = Channel.class.getSimpleName();

    @Attribute(name = "about", required = false)
    @Namespace(reference = "http://www.w3.org/1999/02/22-rdf-syntax-ns#")
    private String mAbout;

    @Element(name = "title")
    private String mTitle;

    @Element(name = "link")
    private String mLink;

    @Element(name = "description")
    private String mChannelDescription;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = mTitle;
    }

    public String getLink() {
        return mLink;
    }

    public void setLink(String link) {
        this.mLink = mLink;
    }

    public String getDescription() {
        return mChannelDescription;
    }

    public void setDescription(String description) {
        this.mChannelDescription = mChannelDescription;
    }

    public String getAbout() {
        return mAbout;
    }

    public void setAbout(String about) {
        this.mAbout = mAbout;
    }
}
