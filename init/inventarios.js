db = db.getSiblingDB('inventario');

db.createCollection('inventarios');

db.items.insertMany([
    {
        number: '8954515915',
        delivered: false,
        product: {
            idProduct: 1,
            name: 'Tarjeta Credito'
        },
        user: 'Adrian',
        createDate: new Date()
    },
    {
        number: '99251651561',
        delivered: true,
        product: {
            idProduct: 2,
            name: 'Cheque'
        },
        user: 'Adrian',
        createDate: new Date()
    },
    {
        number: '122619189',
        delivered: false,
        product: {
            idProduct: 3,
            name: 'Talonario'
        },
        user: 'Adrian',
        createDate: new Date()
    }
]);