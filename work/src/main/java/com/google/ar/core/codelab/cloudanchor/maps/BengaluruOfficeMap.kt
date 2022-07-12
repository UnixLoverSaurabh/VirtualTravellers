package com.google.ar.core.codelab.cloudanchor.maps

import map.local.AnchorMap
import androidx.core.util.Pair;
import com.google.ar.core.codelab.cloudanchor.R

class BengaluruOfficeMap : AnchorMap() {

    private val POI: List<Pair<Int, Int>> = listOf(
            Pair(R.string.bglr_office_entry_gate, 163),
            Pair(R.string.bglr_office_satish_cabin, 171),
            Pair(R.string.bglr_office_sanjay_cabin, 180)
    )

    override fun getAdjacencyMatrix(): Map<Int, List<Int>> {
        val map = HashMap<Int, List<Int>>()
        map.put(163, listOf(164, 172))
        map.put(164, listOf(163, 165))
        map.put(165, listOf(164, 166))
        map.put(166, listOf(165, 167))
        map.put(167, listOf(166, 168))
        map.put(168, listOf(167, 169))
        map.put(169, listOf(168, 170))
        map.put(170, listOf(169, 171))
        map.put(171, listOf(170, 181))
        map.put(181, listOf(171, 182))
        map.put(182, listOf(181, 183))
        map.put(183, listOf(182, 184))
        map.put(184, listOf(183, 195))
        map.put(195, listOf(184, 196))
        map.put(196, listOf(195, 187))
        map.put(187, listOf(196, 188))
        map.put(188, listOf(187, 189))
        map.put(189, listOf(188, 190))
        map.put(190, listOf(189, 191))
        map.put(191, listOf(190, 192))
        map.put(192, listOf(191, 193))
        map.put(193, listOf(192, 194))
        map.put(194, listOf(193, 180))
        map.put(172, listOf(163, 173))
        map.put(173, listOf(172, 174))
        map.put(174, listOf(173, 175))
        map.put(175, listOf(174, 176))
        map.put(176, listOf(175, 177))
        map.put(177, listOf(176, 178))
        map.put(178, listOf(177, 179))
        map.put(179, listOf(178, 180))
        map.put(180, listOf(179, 194))
        return map
    }

    override fun getPOIs(): List<Pair<Int, Int>> {
        return POI
    }
}