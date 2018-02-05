package foodfacts.harbaoui.com.foodfacts.application;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import foodfacts.harbaoui.com.foodfacts.data.DaoMaster;
import foodfacts.harbaoui.com.foodfacts.data.DaoSession;

/**
 * Created by amine on 2/1/18.
 */

public class App extends Application {

    private static App instance;
    private DaoMaster.DevOpenHelper helper;
    private SQLiteDatabase db;
    private DaoMaster daoMaster;
    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this ;

        helper = new DaoMaster.DevOpenHelper(this, "foodfacts-db", null);
        db = helper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();


        Picasso.Builder builder = new Picasso.Builder(this);
        builder.downloader(new OkHttp3Downloader(this,Integer.MAX_VALUE));
        Picasso built = builder.build();
        built.setIndicatorsEnabled(true);
        built.setLoggingEnabled(true);
        Picasso.setSingletonInstance(built);

    }

    public static App getInstance() {
        return instance;
    }

    public static DaoSession getDaoSession() {
        return daoSession;
    }

}
