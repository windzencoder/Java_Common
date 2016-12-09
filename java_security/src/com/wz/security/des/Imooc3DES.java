package com.wz.security.des;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import org.apache.commons.codec.binary.Hex;

public class Imooc3DES {

	private static String src = "imooc security des";

	public static void main(String[] args) {

		jdk3des();

	}

	private static void jdk3des() {
		// 生成密钥
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede");
			// 指定keysize
			//keyGenerator.init(168);
			//生成默认长度的KEY
			keyGenerator.init(new SecureRandom());
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] bytesKey = secretKey.getEncoded();

			// key转换
			DESedeKeySpec desKeySpec = new DESedeKeySpec(bytesKey);
			SecretKeyFactory factory = SecretKeyFactory.getInstance("DESede");
			Key convertSecretKey = factory.generateSecret(desKeySpec);

			// 加密
			Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);
			byte[] resultBytes = cipher.doFinal(src.getBytes());
			System.out.println("jdk 3des encrypt : " + Hex.encodeHexString(resultBytes));

			// 解密
			cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);
			resultBytes = cipher.doFinal(resultBytes);
			System.out.println("jdk 3des decrypt : " + new String(resultBytes));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
