import com.masa.kmptutorial.cache.Database
import com.masa.kmptutorial.cache.DriverFactory
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
object SDK {


    private lateinit var database: Database
    //val api = SpaceXApi()

    fun init(databaseDriverFactory: DriverFactory){
        database = Database(databaseDriverFactory)
    }


//    @Throws(Exception::class) // Throws annotation is necessary for swift
//    suspend fun getLaunches(forceReload: Boolean): List<RocketLaunch> {
//        val cachedLaunches = database.getAllLaunches()
//        return if (cachedLaunches.isNotEmpty() && !forceReload) {
//            cachedLaunches
//        } else {
//            api.getAllLaunches().also {
//                database.clearDatabase()
//                database.createLaunches(it)
//            }
//        }
//    }

}