package com.database.demo.entity

import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "Vehicle")
data class Vehicle(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,
    val vehicle: String? = null,

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CUSTOMER_ID")
    val owner: Customer
)