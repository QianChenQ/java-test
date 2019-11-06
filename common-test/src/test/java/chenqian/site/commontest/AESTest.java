package chenqian.site.commontest;

import org.junit.jupiter.api.Test;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * 功能简介:.
 *
 * @author cq
 * @version 1.0
 * *
 */
public class AESTest {

    @Test
    public void test() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        String data = "12312";
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey secretKey = keyGenerator.generateKey();
        SecretKeySpec key = new SecretKeySpec(secretKey.getEncoded(), "AES");
        System.out.println(parseByte2HexStr(key.getEncoded()));
        System.out.println(new String(Base64.getEncoder().encode(secretKey.getEncoded())));
        System.out.println(new String(secretKey.getEncoded(), StandardCharsets.US_ASCII));
        System.out.println(new String(Base64.getEncoder().encode(secretKey.getEncoded())));
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] bytes = cipher.doFinal(data.getBytes());
        String ciperStr = new String(Base64.getEncoder().encode(bytes));
        System.out.println(ciperStr);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] dataByte = cipher.doFinal(Base64.getDecoder().decode(ciperStr.getBytes()));
        System.out.println(new String(dataByte));
    }

    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }
}
