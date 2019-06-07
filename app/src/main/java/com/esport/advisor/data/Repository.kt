package com.esport.advisor.data

class Repository(
        private val client: com.esport.advisor.data.http.ApiClientInterface
): RepositoryInterface {

//    override suspend fun getBBCNews(api: String): IO<NewsModel, Exception> {
//        return io { client.getCurrentBBCNews(api) }
//    }
}