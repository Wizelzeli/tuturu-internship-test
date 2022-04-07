package com.example.tuturuintershiptest.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Status(
    val sentCount: Int,
    val verified: Boolean
) : Parcelable