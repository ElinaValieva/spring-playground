package com.elina.demo.model;

import com.elina.demo.configs.Tables;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = Tables.TABLE_NAME, schema = Tables.SCHEMA)
public class Model {
    /**
     * model description
     */
}
