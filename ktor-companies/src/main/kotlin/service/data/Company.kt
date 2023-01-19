package service.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Company(
    @SerialName("company")
    val company: String,
    @SerialName("provided_aid")
    val providedAid: String,
    @SerialName("company_host")
    val host: String? = null,
)