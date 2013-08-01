/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.dbcp2.cpdsadapter;

import java.util.Arrays;

import org.apache.commons.dbcp2.PStmtKey;

/**
 * A key uniquely identifying a {@link java.sql.PreparedStatement PreparedStatement}.
 */
public class PStmtKeyCPDS extends PStmtKey {
    private final Integer _autoGeneratedKeys;
    private final Integer _resultSetHoldability;
    private final int _columnIndexes[];
    private final String _columnNames[];
    
    public PStmtKeyCPDS(String sql) {
        super(sql);
        _autoGeneratedKeys = null;
        _resultSetHoldability = null;
        _columnIndexes = null;
        _columnNames = null;
    }

    public PStmtKeyCPDS(String sql, int autoGeneratedKeys) {
        super(sql);
        _autoGeneratedKeys = new Integer(autoGeneratedKeys);
        _resultSetHoldability = null;
        _columnIndexes = null;
        _columnNames = null;
    }

    public PStmtKeyCPDS(String sql, int resultSetType, int resultSetConcurrency) {
        super(sql, resultSetType, resultSetConcurrency);
        _autoGeneratedKeys = null;
        _resultSetHoldability = null;
        _columnIndexes = null;
        _columnNames = null;
    }

    public PStmtKeyCPDS(String sql, int resultSetType, int resultSetConcurrency,
            int resultSetHoldability) {
        super(sql, resultSetType, resultSetConcurrency);
        _resultSetHoldability = new Integer(resultSetHoldability);
        _autoGeneratedKeys = null;
        _columnIndexes = null;
        _columnNames = null;
    }

    public PStmtKeyCPDS(String sql, int columnIndexes[]) {
        super(sql);
        _columnIndexes = columnIndexes;
        _autoGeneratedKeys = null;
        _resultSetHoldability = null;
        _columnNames = null;
    }

    public PStmtKeyCPDS(String sql, String columnNames[]) {
        super(sql);
        _columnNames = columnNames;
        _autoGeneratedKeys = null;
        _resultSetHoldability = null;
        _columnIndexes = null;
    }

    
    public Integer getAutoGeneratedKeys() {
        return _autoGeneratedKeys;
    }

    public Integer getResultSetHoldability() {
        return _resultSetHoldability;
    }

    public int[] getColumnIndexes() {
        return _columnIndexes;
    }

    public String[] getColumnNames() {
        return _columnNames;
    }

    @Override
    public boolean equals(Object that) {
        try {
            PStmtKeyCPDS key = (PStmtKeyCPDS) that;
            return(((null == getSql() && null == key.getSql()) || getSql().equals(key.getSql())) &&
                   ((null == getCatalog() && null == key.getCatalog()) || getCatalog().equals(key.getCatalog())) &&
                   ((null == getResultSetType() && null == key.getResultSetType()) || getResultSetType().equals(key.getResultSetType())) &&
                   ((null == getResultSetConcurrency() && null == key.getResultSetConcurrency()) || getResultSetConcurrency().equals(key.getResultSetConcurrency())) &&
                   (getStmtType() == key.getStmtType()) &&
                   ((null == _autoGeneratedKeys && null == key._autoGeneratedKeys) || _autoGeneratedKeys.equals(key._autoGeneratedKeys)) &&
                   ((null == _resultSetHoldability && null == key._resultSetHoldability) || _resultSetHoldability.equals(key._resultSetHoldability)) &&
                   ((null == _columnIndexes && null == key._columnIndexes) || Arrays.equals(_columnIndexes, key._columnIndexes)) &&
                   ((null == _columnNames && null == key._columnNames) || Arrays.equals(_columnNames, key._columnNames))
                  );
        } catch (ClassCastException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append("PStmtKey: sql=");
        buf.append(getSql());
        buf.append(", catalog=");
        buf.append(getCatalog());
        buf.append(", resultSetType=");
        buf.append(getResultSetType());
        buf.append(", resultSetConcurrency=");
        buf.append(getResultSetConcurrency());
        buf.append(", statmentType=");
        buf.append(getStmtType());
        buf.append(", autoGeneratedKeys=");
        buf.append(_autoGeneratedKeys);
        buf.append(", resultSetHoldability=");
        buf.append(_resultSetHoldability);
        buf.append(", columnIndexes=");
        buf.append(Arrays.toString(_columnIndexes));
        buf.append(", columnNames=");
        buf.append(Arrays.toString(_columnNames));
        return buf.toString();
    }
}