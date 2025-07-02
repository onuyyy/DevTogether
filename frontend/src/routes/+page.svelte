<script lang="ts">
  // 상태, 데이터 로드
  // 여기서 데이터는 css, component, 객체 등도 포함 됨
  import '../app.css'
  import Postpreview from '$lib/components/postPreview.svelte'

  // posts를 받아오도록 변경
  const user: App.UserData = {
    user_id: 0,
    user_createDate: "00:00",
    user_name: "관리자",
    user_role: 7
  }
  const posts: App.PostData[] = [
    {
      post_id: 0,
      post_uploader: user,
      post_title: "글 제목",
      post_createdDate: "00:00",
      post_content: "content",
      post_code: '_',
      post_comments: []
    },
  ]
</script>

<!-- 헤더 -->
<header class="bg-gray-100 py-4 px-6 text-xl font-bold">
  DevTogether
</header>

<!-- 검색 및 필터 -->
<section class="flex justify-between items-center p-4 border-b">
  <input
    type="text"
    placeholder="검색어를 입력하세요"
    class="border rounded px-3 py-1 w-full max-w-sm"
  />
  <div>
    <select class="ml-4 border rounded px-2 py-1">
      <option>최신순</option>
      <option>조회순</option>
    </select>
    <button class="border-1 rounded ml-1 px-2 py-0.75 hover:bg-neutral-100 active:bg-neutral-200">
      글 쓰기
    </button>
  </div>
</section>

<!-- 게시글 리스트 -->
<main class="p-4 space-y-3">
  {#each posts as post}
    <Postpreview data={post}/>
  {/each}
</main>

<!-- 페이지네이션 -->
<footer class="flex justify-center items-center gap-2 py-4">
  <button class="px-3 py-1 border rounded hover:bg-gray-100">이전</button>
  <button class="px-3 py-1 border rounded hover:bg-gray-100">1</button>
  <button class="px-3 py-1 border rounded hover:bg-gray-100">2</button>
  <button class="px-3 py-1 border rounded hover:bg-gray-100">다음</button>
</footer>