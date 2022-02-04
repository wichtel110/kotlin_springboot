package com.database.demo.repository

import com.database.demo.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CustomerRepo : JpaRepository<Customer, Long> {
}