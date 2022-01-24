var dTool = document.createElement("div");
dTool.classList.add("riskTool")
document.body.appendChild(dTool);


function question(askQ,qAns ,qVals , qName){   
//new list(containing each question), class of quest
var list = document.createElement("ul");
list.classList.add("list");
//list.setAttribute('id', id);
dTool.appendChild(list);

//new list item, class of item - add question
var qu = document.createElement("li");
qu.classList.add("question");
var text = document.createTextNode(askQ);
qu.appendChild(text);
list.appendChild(qu);
    //for loop, looping the radio button answer(qAns[]) and radio button values(qVals[])

    for(i=0;i<4;i++){
        
        var radioInput = document.createElement('input');
        radioInput.classList.add("questButt");
        radioInput.setAttribute('type', 'radio');
        radioInput.setAttribute('name', qName);
        radioInput.setAttribute('value', qVals[i]);
        radioInput.setAttribute('id', qAns[i]);
        
        
        list.appendChild(radioInput);
        //if statement selects the lowest value by defaut(selD)
        var selD = 0;
        if(selD == i){
            radioInput.checked = true;
        }
        
        //new list item, class of item - add answer to radio button
        var ans = document.createElement("label");
        ans.setAttribute("for", qAns[i]);
        ans.classList.add("questAns");
        list.appendChild(ans);
        var text = document.createTextNode(qAns[i]);
        ans.appendChild(text);
        list.appendChild(ans);       
    }
}

// calculates total of radio button values
function getTotal(){
    var total = 0;

    var inputs = document.querySelectorAll('input');
    var qId = document.querySelectorAll('ul');
    for(var i=0;i<inputs.length;i++){
        if(inputs[i].checked){
            var num = Number(inputs[i].value);
            var total = total + num;   
        }  
    }
    getHighRisk();
    console.log(total);
    return total
}

function getHighRisk(){
    var highRisk = [];
    var inputs = document.querySelectorAll('input');
   // var qId = document.querySelectorAll('ul');
    for(var i = 0; i<inputs.length;i++){
        if((inputs[i].checked) && (inputs[i].value >=10)){
            var name = inputs[i].getAttribute("name")
            highRisk.push(name);   
        }
    }
    console.log(highRisk);
    return highRisk
}

//adds submit button with 
function addCalcB(){
    var calcB = document.createElement('input');
    calcB.setAttribute('id', 'submit');
    calcB.setAttribute('type', 'submit');
    calcB.setAttribute('value', 'Calculate Risk');
    dTool.appendChild(calcB);
    calcB.addEventListener("click", showResult);
}


function riskMessage(){
   /* var total = getTotal();
    var risks = getHighRisk();
    var riskCount = risks.length;
    var conCount = false;
   
    var contactLink = document.createElement("a");
    
    contactLink.setAttribute("href","contactForm.html");
    var contactText = document.createTextNode("Please fill in our contact form");
    contactLink.appendChild(contactText);
    result.appendChild(contactLink);

    if(total < 15){
       var message = "Your results show that you currently have a low risk ofdeveloping diabetes. However, it is important that you maintain a healthy lifestyle in terms of diet and exercise. ";
    }else if( total < 25){
        var message = "Your results show that you currently have a medium risk of developing diabetes. For more information on your riskfactors, and what to do about them, please visit our diabetes advice website at http://www.zha.org.zd. ";
    }else{
       var message = "Your results show that you currently have a HIGH risk of developing diabetes. We advise that you contact the Health Authority to discuss your risk factors as soon as you can. Please fill in our contact form and a member of the Health Authority Diabetes Team will be in contact with you. ";
        
    }
    if(risks.length == 4){
    var message = message + "Your main risk factors are your "+ risks[0] +", your "+ risks[1] +", your "+ risks[2] + " and your "+ risks[3]+ " .";
    }else if(risks.length == 3){
        var message = message + "Your main risk factors are your "+ risks[0] +", your "+ risks[1] +", and your "+ risks[2] +".";
    }else if(risks.length == 2){
        var message = message + "Your main risk factors are your "+ risks[0] +" and your "+ risks[1] + "."; 
    }else if(risks.length == 1){
        var message = message + "Your main risk factor is your " + risks[0] + ".";     
    }*/
    
return message
       
}


function showResult(){
    var resultPart = document.getElementById("result").classList.add("showResult");
   
    var total = getTotal();
    var risks = getHighRisk();
    var riskCount = risks.length;
    var message = ""
   
    //gets old results then removes them
    var result = document.getElementById("resultDiv");
    var oldResult = document.getElementById("resultBox");
    result.removeChild(oldResult);
    
    var contactLink = document.createElement("a");   
    contactLink.setAttribute("href","contactForm.html");
    var contactText = document.createTextNode("Please fill in our contact form");
    contactLink.appendChild(contactText);
    result.appendChild(contactLink);

    if(total < 15){
       var message = "Your results show that you currently have a low risk ofdeveloping diabetes. However, it is important that you maintain a healthy lifestyle in terms of diet and exercise. ";
    }else if( total < 25){
        var message = "Your results show that you currently have a medium risk of developing diabetes. For more information on your riskfactors, and what to do about them, please visit our diabetes advice website at http://www.zha.org.zd. ";
    }else{
       var message = "Your results show that you currently have a HIGH risk of developing diabetes. We advise that you contact the Health Authority to discuss your risk factors as soon as you can. Please fill in our contact form and a member of the Health Authority Diabetes Team will be in contact with you. ";
        
    }
    if(risks.length == 4){
    var message = message + "Your main risk factors are your "+ risks[0] +", your "+ risks[1] +", your "+ risks[2] + " and your "+ risks[3]+ " .";
    }else if(risks.length == 3){
        var message = message + "Your main risk factors are your "+ risks[0] +", your "+ risks[1] +", and your "+ risks[2] +".";
    }else if(risks.length == 2){
        var message = message + "Your main risk factors are your "+ risks[0] +" and your "+ risks[1] + "."; 
    }else if(risks.length == 1){
        var message = message + "Your main risk factor is your " + risks[0] + ".";     
    }
    
    //gets the message to show
   // var message =  riskMessage();
    

    //creates a new P tag
    var resultPara = document.createElement("p");
    resultPara.setAttribute("id", "resultBox");
    resultPara.classList.add('resultBox'); 
    result.appendChild(resultPara);

    //adds text to new P tag
    var text = document.createTextNode(message);
    //Adds new text and attaches both text and P tag to resultDiv
    resultPara.appendChild(text);
    resultDiv.appendChild(resultPara);
 
}


function int(){

/* The following arrays provide the data(values and answer 
labels) needed to generate the questions for the risk tool */
    
/*question() sends the question being asked, the answer label, 
the answer value and the name of the question.*/    
    
var q1Ans = ["1-25","26-40","41-60","60+"];
var q1Vals = [0,5,8,10];
    
question("How old are you?", q1Ans,q1Vals,"Age");

var q2Ans = ["0-25","26-30","31-35","35+"];
var q2Vals = [0,0,9,10];
question("What is your BMI?", q2Ans, q2Vals,"BMI");
  
var q3Ans = ["No","Grandparent","Sibling","Parent"];
var q3Vals = [0,7,15,15];
question("Does anybody in your family have diabetes?", q3Ans, q3Vals,"Family");
    
var q4Ans = ["Low","Normal","Quite high","High"];
var q4Vals = [0,0,7,10];
question("How would you describe your sugar intake?", q4Ans, q4Vals,"Diet");

// adds a calculate button 
addCalcB();    
}

window.onload = int();
