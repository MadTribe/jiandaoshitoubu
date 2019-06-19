import App from './App.svelte';

const app = new App({
	target: document.body,
	props: {
		name: 'world',
		host: 'localhost:5000'
	}
});

export default app;
