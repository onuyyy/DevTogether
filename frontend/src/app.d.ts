// See https://svelte.dev/docs/kit/types#app.d.ts
// for information about these interfaces
declare global {
	namespace App {
		// interface Error {}
		// interface Locals {}
		// interface PageData {}
		// interface PageState {}
		// interface Platform {}

		// 그냥 모든 데이터를 받은 뒤 쓸 정보만 빼서 쓸까?
		// RESTful API 사용할거면 그게 편하겠는데

		interface UserData {
			username: string
			id: number
		}

		interface FullUserData extends UserData {
			createDate: string
			uploadedPosts: PostData[]
			uploadedComments: CommentData[]
		}

		interface CommentData {
			author: UserData
			postId: number
			id: number
			createDate: Date
			comment: string
			parent: number
		}
		
		interface PostData {
			author: UserData
			id: number
			createDate: string
			title: string
			content: string
			code: string
			comments: CommentData[]
		}
	}
}

export {};
