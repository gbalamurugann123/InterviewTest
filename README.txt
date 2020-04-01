The JSON file is in ASSET Folder. 

The Application generates the layout based on the JSON.


Please find the sample JSON Format:

{
	"page": [{
		"title": "Basic Info",
		"controls": [{
			"label": "Name",
			"type": "text",
			"required": true,
			"min_length": 5,
			"max_length": 12,
			"regex": "^[\\p{L} .'-]+$",
			"options": null
		}, {
			"label": "Gender",
			"type": "select",
			"required": true,
			"min_length": 5,
			"max_length": 12,
			"regex": "",
			"options": ["", "Male", "Female"]
		}, {
			"label": "Languages Known",
			"type": "checkbox",
			"required": false,
			"min_length": 5,
			"max_length": 12,
			"regex": "",
			"options": ["Tamil", "English", "others"]
		}]
	}, {
		"title": "Communication Info",
		"controls": [{
			"label": "Email",
			"type": "text",
			"required": true,
			"min_length": 5,
			"max_length": 25,
			"regex": "^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$",
			"options": null
		}, {
			"label": "Maritial Status",
			"type": "select",
			"required": false,
			"min_length": 5,
			"max_length": 12,
			"regex": "",
			"options": ["", "Married", "Single"]
		}, {
			"label": "Computer Languages Known",
			"type": "checkbox",
			"required": false,
			"min_length": 5,
			"max_length": 12,
			"regex": "",
			"options": ["C", "C++", "JAVA", "Kotlin"]
		}]
	}, {
		"title": "Other Info",
		"controls": [{
			"label": "Address Line",
			"type": "text",
			"required": false,
			"min_length": 5,
			"max_length": 25,
			"regex": "",
			"options": null
		}, {
			"label": "State",
			"type": "select",
			"required": true,
			"min_length": 5,
			"max_length": 12,
			"regex": "",
			"options": ["", "Tamilnadu", "Others"]
		}]
	}]
}