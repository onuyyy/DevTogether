<MainHeader />

<!-- 검색 및 필터 -->
<section class="flex justify-between items-center p-4 border-b">
  <form>
    <input
      type="text"
      name="serach"
      placeholder="검색어를 입력하세요"
      class="border rounded px-3 py-1 w-50 max-w-sm"
    />
  </form>
  <div>
    <select class="ml-4 border rounded px-2 py-1">
      <option>최신순</option>
      <option>조회순</option>
    </select>
    <a href="/board/write" class="border-1 rounded ml-1 px-2 py-1.5 hover:bg-neutral-100 active:bg-neutral-200">
      글 쓰기
    </a>
  </div>
</section>

<!-- 게시글 리스트 -->
<main class="p-4 space-y-3">
  {#if posts.length == 0}
    <div class="text-neutral-500 my-10 flex flex-col place-items-center">
      <p class="m-1">게시글이 비었습니다...</p>
      <p class="m-1">아니면 서버와 연결이 끊어졌거나요...</p>
      <p class="m-1">(슬픈 사진)</p>
    </div>
  {/if}
  {#each posts as post}
    <Postpreview data={post}/>
  {/each}
</main>

<!-- 페이지네이션 -->
<!-- 페이지 수는 어떻게 세지 -->
<!-- PageInfo 형태로 줘야하려나 -->
<footer class="flex justify-center items-center gap-2 py-4">
  {#if posts.length > 0}
    <button on:click={async ()=>{ movePage(page-1) }} class="px-3 py-1 border rounded hover:bg-gray-100 cursor-pointer">이전</button>
    {#each { length: pageInfo.totalPage }, pages}
      <button on:click={async ()=>{ movePage(pages+1) }} class="px-3 py-1 border rounded hover:bg-gray-100 cursor-pointer">{pages+1}</button>
    {/each}
    <button on:click={async ()=>{ movePage(page+1) }} class="px-3 py-1 border rounded hover:bg-gray-100 cursor-pointer">다음</button>
  {/if}
</footer>

<script lang="ts">
  import MainHeader from '$lib/components/mainHeader.svelte';
  import Postpreview from '$lib/components/postPreview.svelte'
  import { onMount } from 'svelte';
  let page: number = 1

  let response: Api.GetPostsResponse
  let pageInfo: Api.GetPostsPageInfo
  let posts: Api.GetPostsPosts[] = []

  onMount (() => {
    loadPosts()
  })

  const loadPosts = async () => {
    try {
      // 쿼리 문 추가히기
      // page=${페이지}&limit=${리미트} 형태 문자열 추가하기
      const res = await fetch(`/api/posts?page=`+page, {
        method: 'GET'
      })
      // 응답 체크
      if(!res.ok) throw new Error("Failed to load posts!")

      const datas = await res.json()
      console.log(datas)
      response = datas
      pageInfo = response.pageInfo
      posts = Array.isArray(response.posts) ? response.posts : []
    } catch (err) {
      console.log(err)
    }
  }

  const movePage = (pageNum: number) => {
    page = pageNum
    if(page <= 0) page = 1
    if(page >= pageInfo.totalPage) page = pageInfo.totalPage
    loadPosts()
  }
</script>