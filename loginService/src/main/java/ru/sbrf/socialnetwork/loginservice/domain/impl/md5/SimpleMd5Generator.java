package ru.sbrf.socialnetwork.loginservice.domain.impl.md5;

import ru.sbrf.socialnetwork.loginservice.domain.Md5Generator;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

/**
 * Created by Ivan on 01/12/2016.
 */
public class SimpleMd5Generator implements Md5Generator {
    @Override
    public String generate(String value) {
        Objects.requireNonNull(value);

        String md5 = null;

        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(value.getBytes(), 0, value.length());
            md5 = new BigInteger(1, digest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return md5;
    }
}
