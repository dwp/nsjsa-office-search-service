INSERT INTO benefit_centre (dwp_bc_id, dwp_service_id, name, created_timestamp, updated_timestamp) VALUES (101810, 'JSGQ', 'London Benefit Centre', '2018-12-11 10:33:44.520069', '2018-12-11 10:33:44.520069');

INSERT INTO job_centre (jcp_id, real_dwp_jcp_id, dwp_bc_id, name, first_line, second_line, town, postcode, created_timestamp, updated_timestamp) VALUES ('5f345d72-9900-47b4-91c6-e82290b4bd03',207610, 101810, 'St Marylebone Jobcentre', '26-46 Lisson Grove', null, 'London', 'NW1 6TZ', '2018-12-11 10:36:06.944262', '2018-12-11 10:36:06.944262');

INSERT INTO postcode_covered (id, jcp_id, postcode_zone, created_timestamp, updated_timestamp) VALUES ('87ef9862-b650-4652-92de-efb16f1b94d8', '5f345d72-9900-47b4-91c6-e82290b4bd03', 'SW1A', '2018-12-11 10:41:46.585808', '2018-12-11 10:41:46.585808');
INSERT INTO postcode_covered (id, jcp_id, postcode_zone, created_timestamp, updated_timestamp) VALUES ('cc9a115c-95d8-47df-b60d-9e1a4369586f', '5f345d72-9900-47b4-91c6-e82290b4bd03', 'NW8', '2018-12-11 10:41:46.585808', '2018-12-11 10:41:46.585808');
INSERT INTO postcode_covered (id, jcp_id, postcode_zone, created_timestamp, updated_timestamp) VALUES ('76a3582a-9132-499d-93eb-f3abefa13555', '5f345d72-9900-47b4-91c6-e82290b4bd03', 'W1A', '2018-12-11 10:41:46.585808', '2018-12-11 10:41:46.585808');
INSERT INTO postcode_covered (id, jcp_id, postcode_zone, created_timestamp, updated_timestamp) VALUES ('6fd45b4b-ead4-4622-87f2-80a3ab4c2574', '5f345d72-9900-47b4-91c6-e82290b4bd03', 'NW1 1', '2018-12-11 10:41:46.585808', '2018-12-11 10:41:46.585808');
INSERT INTO postcode_covered (id, jcp_id, postcode_zone, created_timestamp, updated_timestamp) VALUES ('a7cb4d3b-2550-4723-90bb-6f68068ba9d4', '5f345d72-9900-47b4-91c6-e82290b4bd03', 'W2', '2018-12-11 10:41:46.585808', '2018-12-11 10:41:46.585808');
INSERT INTO postcode_covered (id, jcp_id, postcode_zone, created_timestamp, updated_timestamp) VALUES ('1b1f28a7-3049-4169-b842-06ac01c43b3a', '5f345d72-9900-47b4-91c6-e82290b4bd03', 'WC2A', '2018-12-13 11:55:03.118329', '2018-12-13 11:55:03.118329');
INSERT INTO postcode_covered (id, jcp_id, postcode_zone, created_timestamp, updated_timestamp) VALUES ('75b9260b-dfc4-478b-bb27-c69c13a5b826', '5f345d72-9900-47b4-91c6-e82290b4bd03', 'W9 1', '2018-12-13 11:59:02.941935', '2018-12-13 11:59:02.941935');
INSERT INTO postcode_covered (id, jcp_id, postcode_zone, created_timestamp, updated_timestamp) VALUES ('4b9e71b2-523b-4595-971a-64e450dea2d2', '5f345d72-9900-47b4-91c6-e82290b4bd03', 'NW1 2', '2018-12-13 11:59:02.941935', '2018-12-13 11:59:02.941935');

INSERT INTO phone_number (id, number, type, created_timestamp, updated_timestamp) VALUES ('158c4d3a-57ed-481e-95e7-62088af00dfb', '0800 169 0310', 'main board', '2018-12-11 10:37:22.821943', '2018-12-11 10:37:22.821943');

INSERT INTO phone_number (id, number, type, created_timestamp, updated_timestamp) VALUES ('c934469e-98ee-45be-818f-b4e19ca5077a', '0800 169 0190', 'main board', '2018-12-11 10:37:22.821943', '2018-12-11 10:37:22.821943');
INSERT INTO phone_number (id, number, type, created_timestamp, updated_timestamp) VALUES ('06b88be5-ac5e-475c-965d-9a235445219b', '0800 169 0207', 'welsh', '2018-12-11 14:09:37.861606', '2018-12-11 14:09:37.861606');

