import Dotenv from 'dotenv-webpack';

export default (env) => {
    
    const isProduction = env === 'production';
    const envPath = isProduction ? '.env.production' : '.env.development';

    return {
        entry: './src',

        devtool: 'source-map',

        resolve: {
            extensions: ['.ts', '.tsx', '...']
        },

        plugins: [
            new Dotenv({
                path: envPath
            })
        ],

        module: {
            rules: [{
                test: /\.tsx?/,
                use: {
                    loader: 'ts-loader',
                },

            }]
        },

        devServer: {
            host: '127.0.0.1',
            port: 3000
        }
    }
}
