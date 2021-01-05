package com.ggu.firebase.data.model


/**
 * Sample API was referenced at the site below.
 * @see https://reqres.in/
 */

typealias User = SampleData.UserData
typealias Resource = SampleData.ResourceData

data class SampleData<T>(
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int,
    val data: List<T>
) {
    data class UserData(
        val id: Int,
        val email: String,
        val first_name: String,
        val last_name: String,
        val avatar: String
    )

    data class ResourceData(
        val id: Int,
        val name: String,
        val year: Int,
        val color: String,
        val pantone_value: String
    )
}