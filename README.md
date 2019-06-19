# jiandaoshitoubu


```
0:jiandao
1:shitou
2:bu
```


**1.wanttoplay**
```
method : Ajax  post

URL : http://localhost:8080/wanttoplay

params : application/json
{
	name : "jay"
}

result : String

"WAITING" OR "OK"

```




**2.choice**

```
method :  post
API : /choice


{
	"choice" : 1,
	"username" : "jay1"
}

name=jay




return : "OK"

```




**result**
```

Ajax: get 
API : /result

result : {
	msg : "lose"
}

or

{
    "name": "jay",
    "result": "WIN"
}


```








**import json to postman:**

```
{
	"info": {
		"_postman_id": "102d6989-89d8-4899-8fe7-046ed7b44942",
		"name": "jiandaoshitoubu",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
	},
	"item": [
		{
			"name": "http://localhost:8080/result",
			"protocolProfileBehavior": {
				"disableBodyPruning": true
			},
			"request": {
				"method": "GET",
				"header": [
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": ""
				},
				"url": {
					"raw": "http://localhost:8080/result",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"result"
					]
				}
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/choice?choice=1&name=jay1",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": ""
				},
				"url": {
					"raw": "http://localhost:8080/choice?choice=1&name=jay1",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"choice"
					],
					"query": [
						{
							"key": "choice",
							"value": "1"
						},
						{
							"key": "name",
							"value": "jay1"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/choice?choice=2&name=jay",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "\n{\n\t\n\"name\" : \"jay1\"\t\n}"
				},
				"url": {
					"raw": "http://localhost:8080/choice?choice=2&name=jay",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"choice"
					],
					"query": [
						{
							"key": "choice",
							"value": "2"
						},
						{
							"key": "name",
							"value": "jay"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/wanttoplay",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n\t\"name\" : \"jay\"\n}"
				},
				"url": {
					"raw": "http://localhost:8080/wanttoplay",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"wanttoplay"
					]
				}
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/wanttoplay?player=jay1",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n\t\"name\":\"jay1\"\n}"
				},
				"url": {
					"raw": "http://localhost:8080/wanttoplay?player=jay1",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"wanttoplay"
					],
					"query": [
						{
							"key": "player",
							"value": "jay1"
						}
					]
				}
			},
			"response": []
		}
	]
}
```