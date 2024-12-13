import SwiftUI

struct ContentView: View {
    @State private var answer = "Shake to reveal your answer!"
    private let answers = [
        "Yes", "No", "Maybe", "Ask again later", "Definitely",
        "I don't think so", "Absolutely", "Very doubtful",
        "Without a doubt", "Signs point to yes"
    ]

    var body: some View {
        VStack {
            Spacer()
            Text(answer)
                .font(.title)
                .multilineTextAlignment(.center)
                .padding()
            
            Spacer()
            
            Button(action: {
                answer = answers.randomElement() ?? "Try again!"
            }) {
                Text("Shake")
                    .font(.headline)
                    .padding()
                    .frame(maxWidth: .infinity)
                    .background(Color.blue)
                    .foregroundColor(.white)
                    .cornerRadius(10)
            }
            .padding()
        }
        .padding()
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
