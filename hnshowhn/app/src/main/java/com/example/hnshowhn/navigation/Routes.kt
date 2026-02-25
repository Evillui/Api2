package com.example.hnshowhn.navigation

sealed class Routes(val route: String) {
    data object List : Routes("showhn_list")

    data object Detail : Routes("showhn_detail/{id}") {
        const val ARG_ID = "id"
        fun create(id: Long): String = "showhn_detail/$id"
    }
}