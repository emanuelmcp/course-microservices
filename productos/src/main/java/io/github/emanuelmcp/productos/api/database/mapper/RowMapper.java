package io.github.emanuelmcp.productos.api.database.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper <T>{
    T mapRowReader(ResultSet rs) throws SQLException;
}
