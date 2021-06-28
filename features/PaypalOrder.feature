Feature: : An Order represents a payment between two or more parties
  Use the order API to create,update, retrieve ,authorize and capture orders

  @paypal001
  Scenario Outline: Create order request
    Given I have a valid access token
    And content type is set to application Json
    And the request body is defined as a Json file
    When I send a post create to the "<CreateOrderResouce>"
    Then I should get status code of <statuscode>
    And the response Body should contains status "<status>"


    Examples:


      | CreateOrderResouce | statuscode | status  |  |
      | v2/checkout/orders | 201        | CREATED |  |
      | v2/checkout/orders | 201        | CREATED |  |
      | v2/checkout/orders | 201        | CREATED |  |
      | v2/checkout/orders | 201        | CREATED |  |
      | v2/checkout/orders | 201        | CREATED |  |
      | v2/checkout/orders | 201        | CREATED |  |


    @paypal002
    Scenario Outline: perform a get operation with a valid ID
      Given I am authorized withe valid authentication token
      And I set content type to application Json
      When I send a get request to the department "<resource>" with a valid ID as "<ID>"
      Then I should get a status code of "<statusCode>"


      Examples:
        | resource           | ID                 | statusCode |  |
        | v2/checkout/orders | 86M22794HM631210Y  | 200        |  |
        | v2/checkout/orders | 56U08047G79073316  | 200        |  |
        | v2/checkout/orders | 6N095311TV168980A  | 200        |  |
        | v2/checkout/orders | 6X007135VU627980Bb | 401        |  |
        | v2/checkout/orders | 7FM934349Y613674F  | 200        |  |
        | v2/checkout/orders | 346692645Y5483741  | 401        |  |









