package io.lenra.app.gen.components.styles;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

public class AutofillHints extends ArrayList<AutofillHints.Items> {

  // Sub elements

  public static enum Items {
    // Values
    @JsonProperty("addressCity")
    ADDRESS_CITY,
    @JsonProperty("addressCityAndState")
    ADDRESS_CITY_AND_STATE,
    @JsonProperty("addressState")
    ADDRESS_STATE,
    @JsonProperty("birthday")
    BIRTHDAY,
    @JsonProperty("birthdayDay")
    BIRTHDAY_DAY,
    @JsonProperty("birthdayMonth")
    BIRTHDAY_MONTH,
    @JsonProperty("birthdayYear")
    BIRTHDAY_YEAR,
    @JsonProperty("countryCode")
    COUNTRY_CODE,
    @JsonProperty("countryName")
    COUNTRY_NAME,
    @JsonProperty("creditCardExpirationDate")
    CREDIT_CARD_EXPIRATION_DATE,
    @JsonProperty("creditCardExpirationDay")
    CREDIT_CARD_EXPIRATION_DAY,
    @JsonProperty("creditCardExpirationMonth")
    CREDIT_CARD_EXPIRATION_MONTH,
    @JsonProperty("creditCardExpirationYear")
    CREDIT_CARD_EXPIRATION_YEAR,
    @JsonProperty("creditCardFamilyName")
    CREDIT_CARD_FAMILY_NAME,
    @JsonProperty("creditCardGivenName")
    CREDIT_CARD_GIVEN_NAME,
    @JsonProperty("creditCardMiddleName")
    CREDIT_CARD_MIDDLE_NAME,
    @JsonProperty("creditCardName")
    CREDIT_CARD_NAME,
    @JsonProperty("creditCardNumber")
    CREDIT_CARD_NUMBER,
    @JsonProperty("creditCardSecurityCode")
    CREDIT_CARD_SECURITY_CODE,
    @JsonProperty("creditCardType")
    CREDIT_CARD_TYPE,
    @JsonProperty("email")
    EMAIL,
    @JsonProperty("familyName")
    FAMILY_NAME,
    @JsonProperty("fullStreetAddress")
    FULL_STREET_ADDRESS,
    @JsonProperty("gender")
    GENDER,
    @JsonProperty("givenName")
    GIVEN_NAME,
    @JsonProperty("impp")
    IMPP,
    @JsonProperty("jobTitle")
    JOB_TITLE,
    @JsonProperty("language")
    LANGUAGE,
    @JsonProperty("location")
    LOCATION,
    @JsonProperty("middleInitial")
    MIDDLE_INITIAL,
    @JsonProperty("middleName")
    MIDDLE_NAME,
    @JsonProperty("name")
    NAME,
    @JsonProperty("namePrefix")
    NAME_PREFIX,
    @JsonProperty("nameSuffix")
    NAME_SUFFIX,
    @JsonProperty("newPassword")
    NEW_PASSWORD,
    @JsonProperty("newUsername")
    NEW_USERNAME,
    @JsonProperty("nickname")
    NICKNAME,
    @JsonProperty("oneTimeCode")
    ONE_TIME_CODE,
    @JsonProperty("organizationName")
    ORGANIZATION_NAME,
    @JsonProperty("password")
    PASSWORD,
    @JsonProperty("photo")
    PHOTO,
    @JsonProperty("postalAddress")
    POSTAL_ADDRESS,
    @JsonProperty("postalAddressExtended")
    POSTAL_ADDRESS_EXTENDED,
    @JsonProperty("postalAddressExtendedPostalCode")
    POSTAL_ADDRESS_EXTENDED_POSTAL_CODE,
    @JsonProperty("postalCode")
    POSTAL_CODE,
    @JsonProperty("streetAddressLevel1")
    STREET_ADDRESS_LEVEL1,
    @JsonProperty("streetAddressLevel2")
    STREET_ADDRESS_LEVEL2,
    @JsonProperty("streetAddressLevel3")
    STREET_ADDRESS_LEVEL3,
    @JsonProperty("streetAddressLevel4")
    STREET_ADDRESS_LEVEL4,
    @JsonProperty("streetAddressLine1")
    STREET_ADDRESS_LINE1,
    @JsonProperty("streetAddressLine2")
    STREET_ADDRESS_LINE2,
    @JsonProperty("streetAddressLine3")
    STREET_ADDRESS_LINE3,
    @JsonProperty("sublocality")
    SUBLOCALITY,
    @JsonProperty("telephoneNumber")
    TELEPHONE_NUMBER,
    @JsonProperty("telephoneNumberAreaCode")
    TELEPHONE_NUMBER_AREA_CODE,
    @JsonProperty("telephoneNumberCountryCode")
    TELEPHONE_NUMBER_COUNTRY_CODE,
    @JsonProperty("telephoneNumberDevice")
    TELEPHONE_NUMBER_DEVICE,
    @JsonProperty("telephoneNumberExtension")
    TELEPHONE_NUMBER_EXTENSION,
    @JsonProperty("telephoneNumberLocal")
    TELEPHONE_NUMBER_LOCAL,
    @JsonProperty("telephoneNumberLocalPrefix")
    TELEPHONE_NUMBER_LOCAL_PREFIX,
    @JsonProperty("telephoneNumberLocalSuffix")
    TELEPHONE_NUMBER_LOCAL_SUFFIX,
    @JsonProperty("telephoneNumberNational")
    TELEPHONE_NUMBER_NATIONAL,
    @JsonProperty("transactionAmount")
    TRANSACTION_AMOUNT,
    @JsonProperty("transactionCurrency")
    TRANSACTION_CURRENCY,
    @JsonProperty("url")
    URL,
    @JsonProperty("username")
    USERNAME;
  }

}