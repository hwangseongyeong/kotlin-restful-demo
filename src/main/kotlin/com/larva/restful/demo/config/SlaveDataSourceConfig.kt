package com.larva.restful.demo.config

import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "slaveEntityManagerFactory",
        transactionManagerRef = "slaveTransactionManager",
        basePackages = ["com.larva.restful.demo.domain.slave"]
)
class SlaveDataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.slave")
    fun slaveDataSource(): DataSource {
        val dataSource = DataSourceBuilder.create().type(HikariDataSource::class.java).build()

        // UTF-8
        dataSource.connectionInitSql = "SET NAMES utf8mb4"

        return dataSource
    }

    @Bean
    fun slaveEntityManagerFactory(
            builder: EntityManagerFactoryBuilder): LocalContainerEntityManagerFactoryBean {
        return builder
                .dataSource(this.slaveDataSource())
                .packages("com.larva.restful.demo.domain.slave.entity")
                .persistenceUnit("test")
                .build()
    }

    @Bean
    fun slaveTransactionManager(builder: EntityManagerFactoryBuilder): JpaTransactionManager {
        return JpaTransactionManager(slaveEntityManagerFactory(builder).`object`!!)
    }
}