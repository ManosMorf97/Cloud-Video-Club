import { post_data} from "./authentication.js";
import md5 from "./md5.js"
import { URL_API } from "./Urlapi.js";

document.getElementById("SignIn").addEventListener("submit",(e)=>{
    e.preventDefault();
    let message={}
    message["success"]="Loged In successfully"
    message["error"]="Username and/or password are worng"
    post_data(URL_API+"api/SignIn",md5,true,message)
        
});
