package cn.javis.giada.customer.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public abstract class BasicQueryDao<T> {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<T> query(T params) {
        return jdbcTemplate.query(getSqlSentence(), bindParameter(params), mapRow());
    }

    protected abstract String getSqlSentence();

    protected abstract Map<String, Object> bindParameter(T params);

    protected abstract RowMapper<T> mapRow();
}
