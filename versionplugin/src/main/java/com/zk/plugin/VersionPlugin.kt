package com.zk.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * description ：如果出现红色警告可以忽略，不会影响项目的编译和运行
 * author : zk
 * date : 2020/10/21 11:27
 */


class VersionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
    }

    companion object {


    }
}