<script>
	import Choice from './choice.svelte';

	let apiPath = '/game';
	export let name;
	export let host;
	var myName = "Nobody" + new Date().getTime();
	let state = 0;
	var myChoice = null;
	var theirChoice = null;

	/*
	 * states are
	 *  0=before start
	 *  1=wanting to play
	 *  2=can play
	 *  3=waiting result
	 */

	async function wantToPlay() {
	console.log('want to play')
		// event handler code goes here
		let url = "http://" + host + apiPath +  "/wanttoplay";
		let dataObj = {
			name: myName
		}

		var response = await fetch(url, {
			 method: 'POST',
			 mode: 'cors',
			 cache: 'no-cache',
			 headers: {
					 'Content-Type': 'application/json',
			 },
			 redirect: 'follow', // manual, *follow, error
			 referrer: 'no-referrer', // no-referrer, *client
			 body: JSON.stringify(dataObj)
			 })
			 .then(r => r.json())
			 .catch(error => console.error('Error:', error));


			 if (response.msg!=='ok'){
			 		setTimeout(wantToPlay, 2000);
			 } else {
				 state++;
			 }

				console.log(response);


	}

	function choose(choice) {
	console.log('choose ' + choice)
		theirChoice = choice;
		// event handler code goes here
		state++;

		myChoice =1;
		theirChoice =2;
	}
</script>


<p>{state}</p>

{#if state==0}
	<h1>Press Start To Play</h1>


	<input bind:value={myName} placeholder="enter your name">
	<button on:click={wantToPlay}>
		Start {state}
	</button>
{/if}


{#if state==1}
	<h1>Waiting For Player 2</h1>
{/if}

{#if state==2}
	<h1>Make your choice</h1>
	<button on:click={function(){choose(3)}}>
			Paper
	</button>
	<button on:click={function(){choose(1)}}>
		  Scissors
	</button>
	<button on:click={function(){choose(2)}}>
		 	Stone
	</button>
{/if}

{#if state==3}
	<div>
			you chose
			<choice choice={myChoice}>
			they chose
			<choice choice={theirChoice}>
	</div>
{/if}
