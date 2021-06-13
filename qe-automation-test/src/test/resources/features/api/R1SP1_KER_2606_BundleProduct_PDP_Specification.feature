Feature: To verify the BundleProduct PDP Specification API Services

  @Regression @Sanity @All @api @KER-2606 @ZYP-7313
  Scenario Outline: : Verify BundleProduct PDP Specification for status code 200
    Given "<BundleProductPDPUrl>" endpoint for BundleProduct PDP Specification
    Then Verify response status code as 200 for BundleProduct PDP Specification

    Examples: 
      | BundleProductPDPUrl                |
      | /api/product/5342007?storeId=66209 |

  @Regression @Sanity @All @api @KER-2606 @ZYP-7314
  Scenario Outline: : validate the BundleProduct PDP Specification json schema
    Given "<BundleProductPDPUrl>" endpoint for BundleProduct PDP Specification
    And validate jsonSchema "KER_2606_BundleProductPDPSchema" for BundleProduct PDP Specification

    Examples: 
      | BundleProductPDPUrl                |
      | /api/product/5342007?storeId=66209 |

  @Regression @Sanity @All @api @KER-2606 @ZYP-7315
  Scenario Outline: : Validate the BundleProduct PDP Specification with inventory Requried Property Values are not null
    Given "<BundleProductPDPUrl>" endpoint for BundleProduct PDP Specification
    Then read the API json response
    And Validate the Product PDP "inventory" with "store" API Requried Property Value are not Null
      | bundleId |
    And Validate the Product PDP "inventory" with "online" API Requried Property Value are not Null
      | bundleId |

    Examples: 
      | BundleProductPDPUrl                |
      | /api/product/5342007?storeId=66209 |

  @Regression @Sanity @All @api @KER-2606 @ZYP-7316
  Scenario Outline: : Verify BundleProduct PDP Specification with store and BundleProductid for status code 404
    Given "<BundleProductPDPUrl>" endpoint for Product PDP Specification
    Then Verify response status code as 404 for Product PDP Specification
    And Verify the response message "Product Details could not be found" for CategoryDetail

    Examples: 
      | BundleProductPDPUrl           |
      | /api/product/41346?storeId=12 |
