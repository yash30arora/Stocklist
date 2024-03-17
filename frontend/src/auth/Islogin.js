export const Islogin = () => {
    let data = localStorage.getItem("token");
    if(data != null) {
        return true;
    }

    else {return false;
}
};