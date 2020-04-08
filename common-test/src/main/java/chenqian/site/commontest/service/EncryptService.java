package chenqian.site.commontest.service;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

/**
 * 功能简介:.
 *
 * @author cq
 * @version 1.0
 * *
 */
public interface EncryptService {

    String getPublicKey() throws NoSuchAlgorithmException;

    byte[] getPublicKeyBytes();

    String decryptFromBase64Str(String str) throws BadPaddingException, IllegalBlockSizeException;

    String encryptToBase64Str(String str) throws NoSuchPaddingException, NoSuchAlgorithmException;

}
