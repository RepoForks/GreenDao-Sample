package com.example.shivam.greendao_tutorial;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.db.DaoMaster;
import com.example.db.DaoSession;
import com.example.db.ITEMS;
import com.example.db.ITEMSDao;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etName;
    Button btnSave;

    private ITEMSDao mItemsDao;
    final String DB_NAME = "items-db";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mItemsDao = getItemsDaoInstance();

        etName = (EditText) findViewById(R.id.et_item_name);
        btnSave = (Button) findViewById(R.id.btn_save);
        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_save:
                if (etName.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Cannot be empty", Toast.LENGTH_SHORT).show();
                } else {
                    saveInDatabase(etName.getText().toString());
                }
        }
    }

    private void saveInDatabase(String itemName) {
        ITEMS item = new ITEMS(null, itemName);
        mItemsDao.insert(item);
    }

    private ITEMSDao getItemsDaoInstance() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, DB_NAME, null);
        SQLiteDatabase database = devOpenHelper.getWritableDatabase();
        DaoMaster master = new DaoMaster(database);
        DaoSession session = master.newSession();
        return session.getITEMSDao();
    }
}
