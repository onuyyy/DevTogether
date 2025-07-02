<script lang="ts">
  export let data: App.CommentData

  let depth

  // commentCode 분리해서 ml-x 정의하는 코드
    // depth에 따라 x를 늘리고, 화면 크기에 따라 한계를 정함
  // commentCode 에 따라서 댓글 색 (bg-blue-x)을 정의하는 코드
    // depth가 깊어질 수록 x값이 늘어나고, 최대값이 있음
    // 대댓글 색의 깊이는 화면 크기에 따라 달라지지 않음
</script>

<div class={`bg-blue-100 p-3 rounded`}>
  <p class="text-sm font-semibold">({data.comment_uploader.user_name}) · ({data.comment_createdDate})</p>
  <p class="text-sm">{data.comment_content}</p>
</div>