<div class="h-50 flex justify-center items-center bg-white rounded-xl text-xl font-bold mb-2">
  회원가입 페이지 입니다.
</div>

<form on:submit|preventDefault={handleSubmit} class="w-full h-full">
  <input 
    name="username"
    type="text" 
    placeholder="유저 이름을 입력하세요...">
  <input
    name="password" 
    type="password"
    placeholder="비밀번호를 입력하세요...">
  <input 
    name="password confirm"
    type="password"   
    placeholder="비밀번호를 한 번 더 입력하세요..."
    class="mb-3">
  <div class="flex justify-between">
    <button type="submit" class="bg-white border-1 hover:bg-neutral-100 active:bg-neutral-200">회원가입</button>
  </div>
</form>

<script lang='ts'>
    import { goto } from "$app/navigation";

  const handleSubmit = async (event: SubmitEvent) => {
    const form = event.target as HTMLFormElement
    const data = new FormData(form)

    const username = data.get('username') + ""
    const pw = data.get('password') + ""
    const pwConfirm = data.get('password confirm') + ""

    if (pw != pwConfirm) {
      alert("비밀번호가 일치하지 않습니다.")
      return
    }

    const reqData: Api.PostSignupRequest = {
      username: username,
      password: pw
    }

    const jsonData = JSON.stringify( reqData )
    
    console.log(reqData)
    try {
      const res = await fetch(`${import.meta.env.VITE_API_URL}/api/user`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: jsonData
      })

      console.log(res)
      if(!res.ok) {
        alert("회원가입에 실패했습니다!")
        return
      }
      alert(`회원가입에 성공했습니다.\n환영합니다. ${username}.`)
      // 회원가입 성공시?
        // 정확히 동일한 데이터로 로그인 요청 fetch 날리기
        // 응답 받고 user 상태 변경시켜주기
        // 로그인 요청하고 user 상태 변경하는거 함수로 따로 만들어서 관리하기?
          // 필요한가? 어짜피 회원가입, 로그인에서만 이거 쓸건데?
          // 소셜 로그인, 자동 로그인 기능에서 쓸 수 있으니 빼두는게 좋을 것.

    } catch(err) {
      alert('회원가입에 실패했습니다!')
      console.log(err)
    }
  }
</script>