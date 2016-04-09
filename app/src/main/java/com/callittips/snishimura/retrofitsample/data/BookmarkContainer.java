package com.callittips.snishimura.retrofitsample.data;


import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class BookmarkContainer {
    private static final String TAG = BookmarkContainer.class.getSimpleName();

    @Expose
    private List<Bookmark> bookmarks = new ArrayList<Bookmark>();
    @Expose
    private Integer count;
    @Expose
    private Integer eid;
    @Expose
    private String entryUrl;
    @Expose
    private String screenshot;
    @Expose
    private String title;
    @Expose
    private String url;

    /**
     *
     * @return
     * The bookmarks
     */
    public List<Bookmark> getBookmarks() {
        return bookmarks;
    }

    /**
     *
     * @param bookmarks
     * The bookmarks
     */
    public void setBookmarks(List<Bookmark> bookmarks) {
        this.bookmarks = bookmarks;
    }

    /**
     *
     * @return
     * The count
     */
    public Integer getCount() {
        return count;
    }

    /**
     *
     * @param count
     * The count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     *
     * @return
     * The eid
     */
    public Integer getEid() {
        return eid;
    }

    /**
     *
     * @param eid
     * The eid
     */
    public void setEid(Integer eid) {
        this.eid = eid;
    }

    /**
     *
     * @return
     * The entryUrl
     */
    public String getEntryUrl() {
        return entryUrl;
    }

    /**
     *
     * @param entryUrl
     * The entry_url
     */
    public void setEntryUrl(String entryUrl) {
        this.entryUrl = entryUrl;
    }

    /**
     *
     * @return
     * The screenshot
     */
    public String getScreenshot() {
        return screenshot;
    }

    /**
     *
     * @param screenshot
     * The screenshot
     */
    public void setScreenshot(String screenshot) {
        this.screenshot = screenshot;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     * The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

}