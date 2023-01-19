package service.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Companies(
    @SerialName("companies")
    val companiesList: List<Company>,
) {
    companion object {
        fun getList() = Companies(
            companiesList = listOf(
                Company(
                    company = "Microsoft",
                    providedAid = "Deployed patches against a targeted \"wiper\" malware used against Ukrainian authorities, placing their Threat Intelligence Center on high alert for such attacks. It has provided over $400 million worth of support from cloud service, cybersecurity to humanitarian aid."
                ),
                Company(
                    company = "Google",
                    providedAid = "Provided $2M in donated ads to help those affected find resources."
                ),
                Company(
                    company = "KFC",
                    providedAid = "Opened their kitchens to prepare food for those in need, especially for the military and hospitals"
                ),
                Company(
                    company = "McDonalds",
                    providedAid = "Donated food to local councils to be distributed to those in need, including water, vegetables, fruit, eggs, rolls, and salads."
                ),
                Company(
                    company = "SpaceX",
                    providedAid = "Activated Starlink satellite-based internet service in Ukraine and sent thousands of user terminals."
                ),
                Company(
                    company = "Bolt",
                    providedAid = "Bolt will donate 5 million EUR = 5% of every order in Europe to Non-Governmental Organisations (NGOs)"
                ),
                Company(
                    company = "Lego",
                    providedAid = "110 million DKK for humanitarian aid via Red Cross, Save the Children and UNICEF. 100 million DKK for rebuilding Ukraine's education system and educating Ukrainian child refugees in Europe."
                ),
                Company(
                    company = "Philip Morris International",
                    providedAid = "Donated 500,000 packs of cigarettes to the Ukrainian military."
                ),
                Company(
                    company = "CD Projekt RED",
                    providedAid = "Suspended all sales in Russia and Belarus, and donated $242,000 to humanitarian aid in Ukraine."
                ),
                Company(
                    company = "Baykar",
                    providedAid = "Donated three Baykar Bayraktar TB2-type UAVs to Ukraine."
                ),
                Company(
                    company = "Kel-Tec",
                    providedAid = "Pledged to donate 400 SUB-2000 semi-automatic carbines valued at $200,000 to the Ukrainian Armed Forces."
                ),
                Company(
                    company = "Wizz Air",
                    providedAid = "100.000 airline tickets free of charge, to refugees, for short-distance flights from Poland, Slovakia, Hungary and Romania in March 2022."
                ),
            )
        )
    }
}
