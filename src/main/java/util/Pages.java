package util;

import pages.*;

public class Pages {



    private static UserManagement_Manager userManagement_manager;
    private static UserManagement_Executive userManagement_executive;

    public static UserManagement_RA_Manager userManagementRaManager;

    private static UserManagement_CPuser userManagement_cPuser;

    private static UserManagement_Inactive userManagementInactive;

    private static LoginPage loginPage;

    private static MailSending mailSending;
    private static Home_DashboardCounts home;

    private static Graphs_CollectionTrends home_graphs_CollectionsTrend;

    private static Graphs_BranchWiseCollectionsTrend home_graphs_BranchWiseCollectionsTrend;

    private static Graphs_FieldInvestigationTrends home_graphs_FieldInvestigationTrends;

    private static Graphs_SalesTrend graphsSalesTrend;

    private static Graphs_BranchWiseFieldInvestigation graphs_BranchWiseFieldInvestigation;

    private static Graphs_BranchWiseSales graphs_branchWiseSales;

    private static Graphs_UPI upi_graphs;

    private static CollectionAllocationUpload collectionAllocationUpload;

    private static AllocatedUsersSearchwithLoanNo allocatedUsersSearchwithLoanNo;

    private static CpName_AUBank cpName_AUBank;

    private static AllocatedUserSearchBasedOnVehicleNo allocatedUserSearchBasedOnVehicleNo;

    private static CpName_Indify cpName_Indify;

    private static CpName_Bajaj cpName_Bajaj;

    private static CpName_SriRam cpName_sriRam;

    private static AllocationSummary allocationSummary;

    private static Caller caller;

    private static PaymentHistory paymentHistory;

    private static NonVisitedPayments nonVisitedPayments;

private static Employee_ledger employeeLedger;


   // private static DynamicCSVFileGenerator dynamicCSVFileGenerator;
//

//    public static nmsTransactionLog_nms nmsTransactionLog_nms;
private static CashDeposition cashDeposition;
    /**
     * NMSLoginPage Encapsulate the nmsLoginPage
     *
     * @return nmsLoginPage
     * @version 1.0
     * @see LoginPage
     */
    public static Caller caller()
    {
        if (caller == null)
            caller = new Caller();
        return caller;
    }
    public static Employee_ledger employeeLedger()
    {
        if(employeeLedger==null)
            employeeLedger=new Employee_ledger();
        return employeeLedger;
    }

    public static CashDeposition cashDeposition()
    {
        if(cashDeposition==null)
            cashDeposition=new CashDeposition();
        return cashDeposition;
    }

    public static NonVisitedPayments nonVisitedPayments()
    {
        if(nonVisitedPayments==null)
            nonVisitedPayments=new NonVisitedPayments();
        return  nonVisitedPayments;
    }


    public static PaymentHistory paymentHistory()
    {
        if(paymentHistory==null)
            paymentHistory=new PaymentHistory();
        return paymentHistory;
    }

    public static UserManagement_Inactive userManagementInactive(){
        if(userManagementInactive==null)
            userManagementInactive=new UserManagement_Inactive();
        return userManagementInactive;
    }

    public static UserManagement_RA_Manager userManagementRaManager()
    {
        if(userManagementRaManager==null)
            userManagementRaManager=new UserManagement_RA_Manager();
        return userManagementRaManager;
    }


    public static LoginPage loginPage()
    {
        if (loginPage == null)
            loginPage = new LoginPage();
        return loginPage;
    }

    public static Home_DashboardCounts home() {
        if(home==null)

            home=new Home_DashboardCounts();
        return home;

    }
    public static Graphs_CollectionTrends home_graphs_CollectionsTrend()
    {
        if(home_graphs_CollectionsTrend==null)

            home_graphs_CollectionsTrend=new Graphs_CollectionTrends();

        return home_graphs_CollectionsTrend;
    }

