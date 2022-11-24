package io.github.emanuelmcp.productos.database.managers;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.github.emanuelmcp.productos.api.database.configuration.DBConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Configuration
public class PostgresManager extends DBConfig {

    private final HikariConfig hikariConfig = new HikariConfig();
    private HikariDataSource dataSource;
    @Bean
    public DataSource datasource() {
        return DataSourceBuilder.create()
                .driverClassName("org.postgresql.Driver")
                .url("jdbc:postgresql://localhost:5432/test_db")
                .username("root")
                .password("root")
                .build();
    }
    public void setupPool(){
        hikariConfig.setDataSource(datasource());
        hikariConfig.setMinimumIdle(3);
        hikariConfig.setMaximumPoolSize(10);
        hikariConfig.setConnectionTimeout(5000);
        hikariConfig.setJdbcUrl("jdbc:postgresql://localhost:5432/test_db");
        dataSource = new HikariDataSource(hikariConfig);
    }

    public void close(Connection conn, PreparedStatement ps, ResultSet res) {
        if (conn != null) try { conn.close(); } catch (SQLException ignored) {}
        if (ps != null) try { ps.close(); } catch (SQLException ignored) {}
        if (res != null) try { res.close(); } catch (SQLException ignored) {}
    }
    public void closePool() {
        if (dataSource != null && !dataSource.isClosed()) {
            dataSource.close();
        }
    }

    public Connection getConnection() throws SQLException {
        return datasource().getConnection();
    }
}
