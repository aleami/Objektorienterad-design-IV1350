package se.kth.iv1350.repairelectricbike.model;
import java.util.Date;

/**
 * Represents a diagnostic report for a repair order.
 */
public class DiagnosticReport {
    private Date date;
    private String taskResult;
    private int repairOrderId;

    /**
     * Creates a new diagnostic report.
     *
     * @param taskResult The result of the diagnostic.
     * @param repairOrderId The ID of the repair order.
     */
    public DiagnosticReport(String taskResult, int repairOrderId) {
        this.date = new Date(); // Sätter aktuellt datum vid skapandet
        this.taskResult = taskResult;
        this.repairOrderId = repairOrderId;}

    /**
     * @return The diagnostic result.
     */
    public String getTaskResult() {
        return taskResult;}

    /**
     * @return The date of the report.
     */
    public Date getDate() {
        return date;}

    /**
     * @return The repair order ID.
     */
    public int getRepairOrderId() {
        return repairOrderId;}
}