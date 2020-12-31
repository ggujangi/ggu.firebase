package com.ggu.firebase.data.model


/**
 * Sample API was referenced at the site below.
 * @see https://reqres.in/
 */

data class SampleData<T>(
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int,
    val data: T
) {
    data class User(
        val id: Int,
        val email: String,
        val first_name: String,
        val last_name: String,
        val avatar: String
    )

    data class Resource(
        val id: Int,
        val name: String,
        val year: Int,
        val color: String,
        val pantone_value: String
    )
}