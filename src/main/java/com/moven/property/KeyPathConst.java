package com.moven.property;

import com.moven.utils.RSAEncoder;

/**
 * 引入公钥私钥证书的路径
 */
public class KeyPathConst {
	//证书路径
    private static String keyRoot = "/conf/others/";  
	//RSA加密证书
	public RSAEncoder keyPath() throws Exception {
		//公钥加密
        String publicKeyPath =  KeyPathConst.class.getResource(keyRoot + "rsa_public_key.pem").getPath();
        //公钥解密
        String privateKeyPath =  KeyPathConst.class.getResource(keyRoot + "pkcs8_private_key.pem").getPath(); 
        RSAEncoder rSAEncoder = new RSAEncoder(publicKeyPath, privateKeyPath);
        return rSAEncoder;
    }
	//IOS消息推送证书
	public String getCertificatePath() throws Exception{
		String certificatePath = KeyPathConst.class.getResource(keyRoot + "aps_production.p12").getPath();
		return certificatePath;
	}
	public String getCertificatePwd() throws Exception{
		return "123456";
	}
}