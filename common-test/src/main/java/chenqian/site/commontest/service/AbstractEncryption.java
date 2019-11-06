package chenqian.site.commontest.service;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.security.NoSuchAlgorithmException;

/**
 * 功能简介:.
 *
 * @author cq
 * @version 1.0
 * *
 */
public abstract class AbstractEncryption {

    public abstract String getPublicKey() throws NoSuchAlgorithmException;

    public abstract byte[] getPublicKeyBytes();

    public abstract String decryptFromBase64Str(String str) throws BadPaddingException, IllegalBlockSizeException;

    public abstract String encryptToBase64Str(String str) throws BadPaddingException, IllegalBlockSizeException;

    protected abstract void savePublicKey();

    protected abstract void savePrivateKey();
}
