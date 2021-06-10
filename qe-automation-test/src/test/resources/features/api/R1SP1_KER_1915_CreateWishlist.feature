Feature: To verify the Create Wishlist API Services

  @Regression @Sanity @All @api @KER-1915 @ZYP-7317
  Scenario Outline: : Verify create Wishlist with sign-in user for status code 200
    Given API "<wishlistPostUrl>" and post request "<wishlistRequestJson>" endpoint for Wishlist with Sign-in user "<UserName>""<Password>"
    Then Verify response status code as 200 for Wishlist

    Examples: 
      | wishlistPostUrl       | wishlistRequestJson | UserName       | Password   |
      | /api/profile/wishlist | WishlistPostRequest | travi@ravi.com | Qwerty@123 |

  @Regression @Sanity @All @api @KER-1915 @ZYP-7318
  Scenario Outline: : validate the  create Wishlist sign-in user json schema
     Given API "<wishlistPostUrl>" and post request "<wishlistRequestJson>" endpoint for Wishlist with Sign-in user "<UserName>""<Password>"
    And validate jsonSchema "KER-1915-wishlistSchema" for Wishlist with SignIn

    Examples: 
      | wishlistPostUrl       | wishlistRequestJson | UserName       | Password   |
      | /api/profile/wishlist | WishlistPostRequest | travi@ravi.com | Qwerty@123 |

  @Regression @Sanity @All @api @KER-1915 @ZYP-7319
  Scenario Outline: : Validate the  create Wishlist sign-in user Requried Property Values
     Given API "<wishlistPostUrl>" and post request "<wishlistRequestJson>" endpoint for Wishlist with Sign-in user "<UserName>""<Password>"
    Then read the API json response

    # And Validate the Wishlist API Requried Property Value are not Null
    #  | itemCount          |
    Examples: 
      | wishlistPostUrl       | wishlistRequestJson | UserName       | Password   |
      | /api/profile/wishlist | WishlistPostRequest | travi@ravi.com | Qwerty@123 |

  @Regression @Sanity @All @api @KER-1915 @ZYP-7320
  Scenario Outline: Verify  create Wishlist user for status code 503 for Not Found
    Given "<wishlistPostUrl>" endpoint for Product PDP Specification
    Then Verify response status code as 503 for Wishlist

    Examples: 
      | wishlistPostUrl       |
      | /api/profile/wishlist |
