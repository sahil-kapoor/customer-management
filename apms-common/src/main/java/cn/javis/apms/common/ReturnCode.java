package cn.javis.apms.common;

public enum ReturnCode {
    /*
     * Common Used
     */
    SUCCESS, ENCRYPT_FAIL, DECRYPT_FAIL, STRING_WRONG_FORMAT,

    /*
     * Error Code
     */
    // User
    USER_NOT_EXIST, USER_DUPLICATED, USER_WRONG_PASSWORD, USER_WRONG_ACCESSKEY,

    // Property
    PROPERTY_NOT_FOUND

}
