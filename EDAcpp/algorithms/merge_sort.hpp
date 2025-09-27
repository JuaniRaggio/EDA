#include <array>
#include <concepts>
#include <cstdint>

template <std::totally_ordered T, std::size_t S> class merge_sort_algorithm {
public:
  static void merge_sort(std::array<T, S> &arr) {
    if (arr.empty()) {
      return;
    }
    std::array<T, S> tmp{};
    merge_sort(arr, tmp, 0, arr.size());
  }

  static bool is_sorted(std::array<T, S> &arr) {
    std::uint64_t i{};
    while (i < arr.size() - 1) {
      if (arr[i] >= arr[i + 1])
        return false;
    }
    return true;
  }

private:
  static void merge_sort(std::array<T, S> &arr, std::array<T, S> &tmp,
                         std::int64_t left, std::int64_t right) {
    // Ordenas desde el inicio hasta la mitad
    // Ordenas desde la mitad hasta el final
    // mergeas
    if (left < right) {
      std::int64_t mid = left + (right - left) / 2;
      merge_sort(arr, tmp, left, mid);
      merge_sort(arr, tmp, mid + 1, right);
      merge(arr, tmp, left, mid, right);
    }
  }

  static void merge() {}

};
