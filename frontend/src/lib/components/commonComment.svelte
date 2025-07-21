<script lang="ts">
  import { prettierDate } from "$lib/util/prettierDate";
  export let data: App.CommentData

  const prettyDate = prettierDate(data.createDate)

  // depth 기반 대댓글 색 설정
  export let depth = 0
  const maxDepth = 3
  const marginClasses = ['ml-4', 'ml-8', 'ml-12', 'ml-16', 'ml-20', 'ml-24']
  const bgClasses = ['bg-blue-100', 'bg-blue-200', 'bg-blue-300', 'bg-blue-400 text-white', 'bg-blue-500', 'bg-blue-600']

  let addition = 'bg-blue-100'
  if(depth > 0) {
    const realDepth = depth <= maxDepth ? depth : maxDepth
    addition = marginClasses[realDepth] + " " + bgClasses[realDepth]
  }


  // commentCode 분리해서 ml-x 정의하는 코드
    // depth에 따라 x를 늘리고, 화면 크기에 따라 한계를 정함
  // commentCode 에 따라서 댓글 색 (bg-blue-x)을 정의하는 코드
    // depth가 깊어질 수록 x값이 늘어나고, 최대값이 있음
    // 대댓글 색의 깊이는 화면 크기에 따라 달라지지 않음
</script>

<div class={`p-3 rounded-lg ` + addition}>
  <div class="flex justify-between">
    <p class="text-sm font-semibold">{data.author.username} · {prettyDate}</p>
    <button class="cursor-pointer underline">답글</button>
  </div>
  <p class="text-sm">{data.content}</p>
</div>