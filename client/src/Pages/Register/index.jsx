import React, { useState } from 'react';
import { useFormik } from 'formik';

import './Styles/styles.css';
import { registerSchema } from '../Schemas';

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

    const [checkInputUser, setCheckInputUser] = useState(false);
    const [checkInputCompany, setCheckInputCompany] = useState(false);

    const check = () => {
        const user = document.getElementById('user');
        const company = document.getElementById('company');

        user.checked
            ? setCheckInputUser(true) && user.classList.add('checked-input')
            : setCheckInputUser(false) &&
              user.classList.remove('checked-input');

        company.checked
            ? setCheckInputCompany(true) &&
              company.classList.add('checked-input')
            : setCheckInputCompany(false) &&
              company.classList.remove('checked-input');
    };

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
                    <div className="div-checkbox">
                        <input
                            onClick={() => check()}
                            type="radio"
                            name="check"
                            id="user"
                        />
                        <label
                            className={checkInputUser ? 'checked-input' : ''}
                            htmlFor="user"
                        >
                            Consumidor
                        </label>
                        <input
                            onClick={() => check()}
                            type="radio"
                            name="check"
                            id="company"
                        />
                        <label
                            className={checkInputCompany ? 'checked-input' : ''}
                            htmlFor="company"
                        >
                            Empresa
                        </label>
                    </div>
                    <div className="div-register-btn">
                        <button
                            type="submit"
                            disabled={
                                isSubmitting ||
                                errors.name ||
                                errors.email ||
                                errors.password ||
                                errors.confirmPassword ||
                                values.name == '' ||
                                values.email == '' ||
                                values.password == '' ||
                                values.confirmPassword == '' ||
                                (checkInputCompany == false &&
                                    checkInputUser == false)
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
