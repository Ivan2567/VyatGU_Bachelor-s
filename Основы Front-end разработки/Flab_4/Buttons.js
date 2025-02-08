var key = new Boolean(false)                
var username;                
knopka.onclick = function() 
{
    if(key==true)
    {
        alert("Я это сделал, а тебе, " + username + ", от меня совет: \"Поступай правильно - поступай в ВятГУ!\"")
    }
    else
    {
        username = prompt("Привет, скажи своё имя.");
        
        if (username == "")
        {
            alert("Поле должно быть заполнено")
        }
        else
        {
            alert("Я это сделал, а тебе, " + username + ", от меня совет: \"Поступай правильно - поступай в ВятГУ!\"");
            key = true; 
        }
        
    }
}
knopka1.onclick = function() 
{
    if(key==true)
    {
        alert("Я это сделал, а а тебе, " + username + ", от меня совет: \"Поступай правильно - поступай в ВятГУ!\"")
    }
    else
    {
        username = prompt("Привет, скажи своё имя.");
        
        if (username == "")
        {
            alert("Поле должно быть заполнено")
        }
        else
        {
            alert("Я это сделал, а а тебе, " + username + ", от меня совет: \"Поступай правильно - поступай в ВятГУ!\"");
            key = true; 
        }
        
    }
}