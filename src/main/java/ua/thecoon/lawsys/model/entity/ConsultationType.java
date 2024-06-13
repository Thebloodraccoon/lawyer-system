package ua.thecoon.lawsys.model.entity;

import lombok.Getter;

public enum ConsultationType {
    CIVIL_LAW("Civil Law", 100.0),
    CRIMINAL_LAW("Criminal Law", 150.0),
    LABOR_LAW("Labor Law", 120.0),
    FAMILY_LAW("Family Law", 130.0),
    REAL_ESTATE_AND_PROPERTY_LAW("Real Estate and Property Law", 140.0),
    CORPORATE_LAW("Corporate Law", 200.0),
    TAX_LAW("Tax Law", 180.0),
    ADMINISTRATIVE_LAW("Administrative Law", 110.0),
    INTELLECTUAL_PROPERTY_LAW("Intellectual Property Law", 170.0),
    BANKRUPTCY_AND_FINANCIAL_LAW("Bankruptcy and Financial Law", 160.0);

    private final String displayName;
    @Getter
    private final double cost;

    ConsultationType(String displayName, double cost) {
        this.displayName = displayName;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
