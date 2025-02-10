
import React, { useState, useEffect } from 'react';

function App() {
    const [products, setProducts] = useState([]);

    useEffect(() => {
        fetch('https://price-api.up.railway.app/api/products')
            .then((response) => response.json())
            .then((data) => setProducts(data));
    }, []);

    return (
        <div>
            <h1>Най-добри оферти</h1>
            <ul>
                {products.map((product, index) => (
                    <li key={index}>
                        {product.name} - {product.price}
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default App;
