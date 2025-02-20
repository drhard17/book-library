import {app} from './app'

const container = document.getElementById('root')
if (!container) {
    throw new Error('Container not found')
}

app(container)
