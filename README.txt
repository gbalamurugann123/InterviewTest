The JSON file is in ASSET Folder. 

The Application generates the layout based on the JSON.


Please find the sample JSON Format:

{
	"page": [{
		"controls": [{
			"api_value": "Balamurugan",
			"label": "Name",
			"max_length": 12,
			"min_length": 5,
			"regex": "^[\\p{L} .\u0027-]+$",
			"required": true,
			"type": "text"
		}, {
			"api_value": "Male",
			"label": "Gender",
			"max_length": 12,
			"min_length": 5,
			"options": ["", "Male", "Female"],
			"regex": "",
			"required": true,
			"type": "select"
		}, {
			"api_value": "others, ",
			"label": "Languages Known",
			"max_length": 12,
			"min_length": 5,
			"options": ["Tamil", "English", "others"],
			"regex": "",
			"required": false,
			"type": "checkbox"
		}],
		"title": "Basic Info"
	}, {
		"controls": [{
			"api_value": "gbala@gmail.com",
			"label": "Email",
			"max_length": 25,
			"min_length": 5,
			"regex": "^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$",
			"required": true,
			"type": "text"
		}, {
			"api_value": "",
			"label": "Maritial Status",
			"max_length": 12,
			"min_length": 5,
			"options": ["", "Married", "Single"],
			"regex": "",
			"required": false,
			"type": "select"
		}, {
			"api_value": "JAVA, ",
			"label": "Computer Languages Known",
			"max_length": 12,
			"min_length": 5,
			"options": ["C", "C++", "JAVA", "Kotlin"],
			"regex": "",
			"required": false,
			"type": "checkbox"
		}],
		"title": "Communication Info"
	}, {
		"controls": [{
			"label": "Address Line",
			"max_length": 25,
			"min_length": 5,
			"regex": "",
			"required": false,
			"type": "text"
		}, {
			"api_value": "Others",
			"label": "State",
			"max_length": 12,
			"min_length": 5,
			"options": ["", "Tamilnadu", "Others"],
			"regex": "",
			"required": true,
			"type": "select"
		}],
		"title": "Other Info"
	}]
}