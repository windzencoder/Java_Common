package com.wz.security.des;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class ImoocDES {

	private static String src = "imooc security des";
	
	public static void main(String[] args) {
		
		jdkDES();
		bcDES();
		
	}
	
public static void bcDES() {
		try {
			Security.addProvider(new BouncyCastleProvider());
		
			
			KeyGenerator keyGenerator = KeyGenerator.getInstance("DES", "BC");
			keyGenerator.getProvider();
			//指定keysize
			keyGenerator.init(56);
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] bytesKey = secretKey.getEncoded();
			
			//key转换
			DESKeySpec desKeySpec = new DESKeySpec(bytesKey);
			SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
			Key convertSecretKey = factory.generateSecret(desKeySpec);
			
			//加密 
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);
			byte[] resultBytes =  cipher.doFinal(src.getBytes());
			System.out.println("bc des encrypt : " + Hex.encodeHexString(resultBytes));
			
			//解密
			cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);
			resultBytes = cipher.doFinal(resultBytes);
			System.out.println("bc des decrypt : " + new String(resultBytes));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	public static void jdkDES() {
		
		//生成密钥
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
			//指定keysize
			keyGenerator.init(56);
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] bytesKey = secretKey.getEncoded();
			
			//key转换
			DESKeySpec desKeySpec = new DESKeySpec(bytesKey);
			SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
			Key convertSecretKey = factory.generateSecret(desKeySpec);
			
			//加密 
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);
			byte[] resultBytes =  cipher.doFinal(src.getBytes());
			System.out.println("jdk des encrypt : " + Hex.encodeHexString(resultBytes));
			
			//解密
			cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);
			resultBytes = cipher.doFinal(resultBytes);
			System.out.println("jdk des decrypt : " + new String(resultBytes));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//jdk des encrypt : 719e81b53b891b1309b138c3e8c8a068cc6d476aaf51c288
		//jdk des decrypt : imooc security des

	}
	
}
