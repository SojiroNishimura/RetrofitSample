package com.callittips.snishimura.retrofitsample;

import com.callittips.snishimura.retrofitsample.data.BookmarkContainer;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by snishimura on 16/04/09.
 */
public interface HatenaApiInterface {
    String END_POINT = "http://b.hatena.ne.jp";
    String TARGET_URL = "http://b.hatena.ne.jp/ctop/it";

    @GET("/entry/jsonlite/")
    Call<BookmarkContainer> getBookmarksWithUrl(@Query("url") String target);
}
