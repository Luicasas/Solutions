package com.example.game;

import java.util.*;

public interface ISaveable {
    List<String> write();

    void read(List<String> savedValues);
}
