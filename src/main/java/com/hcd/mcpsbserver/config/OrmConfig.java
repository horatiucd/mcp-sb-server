package com.hcd.mcpsbserver.config;

import com.asentinel.common.jdbc.SqlQuery;
import com.asentinel.common.jdbc.SqlQueryTemplate;
import com.asentinel.common.jdbc.flavors.JdbcFlavor;
import com.asentinel.common.jdbc.flavors.postgres.PgEchoingJdbcTemplate;
import com.asentinel.common.jdbc.flavors.postgres.PostgresJdbcFlavor;
import com.asentinel.common.orm.OrmOperations;
import com.asentinel.common.orm.OrmTemplate;
import com.asentinel.common.orm.ed.tree.DefaultEntityDescriptorTreeRepository;
import com.asentinel.common.orm.ed.tree.EntityDescriptorTreeRepository;
import com.asentinel.common.orm.jql.DefaultSqlBuilderFactory;
import com.asentinel.common.orm.jql.SqlBuilderFactory;
import com.asentinel.common.orm.persist.SimpleUpdater;
import com.asentinel.common.orm.query.DefaultSqlFactory;
import com.asentinel.common.orm.query.SqlFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcOperations;

import javax.sql.DataSource;

@Configuration
public class OrmConfig {

    @Bean
    public JdbcFlavor jdbcFlavor() {
        return new PostgresJdbcFlavor();
    }

    @Bean
    public JdbcOperations jdbcOperations(DataSource dataSource,
                                         JdbcFlavor jdbcFlavor) {
        PgEchoingJdbcTemplate template =  new PgEchoingJdbcTemplate(dataSource);
        template.setJdbcFlavor(jdbcFlavor);
        return template;
    }

    @Bean
    public SqlQuery sqlQuery(JdbcFlavor jdbcFlavor,
                             JdbcOperations jdbcOps) {
        return new SqlQueryTemplate(jdbcFlavor, jdbcOps);
    }

    @Bean
    public SqlFactory sqlFactory(JdbcFlavor jdbcFlavor) {
        return new DefaultSqlFactory(jdbcFlavor);
    }

    @Bean
    public DefaultEntityDescriptorTreeRepository entityDescriptorTreeRepository(SqlBuilderFactory sqlBuilderFactory) {
        DefaultEntityDescriptorTreeRepository treeRepository = new DefaultEntityDescriptorTreeRepository();
        treeRepository.setSqlBuilderFactory(sqlBuilderFactory);
        return treeRepository;
    }

    @Bean
    public DefaultSqlBuilderFactory sqlBuilderFactory(@Lazy EntityDescriptorTreeRepository entityDescriptorTreeRepository,
                                                      SqlFactory sqlFactory,
                                                      SqlQuery sqlQuery) {
        DefaultSqlBuilderFactory sqlBuilderFactory = new DefaultSqlBuilderFactory(sqlFactory, sqlQuery);
        sqlBuilderFactory.setEntityDescriptorTreeRepository(entityDescriptorTreeRepository);
        return sqlBuilderFactory;
    }

    @Bean
    public OrmOperations orm(SqlBuilderFactory sqlBuilderFactory,
                             JdbcFlavor jdbcFlavor,
                             SqlQuery sqlQuery) {
        return new OrmTemplate(sqlBuilderFactory, new SimpleUpdater(jdbcFlavor, sqlQuery));
    }
}
