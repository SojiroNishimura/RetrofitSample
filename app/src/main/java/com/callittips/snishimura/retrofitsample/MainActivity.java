package com.callittips.snishimura.retrofitsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.callittips.snishimura.retrofitsample.data.Bookmark;
import com.callittips.snishimura.retrofitsample.data.BookmarkContainer;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.listView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HatenaApiInterface.END_POINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        HatenaApiInterface service = retrofit.create(HatenaApiInterface.class);
        Call<BookmarkContainer> call = service.getBookmarksWithUrl(HatenaApiInterface.TARGET_URL);

        call.enqueue(new Callback<BookmarkContainer>() {
            @Override
            public void onResponse(Call<BookmarkContainer> call, Response<BookmarkContainer> response) {
                Log.d("AAA", "Successed to request");
                BookmarkContainer container = response.body();
                List<Bookmark> bookmarks = container.getBookmarks();
                ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1);

                for (Bookmark b : bookmarks) {
                    if (b.getComment().length() > 0) adapter.add(b.getComment());
                }
                mListView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<BookmarkContainer> call, Throwable t) {
                Log.d("AAA", "Failed to request");
            }
        });
    }
}
