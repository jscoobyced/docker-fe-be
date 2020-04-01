const path = require('path');
const CopyWebpackPlugin = require('copy-webpack-plugin');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const WebpackMd5Hash = require('webpack-md5-hash');

const { CleanWebpackPlugin } = require('clean-webpack-plugin');

const dist = path.join(__dirname, 'dist');

module.exports = (env, argv) => {
    const config = {
        entry: {
            'vendor': ['react', 'react-dom', 'react-router-dom'],
            'main': './src/index.tsx'
        },
        output: {
            pathinfo: false,
            path: dist,
            publicPath: '/',
            filename: '[name].[chunkhash].js'
        },
        optimization: {
            removeAvailableModules: false,
            removeEmptyChunks: false,
            splitChunks: {
                cacheGroups: {
                    vendor: {
                        chunks: 'initial',
                        name: 'vendor',
                        test: 'vendor',
                        enforce: true
                    },
                }
            }
        },
        resolve: {
            extensions: ['.ts', '.tsx', '.js']
        },
        module: {
            rules: [{
                test: /\.tsx?$/,
                exclude: /node_modules/,
                loader: 'babel-loader',
            }],
        },
        plugins: [
            new CleanWebpackPlugin(),
            new CopyWebpackPlugin([{
                from: './public'
            },]),
            new WebpackMd5Hash(),
        ]
    };

    if (argv.mode === 'development') {
        config.devtool = 'source-map';
        config.plugins.push(
            new HtmlWebpackPlugin({
                inject: true,
            })
        );
    }

    if (argv.mode === 'production') {
        config.plugins.push(
            new HtmlWebpackPlugin({
                inject: true,
            })
        );
    }

    return config;
}