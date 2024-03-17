
export const Logout=(next) => {
    localStorage.removeItem("token");
    localStorage.removeItem("email");
    next()
};