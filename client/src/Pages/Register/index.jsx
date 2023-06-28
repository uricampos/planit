import React from 'react';
import { useFormik } from 'formik';

import './Styles/styles.css';
import { registerSchema } from './Schemas';

const onSubmit = () => {
    console.log("enviado!");
}

function Register() {
    const { values, errors, handleBlur, handleChange, handleSubmit } = useFormik({
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
            <div className="card-register">
                <div className="form-register">
                    <form onSubmit={handleSubmit} autoComplete="off">
                        <label htmlFor="name">Nome</label>
                        <input
                            id="name"
                            type="text"
                            placeholder="Nome completo/nome da empresa"
                            value={values.name}
                            onChange={handleChange}
                            onBlur={handleBlur}
                        />
                        <label htmlFor="email">Email</label>
                        <input
                            id="email"
                            type="email"
                            placeholder="Email"
                            value={values.email}
                            onChange={handleChange}
                            onBlur={handleBlur}
                        />
                        <label htmlFor="password">Password</label>
                        <input
                            id="password"
                            type="password"
                            placeholder="Senha"
                            value={values.password}
                            onChange={handleChange}
                            onBlur={handleBlur}
                        />
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
                        />
                        <button className="btn-submit">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    );
}

export default Register;
