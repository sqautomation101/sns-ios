package util;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Consolidate Report - Initial
 * */
public class ConsolidateInitialReports {

    public static void main(String[] args) {

        // Original JSON paths
        List<String> allJsonFiles = new ArrayList<>();

        // Account
        allJsonFiles.add("target/cucumber-json/initial/account.json");
//        allJsonFiles.add("target/cucumber-json/rerun1/rerun-account.json");
//        allJsonFiles.add("target/cucumber-json/rerun2/rerun2-account.json");

        // Login
        allJsonFiles.add("target/cucumber-json/initial/login.json");
        //allJsonFiles.add("target/cucumber-json/rerun1/rerun2-login.json");
        //allJsonFiles.add("target/cucumber-json/rerun2/rerun2-login.json");

        // SSO
        allJsonFiles.add("target/cucumber-json/initial/ssomenu.json");
//        allJsonFiles.add("target/cucumber-json/rerun1/rerun-sso.json");
//        allJsonFiles.add("target/cucumber-json/rerun2/rerun2-sso.json");

        // Homepage
        allJsonFiles.add("target/cucumber-json/initial/homepage.json");
//        allJsonFiles.add("target/cucumber-json/rerun1/rerun-homepage.json");
//        allJsonFiles.add("target/cucumber-json/rerun2/rerun2-homepage.json");

        // Guest user
        allJsonFiles.add("target/cucumber-json/initial/guestuser.json");
//        allJsonFiles.add("target/cucumber-json/rerun1/rerun-guestUser.json");
//        allJsonFiles.add("target/cucumber-json/rerun2/rerun2-guestUser.json");

        // Points history
        allJsonFiles.add("target/cucumber-json/initial/ptshistory.json");
//        allJsonFiles.add("target/cucumber-json/rerun1/rerun-ptsHistory.json");
//        allJsonFiles.add("target/cucumber-json/rerun2/rerun2-ptsHistory.json");

        // Bottom nav
        allJsonFiles.add("target/cucumber-json/initial/bottomnav.json");
//        allJsonFiles.add("target/cucumber-json/rerun1/rerun-bottomNav.json");
//        allJsonFiles.add("target/cucumber-json/rerun2/rerun2-bottomNav.json");

        // Inbox
        allJsonFiles.add("target/cucumber-json/initial/inbox.json");
//        allJsonFiles.add("target/cucumber-json/rerun1/rerun-inbox.json");
//        allJsonFiles.add("target/cucumber-json/rerun2/rerun2-inbox.json");

        // RTP
        allJsonFiles.add("target/cucumber-json/initial/rtp.json");
//        allJsonFiles.add("target/cucumber-json/rerun1/rerun-rtp.json");
//        allJsonFiles.add("target/cucumber-json/rerun2/rerun2-rtp.json");

        // Manage cards
        allJsonFiles.add("target/cucumber-json/initial/managecards.json");
//        allJsonFiles.add("target/cucumber-json/rerun1/rerun-manageCards.json");
//        allJsonFiles.add("target/cucumber-json/rerun2/rerun2-manageCards.json");

        // Offline Virtual Account
        allJsonFiles.add("target/cucumber-json/initial/offlineVirtualCard.json");
//        allJsonFiles.add("target/cucumber-json/rerun1/rerun-offlineVirtualCard.json");
//        allJsonFiles.add("target/cucumber-json/rerun2/rerun2-offlineVirtualCard.json");

        // QR and Scan
        allJsonFiles.add("target/cucumber-json/initial/qrAndScan.json");
//        allJsonFiles.add("target/cucumber-json/rerun1/rerun-qrAndScan.json");
//        allJsonFiles.add("target/cucumber-json/rerun2/rerun2-qrAndScan.json");
        
        // 1️⃣ Timestamp folder
        String timestamp = new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss").format(new Date());
        File reportOutputDirectory = new File("target/reports/consolidatedReports/" + timestamp);
        reportOutputDirectory.mkdirs();

        // 2️⃣ Filter only valid JSON files
        List<String> jsonFiles = new ArrayList<>();
        for (String path : allJsonFiles) {
            File file = new File(path);
            if (file.exists() && file.length() > 0 && path.endsWith(".json")) {
                jsonFiles.add(file.getAbsolutePath());
            } else {
                System.out.println("Skipping invalid or empty file: " + path);
            }
        }

        // 3️⃣ Generate report only if we have valid JSONs
        if (!jsonFiles.isEmpty()) {
            Configuration configuration = new Configuration(reportOutputDirectory, "SNS Mobile Automation");
            ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
            reportBuilder.generateReports();
            System.out.println("Consolidated report generated at: " + reportOutputDirectory.getAbsolutePath());
        } else {
            System.out.println("No valid JSON files to generate report. Skipping report generation.");
        }
    }
}