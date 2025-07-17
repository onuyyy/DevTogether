
<div class="bg-neutral-400 w-svw h-svh flex justify-center items-center u-scope">
  <div
    class="bg-neutral-200 w-100 h-fit flex justify-center items-center p-5 rounded-3xl drop-shadow-md"
    transition:slide
  >
    <div class="w-full h-full">
      <div class="w-full flex justify-end">
        <a href="/" class="font-extrabold text-2xl mb-2">X</a>
      </div>
      <slot />
    </div>
  </div>
</div>

<script lang='ts'>
  import './u.css'
  import { slide } from 'svelte/transition';
</script>