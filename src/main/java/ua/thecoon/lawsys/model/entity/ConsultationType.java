package ua.thecoon.lawsys.model.entity;

public enum ConsultationType {
    CIVIL_LAW("Civil Law"),
    CRIMINAL_LAW("Criminal Law"),
    LABOR_LAW("Labor Law"),
    FAMILY_LAW("Family Law"),
    REAL_ESTATE_AND_PROPERTY_LAW("Real Estate and Property Law"),
    CORPORATE_LAW("Corporate Law"),
    TAX_LAW("Tax Law"),
    ADMINISTRATIVE_LAW("Administrative Law"),
    INTELLECTUAL_PROPERTY_LAW("Intellectual Property Law"),
    BANKRUPTCY_AND_FINANCIAL_LAW("Bankruptcy and Financial Law");

    private final String displayName;

    ConsultationType(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
