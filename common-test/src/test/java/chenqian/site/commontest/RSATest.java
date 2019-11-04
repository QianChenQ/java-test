package chenqian.site.commontest;

import org.junit.jupiter.api.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.util.Base64;

/**
 * 功能简介:.
 *
 * @author cq
 * @version 1.0
 * *
 */
public class RSATest {

    String data = "hello word";

    @Test
    public void test() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("rsa");
        keyPairGenerator.initialize(1024);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        Cipher cipher = Cipher.getInstance("rsa");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] cipherData = cipher.doFinal(data.getBytes());
        String cipherStr = new String(Base64.getEncoder().encode(cipherData));
        System.out.println(cipherStr);

        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] data = cipher.doFinal(Base64.getDecoder().decode(cipherStr.getBytes()));
        System.out.println(new String(data));
    }
}
