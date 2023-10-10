package com.loevc.celestia.common.util;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/10/10 15:51
 * @Description generate a random digit
 * @Version 1.0
 */
public class GenerateRandomDigitUtil {

    public static String getFourDigitVerifyCode(){
        return getDigitVerifyCode(4);
    }

    public static String getSixDigitVerifyCode(){
        return getDigitVerifyCode(6);
    }

    private static String getDigitVerifyCode(int codeLength){
        return Long.toString(System.nanoTime()).substring(Long.toString(System.nanoTime()).length()-codeLength);
    }

}
