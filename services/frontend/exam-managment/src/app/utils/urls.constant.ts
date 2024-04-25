const BASE_URL = "http://localhost:8000";

// Security Service 
export const AuthenticationUrls = {
  REGISTER_USER : BASE_URL + "/auth/register",
  LOGIN : BASE_URL + "/auth/token",
  CHECK_IS_LOGGEDIN: BASE_URL + "/auth/validate"
}