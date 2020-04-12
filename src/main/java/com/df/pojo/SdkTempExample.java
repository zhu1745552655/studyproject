package com.df.pojo;

import java.util.ArrayList;
import java.util.List;

public class SdkTempExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SdkTempExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andActivityIdIsNull() {
            addCriterion("activity_id is null");
            return (Criteria) this;
        }

        public Criteria andActivityIdIsNotNull() {
            addCriterion("activity_id is not null");
            return (Criteria) this;
        }

        public Criteria andActivityIdEqualTo(Integer value) {
            addCriterion("activity_id =", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotEqualTo(Integer value) {
            addCriterion("activity_id <>", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThan(Integer value) {
            addCriterion("activity_id >", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("activity_id >=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThan(Integer value) {
            addCriterion("activity_id <", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThanOrEqualTo(Integer value) {
            addCriterion("activity_id <=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdIn(List<Integer> values) {
            addCriterion("activity_id in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotIn(List<Integer> values) {
            addCriterion("activity_id not in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdBetween(Integer value1, Integer value2) {
            addCriterion("activity_id between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("activity_id not between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andSdkPathIsNull() {
            addCriterion("sdk_path is null");
            return (Criteria) this;
        }

        public Criteria andSdkPathIsNotNull() {
            addCriterion("sdk_path is not null");
            return (Criteria) this;
        }

        public Criteria andSdkPathEqualTo(String value) {
            addCriterion("sdk_path =", value, "sdkPath");
            return (Criteria) this;
        }

        public Criteria andSdkPathNotEqualTo(String value) {
            addCriterion("sdk_path <>", value, "sdkPath");
            return (Criteria) this;
        }

        public Criteria andSdkPathGreaterThan(String value) {
            addCriterion("sdk_path >", value, "sdkPath");
            return (Criteria) this;
        }

        public Criteria andSdkPathGreaterThanOrEqualTo(String value) {
            addCriterion("sdk_path >=", value, "sdkPath");
            return (Criteria) this;
        }

        public Criteria andSdkPathLessThan(String value) {
            addCriterion("sdk_path <", value, "sdkPath");
            return (Criteria) this;
        }

        public Criteria andSdkPathLessThanOrEqualTo(String value) {
            addCriterion("sdk_path <=", value, "sdkPath");
            return (Criteria) this;
        }

        public Criteria andSdkPathLike(String value) {
            addCriterion("sdk_path like", value, "sdkPath");
            return (Criteria) this;
        }

        public Criteria andSdkPathNotLike(String value) {
            addCriterion("sdk_path not like", value, "sdkPath");
            return (Criteria) this;
        }

        public Criteria andSdkPathIn(List<String> values) {
            addCriterion("sdk_path in", values, "sdkPath");
            return (Criteria) this;
        }

        public Criteria andSdkPathNotIn(List<String> values) {
            addCriterion("sdk_path not in", values, "sdkPath");
            return (Criteria) this;
        }

        public Criteria andSdkPathBetween(String value1, String value2) {
            addCriterion("sdk_path between", value1, value2, "sdkPath");
            return (Criteria) this;
        }

        public Criteria andSdkPathNotBetween(String value1, String value2) {
            addCriterion("sdk_path not between", value1, value2, "sdkPath");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Long value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Long value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Long value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Long value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Long value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Long> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Long> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Long value1, Long value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Long value1, Long value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andSdkNameIsNull() {
            addCriterion("sdk_name is null");
            return (Criteria) this;
        }

        public Criteria andSdkNameIsNotNull() {
            addCriterion("sdk_name is not null");
            return (Criteria) this;
        }

        public Criteria andSdkNameEqualTo(String value) {
            addCriterion("sdk_name =", value, "sdkName");
            return (Criteria) this;
        }

        public Criteria andSdkNameNotEqualTo(String value) {
            addCriterion("sdk_name <>", value, "sdkName");
            return (Criteria) this;
        }

        public Criteria andSdkNameGreaterThan(String value) {
            addCriterion("sdk_name >", value, "sdkName");
            return (Criteria) this;
        }

        public Criteria andSdkNameGreaterThanOrEqualTo(String value) {
            addCriterion("sdk_name >=", value, "sdkName");
            return (Criteria) this;
        }

        public Criteria andSdkNameLessThan(String value) {
            addCriterion("sdk_name <", value, "sdkName");
            return (Criteria) this;
        }

        public Criteria andSdkNameLessThanOrEqualTo(String value) {
            addCriterion("sdk_name <=", value, "sdkName");
            return (Criteria) this;
        }

        public Criteria andSdkNameLike(String value) {
            addCriterion("sdk_name like", value, "sdkName");
            return (Criteria) this;
        }

        public Criteria andSdkNameNotLike(String value) {
            addCriterion("sdk_name not like", value, "sdkName");
            return (Criteria) this;
        }

        public Criteria andSdkNameIn(List<String> values) {
            addCriterion("sdk_name in", values, "sdkName");
            return (Criteria) this;
        }

        public Criteria andSdkNameNotIn(List<String> values) {
            addCriterion("sdk_name not in", values, "sdkName");
            return (Criteria) this;
        }

        public Criteria andSdkNameBetween(String value1, String value2) {
            addCriterion("sdk_name between", value1, value2, "sdkName");
            return (Criteria) this;
        }

        public Criteria andSdkNameNotBetween(String value1, String value2) {
            addCriterion("sdk_name not between", value1, value2, "sdkName");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}