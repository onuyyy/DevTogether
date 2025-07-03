<!-- src/routes/+page.svelte -->
<div class="flex h-screen">
  <!-- 왼쪽: 코드 블록 -->
  <div class="w-1/2 bg-black">
    <!-- 윗 블럭 -->
    <div class="flex justify-between bg-white">
      <p class="py-0.25 px-2 m-1">Java 21</p>
      <button class="border-1 rounded-sm border-black py-0.25 px-2 m-1">코드 복사</button>
    </div>
    <!-- 코드 부분 -->
    <div class="bg-black text-white p-4 overflow-scroll no-scrollbar font-mono text-sm leading-tight">
      코드 부분
    </div>
  </div>

  <!-- 오른쪽: 글 + 댓글 -->
  <div class="w-1/2 bg-neutral-200 p-3 overflow-auto">
    <div class="size-full bg-white rounded-2xl p-6">
      <!-- 게시글 부분 -->
      <div class="mb-4">
        <h2 class="text-xl font-bold">제목 부분</h2>
      </div>

      <div class="mb-6">
        <p class="whitespace-pre-wrap">내용 부분</p>
      </div>
    </div>
  </div>
</div>

<script context="module" lang="ts">
</script>

<script lang="ts">

</script>