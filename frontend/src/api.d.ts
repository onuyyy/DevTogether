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
      totalPage: number
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

    interface PostLoginRequest {
      username: string
      password: string
    }

    interface PostSignupRequest extends PostLoginRequest{ }

    interface PostCommentRequest {
      author: Pick<App.UserData, "username" | 'id'>
      content: string
      parent: number
    }

  }
}

export {}