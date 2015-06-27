package cn.javis.apms.server.helper.crypt;

import java.time.LocalTime;
import java.util.Random;

import cn.javis.apms.common.helper.StringHelper;

public final class RandomTokenGenerator {
    public static String generate() {
        Random random = new Random(LocalTime.now().toNanoOfDay());
        String randomNumber = String.valueOf(random.nextLong());
        return StringHelper.toMd5(randomNumber);
    }
}
