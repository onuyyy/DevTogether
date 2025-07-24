<div class="flex h-screen">
  <!-- 왼쪽: 코드 블록 -->
  <div class="w-1/2 bg-onedark-black">
    <!-- 윗 블럭 -->
    <div class="flex justify-between bg-white">
      <p class="py-0.25 px-2 m-1">Java 21</p>
      <button type="button" on:click={copyCode} class="border-1 rounded-sm border-black py-0.25 px-2 m-1">코드 복사</button>
    </div>
    <!-- 코드 부분 -->
    <div class="overflow-scroll no-scrollbar font-mono text-sm leading-tight">
      <Codemirror code={post.code} readOnly={true} className="text-lg"/>
    </div>
  </div>

  <!-- 오른쪽: 글 + 댓글 -->
  <div class="w-1/2 bg-neutral-200 p-3 overflow-auto h-fit">
    <div class="size-full bg-white rounded-2xl p-6">
      <!-- 게시글 부분 -->
      <div class="mb-4">
        <h2 class="text-xl font-bold">{post.title}</h2>
        <p class="text-sm text-gray-500">{post.author.username} | {prettydate}</p>
      </div>

      <div class="mb-6">
        <p class="tiptap">{@html post.content}</p>
      </div>
      <!-- 댓글 부분 -->
      <div class="border-t pt-4">
        <h3 class="text-lg font-semibold mb-2">💬 댓글 {post.comments.length}개</h3>
        <div class="space-y-4">
          <CommentRenderer comments={post.comments} />
          <CommentWriter postId={data.post.id} />
        </div>
      </div>
    </div>
  </div>
</div>

<script context="module" lang="ts">
</script>

<script lang="ts">
  import CommentRenderer from '$lib/components/CommentRenderer.svelte';
  import Codemirror from '$lib/components/codemirror/codemirror.svelte';

  import hljs from 'highlight.js';
  import java from 'highlight.js/lib/languages/java'
  import 'highlight.js/styles/github-dark.css'
  import '$lib/components/tiptap/tiptap.css'

  import { onMount } from 'svelte'
    import CommentWriter from '$lib/components/CommentWriter.svelte';
    import { prettierDate } from '$lib/util/prettierDate';

  hljs.registerLanguage('java', java)

  onMount(() => {
    const blocks = document.querySelectorAll('code')
    blocks.forEach((block) => {
      hljs.highlightElement(block as HTMLElement)
    })
  })

  export let data: Api.GetPostsByPostId
  let post = data.post
  $: post = data.post

  console.log(post)

  const prettydate = prettierDate(new Date(data.post.createDate))

  const copyCode = async () => {
    try {
      await navigator.clipboard.writeText(post.code)
      alert("코드가 복사되었습니다!")
    } catch (err) {
      alert("복사에 실패했습니다!" + err)
      console.log(err)
    }
  }
</script>