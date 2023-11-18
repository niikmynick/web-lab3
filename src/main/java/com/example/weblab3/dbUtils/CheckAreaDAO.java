package com.example.weblab3.dbUtils;

import com.example.weblab3.beans.AreaCheckerBean;

import java.sql.SQLException;
import java.util.Collection;

public interface CheckAreaDAO {
    void addNewResult(AreaCheckerBean result) throws SQLException;
    void updateResult(Long bus_id, AreaCheckerBean result) throws SQLException;
    AreaCheckerBean getResultById(Long result_id) throws SQLException;
    Collection<AreaCheckerBean> getAllResults() throws SQLException;
    void deleteResult(AreaCheckerBean result) throws SQLException;
    void clearResults() throws SQLException;
}