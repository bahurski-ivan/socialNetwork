package ru.sbrf.socialnetwork.loginservice.domain.impl.md5;

import ru.sbrf.socialnetwork.loginservice.domain.Md5Generator;

/**
 * Created by Ivan on 01/12/2016.
 */
public class SimpleSaltMd5Generator implements Md5Generator {
    private static final String SALT = "2946bV3zH15WHE7vxcFgeloydlT14LaiLE2s*h0XSvz3uxl#b3P4b@V05$cbLTTP";
    private final SimpleMd5Generator generator = new SimpleMd5Generator();

    @Override
    public String generate(String value) {
        return generator.generate(value + SALT);
    }
}
