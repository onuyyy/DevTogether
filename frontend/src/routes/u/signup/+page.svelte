<form on:submit|preventDefault={handleSubmit} class="w-full h-full">
  <input 
    name="username"
    type="text" 
    placeholder="유저 이름을 입력하세요...">
  <input
    name="pw" 
    type="password"
    placeholder="비밀번호를 입력하세요...">
  <input 
    name="pw confirm"
    type="password"   
    placeholder="비밀번호를 한 번 더 입력하세요..."
    class="mb-3">
  <div class="flex justify-between">
    <button type="button" class="bg-white border-1">회원가입</button>
  </div>
</form>

<script>
  const handleSubmit = () => {

  }
</script>