package com.database.demo.resource

import com.database.demo.entity.Customer
import com.database.demo.repository.CustomerRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.util.ObjectUtils
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/api")
class CustomerRes(
    val customerRepo: CustomerRepo
){

//    @Autowired
//    lateinit var customerRepo: CustomerRepo

    @GetMapping("/customers")
    fun fetchCustomer(): ResponseEntity<List<Customer>> {
        val customers = customerRepo.findAll()
        if (customers.isEmpty()) {
            return ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT)
        }
        return ResponseEntity<List<Customer>>(customers, HttpStatus.OK)
    }

    @PostMapping("/customers")
    fun addNewCustomer(@RequestBody customer: Customer, uri: UriComponentsBuilder): ResponseEntity<Customer> {
        val persistedCustomer = customerRepo.save(customer)

        if (ObjectUtils.isEmpty(persistedCustomer)) {
            return ResponseEntity<Customer>(HttpStatus.BAD_REQUEST)
        }
        val headers = HttpHeaders()
        headers.setLocation(uri.path("/customer/{customerId}").buildAndExpand(customer.id).toUri());
        return ResponseEntity(headers, HttpStatus.CREATED)
    }

    @DeleteMapping("/customers/{id}")
    fun removeCustomerById(@PathVariable("id") customerId: Long): ResponseEntity<Void> {
        val customer = customerRepo.findById(customerId)
        if (customer.isPresent) {
            customerRepo.deleteById(customerId)
            return ResponseEntity<Void>(HttpStatus.NO_CONTENT)
        }
        return ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR)
    }

}

