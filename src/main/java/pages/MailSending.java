package pages;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class MailSending {

    private static final String EMAIL_CONTENT_TYPE = "text/HTML; charset=UTF-8";

    public void Report() {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");

            Session session = Session.getDefaultInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("clucloud.automation@gmail.com", "nmdu rhud ascu ntzv");
                }
            });

            MimeMessage msg = new MimeMessage(session);
            msg.addHeader("Content-type", EMAIL_CONTENT_TYPE);
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");
            msg.setFrom(new InternetAddress("no_reply@gmail.com", "no_reply@gmail.com"));
            msg.setSubject("CluCloud QA Automation Report", "UTF-8");
            msg.setSentDate(new Date());
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("saikiran.kondala@clucloud.com"));
//            InternetAddress recipient1 = new InternetAddress("anils@clucloud.com");
//            InternetAddress recipient3 = new InternetAddress("srujana.challa@clucloud.com");
//            InternetAddress recipient4 = new InternetAddress("nagesh.barla@clucloud.com");
//            InternetAddress recipient5 = new InternetAddress("rakesh.chittimela@clucloud.com");
//            InternetAddress recipient2 = new InternetAddress("kondalasaikiran@gmail.com");
//            InternetAddress recipient6 = new InternetAddress("pavan.k@clucloud.com");
//            msg.setRecipients(Message.RecipientType.TO, new InternetAddress[]{recipient1, recipient2, recipient3,recipient4,recipient5,recipient6});
            Multipart multipart = new MimeMultipart();
            String filename = System.getProperty("user.dir") + "/target/test-output/Reports/Clucloud_Test_Automation_Report.html";
            File htmlFile = new File(filename);
            Document doc = Jsoup.parse(htmlFile, "UTF-8");
            Element chromeTdElement = doc.select("td:contains(Chrome)").first();

            // HTML File
            MimeBodyPart htmlBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(filename);
            htmlBodyPart.setDataHandler(new DataHandler(source));
            htmlBodyPart.setFileName("Automation_Report.html");
            multipart.addBodyPart(htmlBodyPart);

            if (chromeTdElement != null) {
                List<Element> nextTdElements = chromeTdElement.nextElementSiblings().select("td");
                String value1 = nextTdElements.get(0).text();
                String value2 = nextTdElements.get(1).text();
                String value3 = nextTdElements.get(2).text();
                String value4 = nextTdElements.get(3).text();
                String value5 = nextTdElements.get(4).text();

                // Construct email body with HTML table and CSS styles
                String emailBody = "<div style='color: red; font-size: 16px;'>Clucloud Automation Report Overview.</div>" +
                        "<style>" +
                        "table {" +
                        "   border-collapse: collapse;" +
                        "   width: 100%;" +
                        "}" +
                        "th, td {" +
                        "   border: 1px solid black;" +
                        "   padding: 10px;" +
                        "   text-align: left;" +
                        "}" +
                        "th {" +
                        "   background-color: #f2f2f2;" +
                        "}" +
                        "tr:nth-child(even) {" +
                        "   background-color: #dddddd;" +
                        "}" +
                        ".chart-container {" +
                        "   text-align: center;" +
                        "}" +
                        ".chart {" +
                        "   max-width: 100%;" +
                        "   height: auto;" +
                        "}" +
                        "</style>" +
                        "<table>" +
                        "<tr><th>Test Cases</th><th>Values</th></tr>" +
                        "<tr><td>Passed Test Cases</td><td>" + value1 + "</td></tr>" +
                        "<tr><td>Failed Test Cases</td><td>" + value2 + "</td></tr>" +
                        "<tr><td>Skipped Test cases</td><td>" + value3 + "</td></tr>" +
                        "<tr><td>Others</td><td>" + value4 + "</td></tr>" +
                        "<tr><td>Passed %</td><td>" + value5 + "</td></tr>" +
                        "</table>" +
                        "<div class='chart-container'>" +
                        generateChartImage("chart", generatePieChart(value1, value2, value3)) +
                        generateChartImage("barChart", generateBarChart(value1, value2, value3)) +
                        "</div>" +
                        "<div style='color: blue; font-size: 16px;'>Please find the attached automation report for the latest test run.<br/>This report provides an overview of the test results and any issues encountered during the testing process.</div>";

                // Add email body to multipart
                MimeBodyPart emailBodyPart = new MimeBodyPart();
                emailBodyPart.setContent(emailBody, "text/html");
                multipart.addBodyPart(emailBodyPart);
                // Save and add pie chart image to email body
                multipart.addBodyPart(generateChartImagePart("chart", generatePieChart(value1, value2, value3)));
                // Save and add bar chart image to email body
                multipart.addBodyPart(generateChartImagePart("barChart", generateBarChart(value1, value2, value3)));
                msg.setContent(multipart);
                System.out.println("Email Sent Successfully");
                msg.setContent(multipart);
                Transport.send(msg);
            }
            else
            {
                System.out.println("Element 'Chrome' not found in the HTML file.");
            }

        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
    }

    private JFreeChart generatePieChart(String value1, String value2, String value3) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Passed", Double.parseDouble(value1));
        dataset.setValue("Failed", Double.parseDouble(value2));
        dataset.setValue("Skipped", Double.parseDouble(value3));

        return ChartFactory.createPieChart3D("Test Results", dataset, true, true, false);
    }

    private JFreeChart generateBarChart(String value1, String value2, String value3) {
        DefaultCategoryDataset barDataset = new DefaultCategoryDataset();
        barDataset.addValue(Double.parseDouble(value1), "Test Results", "Passed");
        barDataset.addValue(Double.parseDouble(value2), "Test Results", "Failed");
        barDataset.addValue(Double.parseDouble(value3), "Test Results", "Skipped");

        return ChartFactory.createBarChart(
                "Test Results",
                "Test Cases",
                "Values",
                barDataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
    }

    private MimeBodyPart generateChartImagePart(String chartId, JFreeChart chart) throws IOException, MessagingException {
        String chartImagePath = System.getProperty("user.dir") + "/target/test-output/Reports/" + chartId + "_chart.png";
        ChartUtilities.saveChartAsPNG(new File(chartImagePath), chart, 400, 300);

        MimeBodyPart chartPart = new MimeBodyPart();
        DataSource chartDataSource = new FileDataSource(chartImagePath);
        chartPart.setDataHandler(new DataHandler(chartDataSource));
        chartPart.setHeader("Content-ID", "<" + chartId + ">");
        return chartPart;
    }

    private String generateChartImage(String chartId, JFreeChart chart) throws IOException, MessagingException {
        MimeBodyPart chartPart = generateChartImagePart(chartId, chart);
        return String.format("<img class='chart' src='cid:%s' alt='%s Chart'>", chartId, chartId);
    }
}
