declare global {
  namespace Api {
    interface GetPostsPosts {
      id: number
      title: string
      content: string
      author: Pick<App.UserData, "username" | "id">
      createDate: string
      commentCount: number
    }
    interface GetPostsPageInfo {
      currentPage: number
      totalPages: number
    }

    interface GetPostsResponse {
      posts: Api.GetPostsPosts[]
      pageInfo: Api.GetPostsPageInfo
    }

    interface GetPostsByPostId {
      post: {
        id: number
        title: string
        content: string
        code: string
        author: Pick<App.UserData, "username" | "id">
        createDate: string
        commentCount: number
        comments: App.CommentData[]
      }
    }

    interface PostPostsRequest {
      title: string
      code: string
      content: string
      author: Pick<App.UserData, "username" | "id">
    }

    interface PostPostsResponse {
      id: number
    }
  }
}

export {}