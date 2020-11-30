import React from 'react';
import { useState } from 'react';

function Main() {
    const [contador, setContador] = useState(1);

    function contar() {
        setContador(contador + 1);
    }

    return (
        <div>
            <p>Contador: {contador} <button onClick={contar} >Contar</button></p>
        </div>
    );
}

export default Main;