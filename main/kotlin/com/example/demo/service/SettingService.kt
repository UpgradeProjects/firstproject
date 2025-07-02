package com.example.demo.service

import com.example.demo.entity.Setting
import com.example.demo.repository.SettingRepository
import org.springframework.stereotype.Service

@Service
class SettingService(private val settingRepository: SettingRepository) {

    fun getSettingByKey(key: String): Setting? {
        return settingRepository.findByKey(key)
    }

    fun getSettingById(id: Long): Setting? {
        return settingRepository.findById(id).orElse(null)
    }

    fun save(setting: Setting): Setting {
        return settingRepository.save(setting)
    }

    fun getAllSettings(): List<Setting> {
        return settingRepository.findAll()
    }
}

