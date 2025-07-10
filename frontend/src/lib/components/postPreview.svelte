<script lang='ts'>
  export let data: Api.GetPostsPosts

  const stripHtmlFast = (html: string) => {
    return html.replace(/<[^>]*>/g, '')
  }

  const summary = stripHtmlFast(data.content.slice(0,128)) + "..."
</script>

<a href={`/board/`+data.id} class="m-1">
  <div class="border rounded p-3 hover:bg-gray-50 ">
    <h2 class="text-2xl font-semibold">{data.title}</h2>
    <div class="flex justify-between">
      <p class="text-sm text-gray-400">{data.author.username} | {data.createDate}</p>
      <p class="text-gray-400"> {data.id}</p>
    </div>
    <p class="border-t-1 border-neutral-600 text-neutral-500 ">{stripHtmlFast(summary)}</p>
  </div>
</a>