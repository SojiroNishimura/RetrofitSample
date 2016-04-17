package com.callittips.snishimura.retrofitsample.data.rss;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by snishimura on 16/04/17.
 */
@NamespaceList({
        @Namespace(reference = "http://purl.org/rss/1.0/"),
        @Namespace(reference = "http://www.w3.org/1999/02/22-rdf-syntax-ns#", prefix = "rdf"),
        @Namespace(reference = "http://purl.org/dc/elements/1.1/", prefix = "dc"),
        @Namespace(reference = "http://www.hatena.ne.jp/info/xmlns#", prefix = "hatena")
})
@Namespace(reference = "http://www.w3.org/1999/02/22-rdf-syntax-ns#")
@Root(strict = false)
public class Rdf {
    private static final String TAG = Rdf.class.getSimpleName();

    @Element(name = "channel")
    private Channel mChannel;

    @ElementList(inline = true)
    private List<Item> mItemList;

    public Channel getChannel() {
        return mChannel;
    }

    public void setChannel(Channel channel) {
        this.mChannel = mChannel;
    }

    public List<Item> getItemList() {
        return mItemList;
    }

    public void setItemList(List<Item> itemList) {
        this.mItemList = mItemList;
    }
}
