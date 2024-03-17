import { Islogin } from "./Islogin"

export const Currentuser = () => {
    if(Islogin()) {
        return JSON.parse(localStorage.getItem("email"))
        
    }
    else{
        return undefined;
    
    }
};