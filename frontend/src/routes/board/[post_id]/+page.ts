import { GetPostsByPostIDExample } from "$lib/testPostData";
import type { PageLoad } from "./$types";

export const load: PageLoad = async ({ params, fetch }) => {
  if(params.post_id == '-1')
    return GetPostsByPostIDExample

  const res = await fetch(`${import.meta.env.VITE_API_URL}/api/posts/${params.post_id}`, {
    method: "GET"
  })
  const post = (await res.json()) as Api.GetPostsByPostId

  return {
    post
  }
}