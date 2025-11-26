package io.videoclub.model.interfaces;

import java.time.LocalDateTime;

public interface IClient extends IStorage<IClient> {
    String getId();  //is UNIQUE in SYSTEM
    String getName();
    LocalDateTime getTime();
    String getPhone();
    void setName(final String name);
    void setTime(final LocalDateTime t);
    void setPhone(final String phone);
}