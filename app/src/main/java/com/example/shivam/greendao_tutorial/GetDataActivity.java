package com.example.shivam.greendao_tutorial;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.db.DaoMaster;
import com.example.db.DaoSession;
import com.example.db.ITEMS;
import com.example.db.ITEMSDao;

import java.util.List;

public class GetDataActivity extends AppCompatActivity {

    List<ITEMS> itemsList;
    ListView lvItems;

    ITEMSDao mItemDaoInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_data);

        lvItems = (ListView) findViewById(R.id.lv_items);

        mItemDaoInstance = getItemsDaoInstance();
        itemsList = mItemDaoInstance.queryBuilder().build().list();
        System.out.println(itemsList.size());
        lvItems.setAdapter(new ItemsAdapter());
    }

    public ITEMSDao getItemsDaoInstance() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "items-db", null);
        SQLiteDatabase database = devOpenHelper.getWritableDatabase();
        DaoMaster master = new DaoMaster(database);
        DaoSession session = master.newSession();
        return session.getITEMSDao();
    }

    public class ItemsAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return itemsList.size();
        }

        @Override
        public ITEMS getItem(int position) {
            return itemsList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            convertView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_2, parent, false);

            TextView tvId = (TextView) convertView.findViewById(android.R.id.text1);
            TextView tvName = (TextView) convertView.findViewById(android.R.id.text2);

            tvId.setText(String.valueOf(getItem(position).getId()));
            tvName.setText(getItem(position).getName());

            return convertView;
        }
    }
}
