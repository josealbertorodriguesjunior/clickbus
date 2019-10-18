# Clickbus

[![Build Status](https://travis-ci.org/josealbertorodriguesjunior/clickbus.svg?branch=master)](https://travis-ci.org/josealbertorodriguesjunior/clickbus)

Test for a clickbus backend position

If you're using [Insomnia](https://insomnia.rest/download/) to test the endpoints, you could get the json file inside the folder ```./requests-insomnia```
and import to make it easy :) 
- `GET` [/api/places](https://clickbus-backend.herokuapp.com/api/places) - Return all places saved 
```
response:
[
  {
    "id": 1,
    "name": "Ubatuba",
    "slug": "Taubatexas, wild way always",
    "city": "Ubatuba",
    "state": "SP",
    "created_at": "2019-10-18T01:01:54.058+0000",
    "updated_at": "2019-10-18T01:01:54.058+0000"
  },
  {
    "id": 2,
    "name": "Ubatuba",
    "slug": "Taubatexas, wild way always",
    "city": "Ubatuba",
    "state": "SP",
    "created_at": "2019-10-18T01:02:01.432+0000",
    "updated_at": "2019-10-18T01:02:01.432+0000"
  },
  {
    "id": 3,
    "name": "Ubatuba",
    "slug": "Taubatexas, wild way always",
    "city": "Ubatuba",
    "state": "SP",
    "created_at": "2019-10-18T01:11:53.737+0000",
    "updated_at": "2019-10-18T01:11:53.737+0000"
  }
]
```
- `POST` [/api/create/place](https://clickbus-backend.herokuapp.com/api/create/place) - To create a new place you must to post a json with the payload like this:
```
    {
    	"name":"Ubatuba",
    	"city":"Ubatuba",
    	"state": "SP",
    	"slug": "Taubatexas, wild way always"
    }
```
- `PUT` [/api/update/place/{id}](https://clickbus-backend.herokuapp.com/api/update/place/1) - This endpoint is used to update a existent. This endpoint receives an ID od a place in the URL as a parameter.
```
{
	"name":"São paulo",
	"city":"Ubatuba",
	"state": "SP",
	"slug": "Taubatexas, wild way always"
}
```
- `GET` [/api/place/{name}](https://clickbus-backend.herokuapp.com/api/update/place/ubatuba) - This endpoint is used to get a place by name receiveing a place name as a URL parameter.

```
response:
[
  {
    "id": 1,
    "name": "Ubatuba",
    "slug": "Taubatexas, wild way always",
    "city": "Ubatuba",
    "state": "SP",
    "created_at": "2019-10-18T00:33:51.425+0000",
    "updated_at": "2019-10-18T00:33:51.425+0000"
  }
]
```