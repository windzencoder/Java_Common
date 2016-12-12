package com.wz.security.aes;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class ImoocAES {

	private static String src = "imooc security aes";

	public static void main(String[] args) {

		jdkAES();

	}

	public static void jdkAES() {

		try {
			// 生成key
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
			keyGenerator.init(128);
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] keybytes = secretKey.getEncoded();

			// key的转换
			Key key = new SecretKeySpec(keybytes, "AES");

			// 加密
			// AES/工作模式/填充方式
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] result = cipher.doFinal(src.getBytes());
			System.out.println("jdk aes encrypt : " + Base64.encodeBase64String(result));

			// 解密
			cipher.init(Cipher.DECRYPT_MODE, key);
			result = cipher.doFinal(result);
			System.out.println("jdk aes decrypt : " + new String(result));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void bcAES() {
		
		
		
	}

}
