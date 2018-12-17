package com.shen.cloud.util;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/**
 * 本示例提供AES（128位）算法加密和解密演示
 * AES 128位算法中秘钥和向量（偏移量）长度为16个字节，需要将32位字符串使用16进制转换成二进制
 */
public class AESDUtile {

    private static final String AES = "AES";
    private static final String AES_CBC = "AES/CBC/PKCS5Padding";
    private static final char[] DIGITS_LOWER =
            {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    /**
     * 加密
     *
     * @param data 待加密明文数据
     * @param key  加密密码
     * @param iv   加密向量（偏移量）
     * @return
     */
    public static byte[] encrypt(byte[] data, byte[] key, byte[] iv) {
        return aes(data, key, iv, Cipher.ENCRYPT_MODE);
    }

    /**
     * 解密
     *
     * @param encryptedData 加密后的数据
     * @param key           解密密码
     * @param iv            解密向量（偏移量）
     * @return
     */
    public static byte[] decrypt(byte[] encryptedData, byte[] key, byte[] iv) {
        return aes(encryptedData, key, iv, Cipher.DECRYPT_MODE);
    }

    /**
     * 使用AES加密或解密无编码的原始字节数组, 返回无编码的字节数组结果.
     *
     * @param input 原始字节数组
     * @param key   符合AES要求的密钥
     * @param iv    初始向量
     * @param mode  Cipher.ENCRYPT_MODE 或 Cipher.DECRYPT_MODE
     */
    private static byte[] aes(byte[] input, byte[] key, byte[] iv, int mode) {
        try {
            SecretKey secretKey = new SecretKeySpec(key, AES);
            IvParameterSpec ivSpec = new IvParameterSpec(iv);
            Cipher cipher = Cipher.getInstance(AES_CBC);
            cipher.init(mode, secretKey, ivSpec);
            return cipher.doFinal(input);
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] decodeHex(final char[] data) throws Exception {

        final int len = data.length;

        if ((len & 0x01) != 0) {
            throw new Exception("Odd number of characters.");
        }

        final byte[] out = new byte[len >> 1];

        // two characters form the hex value.
        for (int i = 0, j = 0; j < len; i++) {
            int f = toDigit(data[j], j) << 4;
            j++;
            f = f | toDigit(data[j], j);
            j++;
            out[i] = (byte) (f & 0xFF);
        }

        return out;
    }

    /**
     * Hex解码.
     */
    public static byte[] decodeHex(String input) {
        try {
            return decodeHex(input.toCharArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static int toDigit(final char ch, final int index) throws Exception {
        final int digit = Character.digit(ch, 16);
        if (digit == -1) {
            throw new Exception("Illegal hexadecimal character " + ch + " at index " + index);
        }
        return digit;
    }

    public static char[] encodeHex(final byte[] data, final char[] toDigits) {
        final int l = data.length;
        final char[] out = new char[l << 1];
        for (int i = 0, j = 0; i < l; i++) {
            out[j++] = toDigits[(0xF0 & data[i]) >>> 4];
            out[j++] = toDigits[0x0F & data[i]];
        }
        return out;
    }



    public static String encodeHexString(final byte[] data) {
        return new String(encodeHex(data));
    }

    public static char[] encodeHex(final byte[] data){
        return encodeHex(data, DIGITS_LOWER);
    }

    /**
     * 生成AES密钥,可选长度为128,192,256位.
     */
    public static byte[] generateAesKey(int keysize)throws Exception {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(AES);
            keyGenerator.init(keysize);
            SecretKey secretKey = keyGenerator.generateKey();
            return secretKey.getEncoded();
        } catch (GeneralSecurityException e) {
            throw new Exception(e);
        }
    }

    public static void main(String[] args) throws Exception {
        //密码：7985c4cc0cf22caccddb0b864f79e5dd
        //向量（偏移量）：e3205234a872012af4f3ac5dbd9c810c
        String password = "7985c4cc0cf22caccddb0b864f79e5dd";
        String iv = "e3205234a872012af4f3ac5dbd9c810c";

        byte[] passwordBinaryArray = AESDUtile.decodeHex(password); //passwordBinaryArray 长度为16个字节
        byte[] ivBinaryArray = AESDUtile.decodeHex(iv); //ivBinaryArray 长度为16个字节
        System.out.println(passwordBinaryArray);
        System.out.println(ivBinaryArray);
        //将明文按照utf-8编码转成二进制数组
        String plainText = "各位辛苦了";//明文
        byte[] plainTextUtf8Array = plainText.getBytes("utf-8");

        //加密
        byte[] encryptedData = AESDUtile.encrypt(plainTextUtf8Array, passwordBinaryArray, ivBinaryArray);
        System.out.println("加密后的内容:" + Arrays.toString(encryptedData));

        //解密
        byte[] decryptedData = AESDUtile.decrypt(encryptedData, passwordBinaryArray, ivBinaryArray);
        System.out.println("解密后的内容:" + Arrays.toString(decryptedData));
        System.out.println("解密后的内容:" + new String(decryptedData, "utf-8"));


        ////所有输出
//        加密后的内容:[-40, 91, 16, -53, 44, -92, 81, -19, 36, -51, -81, 104, -64, -40, -99, -54]
//        解密后的内容:[-27, -112, -124, -28, -67, -115, -24, -66, -101, -24, -117, -90, -28, -70, -122]
//        解密后的内容:各位辛苦了
    }
}
