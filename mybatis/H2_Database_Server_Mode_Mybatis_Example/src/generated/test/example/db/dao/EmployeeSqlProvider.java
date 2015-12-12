package test.example.db.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import java.util.List;
import java.util.Map;
import test.example.model.Employee;
import test.example.model.EmployeeExample.Criteria;
import test.example.model.EmployeeExample.Criterion;
import test.example.model.EmployeeExample;

public class EmployeeSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table EMPLOYEE
     *
     * @mbggenerated Thu Oct 15 19:49:46 JST 2015
     */
    public String countByExample(EmployeeExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("EMPLOYEE");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table EMPLOYEE
     *
     * @mbggenerated Thu Oct 15 19:49:46 JST 2015
     */
    public String deleteByExample(EmployeeExample example) {
        BEGIN();
        DELETE_FROM("EMPLOYEE");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table EMPLOYEE
     *
     * @mbggenerated Thu Oct 15 19:49:46 JST 2015
     */
    public String insertSelective(Employee record) {
        BEGIN();
        INSERT_INTO("EMPLOYEE");
        
        if (record.getEmpname() != null) {
            VALUES("EMPNAME", "#{empname,jdbcType=VARCHAR}");
        }
        
        if (record.getOccupation() != null) {
            VALUES("OCCUPATION", "#{occupation,jdbcType=VARCHAR}");
        }
        
        if (record.getGender() != null) {
            VALUES("GENDER", "#{gender,jdbcType=VARCHAR}");
        }
        
        if (record.getDepartment() != null) {
            VALUES("DEPARTMENT", "#{department,jdbcType=VARCHAR}");
        }
        
        if (record.getDateofbirth() != null) {
            VALUES("DATEOFBIRTH", "#{dateofbirth,jdbcType=DATE}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table EMPLOYEE
     *
     * @mbggenerated Thu Oct 15 19:49:46 JST 2015
     */
    public String selectByExample(EmployeeExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("EMPID");
        } else {
            SELECT("EMPID");
        }
        SELECT("EMPNAME");
        SELECT("OCCUPATION");
        SELECT("GENDER");
        SELECT("DEPARTMENT");
        SELECT("DATEOFBIRTH");
        FROM("EMPLOYEE");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table EMPLOYEE
     *
     * @mbggenerated Thu Oct 15 19:49:46 JST 2015
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        Employee record = (Employee) parameter.get("record");
        EmployeeExample example = (EmployeeExample) parameter.get("example");
        
        BEGIN();
        UPDATE("EMPLOYEE");
        
        if (record.getEmpid() != null) {
            SET("EMPID = #{record.empid,jdbcType=INTEGER}");
        }
        
        if (record.getEmpname() != null) {
            SET("EMPNAME = #{record.empname,jdbcType=VARCHAR}");
        }
        
        if (record.getOccupation() != null) {
            SET("OCCUPATION = #{record.occupation,jdbcType=VARCHAR}");
        }
        
        if (record.getGender() != null) {
            SET("GENDER = #{record.gender,jdbcType=VARCHAR}");
        }
        
        if (record.getDepartment() != null) {
            SET("DEPARTMENT = #{record.department,jdbcType=VARCHAR}");
        }
        
        if (record.getDateofbirth() != null) {
            SET("DATEOFBIRTH = #{record.dateofbirth,jdbcType=DATE}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table EMPLOYEE
     *
     * @mbggenerated Thu Oct 15 19:49:46 JST 2015
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("EMPLOYEE");
        
        SET("EMPID = #{record.empid,jdbcType=INTEGER}");
        SET("EMPNAME = #{record.empname,jdbcType=VARCHAR}");
        SET("OCCUPATION = #{record.occupation,jdbcType=VARCHAR}");
        SET("GENDER = #{record.gender,jdbcType=VARCHAR}");
        SET("DEPARTMENT = #{record.department,jdbcType=VARCHAR}");
        SET("DATEOFBIRTH = #{record.dateofbirth,jdbcType=DATE}");
        
        EmployeeExample example = (EmployeeExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table EMPLOYEE
     *
     * @mbggenerated Thu Oct 15 19:49:46 JST 2015
     */
    public String updateByPrimaryKeySelective(Employee record) {
        BEGIN();
        UPDATE("EMPLOYEE");
        
        if (record.getEmpname() != null) {
            SET("EMPNAME = #{empname,jdbcType=VARCHAR}");
        }
        
        if (record.getOccupation() != null) {
            SET("OCCUPATION = #{occupation,jdbcType=VARCHAR}");
        }
        
        if (record.getGender() != null) {
            SET("GENDER = #{gender,jdbcType=VARCHAR}");
        }
        
        if (record.getDepartment() != null) {
            SET("DEPARTMENT = #{department,jdbcType=VARCHAR}");
        }
        
        if (record.getDateofbirth() != null) {
            SET("DATEOFBIRTH = #{dateofbirth,jdbcType=DATE}");
        }
        
        WHERE("EMPID = #{empid,jdbcType=INTEGER}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table EMPLOYEE
     *
     * @mbggenerated Thu Oct 15 19:49:46 JST 2015
     */
    protected void applyWhere(EmployeeExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}