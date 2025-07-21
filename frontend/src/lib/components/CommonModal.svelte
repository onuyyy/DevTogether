{#if showModal}
  <div class='w-full h-dvh fixed top-0, left-0 flex justify-end' on:click|self>
    <div class='size-fit rounded-2xl border-1 bg-neutral-100 m-2'>
      <slot />
    </div>
  </div>
{/if}

<script lang="ts">
  export let showModal = false
</script>