package com.example.youpay

import retrofit2.Call

data class SearchPlaylists(val pageInfo: PageInfo, val items: List<SearchItems>, val nextPageToken: String)

data class SearchItems(val id: searchID, val snippet: searchSnippet)

data class searchID(val playlistId: String)

data class searchSnippet(val channelId: String, val title: String, val channelTitle: String)