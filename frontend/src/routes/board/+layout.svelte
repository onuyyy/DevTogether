<script>
  import MainHeader from '$lib/components/mainHeader.svelte';
</script>

<!-- 헤더 -->
<!-- TODO: 얘를 routes/의 레이어웃으로 쓰지 말고 따로 분리해버릴까? 헤더라는 컴포넌트로 분리해서 관리하고? -->
<MainHeader />

<slot />

<footer></footer>