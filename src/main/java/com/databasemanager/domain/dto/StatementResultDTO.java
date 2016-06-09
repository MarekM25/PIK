package com.databasemanager.domain.dto;

import java.util.ArrayList;

public class StatementResultDTO {
    private boolean selectQuery;
    private boolean successful;
    private String errorMessage;
    private String[] columnsNames;
    private ArrayList<String[]> rows;

    public boolean isSelectQuery() {
        return selectQuery;
    }

    public void setSelectQuery(boolean selectQuery) {
        this.selectQuery = selectQuery;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String[] getColumnsNames() {
        return columnsNames;
    }

    public void setColumnsNames(String[] columnsNames) {
        this.columnsNames = columnsNames;
    }

    public ArrayList<String[]> getRows() {
        return rows;
    }

    public void setRows(ArrayList<String[]> rows) {
        this.rows = rows;
    }
}
