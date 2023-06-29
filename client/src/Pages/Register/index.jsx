import React from 'react';
import { useFormik } from 'formik';

import './Styles/styles.css';
import { registerSchema } from './Schemas';

const onSubmit = (values, actions) => {
    console.log('enviado!', values);
    actions.resetForm();
};

function Register() {
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
            name: '',
            email: '',
            password: '',
            confirmPassword: '',
        },
        validationSchema: registerSchema,
        onSubmit,
    });

    return (
        <div className="container-register">
            <div className="form-register">
                <form onSubmit={handleSubmit} autoComplete="off">
                    <div className="div-register-name">
                        <label htmlFor="name">Nome</label>
                        <input
                            id="name"
                            type="text"
                            placeholder="Nome completo/nome da empresa"
                            value={values.name}
                            onChange={handleChange}
                            onBlur={handleBlur}
                            className={
                                errors.name && touched.name ? 'input-error' : ''
                            }
                        />
                    </div>
                    {errors.name && touched.name && (
                        <p className="error-paragraph">{errors.name}</p>
                    )}
                    <div className="div-register-email">
                        <label htmlFor="email">Email</label>
                        <input
                            id="email"
                            type="email"
                            placeholder="Email"
                            value={values.email}
                            onChange={handleChange}
                            onBlur={handleBlur}
                            className={
                                errors.email && touched.email
                                    ? 'input-error'
                                    : ''
                            }
                        />
                    </div>
                    {errors.email && touched.email && (
                        <p className="error-paragraph">{errors.email}</p>
                    )}
                    <div className="div-register-password">
                        <label htmlFor="password">Password</label>
                        <input
                            id="password"
                            type="password"
                            placeholder="Senha"
                            value={values.password}
                            onChange={handleChange}
                            onBlur={handleBlur}
                            className={
                                errors.password && touched.password
                                    ? 'input-error'
                                    : ''
                            }
                        />
                    </div>
                    {errors.password && touched.password && (
                        <p className="error-paragraph">{errors.password}</p>
                    )}
                    <div className="div-register-confirmPassword">
                        <label htmlFor="confirmPassword">
                            Confirm Password
                        </label>
                        <input
                            id="confirmPassword"
                            type="password"
                            placeholder="Confirmar senha"
                            value={values.confirmPassword}
                            onChange={handleChange}
                            onBlur={handleBlur}
                            className={
                                errors.confirmPassword &&
                                touched.confirmPassword
                                    ? 'input-error'
                                    : ''
                            }
                        />
                    </div>
                    {errors.confirmPassword && touched.confirmPassword && (
                        <p className="error-paragraph">
                            {errors.confirmPassword}
                        </p>
                    )}
                    <div className="div-register-btn">
                        <button
                            type="submit"
                            disabled={
                                isSubmitting ||
                                errors.name ||
                                errors.email ||
                                errors.password ||
                                errors.confirmPassword
                            }
                            className="btn-register-submit"
                        >
                            Registrar
                        </button>
                    </div>
                </form>
            </div>
        </div>
    );
}

export default Register;
