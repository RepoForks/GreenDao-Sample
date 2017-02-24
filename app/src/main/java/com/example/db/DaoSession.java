package com.example.db;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import com.example.db.ITEMS;

import com.example.db.ITEMSDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig iTEMSDaoConfig;

    private final ITEMSDao iTEMSDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        iTEMSDaoConfig = daoConfigMap.get(ITEMSDao.class).clone();
        iTEMSDaoConfig.initIdentityScope(type);

        iTEMSDao = new ITEMSDao(iTEMSDaoConfig, this);

        registerDao(ITEMS.class, iTEMSDao);
    }
    
    public void clear() {
        iTEMSDaoConfig.getIdentityScope().clear();
    }

    public ITEMSDao getITEMSDao() {
        return iTEMSDao;
    }

}
