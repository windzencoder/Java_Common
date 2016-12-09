package com.wz.security.sha;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class ImoocSHA {

	private static String src = "imooc security sha";
	
	public static void main(String[] args) {
		
		jdkSHA1();
		bcSHA1();
		bcSHA224();
		bcSHA224_Provider();
		ccSHA1();
		
	}
	
	
	public static void ccSHA1(){
		System.out.println("cc SHA1 : " + DigestUtils.sha1Hex(src));
		//cc SHA1 : 8bb95fe138f7e9d993dd90bae339a45e56b72eb7
	}
	
	public static void  bcSHA224_Provider() {
		
		try {
			Security.addProvider(new BouncyCastleProvider());
			MessageDigest md = MessageDigest.getInstance("SHA224");
			byte[] sha224Bytes = md.digest(src.getBytes());
			System.out.println("SHA224Bytes Provider : " + Hex.encodeHexString(sha224Bytes));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//SHA224Bytes Provider : 0b71cc6f590e1d026c922a99081a14e2c58818f4047dae6db3cf3d67


	}
	
	public static void bcSHA224() {
		Digest digest = new SHA224Digest();
		digest.update(src.getBytes(), 0, src.getBytes().length);
		byte[] sha224Bytes = new byte[digest.getDigestSize()];
		digest.doFinal(sha224Bytes, 0);
		System.out.println("bc sha-224 : " + org.bouncycastle.util.encoders.Hex.toHexString(sha224Bytes));
		
		//bc sha-224 : 0b71cc6f590e1d026c922a99081a14e2c58818f4047dae6db3cf3d67
	}
	
	public static void bcSHA1() {
		Digest digest = new SHA1Digest();
		digest.update(src.getBytes(), 0, src.getBytes().length);
		byte[] sha1Bytes = new byte[digest.getDigestSize()];
		digest.doFinal(sha1Bytes, 0);
		System.out.println("bc sha-1 : " + org.bouncycastle.util.encoders.Hex.toHexString(sha1Bytes));
		
		//bc sha-1 : 8bb95fe138f7e9d993dd90bae339a45e56b72eb7

	}
	
	
	public static void jdkSHA1() {
		try {
			MessageDigest md =MessageDigest.getInstance("SHA");
			md.update(src.getBytes());
			System.out.println("jdk sha-1 : " + Hex.encodeHexString(md.digest()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		//jdk sha-1 : 8bb95fe138f7e9d993dd90bae339a45e56b72eb7
	}
	
}
