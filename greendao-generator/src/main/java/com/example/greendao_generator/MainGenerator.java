package com.example.greendao_generator;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class MainGenerator {

    public static void main(String[] args) throws Exception {

        Schema schema = new Schema(1, "com.example.db");
        Entity wordEntity = schema.addEntity("ITEMS");
        wordEntity.addIdProperty();
        wordEntity.addStringProperty("name").notNull();

        new DaoGenerator().generateAll(schema, "./app/src/main/java");
    }
}
