import React, { useState } from 'react';
import { motion } from 'framer-motion';
import { useFormik } from 'formik';
import { loginSchema } from '../Schemas';
import Axios from 'axios';

import { api } from '../../api';

import './Styles/styles.css';

const onSubmit = (values, actions) => {
    Axios.post(`${api}/auth/login`, {
        username: values.email,
        password: values.password,
    })
        .then(response => console.log(response))
        .catch((err) => console.log(err));
    actions.resetForm();
};

function Login() {
    const {
        values,
        errors,
        touched,
        handleBlur,
        handleChange,
        handleSubmit,
        isSubmitting,
    } = useFormik({
        initialValues: {
            email: '',
            password: '',
        },
        validationSchema: loginSchema,
        onSubmit,
    });

    return (
        <div className="container-login">
            <div className="card-login">
                <div className="form-login">
                    <form onSubmit={handleSubmit}>
                        <div className="div-email-login">
                            <label
                                htmlFor="email"
                                className="email-login-label"
                            >
                                Email
                            </label>
                            <input
                                id="email"
                                type="email"
                                className={
                                    errors.email && touched.email
                                        ? 'input-error'
                                        : ''
                                }
                                placeholder="Insira seu email"
                                value={values.email}
                                onChange={handleChange}
                                onBlur={handleBlur}
                            />
                            {errors.email && touched.email && (
                                <p>{errors.email}</p>
                            )}
                        </div>
                        <div className="div-password-login">
                            <label
                                htmlFor="password"
                                className="password-login-label"
                            >
                                Password
                            </label>
                            <input
                                id="password"
                                type="password"
                                className={
                                    errors.password && touched.password
                                        ? 'input-error'
                                        : ''
                                }
                                placeholder="Insira sua senha"
                                value={values.password}
                                onChange={handleChange}
                                onBlur={handleBlur}
                            />
                            {errors.password && touched.password && (
                                <p>{errors.password}</p>
                            )}
                        </div>
                        <div className="div-btn-login">
                            <button
                                type="submit"
                                className="btn-login"
                                disabled={
                                    isSubmitting ||
                                    errors.email ||
                                    errors.password ||
                                    values.email == '' ||
                                    values.password == ''
                                }
                                onClick={() => console.log("redirect")}
                            >
                                Login
                            </button>
                        </div>
                    </form>
                </div>
                <motion.div
                    className="footer-login"
                    initial={{ opacity: 0 }}
                    animate={{ opacity: 1 }}
                    transition={{ duration: 1.5, ease: 'easeInOut' }}
                >
                    <p>ou</p>
                    <p
                        className="footer-login-paragraph"
                        onClick={() => (window.location.pathname = '/register')}
                    >
                        Registre-se aqui!
                    </p>
                </motion.div>
            </div>
        </div>
    );
}

export default Login;
