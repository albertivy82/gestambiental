INSERT INTO `oauth2_registered_client` (
`client_id`, 
`client_id_issued_at`, 
`client_secret`, 
`client_secret_expires_at`, 
`client_name`, 
`client_authentication_methods`, 
`authorization_grant_types`, 
`redirect_uris`, 
`scopes`, 
`client_settings`, 
`token_settings`)
VALUES
('gestambiental', 
'2023-05-03 19:04:12', 
'$2a$12$6NMGw1P1YHctSHVyeDr.xenaSUVpt/QPfFDqO0nVa59Afz0Rp7/nu', 
NULL, 
'1', 
'client_secret_basic', 
'refresh_token,authorization_code', 
'gestambiental://oauthcallback', 
'READ,WRITE', 
'{"@class":"java.util.Collections$UnmodifiableMap","settings.client.require-proof-key":false, "settings.client.require-authorization-consent":false}', 
'{"@class":"java.util.Collections$UnmodifiableMap","settings.token.reuse-refresh-tokens":true,"settings.token.id-token-signature-algorithm":["org.springframework.security.oauth2.jose.jws.SignatureAlgorithm","RS256"],"settings.token.access-token-time-to-live":["java.time.Duration",3600.000000000],"settings.token.access-token-format":{"@class":"org.springframework.security.oauth2.server.authorization.settings.OAuth2TokenFormat","value":"self-contained"},"settings.token.refresh-token-time-to-live":["java.time.Duration",86400.000000000],"settings.token.authorization-code-time-to-live":["java.time.Duration",300.000000000]}');

INSERT INTO `oauth2_registered_client` (
`client_id`, 
`client_id_issued_at`, 
`client_secret`, 
`client_secret_expires_at`, 
`client_name`, 
`client_authentication_methods`, 
`authorization_grant_types`, 
`redirect_uris`, 
`scopes`, 
`client_settings`, 
`token_settings`)
VALUES
('gestambiental-web', 
'2023-10-29 19:04:12', 
'$2a$12$BI8y4sj5Z8khu6cT8TYVI.JWOrRnFkQ8gf1twLQoekIZ1MV0p72ci', 
NULL, 
'GestAmbiental Web Client', 
'client_secret_basic', 
'refresh_token,authorization_code', 
'http://dadoseconomicos.ideflorbio.pa.gov.br/authorize', 
'READ,WRITE', 
'{"@class":"java.util.Collections$UnmodifiableMap","settings.client.require-proof-key":false, "settings.client.require-authorization-consent":false}', 
'{"@class":"java.util.Collections$UnmodifiableMap","settings.token.reuse-refresh-tokens":true,"settings.token.id-token-signature-algorithm":["org.springframework.security.oauth2.jose.jws.SignatureAlgorithm","RS256"],"settings.token.access-token-time-to-live":["java.time.Duration",3600.000000000],"settings.token.access-token-format":{"@class":"org.springframework.security.oauth2.server.authorization.settings.OAuth2TokenFormat","value":"self-contained"},"settings.token.refresh-token-time-to-live":["java.time.Duration",86400.000000000],"settings.token.authorization-code-time-to-live":["java.time.Duration",300.000000000]}');
