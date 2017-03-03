package com.ani.sunny.feature.infrastructure.domain;

import com.ani.octopus.commons.stub.enumeration.PrivilegeType;
import com.ani.sunny.commons.share.persistence.AbstractEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by wyf on 17-3-1.
 */
@Entity
@Table(name = "t_device_feature")
public class FeatureDao extends AbstractEntity{
    private static final long serialVersionUID = 8025939205798572709L;

    @Column(name = "feature_Id", nullable = false, unique = true, length = 100)
    public String featureId;
    @Column(name = "feature_name", nullable = false, unique = true, length = 150)
    public String featureName;
    @Column(name = "description", length = 255)
    public String description;
    @Column(name = "privilegeType")
    public PrivilegeType privilegeType;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "device_feature_id", referencedColumnName = "id")
    public List<FeatureArgDao> featureArgDaoList;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "device_feature_id", referencedColumnName = "id")
    public List<FeatureFunctionDao> featureFunctionDaoList;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "device_feature_id", referencedColumnName = "id")
    public List<FeatureArgFunctionArgRelationDao> argRelationDaoList;

    public FeatureDao() {
    }

    public FeatureDao(String description,
                            List<FeatureArgDao> featureArgDaoList,
                            List<FeatureArgFunctionArgRelationDao> argRelationDaoList,
                            List<FeatureFunctionDao> featureFunctionDaoList,
                            String featureId, String featureName, PrivilegeType privilegeType) {
        this.description = description;
        this.featureArgDaoList = featureArgDaoList;
        this.argRelationDaoList = argRelationDaoList;
        this.featureFunctionDaoList = featureFunctionDaoList;
        this.featureId = featureId;
        this.featureName = featureName;
        this.privilegeType = privilegeType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        FeatureDao that = (FeatureDao) o;

        if (featureId != null ? !featureId.equals(that.featureId) : that.featureId != null) return false;
        return !(featureName != null ? !featureName.equals(that.featureName) : that.featureName != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (featureId != null ? featureId.hashCode() : 0);
        result = 31 * result + (featureName != null ? featureName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DeviceFeatureDao{" +
                "description='" + description + '\'' +
                ", featureId='" + featureId + '\'' +
                ", featureName='" + featureName + '\'' +
                '}';
    }
}
