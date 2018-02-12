package com.dyl.consts;

import java.util.concurrent.ForkJoinPool;

public class GlobalConsts {

    public static ForkJoinPool MULT_TABLE_FJPOOL = new ForkJoinPool(Runtime.getRuntime().availableProcessors());

    public final static String T_NAME_FACE_INFO = "t_face";
    public static final String INTELLIF_FACE = "intellif_face";
}
