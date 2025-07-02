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
		
		interface PostData {
			post_id: number
			post_uploader: UserData
			post_title: string
			post_createdDate: string
			post_content: string
			post_code: string
			post_comments: CommentData[]
		}

		interface CommentData {
			comment_id: string // 하위 구조를 표현하기 위해, 최상위의 번호가 a라고 치면 a-b-c-d... 이런 식으로
			comment_uploader: UserData
			comment_createdDate: string
			comment_content: string
			// comment_comment: CommentData[] <-- 이거 필요한걸까?
		}

		interface UserData {
			user_id: number
			user_name: string
			user_createDate: string
			user_role: number
		}
	}
}

export {};
