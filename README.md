# jiandaoshitoubu





1.wanttoplay
Ajax: post
API : 	/wanttoplay
{
  name: ""
}


result : {
	msg : "ok"
}





2.choice
post
API : /choice

{
  choice: 1
}
params:
param=jiandao=1
param=shitou=2
param=bu=3

name=jay




result : {
	msg : "waiting"
}







Ajax: get 
API : /result

result : {
	msg : "lose"
}

or

result : {
	code : 200,
	msg : "lose"
}
