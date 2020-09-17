Feature: Agent Training request Case Type

  @Regression @Scenario_01
  Scenario: Submitting and resolving a Training Request Case
    Given user login into 'BPA' application as "BPACaseWorker"
    And user click on New Link and then click on "Agent Training Request" case type
    And user submit the Request Details screen
    And user Log out from application
    Then user login into 'BPA' application as "BPACaseManager"
    And user navigate to "Agent Training Request" Work queues and open the same TR Case
    And user submit the Review Request screen
    And user click on "Continue Process" from Actions menu
    And user submit the Continue Process screen
    And user Log out from application
    And Kill the browser session

  @Regression @Scenario_02
  Scenario: Withdraw case Agent Training Request Case
    Given user login into 'BPA' application as "BPACaseWorker"
    And user click on New Link and then click on "Agent Training Request" case type
    And user submit the Request Details screen
    And user Log out from application
    Given user login into 'BPA' application as "BPACaseManager"
    And user navigate to "Agent Training Request" Work queues and open the same TR Case
    And user click on "Withdraw case" from Actions menu
    And user provide the reason and Submit the request for Withdrawal
    And user Log out from application
    And Kill the browser session


