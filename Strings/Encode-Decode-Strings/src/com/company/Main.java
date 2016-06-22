package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Codec codec = new Codec();
        List<String> list = Arrays.asList(new String[]{"63/Rc","h","BmI3FS~J9#vmk","7uBZ?7*/","24h+X","O "});
        List<String> result = codec.decode(codec.encode(list));
        System.out.print(list.equals(result));
    }
}
