var packageJSON = require('./package.json');
var path = require('path');
var webpack = require('webpack');
var glob = require('glob');

const PATHS = {
    build: path.join(__dirname, 'target', 'RestWeb', 'js')
};

module.exports = {
    entry: {
        'myPages': glob.sync('./src/main/resources/webapp/js/**/*.js')
    },

    output: {
        path: PATHS.build,
        filename: 'rest-react-bundle.js'
    },
    module: {
        loaders: [
            {
                loader: 'babel-loader',
                exclude: /node_modules/,
                query: {
                    presets: ['react', 'es2015']
                }
            }
        ]
    }
};