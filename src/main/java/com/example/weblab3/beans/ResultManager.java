package com.example.weblab3.beans;

import com.example.weblab3.utils.AreaChecker;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

import com.example.weblab3.dbUtils.DAOFactory;
import jakarta.transaction.Transactional;

@Named
@ApplicationScoped
public class ResultManager {
    private LinkedList<AreaCheckerBean> results = new LinkedList<>();

    public ResultManager() {
        try {
            results = new LinkedList<>(DAOFactory.getInstance().getResultDAO().getAllResults());
        } catch (SQLException ex) {
            System.err.println("Something went wrong when trying add new result to DB: " + ex);
        }
    }

    @Named(value = "resultList")
    public LinkedList<AreaCheckerBean> getResults() {
        return results;
    }

    public void setResults(LinkedList<AreaCheckerBean> results) {
        this.results = results;
    }

    @Transactional
    public void addResults(UserRequest userRequest) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd.MM.yyyy");
        String requestTime = dateFormat.format(new Date(System.currentTimeMillis()));
        long startTime = System.nanoTime();

        ArrayList<Hit> hits = new ArrayList<>();

        if (userRequest.isNeg1()) {
            hits.add(new Hit(-1, userRequest.getY(), userRequest.getR()));
        }
        if (userRequest.isNeg2()) {
            hits.add(new Hit(-2, userRequest.getY(), userRequest.getR()));
        }
        if (userRequest.isNeg3()) {
            hits.add(new Hit(-3, userRequest.getY(), userRequest.getR()));
        }
        if (userRequest.isNeg4()) {
            hits.add(new Hit(-4, userRequest.getY(), userRequest.getR()));
        }
        if (userRequest.isZero()) {
            hits.add(new Hit(0, userRequest.getY(), userRequest.getR()));
        }
        if (userRequest.isPos1()) {
            hits.add(new Hit(1, userRequest.getY(), userRequest.getR()));
        }
        if (userRequest.isPos2()) {
            hits.add(new Hit(2, userRequest.getY(), userRequest.getR()));
        }
        if (userRequest.isPos3()) {
            hits.add(new Hit(3, userRequest.getY(), userRequest.getR()));
        }
        if (userRequest.isPos4()) {
            hits.add(new Hit(4, userRequest.getY(), userRequest.getR()));
        }

        for (Hit hit : hits) {
            AreaCheckerBean currentResult = new AreaCheckerBean();

            operateHit(requestTime, startTime, currentResult, hit);
        }
    }

    @Transactional
    public void addResultFromGraph(UserRequest userRequest) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd.MM.yyyy");
        String requestTime = dateFormat.format(new Date(System.currentTimeMillis()));
        long startTime = System.currentTimeMillis();

        AreaCheckerBean currentResult = new AreaCheckerBean();

        Hit hit = new Hit(userRequest.getX(), userRequest.getY(), userRequest.getR());

        operateHit(requestTime, startTime, currentResult, hit);
    }

    private void operateHit(String requestTime, long startTime, AreaCheckerBean currentResult, Hit hit) {
        currentResult.setX( hit.getX() );
        currentResult.setY( hit.getY() );
        currentResult.setR( hit.getR() );

        currentResult.setStatus( AreaChecker.isHit(hit.getX(), hit.getY(), hit.getR()) );

        currentResult.setRequestTime( requestTime );
        currentResult.setScriptTime( System.nanoTime() - startTime );

        System.out.println(currentResult);
        try {
            DAOFactory.getInstance().getResultDAO().addNewResult( currentResult );
        } catch (SQLException ex) {
            System.err.println("Something went wrong when trying add new result to DB: " + ex);
        }

        results.addFirst( currentResult );
    }

    @Transactional
    public void clearResults() {
        results.clear();
        try {
            DAOFactory.getInstance().getResultDAO().clearResults();
        } catch (SQLException ex) {
            System.err.println("Something went wrong when trying add new result to DB: " + ex);
        }
    }

    @Transactional
    public void updateResultsWithSorting(String field, String operator, double value) {
        try {
            results = new LinkedList<>(DAOFactory.getInstance().getResultDAO().getSortedResults(field, operator, value));
        } catch (SQLException ex) {
            System.err.println("Something went wrong when trying add new result to DB: " + ex);
        }
    }
}