INSERT INTO jcp_number (jcp_id, phone_number_id) VALUES ('5f345d72-9900-47b4-91c6-e82290b4bd03', 'c934469e-98ee-45be-818f-b4e19ca5077a');
INSERT INTO jcp_number (jcp_id, phone_number_id) VALUES ('5f345d72-9900-47b4-91c6-e82290b4bd03', '06b88be5-ac5e-475c-965d-9a235445219b');



INSERT INTO job_centre (jcp_id, real_dwp_jcp_id, dwp_bc_id, name, first_line, second_line, town, postcode, created_timestamp, updated_timestamp) VALUES ('b9ffd5fd-66c8-434b-89a9-d1970a856de6', 301106, 101810, 'Kentish Town Jobcentre', '178 Kentish Town Road', 'Kentish Town', 'London', 'NW5 2AG', '2018-12-13 13:38:40.636931', '2018-12-13 13:38:40.636931');

INSERT INTO postcode_covered (id, jcp_id, postcode_zone, created_timestamp, updated_timestamp) VALUES ('2bac625c-e35f-4985-9539-eda3d4e5ac6d', 'b9ffd5fd-66c8-434b-89a9-d1970a856de6', 'NW1 0', '2018-12-11 10:41:46.585808', '2018-12-11 10:41:46.585808');
INSERT INTO postcode_covered (id, jcp_id, postcode_zone, created_timestamp, updated_timestamp) VALUES ('216ce1fc-c603-4dd3-ab68-a4d893369e52', 'b9ffd5fd-66c8-434b-89a9-d1970a856de6', 'NW1 7', '2018-12-11 10:41:46.585808', '2018-12-11 10:41:46.585808');
INSERT INTO postcode_covered (id, jcp_id, postcode_zone, created_timestamp, updated_timestamp) VALUES ('420e1abe-397a-41a2-8b6f-f776ba9da6b7', 'b9ffd5fd-66c8-434b-89a9-d1970a856de6', 'NW1 8', '2018-12-13 11:59:02.941935', '2018-12-13 11:59:02.941935');
INSERT INTO postcode_covered (id, jcp_id, postcode_zone, created_timestamp, updated_timestamp) VALUES ('5f16ed5b-68ee-4d71-92f4-7c106552016b', 'b9ffd5fd-66c8-434b-89a9-d1970a856de6', 'NW1 9', '2018-12-13 11:59:02.941935', '2018-12-13 11:59:02.941935');
INSERT INTO postcode_covered (id, jcp_id, postcode_zone, created_timestamp, updated_timestamp) VALUES ('53b42f6b1-9e1f-4b24-bbd4-282a28ad7d29', 'b9ffd5fd-66c8-434b-89a9-d1970a856de6', 'NW3', '2018-12-11 10:41:46.585808', '2018-12-11 10:41:46.585808');
INSERT INTO postcode_covered (id, jcp_id, postcode_zone, created_timestamp, updated_timestamp) VALUES ('66d79814-0a56-4382-af88-ace0093307b8', 'b9ffd5fd-66c8-434b-89a9-d1970a856de6', 'NW5', '2018-12-11 10:41:46.585808', '2018-12-11 10:41:46.585808');
INSERT INTO postcode_covered (id, jcp_id, postcode_zone, created_timestamp, updated_timestamp) VALUES ('96f57782-1d3c-42db-b847-94b0de37bb05', 'b9ffd5fd-66c8-434b-89a9-d1970a856de6', 'NW6 3', '2018-12-11 10:41:46.585808', '2018-12-11 10:41:46.585808');
INSERT INTO postcode_covered (id, jcp_id, postcode_zone, created_timestamp, updated_timestamp) VALUES ('428f6c54-3e42-40f7-86b5-4354a73c9b8a', 'b9ffd5fd-66c8-434b-89a9-d1970a856de6', 'NW6 4', '2018-12-13 11:55:03.118329', '2018-12-13 11:55:03.118329');

INSERT INTO phone_number (id, number, type, created_timestamp, updated_timestamp) VALUES ('b062a679-0fe0-4eae-b3d4-9fa70227a2af', '0800 169 0190', 'main board', '2018-12-11 10:37:22.821943', '2018-12-11 10:37:22.821943');
INSERT INTO phone_number (id, number, type, created_timestamp, updated_timestamp) VALUES ('24fd2d4d-894d-42bd-a719-69047c398e79', '0800 169 0207', 'welsh', '2018-12-11 14:09:37.861606', '2018-12-11 14:09:37.861606');

INSERT INTO jcp_number (jcp_id, phone_number_id) VALUES ('b9ffd5fd-66c8-434b-89a9-d1970a856de6', 'b062a679-0fe0-4eae-b3d4-9fa70227a2af');
INSERT INTO jcp_number (jcp_id, phone_number_id) VALUES ('b9ffd5fd-66c8-434b-89a9-d1970a856de6', '24fd2d4d-894d-42bd-a719-69047c398e79');
