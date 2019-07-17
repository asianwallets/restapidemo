package com.asianwallets.restapi.utils;

import org.apache.commons.codec.binary.Base64;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;

/**
 * @author BLUE
 * Functional Description: Implementation of the RSA tool class
 */
public class RSAUtils {

    // Digital signature, key algorithm
    private static final String RSA_KEY_ALGORITHM = "RSA";

    // Digital signature signature/verification algorithm
    private static final String SIGNATURE_ALGORITHM = "MD5withRSA";

    /**
     * digital signature
     *
     * @param data    Data to be signed
     * @param pri_key Private key
     * @return signature
     * @throws Exception Throw an exception
     */
    public static String sign(byte[] data, String pri_key) throws Exception {
        // Get the private key
        byte[] pri_key_bytes = Base64.decodeBase64(pri_key);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(pri_key_bytes);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_KEY_ALGORITHM);
        // Generate private key
        PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);
        // Instantiate Signature
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        // Initialize Signature
        signature.initSign(priKey);
        // Update
        signature.update(data);
        return Base64.encodeBase64String(signature.sign());
    }


}
