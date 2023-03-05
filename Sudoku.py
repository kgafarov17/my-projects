import tkinter as tk
import tkinter.messagebox
import threading


class SudokuSolver:
    def __init__(self, root):
        self.root = root
        self.grid = [[tk.Entry(root, width=3, bd=3) for _ in range(9)] for _ in range(9)]
        for i in range(9):
            for j in range(9):
                self.grid[i][j].grid(row=i, column=j)
                if (i + j) % 2 == 0:
                    self.grid[i][j].configure(bg='white', font=("Helvetica", 20))
                else:
                    self.grid[i][j].configure(bg='light gray', font=("Helvetica", 20))

        self.solve_button = tk.Button(root, text="Solve", command=self.solve)
        self.solve_button.grid(row=10, column=3)

        self.clear_button = tk.Button(root, text="Clear", command=self.clear)
        self.clear_button.grid(row=10, column=5)

    def clear(self):
        # Clear the grid and reset the input
        for i in range(9):
            for j in range(9):
                self.grid[i][j].delete(0, "end")

    def solve(self):
        def is_valid(grid, row, col, num):
            # check row
            for i in range(9):
                if grid[row][i] == num:
                    return False
            # check column
            for i in range(9):
                if grid[i][col] == num:
                    return False
            # check 3x3 box
            box_row = row // 3
            box_col = col // 3
            for i in range(3):
                for j in range(3):
                    if grid[box_row * 3 + i][box_col * 3 + j] == num:
                        return False
            return True

        # Validate the initial input
        for i in range(9):
            for j in range(9):
                if not self.grid[i][j].get().isdigit() or "0":
                    pass
                else:
                    num = int(self.grid[i][j].get() or "0")
                    if num != 0 and not is_valid(self.grid, i, j, num):
                        tk.messagebox.showerror("Error", "Invalid input")
                        return

        def is_input_valid(grid):
            for i in range(9):
                for j in range(9):
                    num = self.grid[i][j].get()
                    if num and (not num.isdigit() or int(num) < 1 or int(num) > 9):
                        return False
            return True
            # Validate the input before solving the Sudoku

        if not is_input_valid(self.grid):
            tk.messagebox.showerror("Error", "Invalid input, please enter integers between 1 and 9")
            return

        def solve_sudoku(grid, row, col, stop_event):
            if row == 9:
                return True
            if col == 9:
                return solve_sudoku(grid, row + 1, 0, stop_event)
            if grid[row][col] != 0:
                return solve_sudoku(grid, row, col + 1, stop_event)
            if stop_event.is_set():
                return False
            for num in range(1, 10):
                if is_valid(grid, row, col, num):
                    grid[row][col] = num
                    if solve_sudoku(grid, row, col + 1, stop_event):
                        return True
                    grid[row][col] = 0
            return False

        def solve_thread(stop_event):
            # Run the solve operation in a separate thread
            grid = [[int(self.grid[i][j].get() or "0") for j in range(9)] for i in range(9)]
            result = solve_sudoku(grid, 0, 0, stop_event)

            # Update the UI with the result
            if result:
                for i in range(9):
                    for j in range(9):
                        self.grid[i][j].delete(0, "end")
                        self.grid[i][j].insert(0, str(grid[i][j]))
            else:
                tk.messagebox.showerror("Error", "No solution found, make sure input is a valid Sudoku state")

        # Create a stop event
        stop_event = threading.Event()

        # Start the solve operation in a separate thread
        solve_thread = threading.Thread(target=solve_thread, args=(stop_event,))
        solve_thread.start()

        # Set a timer that will set the stop event after 3 seconds
        timer = threading.Timer(3, stop_event.set)
        timer.start()


root = tk.Tk()
root.minsize(480, 400)
root.maxsize(480, 400)
root.title("Sudoku Solver")
sudoku = SudokuSolver(root)
root.mainloop()
