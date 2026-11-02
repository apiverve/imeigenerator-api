# IMEI Generator API - Dart/Flutter Client

IMEI Generator creates valid International Mobile Equipment Identity (IMEI) numbers with proper Luhn checksum validation for mobile devices.

[![pub package](https://img.shields.io/pub/v/apiverve_imeigenerator.svg)](https://pub.dev/packages/apiverve_imeigenerator)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [IMEI Generator API](https://apiverve.com/marketplace/imeigenerator?utm_source=dart&utm_medium=referral&utm_content=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_imeigenerator: ^1.2.4
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
        "imei": "358398048517203",
        "tac": "35839804",
        "manufacturer": "Samsung",
        "model": "Galaxy Xcover",
        "serial": "851720",
        "checksum": "3",
        "isValid": true
      },
      {
        "imei": "359040029448038",
        "tac": "35904002",
        "manufacturer": "Samsung",
        "model": "SGH-B130",
        "serial": "944803",
        "checksum": "8",
        "isValid": true
      }
    ]
  }
}
```

## API Reference

- **API Home:** [IMEI Generator API](https://apiverve.com/marketplace/imeigenerator?utm_source=dart&utm_medium=referral&utm_content=readme)
- **Documentation:** [docs.apiverve.com/ref/imeigenerator](https://docs.apiverve.com/ref/imeigenerator?utm_source=dart&utm_medium=referral&utm_content=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme)
