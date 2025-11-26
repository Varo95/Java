package io.videoclub.model.interfaces;

import java.io.Serial;
import java.io.Serializable;

public interface IStorage<T> extends Serializable, Comparable<T> {
    @Serial
    long serialVersionUID = 1L;
    String getId();
}
