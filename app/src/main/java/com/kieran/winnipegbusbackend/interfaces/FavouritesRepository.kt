package com.kieran.winnipegbusbackend.interfaces

import com.kieran.winnipegbus.data.DataFavourite

interface FavouritesRepository {
    fun get(agencyId: Long, id: Long): DataFavourite?

    fun getAll(agencyId: Long): List<DataFavourite>?

    fun create(favourite: DataFavourite): DataFavourite?

    fun update(favourite: DataFavourite): Boolean

    fun get(agencyId: Long, identifier: StopIdentifier): DataFavourite?

    fun delete(agencyId: Long, stopIdentifier: StopIdentifier): Boolean

    fun hasBeenImported(): Boolean

    fun markImported()
}