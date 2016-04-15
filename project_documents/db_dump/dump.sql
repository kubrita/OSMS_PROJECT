--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: osms_role; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE osms_role (
    id integer NOT NULL,
    role character varying(255)
);


ALTER TABLE osms_role OWNER TO postgres;

--
-- Name: osms_user; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE osms_user (
    id integer NOT NULL,
    name character varying(255) NOT NULL,
    middle_name character varying(255),
    surname character varying(255) NOT NULL,
    age integer NOT NULL,
    address character varying(1024) NOT NULL,
    gender integer NOT NULL,
    email character varying(255) NOT NULL,
    phone_number character varying(255) NOT NULL,
    password character varying(255) DEFAULT 'foo'::character varying NOT NULL
);


ALTER TABLE osms_user OWNER TO postgres;

--
-- Name: osms_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE osms_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE osms_user_id_seq OWNER TO postgres;

--
-- Name: osms_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE osms_user_id_seq OWNED BY osms_user.id;


--
-- Name: osms_user_role; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE osms_user_role (
    userid integer NOT NULL,
    roleid integer NOT NULL
);


ALTER TABLE osms_user_role OWNER TO postgres;

--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY osms_user ALTER COLUMN id SET DEFAULT nextval('osms_user_id_seq'::regclass);


--
-- Data for Name: osms_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY osms_role (id, role) FROM stdin;
1	ADMIN
2	STUDENT
3	LECTURER
\.


--
-- Data for Name: osms_user; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY osms_user (id, name, middle_name, surname, age, address, gender, email, phone_number, password) FROM stdin;
1	KUBRA		USTUN	23	BAKIRKOY	1	kubraustun57@gmail.com	123456	123456
\.


--
-- Name: osms_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('osms_user_id_seq', 1, true);


--
-- Data for Name: osms_user_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY osms_user_role (userid, roleid) FROM stdin;
1	2
\.


--
-- Name: osms_role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY osms_role
    ADD CONSTRAINT osms_role_pkey PRIMARY KEY (id);


--
-- Name: osms_user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY osms_user
    ADD CONSTRAINT osms_user_pkey PRIMARY KEY (id);


--
-- Name: osms_user_role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY osms_user_role
    ADD CONSTRAINT osms_user_role_pkey PRIMARY KEY (userid, roleid);


--
-- Name: osms_user_role_roleid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY osms_user_role
    ADD CONSTRAINT osms_user_role_roleid_fkey FOREIGN KEY (roleid) REFERENCES osms_role(id);


--
-- Name: osms_user_role_userid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY osms_user_role
    ADD CONSTRAINT osms_user_role_userid_fkey FOREIGN KEY (userid) REFERENCES osms_user(id) ON DELETE CASCADE;


--
-- Name: public; Type: ACL; Schema: -; Owner: cagri
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM cagri;
GRANT ALL ON SCHEMA public TO cagri;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

