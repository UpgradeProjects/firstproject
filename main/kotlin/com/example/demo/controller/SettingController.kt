package com.example.demo.controller

import com.example.demo.entity.Setting
import com.example.demo.service.SettingService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/settings")
class SettingController(private val settingService: SettingService) {


    @GetMapping
    fun getSetting(): Setting? {
        return settingService.getSettingByKey("site_title")
    }


    @PostMapping
    fun updateSetting(@RequestBody setting: Setting): Setting {
        return settingService.save(setting)
    }

    @GetMapping("/{id}")
    fun getSettingById(@PathVariable id: Long): Setting? {
        return settingService.getSettingById(id)
    }
}
