package com.whole.night.utils;

import java.util.Random;

/*该方法用于随机获取一张头像图片*/
public class RandomAvatar {

    /*调用该方法时需传入url并将不确定的变量替换为VARIATE*/
    public static String randomAvatar(String url , Integer apex){
        Random random = new Random();
        int variate = random.nextInt(apex);
        String avatarUrl = url.replace("VARIATE", String.valueOf(variate));
        return avatarUrl;
    }

}
