fs = require('fs')

class Message {
    constructor(title, text) {
        this.title = title
        this.text = text
    }

    getTitle = () => {
        return this.title
    }

    getBodyText = () => {
        return this.text
    }
}

const getMessagesFromFile = fileName => {
    const content = fs.readFileSync(fileName).toString('UTF-8').replace(/[\r]+/g, '')
    let messages = [];

    [...content.split('\n')].forEach(line => {
        let lineSplit = line.split(';')
        messages.push(new Message(lineSplit[1], lineSplit[2]))
    })
    return messages
}

const generateKeyValueMap = messages => {
    const messagesMap = new Map()

    messages.forEach(message => {

        console.log(message.getTitle())

        messagesMap.set(message, message.getBodyText().includes(message.getTitle()))
    })
    return messagesMap
}

let messages = getMessagesFromFile('messages.csv')
let messagesMap = generateKeyValueMap(messages)

console.log(messagesMap)
