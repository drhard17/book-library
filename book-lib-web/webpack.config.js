import Dotenv from 'dotenv-webpack';
import HtmlWebpackPlugin from 'html-webpack-plugin';
import CopyPlugin from 'copy-webpack-plugin';

export default (env) => {
    
    const envPath = env.production ? '.env.production' : '.env.development';

    return {
        entry: './src',

        devtool: 'source-map',

        resolve: {
            extensions: ['.ts', '.tsx', '...']
        },

        plugins: [
            new Dotenv({
                path: envPath
            }),
            
            new HtmlWebpackPlugin({
                template: "./public/index.html",
                filename: "index.html"
            }),

            new CopyPlugin({
                patterns: [
                    {
                        from: 'public',
                        to: '',
                        globOptions: {
                            ignore: ['**/index.html']
                        }
                    }
                ]
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
        },

        output: {
            clean: true
        }
    }
}
