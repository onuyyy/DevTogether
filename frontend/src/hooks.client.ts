import { browser } from '$app/environment';

/**
 * SvelteKit의 handleFetch 훅은 SSR‑단계와 load() 내부 fetch 에만 적용됩니다.
 * 클라이언트 스크립트(예: validateAll 내부)에서 직접 호출되는 window.fetch 를
 * 가로채려면 전역 fetch 를 한 번 래핑해 주어야 합니다.
 *
 * 이 스크립트는 브라우저에서만 실행되며, `/api/*` 경로를
 * `https://api.devtogether.site/*` 로 치환한 뒤 원본 fetch 를 호출합니다.
 */
if (browser) {
	const originalFetch = window.fetch;

	window.fetch = (input: RequestInfo | URL, init?: RequestInit): Promise<Response> => {
		let url = typeof input === 'string' || input instanceof URL ? input.toString() : input.url;

		if (url.startsWith('/api/')) {
			url = `https://api.devtogether.site${url}`;
			input = typeof input === 'string' || input instanceof URL
				? url
				: new Request(url, input);
		}

		return originalFetch(input as RequestInfo, init);
	};
}