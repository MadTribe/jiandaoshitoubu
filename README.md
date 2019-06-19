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
choice=jiandao=1
choice=shitou=2
choice=bu=3

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
