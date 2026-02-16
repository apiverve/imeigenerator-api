# IMEI Generator API - Dart/Flutter Client

IMEI Generator creates valid International Mobile Equipment Identity (IMEI) numbers with proper Luhn checksum validation for mobile devices.

[![pub package](https://img.shields.io/pub/v/apiverve_imeigenerator.svg)](https://pub.dev/packages/apiverve_imeigenerator)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [IMEI Generator API](https://apiverve.com/marketplace/imeigenerator?utm_source=dart&utm_medium=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_imeigenerator: ^1.1.14
```

Then run:

```bash
dart pub get
# or for Flutter
flutter pub get
```

## Usage

```dart
import 'package:apiverve_imeigenerator/apiverve_imeigenerator.dart';

void main() async {
  final client = ImeigeneratorClient('YOUR_API_KEY');

  try {
    final response = await client.execute({
      'brand': 'Samsung',
      'count': 1
    });

    print('Status: ${response.status}');
    print('Data: ${response.data}');
  } catch (e) {
    print('Error: $e');
  }
}
```

## Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "count": 2,
    "brand": "Samsung",
    "imeis": [
      {
        "imei": "355828061787269",
        "tac": "35582806",
        "manufacturer": "Samsung",
        "model": "SM-G901F",
        "serial": "178726",
        "checksum": "9",
        "isValid": true
      },
      {
        "imei": "354862004733834",
        "tac": "35486200",
        "manufacturer": "Samsung",
        "model": "SGH-E630",
        "serial": "473383",
        "checksum": "4",
        "isValid": true
      }
    ]
  }
}
```

## API Reference

- **API Home:** [IMEI Generator API](https://apiverve.com/marketplace/imeigenerator?utm_source=dart&utm_medium=readme)
- **Documentation:** [docs.apiverve.com/ref/imeigenerator](https://docs.apiverve.com/ref/imeigenerator?utm_source=dart&utm_medium=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=readme)
