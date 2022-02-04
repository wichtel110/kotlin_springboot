package com.database.demo

import com.database.demo.entity.Customer
import com.database.demo.repository.CustomerRepo
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean


@SpringBootApplication
class DemoApplication

	fun main(args: Array<String>) {
		runApplication<DemoApplication>(*args)
	}

