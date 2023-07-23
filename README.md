# QuizApp
I'm developing this project for practice only, It is a quiz application project using Spring Boot, and one thing is that this is only the Backend part, just like a monolithic application.

To Crate Quiz This is url to create quiz
localhost:8080/quiz/create?category=python&numQ=5&title=pQuiz

To Get The Question
localhost:8080/quiz/get/1

To Submit the Answer in JSON Format
localhost:8080/quiz/submit/1

Formate to submit the answer is 
[
    {
        "id":7,
        "response":"Indentation"
    },
    {
        "id":10,
        "response":"lamda"
    },
    {
        "id":6,
        "response":".py"
    },
    {
        "id":5,
        "response":"Python code is both compiled and interpreted"
    },
    {
        "id":9,
        "response":"Indentation"
        }
]
