package com.database.demo.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToMany
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.Table


@Entity
@Table(name = "Customer")
data class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,
    val firstName: String? = null,
    val lastName: String? = null,

    @OneToMany(mappedBy = "owner")
    val vehicle: List<Vehicle>
)