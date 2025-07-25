import type { HandleFetch } from '@sveltejs/kit';

export const handleFetch: HandleFetch = ({ request, fetch }) => {
  const url = new URL(request.url);
  if (url.pathname.startsWith('/api/')) {
    url.hostname = 'api.devtogether.site';
    url.protocol = 'https:';
    return fetch(new Request(url, request));
  }
  return fetch(request);
};