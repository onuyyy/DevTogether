<script>
  import '../app.css'
</script>

<!-- 헤더 -->
<!-- TODO: 얘를 routes/의 레이어웃으로 쓰지 말고 따로 분리해버릴까? 헤더라는 컴포넌트로 분리해서 관리하고? -->
<header class="bg-gray-100 py-4 px-6 text-xl font-bold flex justify-between drop-shadow-sm">
  <a href="/">
    DevTogether
  </a>
  <a href="/login">
    로그인
  </a>
</header>

<slot />

<footer></footer>