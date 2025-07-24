
{#if openComment || parent == -1}
<form on:submit|preventDefault={handleSubmit} class="w-full py-2">
  <textarea
    name="comment"
    class="w-full h-16 bg-white rounded-xl p-2 border"
    placeholder="댓글을 입력하세요..."
  ></textarea>
  <div class="flex justify-end">
    <button type="submit" class="px-6 py-1 text-white bg-sky-300 rounded-xl hover:bg-sky-400 hover:scale-[105%] active:bg-sky-500 active:scale-[97%]">작성</button>
  </div>
</form>
{/if}

<script lang="ts">
  import { testUser } from "$lib/testPostData";
  import { user } from "../../stores/user.svelte";
  import { invalidateAll } from "$app/navigation";

  export let postId: number
  export let parent: number = -1

  const handleSubmit = async (event: SubmitEvent) => {
    const form = event.target as HTMLFormElement
    const data = new FormData(form)

    const currentUser = user
    const message = data.get('comment') as string

    const reqData: Api.PostCommentRequest = {
      author: currentUser ? currentUser : testUser,
      content: message,
      parent: parent
    }

    const jsonData = JSON.stringify( reqData )
    console.log(jsonData)

    try {
      const res = await fetch(import.meta.env.VITE_API_URL+'/api/posts/'+postId+'/comments', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: jsonData
      })

      if (!res.ok) {
        console.log(res)
        throw Error("Fetch Failed!")
      }

      openComment = !openComment
      await invalidateAll()
    } catch(err) {
      alert("댓글 작성에 실패했습니다!")
      console.log(err)
    }
  }

  // 온오프 export
  export let openComment = true
</script>