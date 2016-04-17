package com.callittips.snishimura.retrofitsample.data.rss;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Created by snishimura on 16/04/17.
 */
@Root(strict = false)
public class Item {
    private static final String TAG = Item.class.getSimpleName();

    @Attribute(name = "about", required = false)
    @Namespace(reference = "http://www.w3.org/1999/02/22-rdf-syntax-ns#")
    private String mAbout;

    @Element(name = "title")
    private String mTitle;

    @Element(name = "link")
    private String mLink;

    @Element(name = "description", required = false)
    private String mDescription;

    @Element(name = "date")
    @Namespace(reference = "http://purl.org/dc/elements/1.1/")
    private String mDate;

    @Element(name = "subject")
    @Namespace(reference = "http://purl.org/dc/elements/1.1/")
    private String mSubject;

    @Element(name = "bookmarkcount")
    @Namespace(reference = "http://www.hatena.ne.jp/info/xmlns#")
    private int mBookmarkCount;

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
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = mDescription;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        this.mDate = mDate;
    }

    public String getSubject() {
        return mSubject;
    }

    public void setSubject(String subject) {
        this.mSubject = mSubject;
    }

    public int getBookmarkCount() {
        return mBookmarkCount;
    }

    public void setBookmarkCount(int bookmarkCount) {
        this.mBookmarkCount = mBookmarkCount;
    }

    public String getAbout() {
        return mAbout;
    }

    public void setAbout(String about) {
        this.mAbout = mAbout;
    }
}
