Feature: To verify the Update Wishlist API Services

  @Regression @Sanity @All @api @KER-1915 @ZYP-7321
  Scenario Outline: : Verify Update Wishlist with sign-in user for status code 200
    Given API "<wishlistUpdateUrl>" and Update request "<wishlistRequestJson>" endpoint for Wishlist with Sign-in user "<UserName>""<Password>"
    Then Verify response status code as 200 for Wishlist

    Examples: 
      | wishlistUpdateUrl           | wishlistRequestJson   | UserName       | Password   |
      | /api/profile/wishlist/43502 | WishlistUpdateRequest | travi@ravi.com | Qwerty@123 |

  @Regression @Sanity @All @api @KER-1915 @ZYP-7322
  Scenario Outline: : validate the  Update Wishlist sign-in user json schema
   Given API "<wishlistUpdateUrl>" and Update request "<wishlistRequestJson>" endpoint for Wishlist with Sign-in user "<UserName>""<Password>"

    #And validate jsonSchema "KER-323-wishlistSchema" for Wishlist with SignIn
    Examples: 
      | wishlistUpdateUrl           | wishlistRequestJson   | UserName       | Password   |
      | /api/profile/wishlist/43502 | WishlistUpdateRequest | travi@ravi.com | Qwerty@123 |

  @Regression @Sanity @All @api @KER-1915 @ZYP-7323
  Scenario Outline: : Validate the  Update Wishlist sign-in user Requried Property Values
    Given API "<wishlistUpdateUrl>" and Update request "<wishlistRequestJson>" endpoint for Wishlist with Sign-in user "<UserName>""<Password>"
    Then read the API json response

    #And Validate the Wishlist API Requried Property Value are not Null
    #| itemCount          |
    Examples: 
      | wishlistUpdateUrl           | wishlistRequestJson   | UserName       | Password   |
      | /api/profile/wishlist/43502 | WishlistUpdateRequest | travi@ravi.com | Qwerty@123 |

  @Regression @Sanity @All @api @KER-1915 @ZYP-7326
  Scenario Outline: Verify  Update Wishlist user for status code 503 for Not Found
    Given "<wishlistUpdateUrl>" endpoint for Product PDP Specification
    Then Verify response status code as 503 for Wishlist

    Examples: 
      | wishlistUpdateUrl           |
      | /api/profile/wishlist/43502 |
