class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if not digits:
            return []

        # Define a dictionary to map digits to their respective letters
        digit_map = {
            '2': 'abc',
            '3': 'def',
            '4': 'ghi',
            '5': 'jkl',
            '6': 'mno',
            '7': 'pqrs',
            '8': 'tuv',
            '9': 'wxyz'
        }

        # Initialize the result list with an empty string
        result = ['']

        for digit in digits:
            # Get the letters corresponding to the current digit
            letters = digit_map[digit]

            # Use list comprehension to generate new combinations
            result = [prefix + letter for prefix in result for letter in letters]

        return result