    public static Graphs_BranchWiseCollectionsTrend home_graphs_BranchWiseCollectionsTrend()
    {
        if(home_graphs_BranchWiseCollectionsTrend==null)

            home_graphs_BranchWiseCollectionsTrend=new Graphs_BranchWiseCollectionsTrend();

        return home_graphs_BranchWiseCollectionsTrend;
    }

    public static Graphs_FieldInvestigationTrends home_graphs_FieldInvestigationTrends()
    {
        if(home_graphs_FieldInvestigationTrends==null)

            home_graphs_FieldInvestigationTrends=new Graphs_FieldInvestigationTrends();

        return home_graphs_FieldInvestigationTrends;
    }
    public static Graphs_SalesTrend graphsSalesTrend()
    {
        if(graphsSalesTrend==null)
            graphsSalesTrend=new Graphs_SalesTrend();

        return graphsSalesTrend;

    }
    public static Graphs_BranchWiseFieldInvestigation graphs_BranchWiseFieldInvestigation()
    {
        if(graphs_BranchWiseFieldInvestigation==null)
            graphs_BranchWiseFieldInvestigation=new Graphs_BranchWiseFieldInvestigation();
        return graphs_BranchWiseFieldInvestigation;

    }
    public static Graphs_BranchWiseSales graphs_branchWiseSales()
    {
        if(graphs_branchWiseSales==null)
            graphs_branchWiseSales=new Graphs_BranchWiseSales();
        return graphs_branchWiseSales;
    }

    public static Graphs_UPI upi_graphs()
    {
        if(upi_graphs==null)

            upi_graphs=new Graphs_UPI();
        return upi_graphs;

    }
    public static CollectionAllocationUpload collectionAllocationUpload() {
        if (collectionAllocationUpload==null)

            collectionAllocationUpload=new CollectionAllocationUpload();
        return
                collectionAllocationUpload;
    }

    public static AllocatedUsersSearchwithLoanNo allocatedUsersSearchwithLoanNo()
    {
        if(allocatedUsersSearchwithLoanNo==null)
            allocatedUsersSearchwithLoanNo=new AllocatedUsersSearchwithLoanNo();
        return allocatedUsersSearchwithLoanNo;
    }

    public static CpName_AUBank cpName_AUBank()
    {
        if(cpName_AUBank==null)
            cpName_AUBank=new CpName_AUBank();
        return cpName_AUBank;
    }
    public static AllocatedUserSearchBasedOnVehicleNo allocatedUserSearchBasedOnVehicleNo()
    {
        if(allocatedUserSearchBasedOnVehicleNo==null)
            allocatedUserSearchBasedOnVehicleNo=new AllocatedUserSearchBasedOnVehicleNo();
        return allocatedUserSearchBasedOnVehicleNo;
    }

    public static CpName_Indify cpName_Indify()
    {
        if(cpName_Indify==null)
            cpName_Indify=new CpName_Indify();
        return cpName_Indify;
    }
    public static CpName_Bajaj cpName_Bajaj()
    {
        if(cpName_Bajaj==null)
            cpName_Bajaj=new CpName_Bajaj();
        return cpName_Bajaj;
    }
    public static UserManagement_Manager userManagement_manager()
    {
        if(userManagement_manager==null)
            userManagement_manager=new UserManagement_Manager();
        return userManagement_manager;
    }

    public static UserManagement_Executive userManagement_executive()
    {
        if(userManagement_executive==null)
            userManagement_executive=new UserManagement_Executive();
        return userManagement_executive;
    }

    public static UserManagement_CPuser userManagement_cPuser(){
        if(userManagement_cPuser==null)
            userManagement_cPuser=new UserManagement_CPuser();
        return userManagement_cPuser;

    }

    public static CpName_SriRam cpName_sriRam()
    {
        if(cpName_sriRam==null)
            cpName_sriRam=new CpName_SriRam();
        return cpName_sriRam;
    }

    public static AllocationSummary allocationSummary()
    {
        if(allocationSummary==null)
            allocationSummary=new AllocationSummary();
        return allocationSummary;
    }

    public static MailSending mailSending()
    {
        if(mailSending==null)
            mailSending=new MailSending();
        return mailSending;
    }

}
