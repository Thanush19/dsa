/**
 * @param {number} rowsCount
 * @param {number} colsCount
 * @return {Array<Array<number>>}
 */
Array.prototype.snail = function(rowsCount, colsCount) {
  if (rowsCount * colsCount !== this.length) return [];
  
  const result = new Array(rowsCount).fill().map(() => new Array(colsCount).fill(null));
  let topRow = 0, bottomRow = rowsCount - 1, leftCol = 0, rightCol = colsCount - 1;
  let index = 0;
  let rev = false;
  
  while (topRow <= bottomRow && leftCol <= rightCol) {
    if (rev) {
      for (let i = bottomRow; i >= topRow; i--) {
        result[i][leftCol] = this[index++];
      }
    } else {
      for (let i = topRow; i <= bottomRow; i++) {
        result[i][leftCol] = this[index++];
      }
    }
    ++leftCol;
    rev = !rev; 
  }
  
  return result;
};

/**
 * const arr = [1,2,3,4];
 * arr.snail(1,4); // [[1,2,3,4]]
 */