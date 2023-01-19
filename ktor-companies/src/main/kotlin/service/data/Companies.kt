package service.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Companies(
    @SerialName("companies")
    val companiesList: List<Company>
)

@Serializable
data class Company(
    @SerialName("company")
    val company: String,
    @SerialName("provided_aid")
    val providedAid: String,
    @SerialName("company_host")
    val host: String? = null,
)
