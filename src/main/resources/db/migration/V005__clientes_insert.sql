insert into oauth_client_details (
  client_id, resource_ids, client_secret, 
  scope, authorized_grant_types, web_server_redirect_uri, authorities,
  access_token_validity, refresh_token_validity, autoapprove
)
values (
  'gestambiental', null, '$2a$12$LaejyJQjfUJG1uYUIs94X.Qa3iQC6CJroL1.71y8NlxcqTrUqhEWG',
  'READ,WRITE', 'password', null, null,
  60 * 60 * 6, 60 * 60 * 60 * 60, null
);

insert into oauth_client_details (
  client_id, resource_ids, client_secret, 
  scope, authorized_grant_types, web_server_redirect_uri, authorities,
  access_token_validity, refresh_token_validity, autoapprove
)
values (
  'authcode', null, null,
  'READ,WRITE', 'authorization_code', 'http://localhost:8000', null,
  null, null, true
);

insert into oauth_client_details (
  client_id, resource_ids, client_secret, 
  scope, authorized_grant_types, web_server_redirect_uri, authorities,
  access_token_validity, refresh_token_validity, autoapprove
)
values (
  'backend', null, '$2a$12$EshErhFSQybww/H05giwpOLXrIqr2Y3Z/E.ItPEi9jVJzW7JfIqKW',
  'READ,WRITE', 'client_credentials', null, null,
  null, null, null
);