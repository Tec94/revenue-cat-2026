import SwiftUI

struct BrandMark: View {
    @Environment(\.colorScheme) private var colorScheme

    var body: some View {
        Canvas { context, size in
            let scaleX = size.width / 256
            let scaleY = size.height / 256
            context.scaleBy(x: scaleX, y: scaleY)
            let color = colorScheme == .dark ? Color.white : RestartThreadTheme.ink

            var upper = Path()
            upper.move(to: CGPoint(x: 110, y: 42))
            upper.addLine(to: CGPoint(x: 80, y: 42))
            upper.addCurve(
                to: CGPoint(x: 38, y: 86),
                control1: CGPoint(x: 52, y: 42),
                control2: CGPoint(x: 38, y: 58)
            )
            upper.addLine(to: CGPoint(x: 38, y: 108))
            upper.addLine(to: CGPoint(x: 62, y: 108))
            upper.addLine(to: CGPoint(x: 62, y: 86))
            upper.addCurve(
                to: CGPoint(x: 80, y: 66),
                control1: CGPoint(x: 62, y: 73),
                control2: CGPoint(x: 67, y: 66)
            )
            upper.addLine(to: CGPoint(x: 110, y: 66))
            upper.closeSubpath()
            context.fill(upper, with: .color(color))

            var lower = Path()
            lower.move(to: CGPoint(x: 38, y: 148))
            lower.addLine(to: CGPoint(x: 38, y: 170))
            lower.addCurve(
                to: CGPoint(x: 80, y: 214),
                control1: CGPoint(x: 38, y: 198),
                control2: CGPoint(x: 52, y: 214)
            )
            lower.addLine(to: CGPoint(x: 110, y: 214))
            lower.addLine(to: CGPoint(x: 110, y: 190))
            lower.addLine(to: CGPoint(x: 80, y: 190))
            lower.addCurve(
                to: CGPoint(x: 62, y: 170),
                control1: CGPoint(x: 67, y: 190),
                control2: CGPoint(x: 62, y: 183)
            )
            lower.addLine(to: CGPoint(x: 62, y: 148))
            lower.closeSubpath()
            context.fill(lower, with: .color(color))

            for x in [22.0, 46.0, 70.0, 94.0] {
                context.fill(
                    Path(ellipseIn: CGRect(x: x - 7, y: 121, width: 14, height: 14)),
                    with: .color(color)
                )
            }
            context.fill(
                Path(ellipseIn: CGRect(x: 114, y: 94, width: 68, height: 68)),
                with: .color(color)
            )

            var arrow = Path()
            arrow.move(to: CGPoint(x: 198, y: 85))
            arrow.addCurve(
                to: CGPoint(x: 189, y: 90),
                control1: CGPoint(x: 194, y: 82),
                control2: CGPoint(x: 189, y: 85)
            )
            arrow.addLine(to: CGPoint(x: 189, y: 166))
            arrow.addCurve(
                to: CGPoint(x: 198, y: 171),
                control1: CGPoint(x: 189, y: 171),
                control2: CGPoint(x: 194, y: 174)
            )
            arrow.addLine(to: CGPoint(x: 236, y: 135))
            arrow.addCurve(
                to: CGPoint(x: 236, y: 121),
                control1: CGPoint(x: 240, y: 131),
                control2: CGPoint(x: 240, y: 125)
            )
            arrow.closeSubpath()
            context.fill(arrow, with: .color(color))
        }
        .accessibilityLabel("Restart Thread")
    }
}
