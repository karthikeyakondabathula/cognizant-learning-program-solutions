package com.cognizant.ormlearn.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ComparisonChart {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ComparisonChart.class);
    
    public static void printComparison() {
        LOGGER.info("\n" + "=".repeat(80));
        LOGGER.info("FEATURE COMPARISON CHART");
        LOGGER.info("=".repeat(80));
        LOGGER.info(String.format("%-25s %-15s %-15s %-20s", "FEATURE", "JPA", "HIBERNATE", "SPRING DATA JPA"));
        LOGGER.info("-".repeat(80));
        LOGGER.info(String.format("%-25s %-15s %-15s %-20s", "Type", "Specification", "Implementation", "Abstraction"));
        LOGGER.info(String.format("%-25s %-15s %-15s %-20s", "Boilerplate Code", "N/A", "High", "Very Low"));
        LOGGER.info(String.format("%-25s %-15s %-15s %-20s", "Transaction Mgmt", "Manual", "Manual", "Automatic"));
        LOGGER.info(String.format("%-25s %-15s %-15s %-20s", "CRUD Operations", "N/A", "Manual", "Built-in"));
        LOGGER.info(String.format("%-25s %-15s %-15s %-20s", "Custom Queries", "N/A", "HQL/SQL", "Method Names"));
        LOGGER.info(String.format("%-25s %-15s %-15s %-20s", "Learning Curve", "N/A", "Steep", "Easy"));
        LOGGER.info(String.format("%-25s %-15s %-15s %-20s", "Development Speed", "N/A", "Slow", "Fast"));
        LOGGER.info("=".repeat(80));
    }
}
