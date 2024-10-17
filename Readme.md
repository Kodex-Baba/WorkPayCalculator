# WorkPayCalculator

WorkPayCalculator is a simple Android application designed to calculate regular pay, overtime pay, total pay, and tax based on user inputs for hours worked and hourly rate. The app also includes an About screen accessible via a menu, displaying the developer's name and student ID.

## Features
- Calculate regular pay and overtime pay based on the number of hours worked and hourly rate.
- Display tax calculated at 18% of the total pay.
- Two activities:
    - **MainActivity**: Implements the pay calculation functionality.
    - **AboutActivity**: Shows the developer's full name and student ID.
- Smooth fade-in animation for displaying calculated results.
- Back button in the ActionBar for navigation between activities.

## Screenshots
_TODO: TBD

## Requirements
- Android Studio
- Java 1.8 or higher
- Android SDK 21 or higher

## Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/Kodex-Baba/WorkPayCalculator.git
    ```

2. Open the project in Android Studio.

3. Build and run the project on an emulator or Android device.

## Usage

1. Enter the **number of hours worked** and the **hourly rate** in the MainActivity.
2. Press the "Calculate" button to compute the regular pay, overtime pay, total pay, and tax.
3. The calculated values will be displayed with a fade-in animation.
4. Access the About page via the menu to view the developer’s name and student ID.

## Formulae

- **Regular Pay**:
    - If hours worked <= 40, regular pay = hours worked * hourly rate.
- **Overtime Pay**:
    - If hours worked > 40, overtime pay = (hours worked - 40) * hourly rate * 1.5.
- **Total Pay**:
    - Total pay = regular pay + overtime pay.
- **Tax**:
    - Tax = total pay * 0.18 (18%).

## Technologies Used

- **Java**: Programming language used to build the application.
- **Android SDK**: Provides tools and APIs necessary to build the app.
- **ConstraintLayout**: Used for flexible UI design.
- **Animation**: For smooth transitions and enhanced user experience.

## Contributing

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Commit your changes (`git commit -am 'Add some feature'`).
4. Push to the branch (`git push origin feature-branch`).
5. Create a new Pull Request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Author

- Akorede Daniel Osunkoya (Student ID: 101477407)

