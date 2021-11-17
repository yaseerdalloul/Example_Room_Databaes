package com.moktamel.room_databaes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Button insertbut, getpostbut;
    EditText etTitel, etBody;
    PostDatabase postDatabase;
    PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postDatabase = PostDatabase.getInstance(this);

        recyclerView = findViewById(R.id.RevPost);
        postAdapter = new PostAdapter();

        etTitel = findViewById(R.id.editTextTitel);
        etBody = findViewById(R.id.editTextTextBody);

        insertbut = findViewById(R.id.buInsert);
        insertbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postDatabase.postDao().insertPost(new Post(new User(1,"yaseer"), etTitel.getEditableText().toString(), etBody.getEditableText().toString()))
                        .subscribeOn(Schedulers.computation()) /*هاد في الخلفيه */
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new CompletableObserver() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {

                            }

                            @Override
                            public void onComplete() {
                                Toast.makeText(MainActivity.this, "تم الاضافه ", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {

                            }
                        });
            }
        });
        getpostbut = findViewById(R.id.butgetpost);
        getpostbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postDatabase.postDao().getPost()
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<List<Post>>() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {

                            }

                            @Override
                            public void onNext(@NonNull List<Post> posts) {

                                RecyclerAdapterPost  recyclerAdapterHomeCategoryArticle = new RecyclerAdapterPost(MainActivity.this, posts);
                                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
                                RecyclerAdapterPost adapterHome = new RecyclerAdapterPost(MainActivity.this, posts);
                                recyclerView.setAdapter(adapterHome);

                              //  recyclerView.setAdapter(postAdapter);

//                                postAdapter.setList(posts);
//                                postAdapter.notifyDataSetChanged();
                                Toast.makeText(MainActivity.this, "Done ", Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onError(@NonNull Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });

            }
        });


    }
}