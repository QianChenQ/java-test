package chenqian.site.commontest.controller.encryption;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

/**
 * 功能简介:.
 *
 * @author cq
 * @version 1.0
 * *
 */
@RestController
@RequestMapping("/rsa")
public class RSAController {

    private String privateKey;

    @GetMapping
    public String getPublicKey() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("rsa");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        privateKey = new String(Base64.getEncoder().encode(keyPair.getPrivate().getEncoded()));
        return new String(Base64.getEncoder().encode(publicKey.getEncoded()));
    }


    @PostMapping
    public String decode(String password) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher rsa = Cipher.getInstance("rsa");
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey.getBytes()));
        KeyFactory keyFactory = KeyFactory.getInstance("rsa");
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        rsa.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] bytes = rsa.doFinal(Base64.getDecoder().decode(password.getBytes()));
        return new String(bytes);
    }
}
