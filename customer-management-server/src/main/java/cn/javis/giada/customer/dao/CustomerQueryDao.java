package cn.javis.giada.customer.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.javis.giada.customer.model.Customer;
import cn.javis.giada.customer.model.Customer.Gender;

@Repository
public class CustomerQueryDao extends BasicQueryDao<Customer> {

    @Override
    protected String getSqlSentence() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT id, name, gender,age");
        sql.append("  FROM customer");
        sql.append("  WHERE");
        sql.append("  id = :id");
        return sql.toString();
    }

    @Override
    protected Map<String, Object> bindParameter(Customer params) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("id", params.getId());
        return parameters;
    }

    @Override
    protected RowMapper<Customer> mapRow() {
        return new RowMapper<Customer>() {
            public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                Customer customer = new Customer();
                customer.setId(rs.getString("id"));
                customer.setName(rs.getString("name"));
                customer.setGender(Gender.valueOf(rs.getString("gender")));
                customer.setAge(rs.getInt("age"));
                return customer;
            }
        };
    }

}
