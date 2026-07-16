# IMEI Generator API - PHP Package

IMEI Generator creates valid International Mobile Equipment Identity (IMEI) numbers with proper Luhn checksum validation for mobile devices.

## Installation

Install via Composer:

```bash
composer require apiverve/imeigenerator
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Imeigenerator\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute([
    'brand' => 'Samsung',
    'count' => 1
]);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Imeigenerator\Client;
use APIVerve\Imeigenerator\Exceptions\APIException;
use APIVerve\Imeigenerator\Exceptions\ValidationException;

try {
    $response = $client->execute(['brand' => 'Samsung', 'count' => 1]);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
```

## Example Response

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

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/imeigenerator?utm_source=packagist&utm_medium=readme).

## Support

- Website: [https://apiverve.com/marketplace/imeigenerator?utm_source=php&utm_medium=readme](https://apiverve.com/marketplace/imeigenerator?utm_source=php&utm_medium=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
