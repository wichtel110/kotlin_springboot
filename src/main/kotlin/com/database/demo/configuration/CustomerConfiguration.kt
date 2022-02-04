package com.database.demo.configuration

import com.database.demo.entity.Customer
import com.database.demo.repository.CustomerRepo
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class CustomerConfiguration {

    @Bean
    fun databaseInitializer(customerRepo: CustomerRepo) = ApplicationRunner {
        customerRepo.save(Customer(firstName = "Peter", lastName = "Pan" , vehicle = emptyList()))
        customerRepo.save(Customer(firstName = "Jackson", lastName = "Peter" , vehicle = emptyList()))
        customerRepo.save(Customer(firstName = "Ron", lastName = "Kol" , vehicle = emptyList()))
    }
}