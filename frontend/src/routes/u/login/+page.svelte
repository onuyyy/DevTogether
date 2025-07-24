<div class="bg-white w-full h-100 rounded-2xl mb-1">
  <div class="h-full flex justify-center items-center text-2xl font-bold">
    로그인 페이지입니다.
  </div>
</div>
<form on:submit|preventDefault={handleSubmit} class="w-full h-1/3">
  <input name="username" type="text" placeholder="아이디를 입력하세요...">
  <input name="password" type="password" placeholder="비밀번호를 입력하세요...">
  <div class="flex justify-between">
    <button type="submit" class="bg-sky-400 text-white mr-2">로그인</button>
    <button type="button" on:click={() => {goto("/u/signup/")}} class="bg-white border-1">회원가입</button>
  </div>
</form>

<script lang='ts'>
    import { goto } from "$app/navigation";
    import { setUser } from "../../../stores/user.svelte";

  const handleSubmit = async (event: SubmitEvent) => {
    const form = event.target as HTMLFormElement
    const data = new FormData(form)

    const reqData: Api.PostLoginRequest = {
      username: data.get('username') + '',
      password: data.get('password') + ''
    }

    setUser(reqData)
  }
</script>