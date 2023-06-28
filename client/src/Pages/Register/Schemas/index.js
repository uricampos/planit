import * as yup from 'yup';

const passwordRules =
    /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&]).{5,}$/;
//Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character

export const registerSchema = yup.object().shape({
    name: yup.string().required('Coloque seu nome'),
    email: yup
        .string()
        .email('Por favor, entre um email válido.')
        .required('Coloque seu email'),
    password: yup
        .string()
        .min(8, "Senha deve conter no mínimo 8 dígitos.")
        .matches(passwordRules, { message: 'Insira uma senha mais forte.' })
        .required('Obrigatório.'),
    confirmPassword: yup
        .string()
        .oneOf([yup.ref('password'), null], 'Senhas devem ser iguais.')
        .required('Obrigatório.'),
});
