Feature: To verify the Product PDP Specification API Services

  @Regression @Sanity @All @api @KER-2606 @ZYP-7052
  Scenario Outline: : Verify Product PDP Specification for status code 200
    Given "<ProductPDPUrl>" endpoint for Product PDP Specification
    Then Verify response status code as 200 for Product PDP Specification

    Examples: 
      | ProductPDPUrl                      |
      | /api/product/4134286?storeId=66209 |

  @Regression @Sanity @All @api @KER-2606 @ZYP-7053
  Scenario Outline: : validate the Product PDP Specification json schema
    Given "<ProductPDPUrl>" endpoint for Product PDP Specification
    And validate jsonSchema "KER_2606_ProductPDPSchema" for Product PDP Specification

    Examples: 
      | ProductPDPUrl                      |
      | /api/product/4134286?storeId=66209 |

  @Regression @Sanity @All @api @KER-2606 @ZYP-7054
  Scenario Outline: : Validate the Product PDP Specification with inventory Requried Property Values are not null
    Given "<ProductPDPUrl>" endpoint for Product PDP Specification
    Then read the API json response
    And Validate the Product PDP "inventory" with "store" API Requried Property Value are not Null
      | productId |
    And Validate the Product PDP "inventory" with "online" API Requried Property Value are not Null
      | skuId             |
      | availableQuantity |
      | inventoryStatus   |
      | onlineStoreName   |
      | inventoryStatus   |
    And Validate the Product PDP "inventory" with "store" API Requried Property Value are not Null
      | skuId |

    Examples: 
      | ProductPDPUrl                      |
      | /api/product/4134286?storeId=66209 |

  @Regression @Sanity @All @api @KER-2606 @ZYP-7056
  Scenario Outline: : Verify Product PDP Specification with store and productid for status code 404
    Given "<ProductPDPUrl>" endpoint for Product PDP Specification
    Then Verify response status code as 404 for Product PDP Specification
    And Verify the response message "Product Details could not be found" for CategoryDetail

    Examples: 
      | ProductPDPUrl                 |
      | /api/product/41346?storeId=12 |
