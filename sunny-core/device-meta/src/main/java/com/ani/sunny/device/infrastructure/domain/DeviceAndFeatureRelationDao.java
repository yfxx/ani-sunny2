package com.ani.sunny.device.infrastructure.domain;

import com.ani.sunny.commons.share.persistence.AbstractEntity;
import com.ani.sunny.feature.infrastructure.domain.FeatureDao;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by wyf on 17-3-1.
 */
@Entity
@Table(
        name = "t_device_feature_relation",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"device_id","user_id"})})
public class DeviceAndFeatureRelationDao extends AbstractEntity{
    private static final long serialVersionUID = 1721893252759160221L;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "device_id", referencedColumnName = "id")
    public DeviceDao deviceDao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "feature_id", referencedColumnName = "feature_id")
    public FeatureDao featureDao;

    @JoinColumn(name = "state_tag")
    public String stateTag;

    public DeviceAndFeatureRelationDao(){}

    public DeviceAndFeatureRelationDao(DeviceDao deviceDao, FeatureDao featureDao, String stateTag){
        this.deviceDao = deviceDao;
        this.featureDao = featureDao;
        this.stateTag = stateTag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DeviceAndFeatureRelationDao that = (DeviceAndFeatureRelationDao) o;
        return Objects.equals(deviceDao.identificationCode, that.deviceDao.identificationCode)
                && featureDao.featureId.equals(that.featureDao.featureId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), deviceDao.identificationCode, featureDao.featureId);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
