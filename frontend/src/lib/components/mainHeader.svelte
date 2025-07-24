<header class="bg-gray-100 py-4 px-6 text-xl font-bold flex justify-between drop-shadow-sm">
  <a href="/">
    DevTogether
  </a>
  <!-- 이거 이미 로그인 되어있으면 어떻게 바뀌어야할까? -->
  <!-- 그냥 유저 이름으로 변경되고 누르면 마이페이지 띄우기?-->
  {#if currentUser.id === -1}
    <a href="/u/login">
      로그인
    </a>
  {/if}
  {#if currentUser.id !== -1}
    <CommonModal showModal={showModal} on:click={toggleModal}>
      <button class="px-10 py-4 cursor-pointer" type="button" on:click={logout}>로그아웃</button>
    </CommonModal>
    <button class="cursor-pointer" type="button" on:click={toggleModal}>
      {user.username}
    </button>
  {/if}
</header>

<script lang='ts'>
  import { goto, invalidate, invalidateAll } from "$app/navigation";
  import { clearUser, user } from "../../stores/user.svelte";
  import CommonModal from "./CommonModal.svelte";
  
  let showModal = false;
  const toggleModal = () => {
    showModal = !showModal
  }

  const logout = async () => {
    clearUser()
    toggleModal()
    await invalidateAll()
    goto('/')
  }

  const currentUser = user
</script>