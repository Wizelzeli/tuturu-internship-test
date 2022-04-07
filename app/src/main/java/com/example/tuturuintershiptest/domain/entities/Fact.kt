package com.example.tuturuintershiptest.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class Fact(
    val __v: Int?,
    val _id: String?,
    val createdAt: Date?,
    val deleted: Boolean?,
    val source: String?,
    val status: Status?,
    val text: String?,
    val type: String?,
    val updatedAt: Date?,
    val used: Boolean?,
    val user: String?
) : Parcelable