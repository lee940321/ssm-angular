package app.op.model;

import java.util.ArrayList;
import java.util.List;

public class OptExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OptExample() {
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

        public Criteria andFhIsNull() {
            addCriterion("fh is null");
            return (Criteria) this;
        }

        public Criteria andFhIsNotNull() {
            addCriterion("fh is not null");
            return (Criteria) this;
        }

        public Criteria andFhEqualTo(Double value) {
            addCriterion("fh =", value, "fh");
            return (Criteria) this;
        }

        public Criteria andFhNotEqualTo(Double value) {
            addCriterion("fh <>", value, "fh");
            return (Criteria) this;
        }

        public Criteria andFhGreaterThan(Double value) {
            addCriterion("fh >", value, "fh");
            return (Criteria) this;
        }

        public Criteria andFhGreaterThanOrEqualTo(Double value) {
            addCriterion("fh >=", value, "fh");
            return (Criteria) this;
        }

        public Criteria andFhLessThan(Double value) {
            addCriterion("fh <", value, "fh");
            return (Criteria) this;
        }

        public Criteria andFhLessThanOrEqualTo(Double value) {
            addCriterion("fh <=", value, "fh");
            return (Criteria) this;
        }

        public Criteria andFhIn(List<Double> values) {
            addCriterion("fh in", values, "fh");
            return (Criteria) this;
        }

        public Criteria andFhNotIn(List<Double> values) {
            addCriterion("fh not in", values, "fh");
            return (Criteria) this;
        }

        public Criteria andFhBetween(Double value1, Double value2) {
            addCriterion("fh between", value1, value2, "fh");
            return (Criteria) this;
        }

        public Criteria andFhNotBetween(Double value1, Double value2) {
            addCriterion("fh not between", value1, value2, "fh");
            return (Criteria) this;
        }

        public Criteria andYqlIsNull() {
            addCriterion("yql is null");
            return (Criteria) this;
        }

        public Criteria andYqlIsNotNull() {
            addCriterion("yql is not null");
            return (Criteria) this;
        }

        public Criteria andYqlEqualTo(Double value) {
            addCriterion("yql =", value, "yql");
            return (Criteria) this;
        }

        public Criteria andYqlNotEqualTo(Double value) {
            addCriterion("yql <>", value, "yql");
            return (Criteria) this;
        }

        public Criteria andYqlGreaterThan(Double value) {
            addCriterion("yql >", value, "yql");
            return (Criteria) this;
        }

        public Criteria andYqlGreaterThanOrEqualTo(Double value) {
            addCriterion("yql >=", value, "yql");
            return (Criteria) this;
        }

        public Criteria andYqlLessThan(Double value) {
            addCriterion("yql <", value, "yql");
            return (Criteria) this;
        }

        public Criteria andYqlLessThanOrEqualTo(Double value) {
            addCriterion("yql <=", value, "yql");
            return (Criteria) this;
        }

        public Criteria andYqlIn(List<Double> values) {
            addCriterion("yql in", values, "yql");
            return (Criteria) this;
        }

        public Criteria andYqlNotIn(List<Double> values) {
            addCriterion("yql not in", values, "yql");
            return (Criteria) this;
        }

        public Criteria andYqlBetween(Double value1, Double value2) {
            addCriterion("yql between", value1, value2, "yql");
            return (Criteria) this;
        }

        public Criteria andYqlNotBetween(Double value1, Double value2) {
            addCriterion("yql not between", value1, value2, "yql");
            return (Criteria) this;
        }

        public Criteria andShsIsNull() {
            addCriterion("shs is null");
            return (Criteria) this;
        }

        public Criteria andShsIsNotNull() {
            addCriterion("shs is not null");
            return (Criteria) this;
        }

        public Criteria andShsEqualTo(Double value) {
            addCriterion("shs =", value, "shs");
            return (Criteria) this;
        }

        public Criteria andShsNotEqualTo(Double value) {
            addCriterion("shs <>", value, "shs");
            return (Criteria) this;
        }

        public Criteria andShsGreaterThan(Double value) {
            addCriterion("shs >", value, "shs");
            return (Criteria) this;
        }

        public Criteria andShsGreaterThanOrEqualTo(Double value) {
            addCriterion("shs >=", value, "shs");
            return (Criteria) this;
        }

        public Criteria andShsLessThan(Double value) {
            addCriterion("shs <", value, "shs");
            return (Criteria) this;
        }

        public Criteria andShsLessThanOrEqualTo(Double value) {
            addCriterion("shs <=", value, "shs");
            return (Criteria) this;
        }

        public Criteria andShsIn(List<Double> values) {
            addCriterion("shs in", values, "shs");
            return (Criteria) this;
        }

