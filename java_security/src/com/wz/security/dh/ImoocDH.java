package com.wz.security.dh;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Objects;

import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;

import org.apache.commons.codec.binary.Base64;

import com.sun.org.apache.regexp.internal.REUtil;

import sun.print.resources.serviceui;

public class ImoocDH {

	private static String src = "imooc security dh";
	
	public static void main(String[] args) {

		jdkDH();
		
	}

	
	public static void jdkDH() {
		try {
			//初始化发送方密钥
			KeyPairGenerator senderKeyPairGenerator = KeyPairGenerator.getInstance("DH");
			senderKeyPairGenerator.initialize(512);
			KeyPair senderKeyPair = senderKeyPairGenerator.generateKeyPair();
			//发送方公钥，发送给接收方（网络、文件）
			byte[] senderPublicKeyEnc = senderKeyPair.getPublic().getEncoded();
			
			//初始化接收方密钥
			KeyFactory receiveKeyFactory = KeyFactory.getInstance("DH");
			X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(senderPublicKeyEnc);
			PublicKey receivePublicKey = receiveKeyFactory.generatePublic(x509EncodedKeySpec);
			DHParameterSpec dhParameterSpec = ((DHPublicKey)receivePublicKey).getParams();
			KeyPairGenerator receiveKeyPairGenerator = KeyPairGenerator.getInstance("DH");
			receiveKeyPairGenerator.initialize(dhParameterSpec);
			KeyPair receiveKeyPair = receiveKeyPairGenerator.generateKeyPair();
			PrivateKey receivePrivateKey = receiveKeyPair.getPrivate();
			byte[] receiverPublicKeyEnc = receiveKeyPair.getPublic().getEncoded();
			
			//密钥构建
			KeyAgreement receiveKeyAgreement = KeyAgreement.getInstance("DH");
			receiveKeyAgreement.init(receivePrivateKey);
			receiveKeyAgreement.doPhase(receivePublicKey, true);
			SecretKey receiverDESKey = receiveKeyAgreement.generateSecret("DES");
			
			KeyFactory senderKeyFactory = KeyFactory.getInstance("DH");
			x509EncodedKeySpec = new X509EncodedKeySpec(receiverPublicKeyEnc);
			PublicKey senderPublicKey = senderKeyFactory.generatePublic(x509EncodedKeySpec);
			KeyAgreement senderKeyAgreement = KeyAgreement.getInstance("DH");
			senderKeyAgreement.init(senderKeyPair.getPrivate());
			senderKeyAgreement.doPhase(senderPublicKey, true);
			
			SecretKey senderDESKey = senderKeyAgreement.generateSecret("DES");
			if (Objects.equals(receiverDESKey, senderDESKey)) {
				System.out.println("双方密钥相同");
			}
			
			//加密和解密
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, senderDESKey);
			byte[] result = cipher.doFinal(src.getBytes());
			System.out.println("jdk dh encrypt : " + Base64.encodeBase64String(result));
			
			cipher.init(Cipher.DECRYPT_MODE, receiverDESKey);
			result = cipher.doFinal(result);
			System.out.println("jdk dh decrypt : " + new String(result));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
