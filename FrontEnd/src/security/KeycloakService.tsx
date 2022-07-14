import Keycloak from "keycloak-js";

const keycloakInstance = new Keycloak({
    url:"http://localhost:8180/",
    realm: "KeycloakAppSecurity",
    clientId: "secure-app"
});

/**
 * Initializes Keycloak instance and calls the provided callback function if successfully authenticated.
 *
 * @param onAuthenticatedCallback
 */
const Login = (onAuthenticatedCallback: Function) => {
  keycloakInstance
    .init({ onLoad: "login-required" })
    .then(function (authenticated) {
      authenticated ? onAuthenticatedCallback() : alert("non authenticated");
    })
    .catch((e) => {
      console.dir(e);
      console.log(`keycloak init exception: ${e}`);
    });
};
const Token=()=>keycloakInstance.token
const Principal=()=>keycloakInstance.tokenParsed
const KeyCloakService = {
  CallLogin: Login,
  GetToken:Token,
  GetPrincipal:Principal
};

export default KeyCloakService;