package de.w11k.jsr308.examples;

import de.w11k.jsr308.checkers.fenum.Level;
import de.w11k.jsr308.checkers.fenum.State;

/**
 * Copyright 2016 Dragan Zuvic
 */
@SuppressWarnings("fenum:assignment.type.incompatible")
class FakeEnums {
    public static final @State int A1 = 1;
    public static final @State int A2 = 2;

    public static final @Level int B1 = -1;
}

class FakeEnumSample {
    @State int state = FakeEnums.A1;
    @Level  int level = FakeEnums.B1;

    void processState(@State int p) {
    }

    void demo() {
        state = FakeEnums.A2;
        processState(state);

        // rest don't compile
        state = 4;
        state = FakeEnums.B1;
        processState(5);
        processState(FakeEnums.B1);
    }
}


