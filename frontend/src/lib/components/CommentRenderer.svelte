<script lang="ts">
  import CommonComment from "./commonComment.svelte"
  import CommentRenderer from './CommentRenderer.svelte'

  export let comments: App.CommentData[]
  export let parent: number = -1
  export let depth: number = 0
</script>

{#each comments as comment}
  {#if comment.parent === parent}
    <CommonComment data={comment} depth={depth} />
    <!-- 자식 댓글이 있다면 재귀적으로 렌더링 -->
    <CommentRenderer comments={comments} parent={comment.id} depth={depth + 1} />
  {/if}
{/each}