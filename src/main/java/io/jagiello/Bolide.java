package io.jagiello;

public class Bolide {
    public static final int WIDTH = 3;
    public static final int HEIGHT = 4;

    public static char[][] BOLIDE = {
            { ' '   , 0x2588, ' '    },
            { 0x2593, 0x2588, 0x2593 },
            { ' '   , 0x2588, ' '    },
            { 0x2593, 0x2588, 0x2593 },
    };

    public static char[][] CRASH_BOLIDE_1 = {
            { ' ', 'X', ' ' },
            { 'X', ' ', 'X' },
            { ' ', 'X', ' ' },
            { 'X', ' ', 'X' },
    };

    public static char[][] CRASH_BOLIDE_2 = {
            { 'X', ' ', 'X' },
            { ' ', 'X', ' ' },
            { 'X', ' ', 'X' },
            { ' ', 'X', ' ' },
    };
}
