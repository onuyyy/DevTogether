<div class="h-screen w-screen fixed bg-neutral-400 flex justify-center items-center z-10">
  <div class="h-128 w-100 bg-neutral-200 rounded-3xl flex justify-center items-center p-5">
    <div class="h-full w-full bg-neutral-50">
      <slot />
    </div>
  </div>
</div>

<script lang="ts">
  import './screenModal.css'
</script>