package com.callittips.snishimura.retrofitsample;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.callittips.snishimura.retrofitsample.data.Bookmark;
import com.callittips.snishimura.retrofitsample.data.BookmarkContainer;
import com.callittips.snishimura.retrofitsample.data.rss.Item;
import com.callittips.snishimura.retrofitsample.data.rss.Rdf;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class MainActivity extends AppCompatActivity {
    private HatenaApiInterface mApiInterface;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.listView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HatenaApiInterface.END_POINT)
//                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        mApiInterface = retrofit.create(HatenaApiInterface.class);
        execGetHotentriesWithCategory(HatenaApiInterface.CATEGORY_IT);
    }

    private static class BookmarkItemAdapter extends ArrayAdapter<Item> {
        public BookmarkItemAdapter(Context context, int resource, List<Item> objects) {
            super(context, resource, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.list_item, null);
            }

            Item item = this.getItem(position);

            TextView title = (TextView) convertView.findViewById(R.id.title);
            title.setText(item.getTitle());

            TextView count = (TextView) convertView.findViewById(R.id.count);
            count.setText(Integer.toString(item.getBookmarkCount()));

            return convertView;
        }
    }

    private void execGetHotentriesWithCategory(String category) {
        Log.d("AAA", "execGetHotentriesWithCategory : category = " + category);
        Call<Rdf> call = mApiInterface.getHotentriesWithCategory(HatenaApiInterface.CATEGORY_IT);

        call.enqueue(new Callback<Rdf>() {
            @Override
            public void onResponse(Call<Rdf> call, Response<Rdf> response) {
                Log.d("AAA", "Successed to request");

                Rdf rdf = response.body();
                List<Item> items = rdf.getItemList();

                BookmarkItemAdapter adapter = new BookmarkItemAdapter(MainActivity.this, R.layout.list_item, items);
                mListView.setAdapter(adapter);
                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Item item = (Item) parent.getItemAtPosition(position);

                        // リストをクリックするとブラウザへ遷移させる
                        Uri uri = Uri.parse(item.getLink());
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onFailure(Call<Rdf> call, Throwable t) {
                Log.d("AAA", "Failed to request : " + t.getCause() + ", " + t.getMessage());
                t.printStackTrace();
            }
        });
    }

    private void execGetBookmarksWithUrl(String targetUrl) {
        Log.d("AAA", "execgetBookmarksWithUrl : targetUrl = " + targetUrl);

        Call<BookmarkContainer> call = mApiInterface.getBookmarksWithUrl(targetUrl);
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
                Log.d("AAA", "Failed to request : " + t.getCause() + ", " + t.getMessage());
                t.printStackTrace();
            }
        });
    }
}
