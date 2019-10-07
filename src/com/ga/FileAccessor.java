package com.ga;

import java.io.IOException;

public interface FileAccessor {
    void accessFile(String fileName, Player player) throws IOException;
}
