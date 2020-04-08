package chenqian.site.commontest.service;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.FileWriter;
import java.io.IOException;
import java.security.*;
import java.util.Base64;

/**
 * 功能简介:.
 *
 * @author cq
 * @version 1.0
 * *
 */
@SuppressWarnings("DuplicatedCode")
@Slf4j
public class RSAEncryption extends AbstractEncryption {

    private PrivateKey privateKey;

    private PublicKey publicKey;

    private static final String ALGORITHM = "rsa";

    public RSAEncryption() {
        KeyPairGenerator keyPairGenerator;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("获取生成加密密钥出现异常，请及时处理");
        }
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        publicKey = keyPair.getPublic();
        privateKey = keyPair.getPrivate();
        savePublicKey();
        savePrivateKey();
    }

    @Override
    public String getPublicKey() {
        return Base64.getEncoder().encodeToString(publicKey.getEncoded());
    }

    @Override
    public byte[] getPublicKeyBytes() {
        return publicKey.getEncoded();
    }

    @Override
    public String decryptFromBase64Str(String str) throws BadPaddingException, IllegalBlockSizeException {
        Cipher cipher;
        try {
            cipher = Cipher.getInstance(ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("加密算法不存在，请检查");
        } catch (NoSuchPaddingException e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("填充方式不存在，请检查");
        }
        try {
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
        } catch (InvalidKeyException e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("秘钥存在异常，请检查系统生成秘钥与秘钥的保存是否正常");
        }
        byte[] cipherData = cipher.doFinal(Base64.getDecoder().decode(str.getBytes()));
        return new String(cipherData);
    }

    @Override
    public String encryptToBase64Str(String str) throws BadPaddingException, IllegalBlockSizeException {
        Cipher cipher;
        try {
            cipher = Cipher.getInstance(ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("加密算法不存在，请检查");
        } catch (NoSuchPaddingException e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("填充方式不存在，请检查");
        }

        try {
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        } catch (InvalidKeyException e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("秘钥存在异常，请检查系统生成秘钥与秘钥的保存是否正常");
        }
        byte[] cipherData = cipher.doFinal(Base64.getDecoder().decode(str.getBytes()));
        return Base64.getEncoder().encodeToString(cipherData);
    }

    @Override
    protected void savePublicKey() {
        try (FileWriter fileWriter = new FileWriter("publicKey")) {
            fileWriter.write(Base64.getEncoder().encodeToString(this.publicKey.getEncoded()));
        } catch (IOException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    protected void savePrivateKey() {
        try (FileWriter fileWriter = new FileWriter("privateKey")) {
            fileWriter.write(Base64.getEncoder().encodeToString(this.privateKey.getEncoded()));
        } catch (IOException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }
}