        public Criteria andShsNotIn(List<Double> values) {
            addCriterion("shs not in", values, "shs");
            return (Criteria) this;
        }

        public Criteria andShsBetween(Double value1, Double value2) {
            addCriterion("shs between", value1, value2, "shs");
            return (Criteria) this;
        }

        public Criteria andShsNotBetween(Double value1, Double value2) {
            addCriterion("shs not between", value1, value2, "shs");
            return (Criteria) this;
        }

        public Criteria andPhIsNull() {
            addCriterion("ph is null");
            return (Criteria) this;
        }

        public Criteria andPhIsNotNull() {
            addCriterion("ph is not null");
            return (Criteria) this;
        }

        public Criteria andPhEqualTo(Double value) {
            addCriterion("ph =", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhNotEqualTo(Double value) {
            addCriterion("ph <>", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhGreaterThan(Double value) {
            addCriterion("ph >", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhGreaterThanOrEqualTo(Double value) {
            addCriterion("ph >=", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhLessThan(Double value) {
            addCriterion("ph <", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhLessThanOrEqualTo(Double value) {
            addCriterion("ph <=", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhIn(List<Double> values) {
            addCriterion("ph in", values, "ph");
            return (Criteria) this;
        }

        public Criteria andPhNotIn(List<Double> values) {
            addCriterion("ph not in", values, "ph");
            return (Criteria) this;
        }

        public Criteria andPhBetween(Double value1, Double value2) {
            addCriterion("ph between", value1, value2, "ph");
            return (Criteria) this;
        }

        public Criteria andPhNotBetween(Double value1, Double value2) {
            addCriterion("ph not between", value1, value2, "ph");
            return (Criteria) this;
        }

        public Criteria andInso2IsNull() {
            addCriterion("inSo2 is null");
            return (Criteria) this;
        }

        public Criteria andInso2IsNotNull() {
            addCriterion("inSo2 is not null");
            return (Criteria) this;
        }

        public Criteria andInso2EqualTo(Double value) {
            addCriterion("inSo2 =", value, "inso2");
            return (Criteria) this;
        }

        public Criteria andInso2NotEqualTo(Double value) {
            addCriterion("inSo2 <>", value, "inso2");
            return (Criteria) this;
        }

        public Criteria andInso2GreaterThan(Double value) {
            addCriterion("inSo2 >", value, "inso2");
            return (Criteria) this;
        }

        public Criteria andInso2GreaterThanOrEqualTo(Double value) {
            addCriterion("inSo2 >=", value, "inso2");
            return (Criteria) this;
        }

        public Criteria andInso2LessThan(Double value) {
            addCriterion("inSo2 <", value, "inso2");
            return (Criteria) this;
        }

        public Criteria andInso2LessThanOrEqualTo(Double value) {
            addCriterion("inSo2 <=", value, "inso2");
            return (Criteria) this;
        }

        public Criteria andInso2In(List<Double> values) {
            addCriterion("inSo2 in", values, "inso2");
            return (Criteria) this;
        }

        public Criteria andInso2NotIn(List<Double> values) {
            addCriterion("inSo2 not in", values, "inso2");
            return (Criteria) this;
        }

        public Criteria andInso2Between(Double value1, Double value2) {
            addCriterion("inSo2 between", value1, value2, "inso2");
            return (Criteria) this;
        }

        public Criteria andInso2NotBetween(Double value1, Double value2) {
            addCriterion("inSo2 not between", value1, value2, "inso2");
            return (Criteria) this;
        }

        public Criteria andOutso2IsNull() {
            addCriterion("outSo2 is null");
            return (Criteria) this;
        }

        public Criteria andOutso2IsNotNull() {
            addCriterion("outSo2 is not null");
            return (Criteria) this;
        }

        public Criteria andOutso2EqualTo(Double value) {
            addCriterion("outSo2 =", value, "outso2");
            return (Criteria) this;
        }

        public Criteria andOutso2NotEqualTo(Double value) {
            addCriterion("outSo2 <>", value, "outso2");
            return (Criteria) this;
        }

        public Criteria andOutso2GreaterThan(Double value) {
            addCriterion("outSo2 >", value, "outso2");
            return (Criteria) this;
        }

        public Criteria andOutso2GreaterThanOrEqualTo(Double value) {
            addCriterion("outSo2 >=", value, "outso2");
            return (Criteria) this;
        }

        public Criteria andOutso2LessThan(Double value) {
            addCriterion("outSo2 <", value, "outso2");
            return (Criteria) this;
        }

        public Criteria andOutso2LessThanOrEqualTo(Double value) {
            addCriterion("outSo2 <=", value, "outso2");
            return (Criteria) this;
        }

        public Criteria andOutso2In(List<Double> values) {
            addCriterion("outSo2 in", values, "outso2");
            return (Criteria) this;
        }

        public Criteria andOutso2NotIn(List<Double> values) {
            addCriterion("outSo2 not in", values, "outso2");
            return (Criteria) this;
        }

        public Criteria andOutso2Between(Double value1, Double value2) {
            addCriterion("outSo2 between", value1, value2, "outso2");
            return (Criteria) this;
        }

        public Criteria andOutso2NotBetween(Double value1, Double value2) {
            addCriterion("outSo2 not between", value1, value2, "outso2");
            return (Criteria) this;
        }

        public Criteria andXlIsNull() {
            addCriterion("xl is null");
            return (Criteria) this;
        }

        public Criteria andXlIsNotNull() {
            addCriterion("xl is not null");
            return (Criteria) this;
        }

        public Criteria andXlEqualTo(Double value) {
            addCriterion("xl =", value, "xl");
            return (Criteria) this;
        }

        public Criteria andXlNotEqualTo(Double value) {
            addCriterion("xl <>", value, "xl");
            return (Criteria) this;
        }

        public Criteria andXlGreaterThan(Double value) {
            addCriterion("xl >", value, "xl");
            return (Criteria) this;
        }

        public Criteria andXlGreaterThanOrEqualTo(Double value) {
            addCriterion("xl >=", value, "xl");
            return (Criteria) this;
        }

        public Criteria andXlLessThan(Double value) {
            addCriterion("xl <", value, "xl");
            return (Criteria) this;
        }

        public Criteria andXlLessThanOrEqualTo(Double value) {
            addCriterion("xl <=", value, "xl");
            return (Criteria) this;
        }

        public Criteria andXlIn(List<Double> values) {
            addCriterion("xl in", values, "xl");
            return (Criteria) this;
        }

        public Criteria andXlNotIn(List<Double> values) {
            addCriterion("xl not in", values, "xl");
            return (Criteria) this;
        }

        public Criteria andXlBetween(Double value1, Double value2) {
            addCriterion("xl between", value1, value2, "xl");
            return (Criteria) this;
        }

        public Criteria andXlNotBetween(Double value1, Double value2) {
            addCriterion("xl not between", value1, value2, "xl");
            return (Criteria) this;
        }

        public Criteria andXllIsNull() {
            addCriterion("xll is null");
            return (Criteria) this;
        }

        public Criteria andXllIsNotNull() {
            addCriterion("xll is not null");
            return (Criteria) this;
        }

        public Criteria andXllEqualTo(Double value) {
            addCriterion("xll =", value, "xll");
            return (Criteria) this;
        }

        public Criteria andXllNotEqualTo(Double value) {
            addCriterion("xll <>", value, "xll");
            return (Criteria) this;
        }

        public Criteria andXllGreaterThan(Double value) {
            addCriterion("xll >", value, "xll");
            return (Criteria) this;
        }

        public Criteria andXllGreaterThanOrEqualTo(Double value) {
            addCriterion("xll >=", value, "xll");
            return (Criteria) this;
        }

        public Criteria andXllLessThan(Double value) {
            addCriterion("xll <", value, "xll");
            return (Criteria) this;
        }

        public Criteria andXllLessThanOrEqualTo(Double value) {
            addCriterion("xll <=", value, "xll");
            return (Criteria) this;
        }

        public Criteria andXllIn(List<Double> values) {
            addCriterion("xll in", values, "xll");
            return (Criteria) this;
        }

        public Criteria andXllNotIn(List<Double> values) {
            addCriterion("xll not in", values, "xll");
            return (Criteria) this;
        }

        public Criteria andXllBetween(Double value1, Double value2) {
            addCriterion("xll between", value1, value2, "xll");
            return (Criteria) this;
        }

        public Criteria andXllNotBetween(Double value1, Double value2) {
            addCriterion("xll not between", value1, value2, "xll");
            return (Criteria) this;
        }

        public Criteria andCountIsNull() {
            addCriterion("count is null");
            return (Criteria) this;
        }

        public Criteria andCountIsNotNull() {
            addCriterion("count is not null");
            return (Criteria) this;
        }

        public Criteria andCountEqualTo(Integer value) {
            addCriterion("count =", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotEqualTo(Integer value) {
            addCriterion("count <>", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThan(Integer value) {
            addCriterion("count >", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("count >=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThan(Integer value) {
            addCriterion("count <", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThanOrEqualTo(Integer value) {
            addCriterion("count <=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountIn(List<Integer> values) {
            addCriterion("count in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotIn(List<Integer> values) {
            addCriterion("count not in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountBetween(Integer value1, Integer value2) {
            addCriterion("count between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotBetween(Integer value1, Integer value2) {
            addCriterion("count not between", value1, value2, "count");
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