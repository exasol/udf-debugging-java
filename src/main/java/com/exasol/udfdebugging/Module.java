package com.exasol.udfdebugging;

import java.util.stream.Stream;

public interface Module {

    public Stream<String> getJvmOptions();
}
