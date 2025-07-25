export const handleFetch: typeof globalThis.fetch = (input, init) => {
  let url = typeof input === 'string' ? input : input.url;

  if (url.startsWith('/api/')) {
    url = `https://api.devtogether.site${url}`;
    input = typeof input === 'string' ? url : new Request(url, input);
  }
  return fetch(input, init);
};