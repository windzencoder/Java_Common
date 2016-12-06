package com.wz.security.md;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD4Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class ImoocMD {

	private static String src = "imooc security md";
	
	public static void main(String[] args) {
			
		jdkMD5();
		jdkMD2();
		bcMD4();
		bcMD5();
		bcMD4_provider();
		ccMD2();
		ccMD5();
		
	}
	
	public static void jdkMD5() {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] md5Bytes = md.digest(src.getBytes());
			System.out.println("JDK MD5 : " + Hex.encodeHexString(md5Bytes));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		//JDK MD2 : 54ade03d9765c9f0290189a2ae704ee7
	}
	
	public static void jdkMD2() {
		try {
			MessageDigest md = MessageDigest.getInstance("MD2");
			byte[] md2Bytes = md.digest(src.getBytes());
			System.out.println("JDK MD2 : " + Hex.encodeHexString(md2Bytes));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		//JDK MD2 : 54ade03d9765c9f0290189a2ae704ee7
	}
	
	/**
	 * bc MD4
	 */
	public static void bcMD4() {
		Digest digest = new MD4Digest();
		/**
		 * 	第一个参数表示处理的内容
		 *  第二个参数表示开始位置
		 *  第三个参数表示长度
		 */
		digest.update(src.getBytes(), 0, src.getBytes().length);
		/**
		 * 第一个参数是进行摘要处理输出的内容
		 * 第二个参数是输出的偏移量
		 */
		byte[] md4Bytes = new byte[digest.getDigestSize()];
		digest.doFinal(md4Bytes, 0);
		//转成16进制输出
		System.out.println("BC MD4 : " + org.bouncycastle.util.encoders.Hex.toHexString(md4Bytes));
	}
	
	
	/**
	 * bc MD4 provider
	 */
	public static void bcMD4_provider() {
		try {
			//通过此种方式给jdk动态的添加一个provider
			Security.addProvider(new BouncyCastleProvider());
			MessageDigest md = MessageDigest.getInstance("MD4");
			byte[] md4Bytes = md.digest(src.getBytes());
			System.out.println("BC MD4 Provider : " + Hex.encodeHexString(md4Bytes));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * bc MD5
	 */
	public static void bcMD5(){
		Digest digest = new MD5Digest();
	
		digest.update(src.getBytes(), 0, src.getBytes().length);

		byte[] md5Bytes = new byte[digest.getDigestSize()];
		digest.doFinal(md5Bytes, 0);
		
		System.out.println("BC MD5 : " + org.bouncycastle.util.encoders.Hex.toHexString(md5Bytes));
		//BC MD5 : 89048f19b72e7367b7faacfe659a8de0
		
	}
	
	/**
	 * cc md5
	 */
	public static void ccMD5() {
		
		System.out.println("cc MD5 : " + DigestUtils.md5Hex(src.getBytes())); 
		
	}
	
	/**
	 * cc md2
	 */
	public static void ccMD2() {
		
		System.out.println("cc MD2 : " + DigestUtils.md2Hex(src.getBytes())); 
		
	}

}
