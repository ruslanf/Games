package studio.bz_soft.games.data

import studio.bz_soft.games.data.http.ApiClientInterface
import studio.bz_soft.mvilibrary.extensions.IO
import studio.bz_soft.mvilibrary.extensions.io
import java.lang.Exception

class Repository(
        private val client: ApiClientInterface
): RepositoryInterface {

//    override suspend fun getBBCNews(api: String): IO<NewsModel, Exception> {
//        return io { client.getCurrentBBCNews(api) }
//    }
}