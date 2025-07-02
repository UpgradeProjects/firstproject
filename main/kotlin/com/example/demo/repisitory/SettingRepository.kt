package com.example.demo.repository

import com.example.demo.entity.Setting
import org.springframework.data.jpa.repository.JpaRepository

interface SettingRepository : JpaRepository<Setting, Long> {
    fun findByKey(key: String): Setting?
}

