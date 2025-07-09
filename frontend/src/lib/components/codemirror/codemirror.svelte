<div class="h-full {className}" bind:this={editorContainer}></div>

<script>
  import { basicSetup, EditorView } from "codemirror"
  import { placeholder } from "@codemirror/view"
  import { java } from "@codemirror/lang-java"
  import { oneDark } from "@codemirror/theme-one-dark"
  import { onMount } from "svelte";

  let editorContainer
  export let className = ""
  export let readOnly = false
  export let placeholderText = ""
  export let code = ''

  onMount(() => {
    const extensions = [basicSetup, java(), oneDark,
      EditorView.updateListener.of(update => {
        if (update.docChanged)
          code = update.state.doc.toString()
      })
    ]

    if (readOnly)
      extensions.push(EditorView.editable.of(false))
    if (placeholder.length >= 1)
      extensions.push(placeholder(placeholderText))

    const editor = new EditorView({
      doc: code,
      extensions: extensions,
      parent: editorContainer
    })
  })
</script>