Feature: Purchase Order request Case Type
  @Regression @Scenario_01
  Scenario: Submitting and resolving a POR case
    Given user login into 'BPA Tracfone' application as "BPACaseWorker"
    And user click on Create New Link and then click on "Purchase Order Request" case type
    And user submit the New Or Amend POR screen
    And user submit the EnterRequestCriteriaPage
    And user submit the Line Item Page
    And user submit the JustificationAndAttachment Page
    And user submit the ContractForm Page
    Then user submit the Review Page
    And user click on Approval from ActionMenu and submit CostCenterApproval Page
    And user click on Approval from ActionMenu and submit Pending Purchasing Approval
    And user click on Approval from ActionMenu and submit VPITCompute Approval
    And user click on FixedAssets from ActionMenu and submit FixedAssetsReview
    Then user_verify the_status_as_ResolvedCompleted
    Then user Log out from application
    And Kill the browser session

   @Regression @Scenario_02
   Scenario: Submitting and resolving POR case with price greater than 50000 and non consultant
     Given user login into 'BPA Tracfone' application as "BPACaseWorker"
     And user click on Create New Link and then click on "Purchase Order Request" case type
     And user submit the New Or Amend POR screen
     And user submit the EnterRequestCriteriaPage
     And user enetered price greater than 50000 ,non consultant and submit the Line Item Page
     And user submit the JustificationAndAttachment Page
     And user submit the ContractForm Page
     Then user submit the Review Page



   @Regression @Scenario_03
   Scenario: Submitting and resolving POR case with greater than 250000 and non consutant




