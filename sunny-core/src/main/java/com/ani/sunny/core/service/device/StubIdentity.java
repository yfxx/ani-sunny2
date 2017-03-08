package com.ani.sunny.core.service.device;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by lihui on 17-3-8.
 */
public class StubIdentity implements Serializable{
    public Integer stubId;
    public Long groupId;

    public StubIdentity() {
    }

    public StubIdentity(Integer stubId, Long groupId) {
        this.stubId = stubId;
        this.groupId = groupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StubIdentity that = (StubIdentity) o;
        return Objects.equals(stubId, that.stubId) &&
                Objects.equals(groupId, that.groupId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stubId, groupId);
    }

    @Override
    public String toString() {
        return "StubIdentity{" +
                "stubId=" + stubId +
                ", groupId=" + groupId +
                '}';
    }
}
