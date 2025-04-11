const { Eureka } = require('eureka-js-client');

const client = new Eureka({
    instance: {
        app: 'email-service', // le nom du service (utilise le même partout)
        hostName: 'localhost',
        ipAddr: '127.0.0.1',
        port: {
            $: 8094,
            '@enabled': true,
        },
        vipAddress: 'email-service', // Doit correspondre à `app`
        statusPageUrl: 'http://localhost:8081/', // Peut pointer vers une route comme `/info` si tu veux
        dataCenterInfo: {
            '@class': 'com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo',
            name: 'MyOwn',
        },
    },
    eureka: {
        host: 'localhost',
        port: 8076,
        servicePath: '/eureka/apps/',
    },
});
